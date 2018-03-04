package com.example.sueliopss.escalonador.ui;

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

import com.example.sueliopss.escalonador.R;
import com.example.sueliopss.escalonador.data.model.MemoryBlock;
import com.example.sueliopss.escalonador.data.model.Process;
import com.example.sueliopss.escalonador.data.model.Processor;
import com.example.sueliopss.escalonador.data.model.Request;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class LTGActivity extends AppCompatActivity {

    GridView gridProcessadores;

    GridView gridMemoria;

    GridView gridAptos;

    GridView gridCancelados;

    GridView gridMaisUsada1;

    GridView gridMaisUsada2;

    GridView gridMaisUsada3;

    GridView gridMaisUsada4;

    MemoriaAdapter maisUsada1;

    MemoriaAdapter maisUsada2;

    MemoriaAdapter maisUsada3;

    MemoriaAdapter maisUsada4;

    ProcessadorAdapter processadorAdapter;

    MemoriaAdapter memoriaAdapter;

    ProcessoAdapter processoAdapter;

    ProcessoAdapter finalizadoAdapter;

    HorizontalScrollView horizontalScrollView;

    ScrollView scrollView;

    FloatingActionButton iniciar;

    int numProcessos;

    int numQtdProcessadores;

    int algoritmo;

    int qtdMemoria;

    LinkedList<Process> processes;

    LinkedList<Processor> processadores;

    LinkedList<Process> finalizados;

    LinkedList<MemoryBlock> memoria;

    LinkedList<LinkedList<MemoryBlock>> maisRequisitados;

    LinkedList<Request> requisicoes;


    Semaphore semaphoreProcessador;


    int requisicao;
    int primeiro;
    int segundo;
    int terceiro;
    int quarto;

    static final int BESTFIT = 1;
    static final int MERGEFIT = 2;
    static final int QUICKFIT = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        processadores = new LinkedList<>();
        processes = new LinkedList<>();
        finalizados = new LinkedList<>();
        memoria = new LinkedList<>();
        requisicoes = new LinkedList<>();
    }

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

    synchronized void iniciarEscalonamento(){

        iniciar.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
        iniciar.setClickable(false);
        preencherProcessadores();

        reloadDataGridViewProcessos(processes);
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

    public MemoryBlock pedirMemoria(Process process){

        requisicao++;

        adicionarRequisicao(process.memory);

        MemoryBlock bloco = memoriaNaoUsada(process);

        if( bloco == null) {

            switch (algoritmo) {
                case BESTFIT:
                    bloco = bestFit(process);
                    break;
                case QUICKFIT:
                    bloco = quickFit(process);
                    break;
                case MERGEFIT:
                    bloco = mergeFit(process);
                    break;
            }
        }

        return bloco;

    }

    public MemoryBlock bestFit(Process process){

        MemoryBlock melhorBloco = null;

        for(MemoryBlock bloco : memoria){

            if(!bloco.isBusy && bloco.amount > process.memory) {

                if (melhorBloco != null && bloco.amount < melhorBloco.amount) {
                    bloco.isBusy = true;
                    melhorBloco.isBusy = false;
                    melhorBloco = bloco;
                    bloco.process = process;
                } else  if(bloco.amount < melhorBloco.amount){
                    bloco.isBusy = true;
                    melhorBloco = bloco;
                    melhorBloco.process = process;
                }
            }

        }

        return melhorBloco;
    }

    public MemoryBlock mergeFit(Process process){

        MemoryBlock novoBloco = null;

        for(MemoryBlock bloco : memoria){
            if(!bloco.isBusy && bloco.amount == process.memory){
                bloco.isBusy = true;
                bloco.process = process;
                break;
            }

            if(!bloco.isBusy && bloco.amount > process.memory){
                bloco.isBusy = true;
                bloco.amount -= process.memory;
                novoBloco = new MemoryBlock(bloco.id + 1, process.memory, process, bloco.id + 1);
                novoBloco.isBusy = true;
                novoBloco.process = process;
                memoria.add(novoBloco.id, novoBloco);
                bloco.isBusy = false;
                reinumerarMemoria();
                break;
            }
        }

        return novoBloco;
    }

    public MemoryBlock quickFit(Process process){

        MemoryBlock memoryBlock = null;

        memoryBlock = firstFit(process);


        if(requisicao % 100 == 0){
            gerarMaisRequisitados();
        }


        return memoryBlock;
    }

    public MemoryBlock verificarMaisRequisitados(Process process){

        MemoryBlock bloco = null;

        if(primeiro == process.memory){

            bloco = buscarBlocoLivre(maisRequisitados.get(0), process);
        }

        if(segundo == process.memory){

            bloco = buscarBlocoLivre(maisRequisitados.get(1), process);
        }

        if(terceiro == process.memory){

            bloco = buscarBlocoLivre(maisRequisitados.get(2), process);
        }

        if(quarto == process.memory){

            bloco = buscarBlocoLivre(maisRequisitados.get(3), process);
        }

        return bloco;
    }

    public MemoryBlock buscarBlocoLivre(LinkedList<MemoryBlock> memoriaAuxiliar, Process process){

        MemoryBlock bloco = null;

        for(MemoryBlock memoryBlock : memoriaAuxiliar){

            if(!memoryBlock.isBusy){
                memoryBlock.isBusy = true;
                memoria.get(bloco.id).isBusy = true;
                memoryBlock.process = process;
                bloco = memoryBlock;

            }
        }
        return bloco;
    }

    public void gerarMaisRequisitados(){

        maisRequisitados = new LinkedList<>();
        maisRequisitados.add(new LinkedList<MemoryBlock>());
        maisRequisitados.add(new LinkedList<MemoryBlock>());
        maisRequisitados.add(new LinkedList<MemoryBlock>());
        maisRequisitados.add(new LinkedList<MemoryBlock>());

        Collections.sort(requisicoes);

        for(int i = 0; i < requisicoes.size(); i++){
            switch (i){
                case 1: primeiro = requisicoes.get(0).tamanho; break;
                case 2: segundo = requisicoes.get(1).tamanho; break;
                case 3: terceiro = requisicoes.get(2).tamanho; break;
                case 4: quarto = requisicoes.get(3).tamanho; break;
            }
        }

        for(MemoryBlock bloco : memoria) {

            if (bloco.amount == primeiro) {
                maisRequisitados.get(0).add(bloco);
            }

            if (bloco.amount == segundo) {
                maisRequisitados.get(1).add(bloco);
            }

            if (bloco.amount == terceiro) {
                maisRequisitados.get(2).add(bloco);
            }

            if (bloco.amount == quarto) {
                maisRequisitados.get(3).add(bloco);
            }
        }

        construirGridMaisRequisitado();
    }

    public void adicionarRequisicao(int tamanho){

        boolean encontrou = false;

        for(Request request : requisicoes){

            if (request.tamanho == tamanho){
                request.vezesRequisitadas++;
                encontrou = true;
                break;
            }
        }

        if (!encontrou){
            requisicoes.add(new Request(tamanho));
        }

    }

    public MemoryBlock firstFit(Process process){

        MemoryBlock bloco = null;

        for(MemoryBlock memoryBlock : memoria){

            if(!memoryBlock.isBusy && memoryBlock.amount > process.memory){

                memoryBlock.isBusy = true;
                memoryBlock.process = process;
                bloco = memoryBlock;
                break;
            }
        }
        return bloco;
    }

    synchronized MemoryBlock memoriaNaoUsada(Process process){

        MemoryBlock bloco = null;

        if(process.memory <= qtdMemoria){
            qtdMemoria = qtdMemoria - process.memory;
            bloco = new MemoryBlock(memoria.size(), process.memory, process, null);
            memoria.add(bloco);

        }
        return bloco;
    }

    synchronized void buscarProcessador(){

        for (Processor processor : processadores) {
            if (!processor.is_processando) {
                if(!processes.isEmpty()) {
                    Process process = processes.pop();
                    MemoryBlock bloco = pedirMemoria(process);

                    if (bloco != null) {
                        processor.process = bloco.process;
                        processor.is_processando = true;
                        processor.blocksAddress.add(bloco.id);
                        reloadDataGridViewProcessos(processes);
                        reloadDataGridViewMemoria(memoria);
                        break;
                    }else{
                        processes.addFirst(process);
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

                    Processor processor = processadores.get(j);

                    if (processor.is_processando) {

                        processadores.get(j).process.processTime--;
                        Process process = processor.process;
                        if (processor.process.instanteMemoria > 0) {
                            if (process.instanteMemoria == process.processTime) {
                                Process outroProcess = new Process();
                                outroProcess.processName = process.processName;
                                outroProcess.memory = process.additionalMemory;
                                MemoryBlock bloco = pedirMemoria(outroProcess);

                                if (bloco == null) {
                                    processor.is_processando = false;
                                    abortarProcesso(process);
                                    desalocarMemoria(process);
                                }

                                reloadDataGridViewMemoria(memoria);
                            }
                        }

                        if (processor.is_processando && processor.process.processTime == 0) {

                            liberarProcessador(processor);

                        }
                    }
                }


                reloadDataGridViewProcessador(processadores);


            }
        }, 0, 1000);


    }

    public void adicionarProcesso(){

        synchronized (this){
            Random gerador = new Random();

            int tempoProcesso = gerador.nextInt(20) + 10;

            int deadLine = gerador.nextInt(20) + 4;

            int memoria = gerador.nextInt(20) + 50;

            int ultimoProcesso = numProcessos;

            int probabilidadeMemoria;

            Process process = new Process("P"+ ultimoProcesso++, tempoProcesso, deadLine, tempoProcesso, Color.BLUE, memoria);

            probabilidadeMemoria = gerador.nextInt(100);
            if(probabilidadeMemoria < 30){
                process.instanteMemoria = tempoProcesso/2;
                process.additionalMemory = gerador.nextInt(100) + 50;
            }

            processes.add(process);

            Collections.sort(processes);

            numProcessos = ultimoProcesso;

            reloadDataGridViewProcessos(processes);
        }

    }

    synchronized void desalocarMemoria(Process process){

        for(MemoryBlock memoryBlock : memoria){
            if (memoryBlock.process.processName.equals(process.processName)){
                memoryBlock.isBusy = false;
            }
        }

        reloadDataGridViewMemoria(memoria);

    }

    public void abortarProcesso(Process process){

        process.color = Color.RED;
        finalizados.addFirst(process);
        reloadDataGridViewFinalizado(finalizados);

    }

    synchronized void liberarProcessador(Processor processor){

        processor.process.color = Color.GRAY;

        finalizados.addFirst(processor.process);

        desalocarMemoria(processor.process);

        processor.is_processando = false;

        reloadDataGridViewFinalizado(finalizados);

        semaphoreProcessador.release();
    }

    public void decrementarDeadLines(){

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                synchronized (this) {
                    if (!processes.isEmpty()) {

                        for (int i = 0; i < processes.size(); i++) {
                            Process process = processes.get(i);
                            process.deadLine--;
                            if (process.deadLine == 0) {
                                abortarProcesso(processes.remove(i));
                            }
                        }
                        reloadDataGridViewProcessos(processes);
                    }
                }
            }
        }, 0, 1000);

    }

    public void preencherProcessadores(){

        int idMemoria = 0;
        while(!processes.isEmpty() && idMemoria < processadores.size() && processes.get(0).memory < qtdMemoria){

            Process process = processes.pop();

            memoriaNaoUsada(process);

            processadores.get(idMemoria).process = process;
            processadores.get(idMemoria).process.color = getResources().getColor(R.color.verdeProcesso);
            processadores.get(idMemoria).is_processando = true;
            processadores.get(idMemoria).blocksAddress.add(idMemoria);
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

                for (int i = 1; i < memoria.size(); i++) {
                    MemoryBlock anterior = memoria.get(i - 1);
                    MemoryBlock atual = memoria.get(i);

                    if (!anterior.isBusy && !atual.isBusy) {
                        memoria.remove(i);
                        anterior.amount += atual.amount;
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
            processadores.add(new Processor());
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
            memoria = gerador.nextInt(20) + 50;
            Process process = new Process("P"+(i+1), tempoProcesso, deadLine, tempoProcesso, Color.YELLOW , memoria);
            probabilidadeMemoria = gerador.nextInt(100);
            if(probabilidadeMemoria < 30){
                process.instanteMemoria = tempoProcesso/2;
                process.additionalMemory = gerador.nextInt(100) + 50;
            }
            processes.add(process);
        }

        Collections.sort(processes);

        gridAptos.setNumColumns(processes.size());

        gridViewSetting(gridAptos, processes.size(), 70);

        processoAdapter.setProcesses(processes);

        gridAptos.setAdapter(processoAdapter);

    }

    synchronized void construirGridViewFinalizados(){

        gridCancelados.setNumColumns(finalizados.size());

        gridViewSetting(gridCancelados, finalizados.size(), 70);

        finalizadoAdapter.setProcesses(finalizados);

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

    public void reloadDataGridViewProcessos(LinkedList<Process> processes){

        synchronized (this){
            gridAptos.setNumColumns(processes.size());

            gridViewSetting(gridAptos, processes.size(), 70);

            processoAdapter.setProcesses(processes);

            gridAptos.setAdapter(processoAdapter);
        }

    }

    public void reloadDataGridViewProcessador(LinkedList<Processor> processadores){

        synchronized (this){
            processadorAdapter.setProcessadores(processadores);
            processadorAdapter.notifyDataSetChanged();
        }

    }

    public void reloadDataGridViewMemoria(LinkedList<MemoryBlock> memoria){

        synchronized (this){
            construirGridViewMemoria();
        }
    }

    public void reloadDataGridViewFinalizado(LinkedList<Process> processes){

        synchronized (this) {
            construirGridViewFinalizados();
        }
    }

    public void construirGridMaisRequisitado(){

        for(int i = 0; i < maisRequisitados.size(); i++){

            switch (i){
                case 0 :
                    gridMaisUsada1.setVisibility(View.VISIBLE);
                    gridMaisUsada1.setNumColumns(maisRequisitados.get(i).size());
                    gridViewSetting(gridMaisUsada1, processes.size(), 150);
                    maisUsada1.setBlocos(maisRequisitados.get(i));
                    gridMaisUsada1.setAdapter(maisUsada1);

                case 1 :
                    gridMaisUsada2.setVisibility(View.VISIBLE);
                    gridMaisUsada2.setNumColumns(maisRequisitados.get(i).size());
                    gridViewSetting(gridMaisUsada2, processes.size(), 150);
                    maisUsada2.setBlocos(maisRequisitados.get(i));
                    gridMaisUsada2.setAdapter(maisUsada2);

                case 2 :
                    gridMaisUsada3.setVisibility(View.VISIBLE);
                    gridMaisUsada3.setNumColumns(maisRequisitados.get(i).size());
                    gridViewSetting(gridMaisUsada3, processes.size(), 150);
                    maisUsada3.setBlocos(maisRequisitados.get(i));
                    gridMaisUsada3.setAdapter(maisUsada3);

                case 3 :
                    gridMaisUsada4.setVisibility(View.VISIBLE);
                    gridMaisUsada4.setNumColumns(maisRequisitados.get(i).size());
                    gridViewSetting(gridMaisUsada4, processes.size(), 150);
                    maisUsada4.setBlocos(maisRequisitados.get(i));
                    gridMaisUsada4.setAdapter(maisUsada4);

            }
        }
    }
}