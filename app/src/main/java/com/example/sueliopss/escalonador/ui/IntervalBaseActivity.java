package com.example.sueliopss.escalonador.ui;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.sueliopss.escalonador.R;
import com.example.sueliopss.escalonador.data.model.Process;
import com.example.sueliopss.escalonador.data.model.Processor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class IntervalBaseActivity extends AppCompatActivity{

    LinearLayout linear1;

    LinearLayout linear2;

    LinearLayout linear3;

    LinearLayout linear4;

    LinearLayout linear5;

    LinearLayout linear6;

    LinearLayout linear7;

    LinearLayout linear8;

    LinearLayout linear9;

    LinearLayout linear10;

    LinearLayout linear11;

    LinearLayout linear12;

    LinearLayout linear13;

    LinearLayout linear14;

    LinearLayout linear15;

    LinearLayout linear16;

    LinearLayout linear17;

    LinearLayout linear18;

    LinearLayout linear19;

    LinearLayout linear20;

    LinearLayout linear21;

    LinearLayout linear22;

    LinearLayout linear23;

    LinearLayout linear24;

    LinearLayout linear25;

    LinearLayout linear26;

    LinearLayout linear27;

    LinearLayout linear28;

    LinearLayout linear29;

    LinearLayout linear30;

    LinearLayout linear31;

    LinearLayout linear32;

    LinearLayout linear33;

    LinearLayout linear34;

    LinearLayout linear35;

    LinearLayout linear36;

    LinearLayout linear37;

    LinearLayout linear38;

    LinearLayout linear39;

    LinearLayout linear40;

    LinearLayout linear41;

    LinearLayout linear42;

    LinearLayout linear43;

    LinearLayout linear44;

    LinearLayout linear45;

    LinearLayout linear46;

    LinearLayout linear47;

    LinearLayout linear48;

    LinearLayout linear49;

    LinearLayout linear50;

    LinearLayout linear51;

    LinearLayout linear52;

    LinearLayout linear53;

    LinearLayout linear54;

    LinearLayout linear55;

    LinearLayout linear56;

    LinearLayout linear57;

    LinearLayout linear58;

    LinearLayout linear59;

    LinearLayout linear60;

    LinearLayout linear61;

    LinearLayout linear62;

    LinearLayout linear63;

    LinearLayout linear64;

    LinearLayout linearRem;


    TextView processador1;

    TextView processador2;

    TextView processador3;

    TextView processador4;

    TextView processador5;

    TextView processador6;

    TextView processador7;

    TextView processador8;

    TextView processador9;

    TextView processador10;

    TextView processador11;

    TextView processador12;

    TextView processador13;

    TextView processador14;

    TextView processador15;

    TextView processador16;

    TextView processador17;

    TextView processador18;

    TextView processador19;

    TextView processador20;

    TextView processador21;

    TextView processador22;

    TextView processador23;

    TextView processador24;

    TextView processador25;

    TextView processador26;

    TextView processador27;

    TextView processador28;

    TextView processador29;

    TextView processador30;

    TextView processador31;

    TextView processador32;

    TextView processador33;

    TextView processador34;

    TextView processador35;

    TextView processador36;

    TextView processador37;

    TextView processador38;

    TextView processador39;

    TextView processador40;

    TextView processador41;

    TextView processador42;

    TextView processador43;

    TextView processador44;

    TextView processador45;

    TextView processador46;

    TextView processador47;

    TextView processador48;

    TextView processador49;

    TextView processador50;

    TextView processador51;

    TextView processador52;

    TextView processador53;

    TextView processador54;

    TextView processador55;

    TextView processador56;

    TextView processador57;

    TextView processador58;

    TextView processador59;

    TextView processador60;

    TextView processador61;

    TextView processador62;

    TextView processador63;

    TextView processador64;

    GridView gridProcessadores;

    GridView gridAptos1;

    GridView gridAptos2;

    GridView gridAptos3;

    GridView gridAptos4;

    GridView gridAptos5;

    GridView gridAptos6;

    GridView gridAptos7;

    GridView gridAptos8;

    GridView gridAptos9;

    GridView gridAptos10;

    GridView gridAptos11;

    GridView gridAptos12;

    GridView gridAptos13;

    GridView gridAptos14;

    GridView gridAptos15;

    GridView gridAptos16;

    GridView gridAptos17;

    GridView gridAptos18;

    GridView gridAptos19;

    GridView gridAptos20;

    GridView gridAptos21;

    GridView gridAptos22;

    GridView gridAptos23;

    GridView gridAptos24;

    GridView gridAptos25;

    GridView gridAptos26;

    GridView gridAptos27;

    GridView gridAptos28;

    GridView gridAptos29;

    GridView gridAptos30;

    GridView gridAptos31;

    GridView gridAptos32;

    GridView gridAptos33;

    GridView gridAptos34;

    GridView gridAptos35;

    GridView gridAptos36;

    GridView gridAptos37;

    GridView gridAptos38;

    GridView gridAptos39;

    GridView gridAptos40;

    GridView gridAptos41;

    GridView gridAptos42;

    GridView gridAptos43;

    GridView gridAptos44;

    GridView gridAptos45;

    GridView gridAptos46;

    GridView gridAptos47;

    GridView gridAptos48;

    GridView gridAptos49;

    GridView gridAptos50;

    GridView gridAptos51;

    GridView gridAptos52;

    GridView gridAptos53;

    GridView gridAptos54;

    GridView gridAptos55;

    GridView gridAptos56;

    GridView gridAptos57;

    GridView gridAptos58;

    GridView gridAptos59;

    GridView gridAptos60;

    GridView gridAptos61;

    GridView gridAptos62;

    GridView gridAptos63;

    GridView gridAptos64;

    GridView gridAptosRem;

    GridView gridCancelados;

    ProcessadorAdapter processadorAdapter;

    ProcessoAdapter processoAdapter1;

    ProcessoAdapter processoAdapter2;

    ProcessoAdapter processoAdapter3;

    ProcessoAdapter processoAdapter4;

    ProcessoAdapter processoAdapter5;

    ProcessoAdapter processoAdapter6;

    ProcessoAdapter processoAdapter7;

    ProcessoAdapter processoAdapter8;

    ProcessoAdapter processoAdapter9;

    ProcessoAdapter processoAdapter10;

    ProcessoAdapter processoAdapter11;

    ProcessoAdapter processoAdapter12;

    ProcessoAdapter processoAdapter13;

    ProcessoAdapter processoAdapter14;

    ProcessoAdapter processoAdapter15;

    ProcessoAdapter processoAdapter16;

    ProcessoAdapter processoAdapter17;

    ProcessoAdapter processoAdapter18;

    ProcessoAdapter processoAdapter19;

    ProcessoAdapter processoAdapter20;

    ProcessoAdapter processoAdapter21;

    ProcessoAdapter processoAdapter22;

    ProcessoAdapter processoAdapter23;

    ProcessoAdapter processoAdapter24;

    ProcessoAdapter processoAdapter25;

    ProcessoAdapter processoAdapter26;

    ProcessoAdapter processoAdapter27;

    ProcessoAdapter processoAdapter28;

    ProcessoAdapter processoAdapter29;

    ProcessoAdapter processoAdapter30;

    ProcessoAdapter processoAdapter31;

    ProcessoAdapter processoAdapter32;

    ProcessoAdapter processoAdapter33;

    ProcessoAdapter processoAdapter34;

    ProcessoAdapter processoAdapter35;

    ProcessoAdapter processoAdapter36;

    ProcessoAdapter processoAdapter37;

    ProcessoAdapter processoAdapter38;

    ProcessoAdapter processoAdapter39;

    ProcessoAdapter processoAdapter40;

    ProcessoAdapter processoAdapter41;

    ProcessoAdapter processoAdapter42;

    ProcessoAdapter processoAdapter43;

    ProcessoAdapter processoAdapter44;

    ProcessoAdapter processoAdapter45;

    ProcessoAdapter processoAdapter46;

    ProcessoAdapter processoAdapter47;

    ProcessoAdapter processoAdapter48;

    ProcessoAdapter processoAdapter49;

    ProcessoAdapter processoAdapter50;

    ProcessoAdapter processoAdapter51;

    ProcessoAdapter processoAdapter52;

    ProcessoAdapter processoAdapter53;

    ProcessoAdapter processoAdapter54;

    ProcessoAdapter processoAdapter55;

    ProcessoAdapter processoAdapter56;

    ProcessoAdapter processoAdapter57;

    ProcessoAdapter processoAdapter58;

    ProcessoAdapter processoAdapter59;

    ProcessoAdapter processoAdapter60;

    ProcessoAdapter processoAdapter61;

    ProcessoAdapter processoAdapter62;

    ProcessoAdapter processoAdapter63;

    ProcessoAdapter processoAdapter64;

    ProcessoAdapter processoAdapterRem;

    ProcessoAdapter finalizadoAdapter;

    ProcessoAdapter remanecenteAdapter;

    ScrollView scrollView;

    int numProcessos;

    int numQtdProcessadores;

    int algoritmo;

    int qtdMemoria;

    FloatingActionButton iniciar;

    LinkedList<Processor> processadores;

    LinkedList<LinkedList<Process>> processosList = new LinkedList<>();

    LinkedList<Process> finalizados;

    LinkedList<Process> remanecentes;

    Semaphore semaphore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        processadores = new LinkedList<>();
        finalizados = new LinkedList<>();
        remanecentes = new LinkedList<>();
    }

    public void afterViews(){
        criarListas();
        ativarGridView();
        prepararEscalonamento();
    }

    synchronized void iniciarEscalonamento() {

        iniciar.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
        iniciar.setClickable(false);
        decrementarDeadLines();
        processar();
        decrementarRemanecente();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                try {
                    semaphore.acquire();

                    for (int i = 0; i < processadores.size(); i++) {
                        Processor processor = processadores.get(i);
                        if (!processor.is_processando) {
                            if (!processosList.get(i).isEmpty()) {
                                if (processosList.get(i).get(0).deadLine == 0) {
                                    processor.process = processosList.get(i).pop();
                                    processor.is_processando = true;
                                    reloadDataGridViewProcessos(i);
                                }
                            }
                        }
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
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

                for (int j = 0; j < processadores.size(); j++) {
                    Processor processor = processadores.get(j);
                    if (processor.is_processando) {
                        processadores.get(j).process.processTime--;
                        if (processor.process.processTime == 0) {
                            processor.process.color = Color.GRAY;
                            finalizados.add(processor.process);
                            processadores.get(j).process = null;
                            processadores.get(j).is_processando = false;
                            reloadDataGridViewFinalizado();
                            semaphore.release();

                        }
                    }
                }

                reloadDataGridViewProcessador(processadores);

            }
        }, 0, 1000);


    }

    synchronized void adicionarProcesso(){

      Random gerador = new Random();

      int tempoProcesso = gerador.nextInt(8) + 2;

      int deadLine = gerador.nextInt(20) + 2;

      int memoria = gerador.nextInt(20) + 10;

      int ultimoProcesso = numProcessos;

      Process process = new Process("P"+ ultimoProcesso++, tempoProcesso, deadLine, tempoProcesso, Color.BLUE, memoria);

      synchronized (this){
        remanecentes.add(process);

        for(int i = 0; i < numQtdProcessadores; i++){

          for(int j = 0; j < remanecentes.size(); j++){
              processosList.get(i).add(remanecentes.pop());
          }
          processosList.set(i, gerarFilaExecucao(processosList.get(i)));
          reloadDataGridViewProcessos(i);
        }
      }
    }

    synchronized void decrementarDeadLines(){

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {


                        for (int i = 0; i < processosList.size(); i++) {

                            if(!processosList.get(i).isEmpty()){
                                for(int j = 0; j < processosList.get(i).size(); j++){
                                    if(processosList.get(i).get(j).deadLine > 0){
                                        processosList.get(i).get(j).deadLine--;

                                    }

                                    reloadDataGridViewProcessos(i);

                                }
                            }

                        }


            }
        }, 0, 1000);

    }

    synchronized void decrementarRemanecente(){
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {


                    for (int i = 0; i < remanecentes.size(); i++) {

                        if(!remanecentes.isEmpty()){
                            remanecentes.get(i).deadLine--;
                            if(remanecentes.get(i).deadLine == 0){
                                remanecentes.get(i).color = Color.RED;
                                finalizados.add(remanecentes.remove(i));
                            }
                        }

                    }

                    reloadDataGridViewRemanecente();

                    reloadDataGridViewFinalizado();


            }
        }, 0, 1000);
    }

    public LinkedList<Process> gerarFilaExecucao(LinkedList<Process> iniciais){

        Process process;
        LinkedList<Process> processes;
        try{

            Collections.sort(iniciais);
            process = iniciais.get(0);
            LinkedList<Process> auxRem = new LinkedList<>();
            processes = new LinkedList<>();
            processes.add(iniciais.pop());
            while(!iniciais.isEmpty()){
                if((process.deadLine + process.processTime < iniciais.get(0).deadLine) || (process.deadLine + process.processTime == iniciais.get(0).deadLine)){
                    process = iniciais.get(0);
                    processes.add(iniciais.pop());
                }else{
                    auxRem.add(iniciais.pop());
                }
            }

            remanecentes = auxRem;

        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            return iniciais;
        }


        return processes;
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

    public void prepararEscalonamento(){

        semaphore = new Semaphore(numQtdProcessadores);

        contruirGridViewProcessadores();

        contruirGridViewProcessos();

        construirGridViewRemanecente();

        contruirGridViewFinalizados();

        setGridViewHeightBasedOnChildren(gridProcessadores, 8);

    }

    public void contruirGridViewProcessadores(){

        for (int i = 0; i < numQtdProcessadores; i++){
            processadores.add(new Processor());
        }

        processadorAdapter.setProcessadores(processadores);

        gridProcessadores.setAdapter(processadorAdapter);

    }

    public void contruirGridViewProcessos(){

        int count = 0;
        Random gerador = new Random();

        LinkedList<Process> iniciais = new LinkedList<>();

        int tempoProcesso;
        int deadLine;
        int memoria;

        for (int i = 0; i < numProcessos; i++) {
            tempoProcesso = gerador.nextInt(8) + 2;
            deadLine = gerador.nextInt(20) + 2;
            memoria = gerador.nextInt(20) + 10;
            iniciais.add(new Process("P" + (i + 1), tempoProcesso, deadLine, tempoProcesso, getResources().getColor(R.color.amareloProcesso), memoria));

            if (count == numQtdProcessadores - 1){
                count = 0;
            }else {
                count ++;
            }
        }

        processosList.set(0, gerarFilaExecucao(iniciais));

        for(int i = 1; i < numQtdProcessadores; i++){
            if(!remanecentes.isEmpty()) {
                iniciais = remanecentes;
                processosList.set(i, gerarFilaExecucao(iniciais));
            }
        }

        setColumsGridView();

        setGridViewSettings();

        setProcessosAdapter();

        setAdapterGridView();

    }

    public void contruirGridViewFinalizados(){

        gridCancelados.setNumColumns(finalizados.size());

        gridViewSetting(gridCancelados, finalizados.size());

        finalizadoAdapter.setProcesses(finalizados);

        gridCancelados.setAdapter(finalizadoAdapter);

    }

    public void construirGridViewRemanecente(){

      gridAptosRem.setNumColumns(remanecentes.size());

      gridViewSetting(gridAptosRem, remanecentes.size());

      remanecenteAdapter.setProcesses(remanecentes);

      gridAptosRem.setAdapter(remanecenteAdapter);

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

    public void reloadDataGridViewProcessos(int numFilaProcesso){

        synchronized (this){

            switch (numFilaProcesso){
                case 0:
                    gridAptos1.setNumColumns(processosList.get(0).size());

                    gridViewSetting(gridAptos1, processosList.get(0).size());

                    processoAdapter1.setProcesses(processosList.get(0));

                    gridAptos1.setAdapter(processoAdapter1);

                    break;
                case 1:
                    gridAptos2.setNumColumns(processosList.get(1).size());

                    gridViewSetting(gridAptos2, processosList.get(1).size());

                    processoAdapter2.setProcesses(processosList.get(1));

                    gridAptos2.setAdapter(processoAdapter2);

                    break;
                case 2:
                    gridAptos3.setNumColumns(processosList.get(2).size());

                    gridViewSetting(gridAptos3, processosList.get(2).size());

                    processoAdapter3.setProcesses(processosList.get(2));

                    gridAptos3.setAdapter(processoAdapter3);

                    break;
                case 3:
                    gridAptos4.setNumColumns(processosList.get(3).size());

                    gridViewSetting(gridAptos4, processosList.get(3).size());

                    processoAdapter4.setProcesses(processosList.get(3));

                    gridAptos4.setAdapter(processoAdapter4);

                    break;
                case 4:
                    gridAptos5.setNumColumns(processosList.get(4).size());

                    gridViewSetting(gridAptos5, processosList.get(4).size());

                    processoAdapter5.setProcesses(processosList.get(4));

                    gridAptos5.setAdapter(processoAdapter5);

                    break;
                case 5:
                    gridAptos6.setNumColumns(processosList.get(5).size());

                    gridViewSetting(gridAptos6, processosList.get(5).size());

                    processoAdapter6.setProcesses(processosList.get(5));

                    gridAptos6.setAdapter(processoAdapter6);

                    break;
                case 6:
                    gridAptos7.setNumColumns(processosList.get(6).size());

                    gridViewSetting(gridAptos7, processosList.get(6).size());

                    processoAdapter7.setProcesses(processosList.get(6));

                    gridAptos7.setAdapter(processoAdapter7);

                    break;
                case 7:
                    gridAptos8.setNumColumns(processosList.get(7).size());

                    gridViewSetting(gridAptos8, processosList.get(7).size());

                    processoAdapter8.setProcesses(processosList.get(7));

                    gridAptos8.setAdapter(processoAdapter8);

                    break;
                case 8:
                    gridAptos9.setNumColumns(processosList.get(8).size());

                    gridViewSetting(gridAptos9, processosList.get(8).size());

                    processoAdapter9.setProcesses(processosList.get(8));

                    gridAptos9.setAdapter(processoAdapter9);

                    break;
                case 9:
                    gridAptos10.setNumColumns(processosList.get(9).size());

                    gridViewSetting(gridAptos10, processosList.get(9).size());

                    processoAdapter10.setProcesses(processosList.get(9));

                    gridAptos10.setAdapter(processoAdapter10);

                    break;
                case 10:
                    gridAptos11.setNumColumns(processosList.get(10).size());

                    gridViewSetting(gridAptos11, processosList.get(10).size());

                    processoAdapter11.setProcesses(processosList.get(10));

                    gridAptos11.setAdapter(processoAdapter11);

                    break;
                case 11:
                    gridAptos12.setNumColumns(processosList.get(11).size());

                    gridViewSetting(gridAptos12, processosList.get(11).size());

                    processoAdapter12.setProcesses(processosList.get(11));

                    gridAptos12.setAdapter(processoAdapter12);

                    break;
                case 12:
                    gridAptos13.setNumColumns(processosList.get(12).size());

                    gridViewSetting(gridAptos13, processosList.get(12).size());

                    processoAdapter13.setProcesses(processosList.get(12));

                    gridAptos13.setAdapter(processoAdapter13);

                    break;
                case 13:
                    gridAptos14.setNumColumns(processosList.get(13).size());

                    gridViewSetting(gridAptos14, processosList.get(13).size());

                    processoAdapter14.setProcesses(processosList.get(13));

                    gridAptos14.setAdapter(processoAdapter14);

                    break;
                case 14:
                    gridAptos15.setNumColumns(processosList.get(14).size());

                    gridViewSetting(gridAptos14, processosList.get(15).size());

                    processoAdapter14.setProcesses(processosList.get(15));

                    gridAptos14.setAdapter(processoAdapter15);

                    break;
                case 15:
                    gridAptos16.setNumColumns(processosList.get(15).size());

                    gridViewSetting(gridAptos16, processosList.get(15).size());

                    processoAdapter16.setProcesses(processosList.get(15));

                    gridAptos16.setAdapter(processoAdapter16);

                    break;
                case 16:
                    gridAptos17.setNumColumns(processosList.get(16).size());

                    gridViewSetting(gridAptos17, processosList.get(16).size());

                    processoAdapter17.setProcesses(processosList.get(16));

                    gridAptos17.setAdapter(processoAdapter17);

                    break;
                case 17:
                    gridAptos18.setNumColumns(processosList.get(17).size());

                    gridViewSetting(gridAptos18, processosList.get(17).size());

                    processoAdapter18.setProcesses(processosList.get(17));

                    gridAptos18.setAdapter(processoAdapter18);

                    break;
                case 18:
                    gridAptos19.setNumColumns(processosList.get(18).size());

                    gridViewSetting(gridAptos19, processosList.get(18).size());

                    processoAdapter19.setProcesses(processosList.get(18));

                    gridAptos19.setAdapter(processoAdapter19);

                    break;
                case 19:
                    gridAptos20.setNumColumns(processosList.get(19).size());

                    gridViewSetting(gridAptos20, processosList.get(19).size());

                    processoAdapter20.setProcesses(processosList.get(19));

                    gridAptos20.setAdapter(processoAdapter20);

                    break;
                case 20:
                    gridAptos21.setNumColumns(processosList.get(20).size());

                    gridViewSetting(gridAptos21, processosList.get(20).size());

                    processoAdapter21.setProcesses(processosList.get(20));

                    gridAptos21.setAdapter(processoAdapter21);

                    break;
                case 21:
                    gridAptos22.setNumColumns(processosList.get(21).size());

                    gridViewSetting(gridAptos22, processosList.get(21).size());

                    processoAdapter22.setProcesses(processosList.get(21));

                    gridAptos22.setAdapter(processoAdapter22);

                    break;
                case 22:
                    gridAptos23.setNumColumns(processosList.get(22).size());

                    gridViewSetting(gridAptos23, processosList.get(22).size());

                    processoAdapter23.setProcesses(processosList.get(22));

                    gridAptos23.setAdapter(processoAdapter23);

                    break;
                case 23:
                    gridAptos24.setNumColumns(processosList.get(23).size());

                    gridViewSetting(gridAptos24, processosList.get(23).size());

                    processoAdapter24.setProcesses(processosList.get(23));

                    gridAptos24.setAdapter(processoAdapter24);

                    break;
                case 24:
                    gridAptos25.setNumColumns(processosList.get(24).size());

                    gridViewSetting(gridAptos25, processosList.get(24).size());

                    processoAdapter25.setProcesses(processosList.get(24));

                    gridAptos25.setAdapter(processoAdapter25);

                    break;
                case 25:
                    gridAptos26.setNumColumns(processosList.get(25).size());

                    gridViewSetting(gridAptos26, processosList.get(25).size());

                    processoAdapter26.setProcesses(processosList.get(25));

                    gridAptos26.setAdapter(processoAdapter26);

                    break;
                case 26:
                    gridAptos27.setNumColumns(processosList.get(26).size());

                    gridViewSetting(gridAptos27, processosList.get(26).size());

                    processoAdapter27.setProcesses(processosList.get(26));

                    gridAptos27.setAdapter(processoAdapter27);

                    break;
                case 27:
                    gridAptos28.setNumColumns(processosList.get(27).size());

                    gridViewSetting(gridAptos28, processosList.get(27).size());

                    processoAdapter28.setProcesses(processosList.get(27));

                    gridAptos28.setAdapter(processoAdapter28);

                    break;
                case 28:
                    gridAptos29.setNumColumns(processosList.get(28).size());

                    gridViewSetting(gridAptos29, processosList.get(28).size());

                    processoAdapter29.setProcesses(processosList.get(28));

                    gridAptos29.setAdapter(processoAdapter29);

                    break;
                case 29:
                    gridAptos30.setNumColumns(processosList.get(29).size());

                    gridViewSetting(gridAptos30, processosList.get(29).size());

                    processoAdapter30.setProcesses(processosList.get(29));

                    gridAptos30.setAdapter(processoAdapter30);

                    break;
                case 30:
                    gridAptos31.setNumColumns(processosList.get(30).size());

                    gridViewSetting(gridAptos31, processosList.get(30).size());

                    processoAdapter31.setProcesses(processosList.get(30));

                    gridAptos31.setAdapter(processoAdapter31);

                    break;
                case 31:
                    gridAptos32.setNumColumns(processosList.get(31).size());

                    gridViewSetting(gridAptos32, processosList.get(31).size());

                    processoAdapter32.setProcesses(processosList.get(31));

                    gridAptos32.setAdapter(processoAdapter32);

                    break;
                case 32:
                    gridAptos33.setNumColumns(processosList.get(32).size());

                    gridViewSetting(gridAptos33, processosList.get(32).size());

                    processoAdapter33.setProcesses(processosList.get(32));

                    gridAptos33.setAdapter(processoAdapter33);

                    break;
                case 33:
                    gridAptos34.setNumColumns(processosList.get(33).size());

                    gridViewSetting(gridAptos34, processosList.get(33).size());

                    processoAdapter34.setProcesses(processosList.get(33));

                    gridAptos34.setAdapter(processoAdapter34);

                    break;
                case 34:
                    gridAptos35.setNumColumns(processosList.get(34).size());

                    gridViewSetting(gridAptos35, processosList.get(34).size());

                    processoAdapter35.setProcesses(processosList.get(34));

                    gridAptos35.setAdapter(processoAdapter35);

                    break;
                case 35:
                    gridAptos36.setNumColumns(processosList.get(35).size());

                    gridViewSetting(gridAptos36, processosList.get(35).size());

                    processoAdapter36.setProcesses(processosList.get(35));

                    gridAptos36.setAdapter(processoAdapter36);

                    break;
                case 36:
                    gridAptos37.setNumColumns(processosList.get(36).size());

                    gridViewSetting(gridAptos37, processosList.get(36).size());

                    processoAdapter37.setProcesses(processosList.get(36));

                    gridAptos37.setAdapter(processoAdapter37);

                    break;
                case 37:
                    gridAptos38.setNumColumns(processosList.get(37).size());

                    gridViewSetting(gridAptos38, processosList.get(37).size());

                    processoAdapter38.setProcesses(processosList.get(37));

                    gridAptos38.setAdapter(processoAdapter38);

                    break;
                case 38:
                    gridAptos39.setNumColumns(processosList.get(38).size());

                    gridViewSetting(gridAptos39, processosList.get(38).size());

                    processoAdapter39.setProcesses(processosList.get(38));

                    gridAptos39.setAdapter(processoAdapter39);

                    break;
                case 39:
                    gridAptos40.setNumColumns(processosList.get(39).size());

                    gridViewSetting(gridAptos40, processosList.get(39).size());

                    processoAdapter40.setProcesses(processosList.get(39));

                    gridAptos40.setAdapter(processoAdapter40);

                    break;
                case 40:

                    gridAptos41.setNumColumns(processosList.get(40).size());

                    gridViewSetting(gridAptos41, processosList.get(40).size());

                    processoAdapter41.setProcesses(processosList.get(40));

                    gridAptos41.setAdapter(processoAdapter41);

                    break;
                case 41:
                    gridAptos42.setNumColumns(processosList.get(41).size());

                    gridViewSetting(gridAptos42, processosList.get(41).size());

                    processoAdapter42.setProcesses(processosList.get(41));

                    gridAptos42.setAdapter(processoAdapter42);

                    break;
                case 42:
                    gridAptos43.setNumColumns(processosList.get(42).size());

                    gridViewSetting(gridAptos43, processosList.get(42).size());

                    processoAdapter43.setProcesses(processosList.get(42));

                    gridAptos43.setAdapter(processoAdapter43);

                    break;
                case 43:
                    gridAptos44.setNumColumns(processosList.get(43).size());

                    gridViewSetting(gridAptos44, processosList.get(43).size());

                    processoAdapter44.setProcesses(processosList.get(43));

                    gridAptos44.setAdapter(processoAdapter44);

                    break;
                case 44:
                    gridAptos45.setNumColumns(processosList.get(44).size());

                    gridViewSetting(gridAptos45, processosList.get(44).size());

                    processoAdapter45.setProcesses(processosList.get(44));

                    gridAptos45.setAdapter(processoAdapter45);

                    break;
                case 45:
                    gridAptos46.setNumColumns(processosList.get(45).size());

                    gridViewSetting(gridAptos46, processosList.get(45).size());

                    processoAdapter46.setProcesses(processosList.get(45));

                    gridAptos46.setAdapter(processoAdapter46);

                    break;
                case 46:
                    gridAptos47.setNumColumns(processosList.get(46).size());

                    gridViewSetting(gridAptos47, processosList.get(46).size());

                    processoAdapter47.setProcesses(processosList.get(46));

                    gridAptos47.setAdapter(processoAdapter47);

                    break;
                case 47:
                    gridAptos48.setNumColumns(processosList.get(47).size());

                    gridViewSetting(gridAptos48, processosList.get(47).size());

                    processoAdapter48.setProcesses(processosList.get(47));

                    gridAptos48.setAdapter(processoAdapter48);

                    break;
                case 48:
                    gridAptos49.setNumColumns(processosList.get(48).size());

                    gridViewSetting(gridAptos49, processosList.get(48).size());

                    processoAdapter49.setProcesses(processosList.get(48));

                    gridAptos49.setAdapter(processoAdapter49);

                    break;
                case 49:
                    gridAptos50.setNumColumns(processosList.get(49).size());

                    gridViewSetting(gridAptos50, processosList.get(49).size());

                    processoAdapter50.setProcesses(processosList.get(49));

                    gridAptos50.setAdapter(processoAdapter50);

                    break;
                case 50:
                    gridAptos51.setNumColumns(processosList.get(50).size());

                    gridViewSetting(gridAptos51, processosList.get(50).size());

                    processoAdapter51.setProcesses(processosList.get(50));

                    gridAptos51.setAdapter(processoAdapter51);

                    break;
                case 51:
                    gridAptos52.setNumColumns(processosList.get(51).size());

                    gridViewSetting(gridAptos52, processosList.get(51).size());

                    processoAdapter52.setProcesses(processosList.get(1));

                    gridAptos52.setAdapter(processoAdapter52);

                    break;
                case 52:
                    gridAptos53.setNumColumns(processosList.get(52).size());

                    gridViewSetting(gridAptos53, processosList.get(52).size());

                    processoAdapter53.setProcesses(processosList.get(52));

                    gridAptos53.setAdapter(processoAdapter53);

                    break;
                case 53:
                    gridAptos54.setNumColumns(processosList.get(53).size());

                    gridViewSetting(gridAptos54, processosList.get(53).size());

                    processoAdapter54.setProcesses(processosList.get(53));

                    gridAptos54.setAdapter(processoAdapter54);

                    break;
                case 54:
                    gridAptos55.setNumColumns(processosList.get(54).size());

                    gridViewSetting(gridAptos55, processosList.get(54).size());

                    processoAdapter55.setProcesses(processosList.get(54));

                    gridAptos55.setAdapter(processoAdapter55);

                    break;
                case 55:
                    gridAptos56.setNumColumns(processosList.get(55).size());

                    gridViewSetting(gridAptos56, processosList.get(55).size());

                    processoAdapter56.setProcesses(processosList.get(55));

                    gridAptos56.setAdapter(processoAdapter56);

                    break;
                case 56:
                    gridAptos57.setNumColumns(processosList.get(56).size());

                    gridViewSetting(gridAptos57, processosList.get(56).size());

                    processoAdapter57.setProcesses(processosList.get(56));

                    gridAptos57.setAdapter(processoAdapter57);

                    break;
                case 57:
                    gridAptos58.setNumColumns(processosList.get(57).size());

                    gridViewSetting(gridAptos58, processosList.get(57).size());

                    processoAdapter58.setProcesses(processosList.get(57));

                    gridAptos58.setAdapter(processoAdapter58);

                    break;
                case 58:
                    gridAptos59.setNumColumns(processosList.get(58).size());

                    gridViewSetting(gridAptos59, processosList.get(58).size());

                    processoAdapter59.setProcesses(processosList.get(58));

                    gridAptos59.setAdapter(processoAdapter59);

                    break;
                case 59:
                    gridAptos60.setNumColumns(processosList.get(59).size());

                    gridViewSetting(gridAptos60, processosList.get(59).size());

                    processoAdapter60.setProcesses(processosList.get(59));

                    gridAptos60.setAdapter(processoAdapter60);

                    break;
                case 60:
                    gridAptos61.setNumColumns(processosList.get(60).size());

                    gridViewSetting(gridAptos61, processosList.get(60).size());

                    processoAdapter61.setProcesses(processosList.get(60));

                    gridAptos61.setAdapter(processoAdapter61);

                    break;
                case 61:
                    gridAptos62.setNumColumns(processosList.get(61).size());

                    gridViewSetting(gridAptos62, processosList.get(61).size());

                    processoAdapter62.setProcesses(processosList.get(61));

                    gridAptos62.setAdapter(processoAdapter62);

                    break;
                case 62:
                    gridAptos63.setNumColumns(processosList.get(62).size());

                    gridViewSetting(gridAptos63, processosList.get(62).size());

                    processoAdapter63.setProcesses(processosList.get(62));

                    gridAptos63.setAdapter(processoAdapter63);

                    break;
                case 63:
                    gridAptos64.setNumColumns(processosList.get(63).size());

                    gridViewSetting(gridAptos64, processosList.get(63).size());

                    processoAdapter64.setProcesses(processosList.get(63));

                    gridAptos64.setAdapter(processoAdapter64);

                    break;







            }

        }

    }

    public void reloadDataGridViewProcessador(LinkedList<Processor> processadores){

        synchronized (getApplicationContext()){
            processadorAdapter.setProcessadores(processadores);
            processadorAdapter.notifyDataSetChanged();
        }

    }

    public void reloadDataGridViewFinalizado(){

        synchronized (getApplicationContext()) {
            contruirGridViewFinalizados();
        }
    }

    public void reloadDataGridViewRemanecente(){
      synchronized (this){
        construirGridViewRemanecente();
      }
    }

    public void criarListas(){
        for (int i = 0; i < numQtdProcessadores; i++){
            processosList.add(new LinkedList<Process>());
        }
    }

    public void ativarGridView(){

        for(int i = 0; i < numQtdProcessadores; i++){

            switch (i){
                case 0: linear1.setVisibility(View.VISIBLE);
                    processador1.setVisibility(View.VISIBLE);break;
                case 1: linear2.setVisibility(View.VISIBLE);
                    processador2.setVisibility(View.VISIBLE);break;
                case 2: linear3.setVisibility(View.VISIBLE);
                    processador3.setVisibility(View.VISIBLE);break;
                case 3: linear4.setVisibility(View.VISIBLE);
                    processador4.setVisibility(View.VISIBLE);break;
                case 4: linear5.setVisibility(View.VISIBLE);
                    processador5.setVisibility(View.VISIBLE);break;
                case 5: linear6.setVisibility(View.VISIBLE);
                    processador6.setVisibility(View.VISIBLE);break;
                case 6: linear7.setVisibility(View.VISIBLE);
                    processador7.setVisibility(View.VISIBLE);break;
                case 7: linear8.setVisibility(View.VISIBLE);
                    processador8.setVisibility(View.VISIBLE);break;
                case 8: linear9.setVisibility(View.VISIBLE);
                    processador9.setVisibility(View.VISIBLE);break;
                case 9: linear10.setVisibility(View.VISIBLE);
                    processador10.setVisibility(View.VISIBLE);break;
                case 10: linear11.setVisibility(View.VISIBLE);
                    processador11.setVisibility(View.VISIBLE);break;
                case 11: linear12.setVisibility(View.VISIBLE);
                    processador12.setVisibility(View.VISIBLE);break;
                case 12: linear13.setVisibility(View.VISIBLE);
                    processador13.setVisibility(View.VISIBLE);break;
                case 13: linear14.setVisibility(View.VISIBLE);
                    processador14.setVisibility(View.VISIBLE);break;
                case 14: linear15.setVisibility(View.VISIBLE);
                    processador15.setVisibility(View.VISIBLE);break;
                case 15: linear16.setVisibility(View.VISIBLE);
                    processador16.setVisibility(View.VISIBLE);break;
                case 16: linear17.setVisibility(View.VISIBLE);
                    processador17.setVisibility(View.VISIBLE);break;
                case 17: linear18.setVisibility(View.VISIBLE);
                    processador18.setVisibility(View.VISIBLE);break;
                case 18: linear19.setVisibility(View.VISIBLE);
                    processador19.setVisibility(View.VISIBLE);break;
                case 19: linear20.setVisibility(View.VISIBLE);
                    processador20.setVisibility(View.VISIBLE);break;
                case 20: linear21.setVisibility(View.VISIBLE);
                    processador21.setVisibility(View.VISIBLE);break;
                case 21: linear22.setVisibility(View.VISIBLE);
                    processador22.setVisibility(View.VISIBLE);break;
                case 22: linear23.setVisibility(View.VISIBLE);
                    processador23.setVisibility(View.VISIBLE);break;
                case 23: linear24.setVisibility(View.VISIBLE);
                    processador24.setVisibility(View.VISIBLE);break;
                case 24: linear25.setVisibility(View.VISIBLE);
                    processador25.setVisibility(View.VISIBLE);break;
                case 25: linear26.setVisibility(View.VISIBLE);
                    processador26.setVisibility(View.VISIBLE);break;
                case 26: linear27.setVisibility(View.VISIBLE);
                    processador27.setVisibility(View.VISIBLE);break;
                case 27: linear28.setVisibility(View.VISIBLE);
                    processador28.setVisibility(View.VISIBLE);break;
                case 28: linear29.setVisibility(View.VISIBLE);
                    processador29.setVisibility(View.VISIBLE);break;
                case 29: linear30.setVisibility(View.VISIBLE);
                    processador30.setVisibility(View.VISIBLE);break;
                case 30: linear31.setVisibility(View.VISIBLE);
                    processador31.setVisibility(View.VISIBLE);break;
                case 31: linear32.setVisibility(View.VISIBLE);
                    processador32.setVisibility(View.VISIBLE);break;
                case 32: linear33.setVisibility(View.VISIBLE);
                    processador33.setVisibility(View.VISIBLE);break;
                case 33: linear34.setVisibility(View.VISIBLE);
                    processador34.setVisibility(View.VISIBLE);break;
                case 34: linear35.setVisibility(View.VISIBLE);
                    processador35.setVisibility(View.VISIBLE);break;
                case 35: linear36.setVisibility(View.VISIBLE);
                    processador36.setVisibility(View.VISIBLE);break;
                case 36: linear37.setVisibility(View.VISIBLE);
                    processador37.setVisibility(View.VISIBLE);break;
                case 37: linear38.setVisibility(View.VISIBLE);
                    processador38.setVisibility(View.VISIBLE);break;
                case 38: linear39.setVisibility(View.VISIBLE);
                    processador39.setVisibility(View.VISIBLE);break;
                case 39: linear40.setVisibility(View.VISIBLE);
                    processador40.setVisibility(View.VISIBLE);break;
                case 40: linear41.setVisibility(View.VISIBLE);
                    processador41.setVisibility(View.VISIBLE);break;
                case 41: linear42.setVisibility(View.VISIBLE);
                    processador42.setVisibility(View.VISIBLE);break;
                case 42: linear43.setVisibility(View.VISIBLE);
                    processador43.setVisibility(View.VISIBLE);break;
                case 43: linear44.setVisibility(View.VISIBLE);
                    processador44.setVisibility(View.VISIBLE);break;
                case 44: linear45.setVisibility(View.VISIBLE);
                    processador45.setVisibility(View.VISIBLE);break;
                case 45: linear46.setVisibility(View.VISIBLE);
                    processador46.setVisibility(View.VISIBLE);break;
                case 46: linear47.setVisibility(View.VISIBLE);
                    processador47.setVisibility(View.VISIBLE);break;
                case 47: linear48.setVisibility(View.VISIBLE);
                    processador48.setVisibility(View.VISIBLE);break;
                case 48: linear49.setVisibility(View.VISIBLE);
                    processador49.setVisibility(View.VISIBLE);break;
                case 49: linear50.setVisibility(View.VISIBLE);
                    processador50.setVisibility(View.VISIBLE);break;
                case 50: linear51.setVisibility(View.VISIBLE);
                    processador51.setVisibility(View.VISIBLE);break;
                case 51: linear52.setVisibility(View.VISIBLE);
                    processador52.setVisibility(View.VISIBLE);break;
                case 52: linear53.setVisibility(View.VISIBLE);
                    processador53.setVisibility(View.VISIBLE);break;
                case 53: linear54.setVisibility(View.VISIBLE);
                    processador54.setVisibility(View.VISIBLE);break;
                case 54: linear55.setVisibility(View.VISIBLE);
                    processador55.setVisibility(View.VISIBLE);break;
                case 55: linear56.setVisibility(View.VISIBLE);
                    processador56.setVisibility(View.VISIBLE);break;
                case 56: linear57.setVisibility(View.VISIBLE);
                    processador57.setVisibility(View.VISIBLE);break;
                case 57: linear58.setVisibility(View.VISIBLE);
                    processador58.setVisibility(View.VISIBLE);break;
                case 58: linear59.setVisibility(View.VISIBLE);
                    processador59.setVisibility(View.VISIBLE);break;
                case 59: linear60.setVisibility(View.VISIBLE);
                    processador60.setVisibility(View.VISIBLE);break;
                case 60: linear61.setVisibility(View.VISIBLE);
                    processador61.setVisibility(View.VISIBLE);break;
                case 61: linear62.setVisibility(View.VISIBLE);
                    processador62.setVisibility(View.VISIBLE);break;
                case 62: linear63.setVisibility(View.VISIBLE);
                    processador63.setVisibility(View.VISIBLE);break;
                case 63: linear64.setVisibility(View.VISIBLE);
                    processador64.setVisibility(View.VISIBLE);break;

            }

            linearRem.setVisibility(View.VISIBLE);
        }
    }

    public void setColumsGridView(){

        for (int i = 0; i < numQtdProcessadores; i++){
            switch (i){
                case 0: gridAptos1.setNumColumns(processosList.get(0).size()); break;
                case 1: gridAptos2.setNumColumns(processosList.get(1).size()); break;
                case 2: gridAptos3.setNumColumns(processosList.get(2).size()); break;
                case 3: gridAptos4.setNumColumns(processosList.get(3).size()); break;
                case 4: gridAptos5.setNumColumns(processosList.get(4).size()); break;
                case 5: gridAptos6.setNumColumns(processosList.get(5).size()); break;
                case 6: gridAptos7.setNumColumns(processosList.get(6).size()); break;
                case 7: gridAptos8.setNumColumns(processosList.get(7).size()); break;
                case 8: gridAptos9.setNumColumns(processosList.get(8).size()); break;
                case 9: gridAptos10.setNumColumns(processosList.get(9).size()); break;
                case 10: gridAptos11.setNumColumns(processosList.get(10).size()); break;
                case 11: gridAptos12.setNumColumns(processosList.get(11).size()); break;
                case 12: gridAptos13.setNumColumns(processosList.get(12).size()); break;
                case 13: gridAptos14.setNumColumns(processosList.get(13).size()); break;
                case 14: gridAptos15.setNumColumns(processosList.get(14).size()); break;
                case 15: gridAptos16.setNumColumns(processosList.get(15).size()); break;
                case 16: gridAptos17.setNumColumns(processosList.get(16).size()); break;
                case 17: gridAptos18.setNumColumns(processosList.get(17).size()); break;
                case 18: gridAptos19.setNumColumns(processosList.get(18).size()); break;
                case 19: gridAptos20.setNumColumns(processosList.get(19).size()); break;
                case 20: gridAptos21.setNumColumns(processosList.get(20).size()); break;
                case 21: gridAptos22.setNumColumns(processosList.get(21).size()); break;
                case 22: gridAptos23.setNumColumns(processosList.get(22).size()); break;
                case 23: gridAptos24.setNumColumns(processosList.get(23).size()); break;
                case 24: gridAptos25.setNumColumns(processosList.get(24).size()); break;
                case 25: gridAptos26.setNumColumns(processosList.get(25).size()); break;
                case 26: gridAptos27.setNumColumns(processosList.get(26).size()); break;
                case 27: gridAptos28.setNumColumns(processosList.get(27).size()); break;
                case 28: gridAptos29.setNumColumns(processosList.get(28).size()); break;
                case 29: gridAptos30.setNumColumns(processosList.get(29).size()); break;
                case 30: gridAptos31.setNumColumns(processosList.get(30).size()); break;
                case 31: gridAptos32.setNumColumns(processosList.get(31).size()); break;
                case 32: gridAptos33.setNumColumns(processosList.get(32).size()); break;
                case 33: gridAptos34.setNumColumns(processosList.get(33).size()); break;
                case 34: gridAptos35.setNumColumns(processosList.get(34).size()); break;
                case 35: gridAptos36.setNumColumns(processosList.get(35).size()); break;
                case 36: gridAptos37.setNumColumns(processosList.get(36).size()); break;
                case 37: gridAptos38.setNumColumns(processosList.get(37).size()); break;
                case 38: gridAptos39.setNumColumns(processosList.get(38).size()); break;
                case 39: gridAptos40.setNumColumns(processosList.get(39).size()); break;
                case 40: gridAptos41.setNumColumns(processosList.get(40).size()); break;
                case 41: gridAptos42.setNumColumns(processosList.get(41).size()); break;
                case 42: gridAptos43.setNumColumns(processosList.get(42).size()); break;
                case 43: gridAptos44.setNumColumns(processosList.get(43).size()); break;
                case 44: gridAptos45.setNumColumns(processosList.get(44).size()); break;
                case 45: gridAptos46.setNumColumns(processosList.get(45).size()); break;
                case 46: gridAptos47.setNumColumns(processosList.get(46).size()); break;
                case 47: gridAptos48.setNumColumns(processosList.get(47).size()); break;
                case 48: gridAptos49.setNumColumns(processosList.get(48).size()); break;
                case 49: gridAptos50.setNumColumns(processosList.get(49).size()); break;
                case 50: gridAptos51.setNumColumns(processosList.get(50).size()); break;
                case 51: gridAptos52.setNumColumns(processosList.get(51).size()); break;
                case 52: gridAptos53.setNumColumns(processosList.get(52).size()); break;
                case 53: gridAptos54.setNumColumns(processosList.get(53).size()); break;
                case 54: gridAptos55.setNumColumns(processosList.get(54).size()); break;
                case 55: gridAptos56.setNumColumns(processosList.get(55).size()); break;
                case 56: gridAptos57.setNumColumns(processosList.get(56).size()); break;
                case 57: gridAptos58.setNumColumns(processosList.get(57).size()); break;
                case 58: gridAptos59.setNumColumns(processosList.get(58).size()); break;
                case 59: gridAptos60.setNumColumns(processosList.get(59).size()); break;
                case 60: gridAptos61.setNumColumns(processosList.get(60).size()); break;
                case 61: gridAptos62.setNumColumns(processosList.get(61).size()); break;
                case 62: gridAptos63.setNumColumns(processosList.get(62).size()); break;
                case 63: gridAptos64.setNumColumns(processosList.get(63).size()); break;

            }

            gridAptosRem.setNumColumns(remanecentes.size());
        }
    }

    public void setGridViewSettings(){

        for (int i = 0; i < numQtdProcessadores; i++){
            switch (i){
                case 0: gridViewSetting(gridAptos1, processosList.get(0).size()); break;
                case 1: gridViewSetting(gridAptos2, processosList.get(1).size()); break;
                case 2: gridViewSetting(gridAptos3, processosList.get(2).size()); break;
                case 3: gridViewSetting(gridAptos4, processosList.get(3).size()); break;
                case 4: gridViewSetting(gridAptos5, processosList.get(4).size()); break;
                case 5: gridViewSetting(gridAptos6, processosList.get(5).size()); break;
                case 6: gridViewSetting(gridAptos7, processosList.get(6).size()); break;
                case 7: gridViewSetting(gridAptos8, processosList.get(7).size()); break;
                case 8: gridViewSetting(gridAptos9, processosList.get(8).size()); break;
                case 9: gridViewSetting(gridAptos10, processosList.get(9).size()); break;
                case 10: gridViewSetting(gridAptos11, processosList.get(10).size()); break;
                case 11: gridViewSetting(gridAptos12, processosList.get(11).size()); break;
                case 12: gridViewSetting(gridAptos13, processosList.get(12).size()); break;
                case 13: gridViewSetting(gridAptos14, processosList.get(13).size()); break;
                case 14: gridViewSetting(gridAptos15, processosList.get(14).size()); break;
                case 15: gridViewSetting(gridAptos16, processosList.get(15).size()); break;
                case 16: gridViewSetting(gridAptos17, processosList.get(16).size()); break;
                case 17: gridViewSetting(gridAptos18, processosList.get(17).size()); break;
                case 18: gridViewSetting(gridAptos19, processosList.get(18).size()); break;
                case 19: gridViewSetting(gridAptos20, processosList.get(19).size()); break;
                case 20: gridViewSetting(gridAptos21, processosList.get(20).size()); break;
                case 21: gridViewSetting(gridAptos22, processosList.get(21).size()); break;
                case 22: gridViewSetting(gridAptos23, processosList.get(22).size()); break;
                case 23: gridViewSetting(gridAptos24, processosList.get(23).size()); break;
                case 24: gridViewSetting(gridAptos25, processosList.get(24).size()); break;
                case 25: gridViewSetting(gridAptos26, processosList.get(25).size()); break;
                case 26: gridViewSetting(gridAptos27, processosList.get(26).size()); break;
                case 27: gridViewSetting(gridAptos28, processosList.get(27).size()); break;
                case 28: gridViewSetting(gridAptos29, processosList.get(28).size()); break;
                case 29: gridViewSetting(gridAptos30, processosList.get(29).size()); break;
                case 30: gridViewSetting(gridAptos31, processosList.get(30).size()); break;
                case 31: gridViewSetting(gridAptos32, processosList.get(31).size()); break;
                case 32: gridViewSetting(gridAptos33, processosList.get(32).size()); break;
                case 33: gridViewSetting(gridAptos34, processosList.get(33).size()); break;
                case 34: gridViewSetting(gridAptos35, processosList.get(34).size()); break;
                case 35: gridViewSetting(gridAptos36, processosList.get(35).size()); break;
                case 36: gridViewSetting(gridAptos37, processosList.get(36).size()); break;
                case 37: gridViewSetting(gridAptos38, processosList.get(37).size()); break;
                case 38: gridViewSetting(gridAptos39, processosList.get(38).size()); break;
                case 39: gridViewSetting(gridAptos40, processosList.get(39).size()); break;
                case 40: gridViewSetting(gridAptos41, processosList.get(40).size()); break;
                case 41: gridViewSetting(gridAptos42, processosList.get(41).size()); break;
                case 42: gridViewSetting(gridAptos43, processosList.get(42).size()); break;
                case 43: gridViewSetting(gridAptos44, processosList.get(43).size()); break;
                case 44: gridViewSetting(gridAptos45, processosList.get(44).size()); break;
                case 45: gridViewSetting(gridAptos46, processosList.get(45).size()); break;
                case 46: gridViewSetting(gridAptos47, processosList.get(46).size()); break;
                case 47: gridViewSetting(gridAptos48, processosList.get(47).size()); break;
                case 48: gridViewSetting(gridAptos49, processosList.get(48).size()); break;
                case 49: gridViewSetting(gridAptos50, processosList.get(49).size()); break;
                case 50: gridViewSetting(gridAptos51, processosList.get(50).size()); break;
                case 51: gridViewSetting(gridAptos52, processosList.get(51).size()); break;
                case 52: gridViewSetting(gridAptos53, processosList.get(52).size()); break;
                case 53: gridViewSetting(gridAptos54, processosList.get(53).size()); break;
                case 54: gridViewSetting(gridAptos55, processosList.get(54).size()); break;
                case 55: gridViewSetting(gridAptos56, processosList.get(55).size()); break;
                case 56: gridViewSetting(gridAptos57, processosList.get(56).size()); break;
                case 57: gridViewSetting(gridAptos58, processosList.get(57).size()); break;
                case 58: gridViewSetting(gridAptos59, processosList.get(58).size()); break;
                case 59: gridViewSetting(gridAptos60, processosList.get(59).size()); break;
                case 60: gridViewSetting(gridAptos61, processosList.get(60).size()); break;
                case 61: gridViewSetting(gridAptos62, processosList.get(61).size()); break;
                case 62: gridViewSetting(gridAptos63, processosList.get(62).size()); break;
                case 63: gridViewSetting(gridAptos64, processosList.get(63).size()); break;
            }

            gridViewSetting(gridAptosRem, remanecentes.size());
        }
    }

    public void setProcessosAdapter(){
        for (int i = 0; i < numQtdProcessadores; i++){
            switch (i){
                case 0: processoAdapter1.setProcesses(processosList.get(0)); break;
                case 1: processoAdapter2.setProcesses(processosList.get(1)); break;
                case 2: processoAdapter3.setProcesses(processosList.get(2)); break;
                case 3: processoAdapter4.setProcesses(processosList.get(3)); break;
                case 4: processoAdapter5.setProcesses(processosList.get(4)); break;
                case 5: processoAdapter6.setProcesses(processosList.get(5)); break;
                case 6: processoAdapter7.setProcesses(processosList.get(6)); break;
                case 7: processoAdapter8.setProcesses(processosList.get(7)); break;
                case 8: processoAdapter9.setProcesses(processosList.get(8)); break;
                case 9: processoAdapter10.setProcesses(processosList.get(9)); break;
                case 10: processoAdapter11.setProcesses(processosList.get(10)); break;
                case 11: processoAdapter12.setProcesses(processosList.get(11)); break;
                case 12: processoAdapter13.setProcesses(processosList.get(12)); break;
                case 13: processoAdapter14.setProcesses(processosList.get(13)); break;
                case 14: processoAdapter15.setProcesses(processosList.get(14)); break;
                case 15: processoAdapter16.setProcesses(processosList.get(15)); break;
                case 16: processoAdapter17.setProcesses(processosList.get(16)); break;
                case 17: processoAdapter18.setProcesses(processosList.get(17)); break;
                case 18: processoAdapter19.setProcesses(processosList.get(18)); break;
                case 19: processoAdapter20.setProcesses(processosList.get(19)); break;
                case 20: processoAdapter21.setProcesses(processosList.get(20)); break;
                case 21: processoAdapter22.setProcesses(processosList.get(21)); break;
                case 22: processoAdapter23.setProcesses(processosList.get(22)); break;
                case 23: processoAdapter24.setProcesses(processosList.get(23)); break;
                case 24: processoAdapter25.setProcesses(processosList.get(24)); break;
                case 25: processoAdapter26.setProcesses(processosList.get(25)); break;
                case 26: processoAdapter27.setProcesses(processosList.get(26)); break;
                case 27: processoAdapter28.setProcesses(processosList.get(27)); break;
                case 28: processoAdapter29.setProcesses(processosList.get(28)); break;
                case 29: processoAdapter30.setProcesses(processosList.get(29)); break;
                case 30: processoAdapter31.setProcesses(processosList.get(30)); break;
                case 31: processoAdapter32.setProcesses(processosList.get(31)); break;
                case 32: processoAdapter33.setProcesses(processosList.get(32)); break;
                case 33: processoAdapter34.setProcesses(processosList.get(33)); break;
                case 34: processoAdapter35.setProcesses(processosList.get(34)); break;
                case 35: processoAdapter36.setProcesses(processosList.get(35)); break;
                case 36: processoAdapter37.setProcesses(processosList.get(36)); break;
                case 37: processoAdapter38.setProcesses(processosList.get(37)); break;
                case 38: processoAdapter39.setProcesses(processosList.get(38)); break;
                case 39: processoAdapter40.setProcesses(processosList.get(39)); break;
                case 40: processoAdapter41.setProcesses(processosList.get(40)); break;
                case 41: processoAdapter42.setProcesses(processosList.get(41)); break;
                case 42: processoAdapter43.setProcesses(processosList.get(42)); break;
                case 43: processoAdapter44.setProcesses(processosList.get(43)); break;
                case 44: processoAdapter45.setProcesses(processosList.get(44)); break;
                case 45: processoAdapter46.setProcesses(processosList.get(45)); break;
                case 46: processoAdapter47.setProcesses(processosList.get(46)); break;
                case 47: processoAdapter48.setProcesses(processosList.get(47)); break;
                case 48: processoAdapter49.setProcesses(processosList.get(48)); break;
                case 49: processoAdapter50.setProcesses(processosList.get(49)); break;
                case 50: processoAdapter51.setProcesses(processosList.get(50)); break;
                case 51: processoAdapter52.setProcesses(processosList.get(51)); break;
                case 52: processoAdapter53.setProcesses(processosList.get(52)); break;
                case 53: processoAdapter54.setProcesses(processosList.get(53)); break;
                case 54: processoAdapter55.setProcesses(processosList.get(54)); break;
                case 55: processoAdapter56.setProcesses(processosList.get(55)); break;
                case 56: processoAdapter57.setProcesses(processosList.get(56)); break;
                case 57: processoAdapter58.setProcesses(processosList.get(57)); break;
                case 58: processoAdapter59.setProcesses(processosList.get(58)); break;
                case 59: processoAdapter60.setProcesses(processosList.get(59)); break;
                case 60: processoAdapter61.setProcesses(processosList.get(60)); break;
                case 61: processoAdapter62.setProcesses(processosList.get(61)); break;
                case 62: processoAdapter63.setProcesses(processosList.get(62)); break;
                case 63: processoAdapter64.setProcesses(processosList.get(63)); break;

            }

            remanecenteAdapter.setProcesses(remanecentes);
        }
    }

    public void setAdapterGridView(){
        for (int i = 0; i < numQtdProcessadores; i++){
            switch (i){
                case 0: gridAptos1.setAdapter(processoAdapter1); break;
                case 1: gridAptos2.setAdapter(processoAdapter2); break;
                case 2: gridAptos3.setAdapter(processoAdapter3); break;
                case 3: gridAptos4.setAdapter(processoAdapter4); break;
                case 4: gridAptos5.setAdapter(processoAdapter5); break;
                case 5: gridAptos6.setAdapter(processoAdapter6); break;
                case 6: gridAptos7.setAdapter(processoAdapter7); break;
                case 7: gridAptos8.setAdapter(processoAdapter8); break;
                case 8: gridAptos9.setAdapter(processoAdapter9); break;
                case 9: gridAptos10.setAdapter(processoAdapter10); break;
                case 10: gridAptos11.setAdapter(processoAdapter11); break;
                case 11: gridAptos12.setAdapter(processoAdapter12); break;
                case 12: gridAptos13.setAdapter(processoAdapter13); break;
                case 13: gridAptos14.setAdapter(processoAdapter14); break;
                case 14: gridAptos15.setAdapter(processoAdapter15); break;
                case 15: gridAptos16.setAdapter(processoAdapter16); break;
                case 16: gridAptos17.setAdapter(processoAdapter17); break;
                case 17: gridAptos18.setAdapter(processoAdapter18); break;
                case 18: gridAptos19.setAdapter(processoAdapter19); break;
                case 19: gridAptos20.setAdapter(processoAdapter20); break;
                case 20: gridAptos21.setAdapter(processoAdapter21); break;
                case 21: gridAptos22.setAdapter(processoAdapter22); break;
                case 22: gridAptos23.setAdapter(processoAdapter23); break;
                case 23: gridAptos24.setAdapter(processoAdapter24); break;
                case 24: gridAptos25.setAdapter(processoAdapter25); break;
                case 25: gridAptos26.setAdapter(processoAdapter26); break;
                case 26: gridAptos27.setAdapter(processoAdapter27); break;
                case 27: gridAptos28.setAdapter(processoAdapter28); break;
                case 28: gridAptos29.setAdapter(processoAdapter29); break;
                case 29: gridAptos30.setAdapter(processoAdapter30); break;
                case 30: gridAptos31.setAdapter(processoAdapter31); break;
                case 31: gridAptos32.setAdapter(processoAdapter32); break;
                case 32: gridAptos33.setAdapter(processoAdapter33); break;
                case 33: gridAptos34.setAdapter(processoAdapter34); break;
                case 34: gridAptos35.setAdapter(processoAdapter35); break;
                case 35: gridAptos36.setAdapter(processoAdapter36); break;
                case 36: gridAptos37.setAdapter(processoAdapter37); break;
                case 37: gridAptos38.setAdapter(processoAdapter38); break;
                case 38: gridAptos39.setAdapter(processoAdapter39); break;
                case 39: gridAptos40.setAdapter(processoAdapter40); break;
                case 40: gridAptos41.setAdapter(processoAdapter41); break;
                case 41: gridAptos42.setAdapter(processoAdapter42); break;
                case 42: gridAptos43.setAdapter(processoAdapter43); break;
                case 43: gridAptos44.setAdapter(processoAdapter44); break;
                case 44: gridAptos45.setAdapter(processoAdapter45); break;
                case 45: gridAptos46.setAdapter(processoAdapter46); break;
                case 46: gridAptos47.setAdapter(processoAdapter47); break;
                case 47: gridAptos48.setAdapter(processoAdapter48); break;
                case 48: gridAptos49.setAdapter(processoAdapter49); break;
                case 49: gridAptos50.setAdapter(processoAdapter50); break;
                case 50: gridAptos51.setAdapter(processoAdapter51); break;
                case 51: gridAptos52.setAdapter(processoAdapter52); break;
                case 52: gridAptos53.setAdapter(processoAdapter53); break;
                case 53: gridAptos54.setAdapter(processoAdapter54); break;
                case 54: gridAptos55.setAdapter(processoAdapter55); break;
                case 55: gridAptos56.setAdapter(processoAdapter56); break;
                case 56: gridAptos57.setAdapter(processoAdapter57); break;
                case 57: gridAptos58.setAdapter(processoAdapter58); break;
                case 58: gridAptos59.setAdapter(processoAdapter59); break;
                case 59: gridAptos60.setAdapter(processoAdapter60); break;
                case 60: gridAptos61.setAdapter(processoAdapter61); break;
                case 61: gridAptos62.setAdapter(processoAdapter62); break;
                case 62: gridAptos63.setAdapter(processoAdapter63); break;
                case 63: gridAptos64.setAdapter(processoAdapter64); break;
            }

            gridAptosRem.setAdapter(remanecenteAdapter);
        }
    }

}
