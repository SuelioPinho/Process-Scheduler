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

    @ViewById(R.id.gridMaisUsada1)
    GridView gridMaisUsada1;

    @ViewById(R.id.gridMaisUsada2)
    GridView gridMaisUsada2;

    @ViewById(R.id.gridMaisUsada3)
    GridView gridMaisUsada3;

    @ViewById(R.id.gridMaisUsada4)
    GridView gridMaisUsada4;

    @Bean
    MemoriaAdapter maisUsadaAdapter1;

    @Bean
    MemoriaAdapter maisUsadaAdapter2;

    @Bean
    MemoriaAdapter maisUsadaAdapter3;

    @Bean
    MemoriaAdapter maisUsadaAdapter4;

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

    LinkedList<LinkedList<BlocoMemoria>> maisRequisitados;

    LinkedList<Requisicao> requisicoes;


    Semaphore semaphoreProcessador;

    int qtdMemoria;
    int requisicao;
    int primeiro;
    int segundo;
    int terceiro;
    int quarto;

    static final int BESTFIT = 0;
    static final int MERGEFIT = 1;
    static final int QUICKFIT = 2;
    static final int algoritmo = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        processadores = new LinkedList<>();
        processos = new LinkedList<>();
        finalizados = new LinkedList<>();
        memoria = new LinkedList<>();
        requisicoes = new LinkedList<>();
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
        if(algoritmo == MERGEFIT){
            mesclarBlocos();
        }

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

        requisicao++;
        adicionarRequisicao(processo.memoria);

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
//
    synchronized BlocoMemoria bestFit(Processo processo){

        BlocoMemoria melhorBloco = null;

        for(int i = 0; i < memoria.size(); i++){
            BlocoMemoria bloco = memoria.get(i);

            if(!bloco.is_ocupado &&bloco.tamanho > processo.memoria) {

                if (melhorBloco != null && bloco.tamanho < melhorBloco.tamanho) {
                    bloco.is_ocupado = true;
                    memoria.get(melhorBloco.id).is_ocupado= false;
                    melhorBloco = bloco;
                    bloco.processo = processo;

                } else if (melhorBloco == null){
                    bloco.is_ocupado = true;
                    melhorBloco = bloco;
                    melhorBloco.processo = processo;
                }
            }
        }

        return melhorBloco;
    }

    public BlocoMemoria mergeFit(Processo processo){

        BlocoMemoria novoBloco = null;

        for(BlocoMemoria bloco : memoria){
            if(!bloco.is_ocupado &&bloco.tamanho == processo.memoria){
                bloco.is_ocupado = true;
                bloco.processo = processo;
                break;
            }

            if(!bloco.is_ocupado &&bloco.tamanho > processo.memoria){
                bloco.is_ocupado = true;
                bloco.tamanho-=processo.memoria;
                novoBloco = new BlocoMemoria(bloco.id + 1, processo.memoria, processo, bloco.id + 1);
                novoBloco.is_ocupado = true;
                novoBloco.processo = processo;
                memoria.add(novoBloco.id, novoBloco);
                bloco.is_ocupado = false;
                reinumerarMemoria();
                break;
            }
        }

        return novoBloco;
    }

    public BlocoMemoria quickFit(Processo processo){

        BlocoMemoria blocoMemoria = null;

        if(requisicao <= 100){
            blocoMemoria = firstFit(processo);
        }

        if(requisicao == 100){
            gerarMaisRequisitados();
        }

        if(requisicao > 100){
            blocoMemoria = firstFit(processo);
        }



//        if(requisicao > 100){
//            blocoMemoria = verificarMaisRequisitados(processo);
//            if (blocoMemoria == null){
//                firstFit(processo);
//            }
//        }

        return blocoMemoria;
    }

    public BlocoMemoria verificarMaisRequisitados(Processo processo){

        BlocoMemoria bloco = null;

        if(primeiro == processo.memoria){

            bloco = buscarBlocoLivre(maisRequisitados.get(0), processo);
        }

        if(segundo == processo.memoria){

            bloco = buscarBlocoLivre(maisRequisitados.get(1), processo);
        }

        if(terceiro == processo.memoria){

            bloco = buscarBlocoLivre(maisRequisitados.get(2), processo);
        }

        if(quarto == processo.memoria){

            bloco = buscarBlocoLivre(maisRequisitados.get(3), processo);
        }

        return bloco;
    }

    public BlocoMemoria buscarBlocoLivre(LinkedList<BlocoMemoria> memoriaAuxiliar, Processo processo){

        BlocoMemoria bloco = null;

        for(BlocoMemoria blocoMemoria : memoriaAuxiliar){

            if(!blocoMemoria.is_ocupado){
                blocoMemoria.is_ocupado = true;
                memoria.get(bloco.id).is_ocupado = true;
                blocoMemoria.processo = processo;
                bloco = blocoMemoria;

            }
        }
         return bloco;
    }

    public void gerarMaisRequisitados(){

        maisRequisitados = new LinkedList<>();
        maisRequisitados.add(new LinkedList<BlocoMemoria>());
        maisRequisitados.add(new LinkedList<BlocoMemoria>());
        maisRequisitados.add(new LinkedList<BlocoMemoria>());
        maisRequisitados.add(new LinkedList<BlocoMemoria>());

        Collections.sort(requisicoes);

        for(int i = 0; i < requisicoes.size(); i++){
            switch (i){
                case 1: primeiro = requisicoes.get(0).tamanho; break;
                case 2: segundo = requisicoes.get(1).tamanho; break;
                case 3: terceiro = requisicoes.get(2).tamanho; break;
                case 4: quarto = requisicoes.get(3).tamanho; break;
            }
        }

        for(BlocoMemoria bloco : memoria) {

            if (bloco.tamanho == primeiro) {
                maisRequisitados.get(0).add(bloco);
            }

            if (bloco.tamanho == segundo) {
                maisRequisitados.get(1).add(bloco);
            }

            if (bloco.tamanho == terceiro) {
                maisRequisitados.get(2).add(bloco);
            }

            if (bloco.tamanho == quarto) {
                maisRequisitados.get(3).add(bloco);
            }
        }

        construirGridMaisUsada();
    }

    public void adicionarRequisicao(int tamanho){

        boolean encontrou = false;

        for(Requisicao requisicao : requisicoes){

            if (requisicao.tamanho == tamanho){
                requisicao.vezesRequisitadas++;
                encontrou = true;
                break;
            }
        }

        if (encontrou == false){
            requisicoes.add(new Requisicao(tamanho));
        }

    }

    public BlocoMemoria firstFit(Processo processo){

        BlocoMemoria bloco = null;

        for(BlocoMemoria blocoMemoria : memoria){

            if(!blocoMemoria.is_ocupado && blocoMemoria.tamanho > processo.memoria){

                blocoMemoria.is_ocupado = true;
                blocoMemoria.processo = processo;
                bloco = blocoMemoria;
            }
        }
        return bloco;
    }

    synchronized BlocoMemoria memoriaNaoUsada(Processo processo){

        BlocoMemoria bloco = null;

        if(processo.memoria <= qtdMemoria){
            qtdMemoria = qtdMemoria - processo.memoria;
            bloco = new BlocoMemoria(memoria.size(), processo.memoria, processo, null);
            memoria.add(bloco);
        }
        return bloco;
    }

    synchronized void buscarProcessador(){

        for (Processador processador : processadores) {
            if (!processador.is_processando) {
                if(!processos.isEmpty()) {
                    Processo processo = processos.pop();
                    BlocoMemoria bloco = pedirMemoria(processo);

                    if (bloco != null) {
                        processador.processo = bloco.processo;
                        processador.is_processando = true;
                        processador.enderecoBlocos.add(bloco.id);
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
                        Processo processo = processador.processo;
                        if (processador.processo.instanteMemoria > 0) {
                            if (processo.instanteMemoria == processo.tempoProcesso) {
                                Processo outroProcesso = new Processo();
                                outroProcesso.nomeProcesso = processo.nomeProcesso;
                                outroProcesso.memoria = processo.memoriaAdicional;
                                BlocoMemoria bloco = pedirMemoria(outroProcesso);

                                if (bloco == null) {
                                    processador.is_processando = false;
                                    abortarProcesso(processo);
                                    desalocarMemoria(processo);
                                }

                                reloadDataGridViewMemoria(memoria);
                            }
                        }

                        if (processador.is_processando && processador.processo.tempoProcesso == 0) {

                            liberarProcessador(processador);

                        }
                    }
                }


                reloadDataGridViewProcessador(processadores);
                //mesclarBlocos();

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

    synchronized void desalocarMemoria(Processo processo){

        for(BlocoMemoria blocoMemoria : memoria){
            if (blocoMemoria.processo.nomeProcesso.equals(processo.nomeProcesso)){
                blocoMemoria.is_ocupado = false;
            }
        }

        reloadDataGridViewMemoria(memoria);

    }

    public void abortarProcesso(Processo processo){

        processo.color = Color.RED;
        finalizados.addFirst(processo);
        reloadDataGridViewFinalizado(finalizados);

    }

    synchronized void liberarProcessador(Processador processador){

        processador.processo.color = Color.GRAY;

        finalizados.addFirst(processador.processo);

        desalocarMemoria(processador.processo);

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

        construirGridViewMemoria();
        reloadDataGridViewProcessador(processadores);
        processar();
    }

    synchronized void reinumerarMemoria(){
        for(int i = 0; i < memoria.size(); i++){
            memoria.get(i).id = i;
        }
    }

    synchronized void mesclarBlocos(){

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                for (int i = 1; i < memoria.size();i++){
                    BlocoMemoria anterior = memoria.get(i-1);
                    BlocoMemoria atual = memoria.get(i);

                    if(!anterior.is_ocupado && !atual.is_ocupado){
                        memoria.remove(i);
                        anterior.tamanho+=atual.tamanho;
                        reinumerarMemoria();

                    }
                }

                reloadDataGridViewMemoria(memoria);

            }
        }, 0, 1000);

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
    @UiThread
    public void construirGridMaisUsada(){
        gridMaisUsada1.setVisibility(View.VISIBLE);
        gridMaisUsada2.setVisibility(View.VISIBLE);
        gridMaisUsada3.setVisibility(View.VISIBLE);
        gridMaisUsada4.setVisibility(View.VISIBLE);

        gridMaisUsada1.setNumColumns(maisRequisitados.get(0).size());
        gridMaisUsada2.setNumColumns(maisRequisitados.get(1).size());
        gridMaisUsada3.setNumColumns(maisRequisitados.get(2).size());
        gridMaisUsada4.setNumColumns(maisRequisitados.get(3).size());

        gridViewSetting(gridMaisUsada1, maisRequisitados.get(0).size(), 150);
        gridViewSetting(gridMaisUsada1, maisRequisitados.get(1).size(), 150);
        gridViewSetting(gridMaisUsada1, maisRequisitados.get(2).size(), 150);
        gridViewSetting(gridMaisUsada1, maisRequisitados.get(3).size(), 150);

        maisUsadaAdapter1.setBlocos(maisRequisitados.get(0));
        maisUsadaAdapter1.setBlocos(maisRequisitados.get(1));
        maisUsadaAdapter1.setBlocos(maisRequisitados.get(2));
        maisUsadaAdapter1.setBlocos(maisRequisitados.get(3));

        gridMaisUsada1.setAdapter(maisUsadaAdapter1);
        gridMaisUsada2.setAdapter(maisUsadaAdapter2);
        gridMaisUsada3.setAdapter(maisUsadaAdapter3);
        gridMaisUsada4.setAdapter(maisUsadaAdapter4);
    }
}
