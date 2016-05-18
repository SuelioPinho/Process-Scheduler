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

    int qtdMemoria;

    static final int OCUPADO = 1;
    static final int LIVRE = 0;

    static final int BESTFIT = 0;
    static final int MERGEFIT = 1;
    static final int QUICKFIT = 2;
    static final int algoritmo = 1;

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
                    buscarProcessador();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreProcessador.release();

                }


            }
        }, 0, 1000);


    }

    public BlocoMemoria pedirMemoria(Processo processo){

        BlocoMemoria bloco = memoriaNaoUsada(processo);

        if( bloco == null) {

            switch (algoritmo) {
                case BESTFIT:
                    bloco = bestFit(processo);
                    break;
                case QUICKFIT:
                    bloco = quickFit(processo);
                    break;
                case MERGEFIT:
                    bloco = mergeFit(processo);
                    break;
            }
        }

        return bloco;

    }

    public BlocoMemoria bestFit(Processo processo){

        BlocoMemoria melhorBloco = null;

            for (BlocoMemoria bloco : memoriaLivre) {

                 if (bloco.tamanho >= processo.memoria) {

                     if (melhorBloco != null) {

                         if (bloco.tamanho < melhorBloco.tamanho) {

                            melhorBloco.is_ocupado = false;
                            melhorBloco = bloco;
                            melhorBloco.is_ocupado = true;
                            melhorBloco.processo = processo;
                         }

                     } else {

                        melhorBloco = bloco;
                        melhorBloco.is_ocupado = true;
                        melhorBloco.processo = processo;

                     }
                 }
            }

        return melhorBloco;
    }

    public BlocoMemoria mergeFit(Processo processo){

        BlocoMemoria novoBloco = null;

        for(BlocoMemoria bloco : memoriaLivre){

            if (bloco.tamanho == processo.memoria){

                novoBloco = bloco;
                novoBloco.is_ocupado = true;
                novoBloco.processo = processo;
                break;
            }

            if (bloco.tamanho > processo.memoria){

                novoBloco = dividirBloco(bloco, processo);
                memoria.add(novoBloco.id, novoBloco);
                incrementarIdBlocosAPartir(novoBloco.id + 1, memoria);
                incrementarIdBlocos(novoBloco.id, memoriaLivre);
                incrementarIdBlocos(novoBloco.id, memoriaOcupada);

                break;
            }
        }

        return novoBloco;
    }

    public BlocoMemoria quickFit(Processo processo){
        return null;
    }

    public BlocoMemoria firstFit(Processo processo){
        return null;
    }

    public BlocoMemoria dividirBloco(BlocoMemoria bloco, Processo processo){

        bloco.tamanho-=processo.memoria;
        memoria.get(bloco.id).tamanho-=processo.memoria;
        BlocoMemoria novoBloco = new BlocoMemoria(bloco.id + 1, processo.memoria, processo, bloco.id + 1);
        novoBloco.is_ocupado = true;
        novoBloco.processo = processo;
        return novoBloco;
    }

    public BlocoMemoria memoriaNaoUsada(Processo processo){

        BlocoMemoria bloco = null;

        if(processo.memoria <= qtdMemoria){
            qtdMemoria-=processo.memoria;
            bloco = new BlocoMemoria(memoria.size(), processo.memoria, processo, null);
            memoria.add(bloco);
            memoriaOcupada.add(bloco);
        }
        return bloco;
    }

    public void buscarProcessador(){

        for (Processador processador : processadores) {
            if (!processador.is_processando) {
                if(!processos.isEmpty()) {
                    Processo processo = processos.pop();
                    BlocoMemoria bloco = pedirMemoria(processo);

                    if (bloco != null) {
                        memoria.set(bloco.id, bloco);
                        processador.processo = bloco.processo;
                        processador.is_processando = true;
                        processador.enderecoBlocos.add(bloco.id);
                        mudarEstadoMemoria(bloco.id, LIVRE);
                        reloadDataGridViewProcessos(processos);
                        reloadDataGridViewMemoria(memoria);
                        break;
                    }else{
                        processos.addFirst(processo);
                    }
                }

            }
        }
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
                        Processo processo  = processador.processo;
                        if(processador.processo.instanteMemoria > 0){
                            if(processo.instanteMemoria == processo.tempoProcesso){
                                Processo outroProcesso = new Processo();
                                outroProcesso.nomeProcesso = processo.nomeProcesso;
                                outroProcesso.memoria = processo.memoriaAdicional;
                                BlocoMemoria bloco = pedirMemoria(outroProcesso);

                                if (bloco == null){
                                    processador.is_processando = false;
                                    abortarProcesso(processo);
                                    desalocarMemoria(processo);
                                }else{
                                    memoria.set(bloco.id, bloco);
                                    processador.enderecoBlocos.add(bloco.id);
                                    mudarEstadoMemoria(bloco.id, LIVRE);
                                    reloadDataGridViewMemoria(memoria);

                                }
                            }
                        }

                        if (processador.is_processando && processador.processo.tempoProcesso == 0) {

                            liberarProcessador(processador);
                        }
                    }
                }
                mesclarBlocos();
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

    public void desalocarMemoria(Processo processo){

        for(BlocoMemoria blocoMemoria : memoria){
            if (blocoMemoria.processo.nomeProcesso.equals(processo.nomeProcesso)){
                memoria.get(blocoMemoria.id).is_ocupado = false;
                mudarEstadoMemoria(blocoMemoria.id, OCUPADO);
            }
        }
//        for(int endereco : enderecos){
//            memoria.get(endereco).is_ocupado = false;
//            mudarEstadoMemoria(endereco, OCUPADO);
//        }
    }

    public void abortarProcesso(Processo processo){

        processo.color = Color.RED;
        finalizados.addFirst(processo);
        reloadDataGridViewFinalizado(finalizados);

    }

    public void liberarProcessador(Processador processador){

        processador.processo.color = Color.GRAY;

        finalizados.addFirst(processador.processo);

        desalocarMemoria(processador.processo);

        processador.enderecoBlocos = new LinkedList<Integer>();

        processador.is_processando = false;

        reloadDataGridViewFinalizado(finalizados);

        semaphoreProcessador.release();
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
                            processo.deadLine--;
                            if (processo.deadLine == 0) {
                                abortarProcesso(processos.remove(i));
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
        while(!processos.isEmpty() && idMemoria < processadores.size() && processos.get(0).memoria < qtdMemoria){

            Processo processo = processos.pop();

            memoriaNaoUsada(processo);

            processadores.get(idMemoria).processo = processo;
            processadores.get(idMemoria).processo.color = getResources().getColor(R.color.verdeProcesso);
            processadores.get(idMemoria).is_processando = true;
            processadores.get(idMemoria).enderecoBlocos.add(idMemoria);
            idMemoria++;
        }

        ordenarMemoria(memoriaOcupada);
        construirGridViewMemoria();
        reloadDataGridViewProcessador(processadores);
        processar();
    }

    public void mudarEstadoMemoria(int idBloco, int estadoAtual){

        switch (estadoAtual){
            case OCUPADO:
                for(int i = 0; i < memoriaOcupada.size(); i++){

                    if(memoriaOcupada.get(i).id == idBloco){

                        memoria.get(idBloco).is_ocupado = false;
                        memoriaLivre.add(memoriaOcupada.remove(i));

                    }
                } break;
            case LIVRE:
                for (int i = 0; i < memoriaLivre.size(); i++){

                    if(memoriaLivre.get(i).id == idBloco){
                        memoria.get(idBloco).is_ocupado = true;
                        memoriaOcupada.add(memoriaLivre.remove(i));

                    }
                }
        }

        ordenarMemoria(memoriaLivre);
        ordenarMemoria(memoriaOcupada);
        reloadDataGridViewMemoria(memoria);
    }

    public void ordenarMemoria(LinkedList<BlocoMemoria> memoriaAuxiliar){

        Collections.sort(memoriaAuxiliar);

        if (memoriaAuxiliar.size() > 0){
            memoriaAuxiliar.get(0).proximoBloco = null;

            memoria.get(memoriaAuxiliar.get(0).id).proximoBloco = null;

            for(int i = 1; i < memoriaAuxiliar.size(); i++){

                BlocoMemoria anterior = memoriaAuxiliar.get(i - 1);

                BlocoMemoria atual = memoriaAuxiliar.get(i);

                memoria.get(anterior.id).proximoBloco = memoria.get(atual.id).id;

                memoria.get(atual.id).proximoBloco = null;
            }
        }

    }

    public void incrementarIdBlocosAPartir(int idInicial, LinkedList<BlocoMemoria> memoriaAuxiliar){
        for(int i = idInicial; i < memoriaAuxiliar.size(); i++){
            memoriaAuxiliar.get(i).id++;
        }
    }

    public void incrementarIdBlocos(int idInicial, LinkedList<BlocoMemoria> memoriaAuxiliar){

        for(BlocoMemoria bloco : memoriaAuxiliar){
            if(bloco.id >= idInicial){
                bloco.id++;
            }
        }

    }

    public void decrementarIdBlocos(int idInicial, LinkedList<BlocoMemoria> memoriaAuxiliar){
        for(BlocoMemoria bloco : memoriaAuxiliar){
            if(bloco.id > idInicial){
                bloco.id--;
            }
        }
    }

    public void mesclarBlocos(){
        for (int i = 1; i < memoriaLivre.size(); i++){
            BlocoMemoria anterior = memoriaLivre.get(i-1);
            BlocoMemoria atual = memoriaLivre.get(i);

            if ((anterior.id + 1) == atual.id){
                anterior.tamanho+=atual.tamanho;
                memoria.get(anterior.id).tamanho+=memoria.get(atual.id).tamanho;
                memoriaLivre.remove(i);
                memoria.remove(atual.id);
                decrementarIdBlocos(atual.id, memoriaLivre);
                decrementarIdBlocos(atual.id, memoria);
            }
        }
        reloadDataGridViewMemoria(memoria);
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

        construirGridViewProcessadores(qntProcessadores);
        construirGridViewProcessos(qntprocessos);
        construirGridViewFinalizados();
        construirGridViewMemoria();

        setGridViewHeightBasedOnChildren(gridProcessadores, 4);
    }

    public void construirGridViewProcessadores(int numProcessadores){

        for (int i = 0; i < numProcessadores; i++){
            processadores.add(new Processador());
        }
        processadorAdapter.setProcessadores(processadores);
        gridProcessadores.setAdapter(processadorAdapter);
    }

    public void construirGridViewProcessos(int numProcesso){

        Random gerador = new Random();

        int tempoProcesso;
        int deadLine;
        int memoria;
        int probabilidadeMemoria;

        for (int i = 0; i < numProcesso; i++){
            tempoProcesso = gerador.nextInt(20) + 10;
            deadLine = gerador.nextInt(20) + 4;
            memoria = gerador.nextInt(992) + 32;
            Processo processo = new Processo("P"+(i+1), tempoProcesso, deadLine, tempoProcesso, Color.YELLOW , memoria);
            probabilidadeMemoria = gerador.nextInt(100);
            //if(probabilidadeMemoria < 30){
                processo.instanteMemoria = tempoProcesso/2;
                processo.memoriaAdicional = 100;
            //}
            processos.add(processo);
        }

        Collections.sort(processos);

        gridAptos.setNumColumns(processos.size());

        gridViewSetting(gridAptos, processos.size(), 70);

        processoAdapter.setProcessos(processos);

        gridAptos.setAdapter(processoAdapter);

    }

    synchronized void construirGridViewFinalizados(){

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
    public void reloadDataGridViewMemoria(LinkedList<BlocoMemoria> memoria){

        synchronized (this){
            construirGridViewMemoria();
        }
    }
    @UiThread
    public void reloadDataGridViewFinalizado(LinkedList<Processo> processos){

        synchronized (this) {
            construirGridViewFinalizados();
        }
    }
}
