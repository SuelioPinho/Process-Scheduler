package com.example.sueliopss.escalonador;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

import dalvik.system.BaseDexClassLoader;

@EActivity(R.layout.activity_main)
public class LTGActivity extends AppCompatActivity {

    @ViewById(R.id.gridProcessadores)
    GridView gridProcessadores;

    @ViewById(R.id.gridMemoria)
    GridView gridMemoria;

    @ViewById(R.id.gridAptos)
    GridView gridAptos;

    @ViewById
    GridView gridCancelados;

    @Bean
    ProcessadorAdapter processadorAdapter;

    @Bean
    MemoriaAdapter memoriaAdapter;

    @Bean
    ProcessoAdapter processoAdapter;

    @Bean
    ProcessoAdapter finalizadoAdapter;

    @ViewById
    HorizontalScrollView horizontalScrollView;

    @ViewById(R.id.scrollview_content_main)
    ScrollView scrollView;

    @ViewById(R.id.iniciar)
    FloatingActionButton iniciar;

    @Extra
    int numProcessos;

    @Extra
    int numQtdProcessadores;

    LinkedList<Processo> processos;

    LinkedList<Processador> processadores;

    LinkedList<Processo> finalizados;

    LinkedList<BlocoMemoria> memoria;

    LinkedList<BlocoMemoria> memoriaLivre;

    LinkedList<BlocoMemoria> memoriaOcupada;


    Semaphore semaphoreProcessador;

    Semaphore semaphoreMemoria;

    int qtdMemoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        processadores = new LinkedList<>();
        processos = new LinkedList<>();
        finalizados = new LinkedList<>();
        memoria = new LinkedList<>();
        memoriaLivre = new LinkedList<>();
        memoriaOcupada = new LinkedList<>();
        qtdMemoria = 10000;

    }

    @AfterViews
    public void afterViews(){

        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        memoria.add(new BlocoMemoria(1, qtdMemoria, null));
        memoriaLivre.add(new BlocoMemoria(1, qtdMemoria, null, 0));
        prepararEscalonamento();

    }

    @Click(R.id.iniciar)
    synchronized void iniciarEscalonamento(){

        iniciar.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
        iniciar.setClickable(false);
        preencherProcessadores();

        reloadDataGridViewProcessos(processos);
        decrementarDeadLines();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                try {
                    semaphoreProcessador.acquire();

                    for (Processador processador : processadores) {
                        if (!processador.is_processando) {
                            if (!processos.isEmpty()) {
                                processador.processo = processos.pop();
                                processador.is_processando = true;
                                reloadDataGridViewProcessos(processos);
                            }
                        }
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreProcessador.release();
                }


            }
        }, 0, 1000);


    }

    synchronized void processar() {

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                for (int j = 0; j < processadores.size(); j++) {
                    Processador processador = processadores.get(j);
                    if (processador.is_processando) {
                        processadores.get(j).processo.tempoProcesso--;
                        if (processador.processo.tempoProcesso == 0) {
                            processador.processo.color = Color.GRAY;
                            finalizados.add(processador.processo);
                            processadores.get(j).processo = null;
                            processadores.get(j).is_processando = false;
                            reloadDataGridViewFinalizado(finalizados);
                            semaphoreProcessador.release();
                        }
                    }
                }

                reloadDataGridViewProcessador(processadores);

            }
        }, 0, 1000);


    }

    @Click(R.id.adicionar)
    @UiThread
    public void adicionarProcesso(){

        synchronized (this){
            Random gerador = new Random();

            int tempoProcesso = gerador.nextInt(20) + 10;

            int deadLine = gerador.nextInt(20) + 4;

            int memoria = gerador.nextInt(992) + 32;

            int ultimoProcesso = numProcessos;

            Processo processo = new Processo("P"+ ultimoProcesso++, tempoProcesso, deadLine, tempoProcesso, Color.BLUE, memoria);

            processos.add(processo);

            Collections.sort(processos);

            numProcessos = ultimoProcesso;

            reloadDataGridViewProcessos(processos);
        }

    }

    public void decrementarDeadLines(){

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                synchronized (this) {
                    if (!processos.isEmpty()) {

                        for (int i = 0; i < processos.size(); i++) {
                            Processo processo = processos.get(i);
                            processos.get(i).deadLine--;
                            if (processo.deadLine == 0) {
                                processos.get(i).color = Color.RED;
                                finalizados.add(processos.remove(i));
                                reloadDataGridViewFinalizado(finalizados);
                            }
                        }
                        reloadDataGridViewProcessos(processos);
                    }
                }
            }
        }, 0, 1000);

    }

    public void preencherProcessadores(){

        int idMemoria = 0;
        while(!processos.isEmpty() && processos.get(0).memoria < memoria.get(0).tamanho && idMemoria < processadores.size()){

            Processo processo = processos.pop();
            memoria.get(0).tamanho-= processo.memoria;
            BlocoMemoria bloco = new BlocoMemoria(idMemoria + 2, processo.memoria, processo, null);
            if(idMemoria > 1){
                memoria.get(idMemoria - 1).proximoBloco = idMemoria;
            }
            memoria.add(bloco);
            bloco.endereco = idMemoria + 1;
            memoriaOcupada.add();
            processadores.get(idMemoria).processo = processo;
            processadores.get(idMemoria).processo.color = getResources().getColor(R.color.verdeProcesso);
            processadores.get(idMemoria).is_processando = true;
            idMemoria++;
        }

        semaphoreMemoria = new Semaphore(memoria.size());
        construirGridViewMemoria();
        reloadDataGridViewProcessador(processadores);
        processar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void gridViewSetting(GridView gridview, int size, int width) {


        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;

        int totalWidth = (int) (width * size * density);
        int singleItemWidth = (int) (width * density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                totalWidth, LinearLayout.LayoutParams.MATCH_PARENT);

        gridview.setLayoutParams(params);
        gridview.setColumnWidth(singleItemWidth);
        gridview.setHorizontalSpacing(2);
        gridview.setStretchMode(GridView.STRETCH_SPACING);
        gridview.setNumColumns(size);
    }

    public void prepararEscalonamento(){

        int qntProcessadores = numQtdProcessadores;
        int qntprocessos = numProcessos;

        semaphoreProcessador = new Semaphore(qntProcessadores);

        contruirGridViewProcessadores(qntProcessadores);
        contruirGridViewProcessos(qntprocessos);
        contruirGridViewFinalizados();
        construirGridViewMemoria();

        setGridViewHeightBasedOnChildren(gridProcessadores, 4);
    }

    public void contruirGridViewProcessadores(int numProcessadores){

        for (int i = 0; i < numProcessadores; i++){
            processadores.add(new Processador());
        }
        processadorAdapter.setProcessadores(processadores);
        gridProcessadores.setAdapter(processadorAdapter);
    }

    public void contruirGridViewProcessos(int numProcesso){

        Random gerador = new Random();

        int tempoProcesso;
        int deadLine;
        int memoria;

        for (int i = 0; i < numProcesso; i++){
            tempoProcesso = gerador.nextInt(20) + 10;
            deadLine = gerador.nextInt(20) + 4;
            memoria = gerador.nextInt(992) + 32;
            processos.add(new Processo("P"+(i+1), tempoProcesso, deadLine, tempoProcesso, Color.YELLOW , memoria));
        }

        Collections.sort(processos);

        gridAptos.setNumColumns(processos.size());

        gridViewSetting(gridAptos, processos.size(), 70);

        processoAdapter.setProcessos(processos);

        gridAptos.setAdapter(processoAdapter);

    }

    synchronized void contruirGridViewFinalizados(){

        gridCancelados.setNumColumns(finalizados.size());

        gridViewSetting(gridCancelados, finalizados.size(), 70);

        finalizadoAdapter.setProcessos(finalizados);

        gridCancelados.setAdapter(finalizadoAdapter);

    }

    public void construirGridViewMemoria(){

        gridMemoria.setNumColumns(memoria.size());

        gridViewSetting(gridMemoria, memoria.size(), 150);

        memoriaAdapter.setBlocos(memoria);

        gridMemoria.setAdapter(memoriaAdapter);
    }

    public void setGridViewHeightBasedOnChildren(GridView gridView, int columns) {

        ListAdapter listAdapter = gridView.getAdapter();

        if (listAdapter == null) {
            // pre-condition
            return;

        }

        int totalHeight = 0;
        int items = listAdapter.getCount();
        int rows = 0;

        View listItem = listAdapter.getView(0, null, gridView);
        listItem.measure(0, 0);
        totalHeight = listItem.getMeasuredHeight();

        float x = 1;

        if( items > columns ){
            if(items % columns == 0){
                x = items/columns;
                rows = (int) x;
                totalHeight *= rows;
            }else {
                x = items/columns;
                rows = (int) (x + 1);
                totalHeight *= rows;
            }
        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);
    }

    @UiThread
    public void reloadDataGridViewProcessos(LinkedList<Processo> processos){

        synchronized (this){
            gridAptos.setNumColumns(processos.size());

            gridViewSetting(gridAptos, processos.size(), 70);

            processoAdapter.setProcessos(processos);

            gridAptos.setAdapter(processoAdapter);
        }

    }

    @UiThread
    public void reloadDataGridViewProcessador(LinkedList<Processador> processadores){

        synchronized (this){
            processadorAdapter.setProcessadores(processadores);
            processadorAdapter.notifyDataSetChanged();
        }

    }

    @UiThread
    public void reloadDataGridViewFinalizado(LinkedList<Processo> processos){

        synchronized (this) {
            contruirGridViewFinalizados();
        }
    }
}
