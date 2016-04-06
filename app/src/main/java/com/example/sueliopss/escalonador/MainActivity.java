package com.example.sueliopss.escalonador;

import android.app.AlertDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.gridProcessadores)
    GridView gridProcessadores;

    @ViewById(R.id.gridAptos)
    GridView gridAptos;

    @ViewById
    GridView gridCancelados;

    @Bean
    ProcessadorAdapter processadorAdapter;

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

    EditText numProcessadores;

    EditText numProcesso;

    AlertDialog.Builder builder;

    LinkedList<Processo> processos;

    LinkedList<Processador> processadores;

    LinkedList<Processo> finalizados;

    Button escalonar;

    Semaphore semaphore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AlertDialog dialog = createDialog(savedInstanceState);
        dialog.show();

        processadores = new LinkedList<>();
        processos = new LinkedList<>();
        finalizados = new LinkedList<>();

        escalonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepararEscalonamento(v);
                dialog.dismiss();
            }
        });

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
                    semaphore.acquire();

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
                }finally {
                    semaphore.release();
                }


            }
        }, 0, 1000);


    }

    synchronized void processar() {

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                for (int j = 0; j < processadores.size(); j++){
                    Processador processador = processadores.get(j);
                    if (processador.is_processando){
                        if(processador.processo.tempoProcesso == 0){
                            finalizados.add(processador.processo);
                            processadores.get(j).processo = null;
                            processadores.get(j).is_processando = false;
                            reloadDataGridViewFinalizado(finalizados);
                            semaphore.release();
                        }else {
                            processadores.get(j).processo.tempoProcesso--;
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

            int tempoProcesso = gerador.nextInt(20) + 4;

            int deadLine = gerador.nextInt(20) + 4;

            int ultimoProcesso = Integer.parseInt(numProcesso.getText().toString());

            Processo processo = new Processo("P"+ ultimoProcesso++, tempoProcesso, deadLine, tempoProcesso, Color.YELLOW);

            processos.add(processo);

            Collections.sort(processos);

            numProcesso.setText(""+ultimoProcesso);

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
                            if (processo.deadLine == 0) {
                                finalizados.add(processos.remove(i));
                                reloadDataGridViewFinalizado(finalizados);

                            } else {
                                processos.get(i).deadLine--;

                            }

                        }

                        reloadDataGridViewProcessos(processos);


                    }
                }
            }
        }, 0, 1000);

        //reloadDataGridViewFinalizado(finalizados);

    }

    public void preencherProcessadores(){

        for (int i = 0; i < processadores.size(); i++){

            if(!processos.isEmpty()){
                processadores.get(i).processo = processos.pop();
                processadores.get(i).is_processando = true;
            }
        }

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

    public AlertDialog createDialog(Bundle savedInstanceState){

        builder = new AlertDialog.Builder(this);

        LayoutInflater layoutInflater = this.getLayoutInflater();

        View dialog = layoutInflater.inflate(R.layout.dialog_main_escalonador, null);

        builder.setView(dialog);

        builder.setCancelable(false);

        escalonar = (Button) dialog.findViewById(R.id.buttonEscalonar);

        numProcessadores = (EditText) dialog.findViewById(R.id.editTextNumProcessador);

        numProcesso = (EditText) dialog.findViewById(R.id.editTextNumProcesso);

        return builder.create();
    }

    private void gridViewSetting(GridView gridview, int size) {

        // Calculated single Item Layout Width for each grid element ....
        int width = 70 ;

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

    public void prepararEscalonamento(View view){

        int qntProcessadores = Integer.parseInt(numProcessadores.getText().toString());

        int qntprocessos = Integer.parseInt(numProcesso.getText().toString());

        semaphore = new Semaphore(qntProcessadores);

        contruirGridViewProcessadores(qntProcessadores);

        contruirGridViewProcessos(qntprocessos);

        contruirGridViewFinalizados();


        setGridViewHeightBasedOnChildren(gridProcessadores, 4);

        //setGridViewHeightBasedOnChildren(gridCancelados, 4);

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

        for (int i = 0; i < numProcesso; i++){
            tempoProcesso = gerador.nextInt(20) + 4;
            deadLine = gerador.nextInt(20) + 4;
            processos.add(new Processo("P"+(i+1), tempoProcesso, deadLine, tempoProcesso, Color.YELLOW ));
        }

        Collections.sort(processos);

        gridAptos.setNumColumns(processos.size());

        gridViewSetting(gridAptos, processos.size());

        processoAdapter.setProcessos(processos);

        gridAptos.setAdapter(processoAdapter);

    }



    synchronized void contruirGridViewFinalizados(){

        gridCancelados.setNumColumns(finalizados.size());

        gridViewSetting(gridCancelados, finalizados.size());

        finalizadoAdapter.setProcessos(finalizados);

        gridCancelados.setAdapter(finalizadoAdapter);

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

            gridViewSetting(gridAptos, processos.size());

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
