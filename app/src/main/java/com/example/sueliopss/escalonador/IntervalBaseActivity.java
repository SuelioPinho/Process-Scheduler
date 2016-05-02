package com.example.sueliopss.escalonador;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;

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

@EActivity(R.layout.activity_interval_base)
public class IntervalBaseActivity extends AppCompatActivity{

    @ViewById
    LinearLayout linear1;
    @ViewById
    LinearLayout linear2;
    @ViewById
    LinearLayout linear3;
    @ViewById
    LinearLayout linear4;
    @ViewById
    LinearLayout linear5;
    @ViewById
    LinearLayout linear6;
    @ViewById
    LinearLayout linear7;
    @ViewById
    LinearLayout linear8;
    @ViewById
    LinearLayout linear9;
    @ViewById
    LinearLayout linear10;
    @ViewById
    LinearLayout linear11;
    @ViewById
    LinearLayout linear12;
    @ViewById
    LinearLayout linear13;
    @ViewById
    LinearLayout linear14;
    @ViewById
    LinearLayout linear15;
    @ViewById
    LinearLayout linear16;
    @ViewById
    LinearLayout linear17;
    @ViewById
    LinearLayout linear18;
    @ViewById
    LinearLayout linear19;
    @ViewById
    LinearLayout linear20;
    @ViewById
    LinearLayout linear21;
    @ViewById
    LinearLayout linear22;
    @ViewById
    LinearLayout linear23;
    @ViewById
    LinearLayout linear24;
    @ViewById
    LinearLayout linear25;
    @ViewById
    LinearLayout linear26;
    @ViewById
    LinearLayout linear27;
    @ViewById
    LinearLayout linear28;
    @ViewById
    LinearLayout linear29;
    @ViewById
    LinearLayout linear30;
    @ViewById
    LinearLayout linear31;
    @ViewById
    LinearLayout linear32;
    @ViewById
    LinearLayout linear33;
    @ViewById
    LinearLayout linear34;
    @ViewById
    LinearLayout linear35;
    @ViewById
    LinearLayout linear36;
    @ViewById
    LinearLayout linear37;
    @ViewById
    LinearLayout linear38;
    @ViewById
    LinearLayout linear39;
    @ViewById
    LinearLayout linear40;
    @ViewById
    LinearLayout linear41;
    @ViewById
    LinearLayout linear42;
    @ViewById
    LinearLayout linear43;
    @ViewById
    LinearLayout linear44;
    @ViewById
    LinearLayout linear45;
    @ViewById
    LinearLayout linear46;
    @ViewById
    LinearLayout linear47;
    @ViewById
    LinearLayout linear48;
    @ViewById
    LinearLayout linear49;
    @ViewById
    LinearLayout linear50;
    @ViewById
    LinearLayout linear51;
    @ViewById
    LinearLayout linear52;
    @ViewById
    LinearLayout linear53;
    @ViewById
    LinearLayout linear54;
    @ViewById
    LinearLayout linear55;
    @ViewById
    LinearLayout linear56;
    @ViewById
    LinearLayout linear57;
    @ViewById
    LinearLayout linear58;
    @ViewById
    LinearLayout linear59;
    @ViewById
    LinearLayout linear60;
    @ViewById
    LinearLayout linear61;
    @ViewById
    LinearLayout linear62;
    @ViewById
    LinearLayout linear63;
    @ViewById
    LinearLayout linear64;
    @ViewById
    LinearLayout linearRem;

    @ViewById
    TextView processador1;
    @ViewById
    TextView processador2;
    @ViewById
    TextView processador3;
    @ViewById
    TextView processador4;
    @ViewById
    TextView processador5;
    @ViewById
    TextView processador6;
    @ViewById
    TextView processador7;
    @ViewById
    TextView processador8;
    @ViewById
    TextView processador9;
    @ViewById
    TextView processador10;
    @ViewById
    TextView processador11;
    @ViewById
    TextView processador12;
    @ViewById
    TextView processador13;
    @ViewById
    TextView processador14;
    @ViewById
    TextView processador15;
    @ViewById
    TextView processador16;
    @ViewById
    TextView processador17;
    @ViewById
    TextView processador18;
    @ViewById
    TextView processador19;
    @ViewById
    TextView processador20;
    @ViewById
    TextView processador21;
    @ViewById
    TextView processador22;
    @ViewById
    TextView processador23;
    @ViewById
    TextView processador24;
    @ViewById
    TextView processador25;
    @ViewById
    TextView processador26;
    @ViewById
    TextView processador27;
    @ViewById
    TextView processador28;
    @ViewById
    TextView processador29;
    @ViewById
    TextView processador30;
    @ViewById
    TextView processador31;
    @ViewById
    TextView processador32;
    @ViewById
    TextView processador33;
    @ViewById
    TextView processador34;
    @ViewById
    TextView processador35;
    @ViewById
    TextView processador36;
    @ViewById
    TextView processador37;
    @ViewById
    TextView processador38;
    @ViewById
    TextView processador39;
    @ViewById
    TextView processador40;
    @ViewById
    TextView processador41;
    @ViewById
    TextView processador42;
    @ViewById
    TextView processador43;
    @ViewById
    TextView processador44;
    @ViewById
    TextView processador45;
    @ViewById
    TextView processador46;
    @ViewById
    TextView processador47;
    @ViewById
    TextView processador48;
    @ViewById
    TextView processador49;
    @ViewById
    TextView processador50;
    @ViewById
    TextView processador51;
    @ViewById
    TextView processador52;
    @ViewById
    TextView processador53;
    @ViewById
    TextView processador54;
    @ViewById
    TextView processador55;
    @ViewById
    TextView processador56;
    @ViewById
    TextView processador57;
    @ViewById
    TextView processador58;
    @ViewById
    TextView processador59;
    @ViewById
    TextView processador60;
    @ViewById
    TextView processador61;
    @ViewById
    TextView processador62;
    @ViewById
    TextView processador63;
    @ViewById
    TextView processador64;

    @ViewById(R.id.gridProcessadores)
    GridView gridProcessadores;
    @ViewById
    GridView gridAptos1;
    @ViewById
    GridView gridAptos2;
    @ViewById
    GridView gridAptos3;
    @ViewById
    GridView gridAptos4;
    @ViewById
    GridView gridAptos5;
    @ViewById
    GridView gridAptos6;
    @ViewById
    GridView gridAptos7;
    @ViewById
    GridView gridAptos8;
    @ViewById
    GridView gridAptos9;
    @ViewById
    GridView gridAptos10;
    @ViewById
    GridView gridAptos11;
    @ViewById
    GridView gridAptos12;
    @ViewById
    GridView gridAptos13;
    @ViewById
    GridView gridAptos14;
    @ViewById
    GridView gridAptos15;
    @ViewById
    GridView gridAptos16;
    @ViewById
    GridView gridAptos17;
    @ViewById
    GridView gridAptos18;
    @ViewById
    GridView gridAptos19;
    @ViewById
    GridView gridAptos20;
    @ViewById
    GridView gridAptos21;
    @ViewById
    GridView gridAptos22;
    @ViewById
    GridView gridAptos23;
    @ViewById
    GridView gridAptos24;
    @ViewById
    GridView gridAptos25;
    @ViewById
    GridView gridAptos26;
    @ViewById
    GridView gridAptos27;
    @ViewById
    GridView gridAptos28;
    @ViewById
    GridView gridAptos29;
    @ViewById
    GridView gridAptos30;
    @ViewById
    GridView gridAptos31;
    @ViewById
    GridView gridAptos32;
    @ViewById
    GridView gridAptos33;
    @ViewById
    GridView gridAptos34;
    @ViewById
    GridView gridAptos35;
    @ViewById
    GridView gridAptos36;
    @ViewById
    GridView gridAptos37;
    @ViewById
    GridView gridAptos38;
    @ViewById
    GridView gridAptos39;
    @ViewById
    GridView gridAptos40;
    @ViewById
    GridView gridAptos41;
    @ViewById
    GridView gridAptos42;
    @ViewById
    GridView gridAptos43;
    @ViewById
    GridView gridAptos44;
    @ViewById
    GridView gridAptos45;
    @ViewById
    GridView gridAptos46;
    @ViewById
    GridView gridAptos47;
    @ViewById
    GridView gridAptos48;
    @ViewById
    GridView gridAptos49;
    @ViewById
    GridView gridAptos50;
    @ViewById
    GridView gridAptos51;
    @ViewById
    GridView gridAptos52;
    @ViewById
    GridView gridAptos53;
    @ViewById
    GridView gridAptos54;
    @ViewById
    GridView gridAptos55;
    @ViewById
    GridView gridAptos56;
    @ViewById
    GridView gridAptos57;
    @ViewById
    GridView gridAptos58;
    @ViewById
    GridView gridAptos59;
    @ViewById
    GridView gridAptos60;
    @ViewById
    GridView gridAptos61;
    @ViewById
    GridView gridAptos62;
    @ViewById
    GridView gridAptos63;
    @ViewById
    GridView gridAptos64;
    @ViewById
    GridView gridAptosRem;
    @ViewById
    GridView gridCancelados;

    @Bean
    ProcessadorAdapter processadorAdapter;
    @Bean
    ProcessoAdapter processoAdapter1;
    @Bean
    ProcessoAdapter processoAdapter2;
    @Bean
    ProcessoAdapter processoAdapter3;
    @Bean
    ProcessoAdapter processoAdapter4;
    @Bean
    ProcessoAdapter processoAdapter5;
    @Bean
    ProcessoAdapter processoAdapter6;
    @Bean
    ProcessoAdapter processoAdapter7;
    @Bean
    ProcessoAdapter processoAdapter8;
    @Bean
    ProcessoAdapter processoAdapter9;
    @Bean
    ProcessoAdapter processoAdapter10;
    @Bean
    ProcessoAdapter processoAdapter11;
    @Bean
    ProcessoAdapter processoAdapter12;
    @Bean
    ProcessoAdapter processoAdapter13;
    @Bean
    ProcessoAdapter processoAdapter14;
    @Bean
    ProcessoAdapter processoAdapter15;
    @Bean
    ProcessoAdapter processoAdapter16;
    @Bean
    ProcessoAdapter processoAdapter17;
    @Bean
    ProcessoAdapter processoAdapter18;
    @Bean
    ProcessoAdapter processoAdapter19;
    @Bean
    ProcessoAdapter processoAdapter20;
    @Bean
    ProcessoAdapter processoAdapter21;
    @Bean
    ProcessoAdapter processoAdapter22;
    @Bean
    ProcessoAdapter processoAdapter23;
    @Bean
    ProcessoAdapter processoAdapter24;
    @Bean
    ProcessoAdapter processoAdapter25;
    @Bean
    ProcessoAdapter processoAdapter26;
    @Bean
    ProcessoAdapter processoAdapter27;
    @Bean
    ProcessoAdapter processoAdapter28;
    @Bean
    ProcessoAdapter processoAdapter29;
    @Bean
    ProcessoAdapter processoAdapter30;
    @Bean
    ProcessoAdapter processoAdapter31;
    @Bean
    ProcessoAdapter processoAdapter32;
    @Bean
    ProcessoAdapter processoAdapter33;
    @Bean
    ProcessoAdapter processoAdapter34;
    @Bean
    ProcessoAdapter processoAdapter35;
    @Bean
    ProcessoAdapter processoAdapter36;
    @Bean
    ProcessoAdapter processoAdapter37;
    @Bean
    ProcessoAdapter processoAdapter38;
    @Bean
    ProcessoAdapter processoAdapter39;
    @Bean
    ProcessoAdapter processoAdapter40;
    @Bean
    ProcessoAdapter processoAdapter41;
    @Bean
    ProcessoAdapter processoAdapter42;
    @Bean
    ProcessoAdapter processoAdapter43;
    @Bean
    ProcessoAdapter processoAdapter44;
    @Bean
    ProcessoAdapter processoAdapter45;
    @Bean
    ProcessoAdapter processoAdapter46;
    @Bean
    ProcessoAdapter processoAdapter47;
    @Bean
    ProcessoAdapter processoAdapter48;
    @Bean
    ProcessoAdapter processoAdapter49;
    @Bean
    ProcessoAdapter processoAdapter50;
    @Bean
    ProcessoAdapter processoAdapter51;
    @Bean
    ProcessoAdapter processoAdapter52;
    @Bean
    ProcessoAdapter processoAdapter53;
    @Bean
    ProcessoAdapter processoAdapter54;
    @Bean
    ProcessoAdapter processoAdapter55;
    @Bean
    ProcessoAdapter processoAdapter56;
    @Bean
    ProcessoAdapter processoAdapter57;
    @Bean
    ProcessoAdapter processoAdapter58;
    @Bean
    ProcessoAdapter processoAdapter59;
    @Bean
    ProcessoAdapter processoAdapter60;
    @Bean
    ProcessoAdapter processoAdapter61;
    @Bean
    ProcessoAdapter processoAdapter62;
    @Bean
    ProcessoAdapter processoAdapter63;
    @Bean
    ProcessoAdapter processoAdapter64;
    @Bean
    ProcessoAdapter processoAdapterRem;
    @Bean
    ProcessoAdapter finalizadoAdapter;
    @Bean
    ProcessoAdapter remanecenteAdapter;

    @ViewById(R.id.scrollview_content_main)
    ScrollView scrollView;

    @Extra
    int numProcessos;

    @Extra
    int numQtdProcessadores;

    @ViewById(R.id.iniciar)
    FloatingActionButton iniciar;

    LinkedList<Processador> processadores;

    LinkedList<LinkedList<Processo>> processosList = new LinkedList<>();

    LinkedList<Processo> finalizados;

    LinkedList<Processo> remanecentes;

    Semaphore semaphore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        processadores = new LinkedList<>();
        finalizados = new LinkedList<>();
        remanecentes = new LinkedList<>();
    }

    @AfterViews
    public void afterViews(){
        criarListas();
        ativarGridView();
        prepararEscalonamento();
    }

    @Click(R.id.iniciar)
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
                        Processador processador = processadores.get(i);
                        if (!processador.is_processando) {
                            if (!processosList.get(i).isEmpty()) {
                                if (processosList.get(i).get(0).deadLine == 0) {
                                    processador.processo = processosList.get(i).pop();
                                    processador.is_processando = true;
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
                    Processador processador = processadores.get(j);
                    if (processador.is_processando) {
                        processadores.get(j).processo.tempoProcesso--;
                        if (processador.processo.tempoProcesso == 0) {
                            processador.processo.color = Color.GRAY;
                            finalizados.add(processador.processo);
                            processadores.get(j).processo = null;
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

    @Click(R.id.adicionar)
    synchronized void adicionarProcesso(){

      Random gerador = new Random();

      int tempoProcesso = gerador.nextInt(8) + 2;

      int deadLine = gerador.nextInt(20) + 2;

      int ultimoProcesso = numProcessos;

      Processo processo = new Processo("P"+ ultimoProcesso++, tempoProcesso, deadLine, tempoProcesso, Color.BLUE);

      synchronized (this){
        remanecentes.add(processo);

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

    public LinkedList<Processo> gerarFilaExecucao(LinkedList<Processo> iniciais){

        Processo processo;
        LinkedList<Processo> processos;
        try{

            Collections.sort(iniciais);
            processo = iniciais.get(0);
            LinkedList<Processo> auxRem = new LinkedList<>();
            processos = new LinkedList<>();
            processos.add(iniciais.pop());
            while(!iniciais.isEmpty()){
                if((processo.deadLine + processo.tempoProcesso < iniciais.get(0).deadLine) || (processo.deadLine + processo.tempoProcesso == iniciais.get(0).deadLine)){
                    processo = iniciais.get(0);
                    processos.add(iniciais.pop());
                }else{
                    auxRem.add(iniciais.pop());
                }
            }

            remanecentes = auxRem;

        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            return iniciais;
        }


        return processos;
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
            processadores.add(new Processador());
        }

        processadorAdapter.setProcessadores(processadores);

        gridProcessadores.setAdapter(processadorAdapter);

    }

    public void contruirGridViewProcessos(){

        int count = 0;
        Random gerador = new Random();

        LinkedList<Processo> iniciais = new LinkedList<>();

        int tempoProcesso;
        int deadLine;

        for (int i = 0; i < numProcessos; i++) {
            tempoProcesso = gerador.nextInt(8) + 2;
            deadLine = gerador.nextInt(20) + 2;
            iniciais.add(new Processo("P" + (i + 1), tempoProcesso, deadLine, tempoProcesso, getResources().getColor(R.color.amareloProcesso)));

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

        finalizadoAdapter.setProcessos(finalizados);

        gridCancelados.setAdapter(finalizadoAdapter);

    }

    public void construirGridViewRemanecente(){

      gridAptosRem.setNumColumns(remanecentes.size());

      gridViewSetting(gridAptosRem, remanecentes.size());

      remanecenteAdapter.setProcessos(remanecentes);

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

    @UiThread
    public void reloadDataGridViewProcessos(int numFilaProcesso){

        synchronized (this){

            switch (numFilaProcesso){
                case 0:
                    gridAptos1.setNumColumns(processosList.get(0).size());

                    gridViewSetting(gridAptos1, processosList.get(0).size());

                    processoAdapter1.setProcessos(processosList.get(0));

                    gridAptos1.setAdapter(processoAdapter1);

                    break;
                case 1:
                    gridAptos2.setNumColumns(processosList.get(1).size());

                    gridViewSetting(gridAptos2, processosList.get(1).size());

                    processoAdapter2.setProcessos(processosList.get(1));

                    gridAptos2.setAdapter(processoAdapter2);

                    break;
                case 2:
                    gridAptos3.setNumColumns(processosList.get(2).size());

                    gridViewSetting(gridAptos3, processosList.get(2).size());

                    processoAdapter3.setProcessos(processosList.get(2));

                    gridAptos3.setAdapter(processoAdapter3);

                    break;
                case 3:
                    gridAptos4.setNumColumns(processosList.get(3).size());

                    gridViewSetting(gridAptos4, processosList.get(3).size());

                    processoAdapter4.setProcessos(processosList.get(3));

                    gridAptos4.setAdapter(processoAdapter4);

                    break;
                case 4:
                    gridAptos5.setNumColumns(processosList.get(4).size());

                    gridViewSetting(gridAptos5, processosList.get(4).size());

                    processoAdapter5.setProcessos(processosList.get(4));

                    gridAptos5.setAdapter(processoAdapter5);

                    break;
                case 5:
                    gridAptos6.setNumColumns(processosList.get(5).size());

                    gridViewSetting(gridAptos6, processosList.get(5).size());

                    processoAdapter6.setProcessos(processosList.get(5));

                    gridAptos6.setAdapter(processoAdapter6);

                    break;
                case 6:
                    gridAptos7.setNumColumns(processosList.get(6).size());

                    gridViewSetting(gridAptos7, processosList.get(6).size());

                    processoAdapter7.setProcessos(processosList.get(6));

                    gridAptos7.setAdapter(processoAdapter7);

                    break;
                case 7:
                    gridAptos8.setNumColumns(processosList.get(7).size());

                    gridViewSetting(gridAptos8, processosList.get(7).size());

                    processoAdapter8.setProcessos(processosList.get(7));

                    gridAptos8.setAdapter(processoAdapter8);

                    break;
                case 8:
                    gridAptos9.setNumColumns(processosList.get(8).size());

                    gridViewSetting(gridAptos9, processosList.get(8).size());

                    processoAdapter9.setProcessos(processosList.get(8));

                    gridAptos9.setAdapter(processoAdapter9);

                    break;
                case 9:
                    gridAptos10.setNumColumns(processosList.get(9).size());

                    gridViewSetting(gridAptos10, processosList.get(9).size());

                    processoAdapter10.setProcessos(processosList.get(9));

                    gridAptos10.setAdapter(processoAdapter10);

                    break;
                case 10:
                    gridAptos11.setNumColumns(processosList.get(10).size());

                    gridViewSetting(gridAptos11, processosList.get(10).size());

                    processoAdapter11.setProcessos(processosList.get(10));

                    gridAptos11.setAdapter(processoAdapter11);

                    break;
                case 11:
                    gridAptos12.setNumColumns(processosList.get(11).size());

                    gridViewSetting(gridAptos12, processosList.get(11).size());

                    processoAdapter12.setProcessos(processosList.get(11));

                    gridAptos12.setAdapter(processoAdapter12);

                    break;
                case 12:
                    gridAptos13.setNumColumns(processosList.get(12).size());

                    gridViewSetting(gridAptos13, processosList.get(12).size());

                    processoAdapter13.setProcessos(processosList.get(12));

                    gridAptos13.setAdapter(processoAdapter13);

                    break;
                case 13:
                    gridAptos14.setNumColumns(processosList.get(13).size());

                    gridViewSetting(gridAptos14, processosList.get(13).size());

                    processoAdapter14.setProcessos(processosList.get(13));

                    gridAptos14.setAdapter(processoAdapter14);

                    break;
                case 14:
                    gridAptos15.setNumColumns(processosList.get(14).size());

                    gridViewSetting(gridAptos14, processosList.get(15).size());

                    processoAdapter14.setProcessos(processosList.get(15));

                    gridAptos14.setAdapter(processoAdapter15);

                    break;
                case 15:
                    gridAptos16.setNumColumns(processosList.get(15).size());

                    gridViewSetting(gridAptos16, processosList.get(15).size());

                    processoAdapter16.setProcessos(processosList.get(15));

                    gridAptos16.setAdapter(processoAdapter16);

                    break;
                case 16:
                    gridAptos17.setNumColumns(processosList.get(16).size());

                    gridViewSetting(gridAptos17, processosList.get(16).size());

                    processoAdapter17.setProcessos(processosList.get(16));

                    gridAptos17.setAdapter(processoAdapter17);

                    break;
                case 17:
                    gridAptos18.setNumColumns(processosList.get(17).size());

                    gridViewSetting(gridAptos18, processosList.get(17).size());

                    processoAdapter18.setProcessos(processosList.get(17));

                    gridAptos18.setAdapter(processoAdapter18);

                    break;
                case 18:
                    gridAptos19.setNumColumns(processosList.get(18).size());

                    gridViewSetting(gridAptos19, processosList.get(18).size());

                    processoAdapter19.setProcessos(processosList.get(18));

                    gridAptos19.setAdapter(processoAdapter19);

                    break;
                case 19:
                    gridAptos20.setNumColumns(processosList.get(19).size());

                    gridViewSetting(gridAptos20, processosList.get(19).size());

                    processoAdapter20.setProcessos(processosList.get(19));

                    gridAptos20.setAdapter(processoAdapter20);

                    break;
                case 20:
                    gridAptos21.setNumColumns(processosList.get(20).size());

                    gridViewSetting(gridAptos21, processosList.get(20).size());

                    processoAdapter21.setProcessos(processosList.get(20));

                    gridAptos21.setAdapter(processoAdapter21);

                    break;
                case 21:
                    gridAptos22.setNumColumns(processosList.get(21).size());

                    gridViewSetting(gridAptos22, processosList.get(21).size());

                    processoAdapter22.setProcessos(processosList.get(21));

                    gridAptos22.setAdapter(processoAdapter22);

                    break;
                case 22:
                    gridAptos23.setNumColumns(processosList.get(22).size());

                    gridViewSetting(gridAptos23, processosList.get(22).size());

                    processoAdapter23.setProcessos(processosList.get(22));

                    gridAptos23.setAdapter(processoAdapter23);

                    break;
                case 23:
                    gridAptos24.setNumColumns(processosList.get(23).size());

                    gridViewSetting(gridAptos24, processosList.get(23).size());

                    processoAdapter24.setProcessos(processosList.get(23));

                    gridAptos24.setAdapter(processoAdapter24);

                    break;
                case 24:
                    gridAptos25.setNumColumns(processosList.get(24).size());

                    gridViewSetting(gridAptos25, processosList.get(24).size());

                    processoAdapter25.setProcessos(processosList.get(24));

                    gridAptos25.setAdapter(processoAdapter25);

                    break;
                case 25:
                    gridAptos26.setNumColumns(processosList.get(25).size());

                    gridViewSetting(gridAptos26, processosList.get(25).size());

                    processoAdapter26.setProcessos(processosList.get(25));

                    gridAptos26.setAdapter(processoAdapter26);

                    break;
                case 26:
                    gridAptos27.setNumColumns(processosList.get(26).size());

                    gridViewSetting(gridAptos27, processosList.get(26).size());

                    processoAdapter27.setProcessos(processosList.get(26));

                    gridAptos27.setAdapter(processoAdapter27);

                    break;
                case 27:
                    gridAptos28.setNumColumns(processosList.get(27).size());

                    gridViewSetting(gridAptos28, processosList.get(27).size());

                    processoAdapter28.setProcessos(processosList.get(27));

                    gridAptos28.setAdapter(processoAdapter28);

                    break;
                case 28:
                    gridAptos29.setNumColumns(processosList.get(28).size());

                    gridViewSetting(gridAptos29, processosList.get(28).size());

                    processoAdapter29.setProcessos(processosList.get(28));

                    gridAptos29.setAdapter(processoAdapter29);

                    break;
                case 29:
                    gridAptos30.setNumColumns(processosList.get(29).size());

                    gridViewSetting(gridAptos30, processosList.get(29).size());

                    processoAdapter30.setProcessos(processosList.get(29));

                    gridAptos30.setAdapter(processoAdapter30);

                    break;
                case 30:
                    gridAptos31.setNumColumns(processosList.get(30).size());

                    gridViewSetting(gridAptos31, processosList.get(30).size());

                    processoAdapter31.setProcessos(processosList.get(30));

                    gridAptos31.setAdapter(processoAdapter31);

                    break;
                case 31:
                    gridAptos32.setNumColumns(processosList.get(31).size());

                    gridViewSetting(gridAptos32, processosList.get(31).size());

                    processoAdapter32.setProcessos(processosList.get(31));

                    gridAptos32.setAdapter(processoAdapter32);

                    break;
                case 32:
                    gridAptos33.setNumColumns(processosList.get(32).size());

                    gridViewSetting(gridAptos33, processosList.get(32).size());

                    processoAdapter33.setProcessos(processosList.get(32));

                    gridAptos33.setAdapter(processoAdapter33);

                    break;
                case 33:
                    gridAptos34.setNumColumns(processosList.get(33).size());

                    gridViewSetting(gridAptos34, processosList.get(33).size());

                    processoAdapter34.setProcessos(processosList.get(33));

                    gridAptos34.setAdapter(processoAdapter34);

                    break;
                case 34:
                    gridAptos35.setNumColumns(processosList.get(34).size());

                    gridViewSetting(gridAptos35, processosList.get(34).size());

                    processoAdapter35.setProcessos(processosList.get(34));

                    gridAptos35.setAdapter(processoAdapter35);

                    break;
                case 35:
                    gridAptos36.setNumColumns(processosList.get(35).size());

                    gridViewSetting(gridAptos36, processosList.get(35).size());

                    processoAdapter36.setProcessos(processosList.get(35));

                    gridAptos36.setAdapter(processoAdapter36);

                    break;
                case 36:
                    gridAptos37.setNumColumns(processosList.get(36).size());

                    gridViewSetting(gridAptos37, processosList.get(36).size());

                    processoAdapter37.setProcessos(processosList.get(36));

                    gridAptos37.setAdapter(processoAdapter37);

                    break;
                case 37:
                    gridAptos38.setNumColumns(processosList.get(37).size());

                    gridViewSetting(gridAptos38, processosList.get(37).size());

                    processoAdapter38.setProcessos(processosList.get(37));

                    gridAptos38.setAdapter(processoAdapter38);

                    break;
                case 38:
                    gridAptos39.setNumColumns(processosList.get(38).size());

                    gridViewSetting(gridAptos39, processosList.get(38).size());

                    processoAdapter39.setProcessos(processosList.get(38));

                    gridAptos39.setAdapter(processoAdapter39);

                    break;
                case 39:
                    gridAptos40.setNumColumns(processosList.get(39).size());

                    gridViewSetting(gridAptos40, processosList.get(39).size());

                    processoAdapter40.setProcessos(processosList.get(39));

                    gridAptos40.setAdapter(processoAdapter40);

                    break;
                case 40:

                    gridAptos41.setNumColumns(processosList.get(40).size());

                    gridViewSetting(gridAptos41, processosList.get(40).size());

                    processoAdapter41.setProcessos(processosList.get(40));

                    gridAptos41.setAdapter(processoAdapter41);

                    break;
                case 41:
                    gridAptos42.setNumColumns(processosList.get(41).size());

                    gridViewSetting(gridAptos42, processosList.get(41).size());

                    processoAdapter42.setProcessos(processosList.get(41));

                    gridAptos42.setAdapter(processoAdapter42);

                    break;
                case 42:
                    gridAptos43.setNumColumns(processosList.get(42).size());

                    gridViewSetting(gridAptos43, processosList.get(42).size());

                    processoAdapter43.setProcessos(processosList.get(42));

                    gridAptos43.setAdapter(processoAdapter43);

                    break;
                case 43:
                    gridAptos44.setNumColumns(processosList.get(43).size());

                    gridViewSetting(gridAptos44, processosList.get(43).size());

                    processoAdapter44.setProcessos(processosList.get(43));

                    gridAptos44.setAdapter(processoAdapter44);

                    break;
                case 44:
                    gridAptos45.setNumColumns(processosList.get(44).size());

                    gridViewSetting(gridAptos45, processosList.get(44).size());

                    processoAdapter45.setProcessos(processosList.get(44));

                    gridAptos45.setAdapter(processoAdapter45);

                    break;
                case 45:
                    gridAptos46.setNumColumns(processosList.get(45).size());

                    gridViewSetting(gridAptos46, processosList.get(45).size());

                    processoAdapter46.setProcessos(processosList.get(45));

                    gridAptos46.setAdapter(processoAdapter46);

                    break;
                case 46:
                    gridAptos47.setNumColumns(processosList.get(46).size());

                    gridViewSetting(gridAptos47, processosList.get(46).size());

                    processoAdapter47.setProcessos(processosList.get(46));

                    gridAptos47.setAdapter(processoAdapter47);

                    break;
                case 47:
                    gridAptos48.setNumColumns(processosList.get(47).size());

                    gridViewSetting(gridAptos48, processosList.get(47).size());

                    processoAdapter48.setProcessos(processosList.get(47));

                    gridAptos48.setAdapter(processoAdapter48);

                    break;
                case 48:
                    gridAptos49.setNumColumns(processosList.get(48).size());

                    gridViewSetting(gridAptos49, processosList.get(48).size());

                    processoAdapter49.setProcessos(processosList.get(48));

                    gridAptos49.setAdapter(processoAdapter49);

                    break;
                case 49:
                    gridAptos50.setNumColumns(processosList.get(49).size());

                    gridViewSetting(gridAptos50, processosList.get(49).size());

                    processoAdapter50.setProcessos(processosList.get(49));

                    gridAptos50.setAdapter(processoAdapter50);

                    break;
                case 50:
                    gridAptos51.setNumColumns(processosList.get(50).size());

                    gridViewSetting(gridAptos51, processosList.get(50).size());

                    processoAdapter51.setProcessos(processosList.get(50));

                    gridAptos51.setAdapter(processoAdapter51);

                    break;
                case 51:
                    gridAptos52.setNumColumns(processosList.get(51).size());

                    gridViewSetting(gridAptos52, processosList.get(51).size());

                    processoAdapter52.setProcessos(processosList.get(1));

                    gridAptos52.setAdapter(processoAdapter52);

                    break;
                case 52:
                    gridAptos53.setNumColumns(processosList.get(52).size());

                    gridViewSetting(gridAptos53, processosList.get(52).size());

                    processoAdapter53.setProcessos(processosList.get(52));

                    gridAptos53.setAdapter(processoAdapter53);

                    break;
                case 53:
                    gridAptos54.setNumColumns(processosList.get(53).size());

                    gridViewSetting(gridAptos54, processosList.get(53).size());

                    processoAdapter54.setProcessos(processosList.get(53));

                    gridAptos54.setAdapter(processoAdapter54);

                    break;
                case 54:
                    gridAptos55.setNumColumns(processosList.get(54).size());

                    gridViewSetting(gridAptos55, processosList.get(54).size());

                    processoAdapter55.setProcessos(processosList.get(54));

                    gridAptos55.setAdapter(processoAdapter55);

                    break;
                case 55:
                    gridAptos56.setNumColumns(processosList.get(55).size());

                    gridViewSetting(gridAptos56, processosList.get(55).size());

                    processoAdapter56.setProcessos(processosList.get(55));

                    gridAptos56.setAdapter(processoAdapter56);

                    break;
                case 56:
                    gridAptos57.setNumColumns(processosList.get(56).size());

                    gridViewSetting(gridAptos57, processosList.get(56).size());

                    processoAdapter57.setProcessos(processosList.get(56));

                    gridAptos57.setAdapter(processoAdapter57);

                    break;
                case 57:
                    gridAptos58.setNumColumns(processosList.get(57).size());

                    gridViewSetting(gridAptos58, processosList.get(57).size());

                    processoAdapter58.setProcessos(processosList.get(57));

                    gridAptos58.setAdapter(processoAdapter58);

                    break;
                case 58:
                    gridAptos59.setNumColumns(processosList.get(58).size());

                    gridViewSetting(gridAptos59, processosList.get(58).size());

                    processoAdapter59.setProcessos(processosList.get(58));

                    gridAptos59.setAdapter(processoAdapter59);

                    break;
                case 59:
                    gridAptos60.setNumColumns(processosList.get(59).size());

                    gridViewSetting(gridAptos60, processosList.get(59).size());

                    processoAdapter60.setProcessos(processosList.get(59));

                    gridAptos60.setAdapter(processoAdapter60);

                    break;
                case 60:
                    gridAptos61.setNumColumns(processosList.get(60).size());

                    gridViewSetting(gridAptos61, processosList.get(60).size());

                    processoAdapter61.setProcessos(processosList.get(60));

                    gridAptos61.setAdapter(processoAdapter61);

                    break;
                case 61:
                    gridAptos62.setNumColumns(processosList.get(61).size());

                    gridViewSetting(gridAptos62, processosList.get(61).size());

                    processoAdapter62.setProcessos(processosList.get(61));

                    gridAptos62.setAdapter(processoAdapter62);

                    break;
                case 62:
                    gridAptos63.setNumColumns(processosList.get(62).size());

                    gridViewSetting(gridAptos63, processosList.get(62).size());

                    processoAdapter63.setProcessos(processosList.get(62));

                    gridAptos63.setAdapter(processoAdapter63);

                    break;
                case 63:
                    gridAptos64.setNumColumns(processosList.get(63).size());

                    gridViewSetting(gridAptos64, processosList.get(63).size());

                    processoAdapter64.setProcessos(processosList.get(63));

                    gridAptos64.setAdapter(processoAdapter64);

                    break;







            }

        }

    }

    @UiThread
    public void reloadDataGridViewProcessador(LinkedList<Processador> processadores){

        synchronized (getApplicationContext()){
            processadorAdapter.setProcessadores(processadores);
            processadorAdapter.notifyDataSetChanged();
        }

    }

    @UiThread
    public void reloadDataGridViewFinalizado(){

        synchronized (getApplicationContext()) {
            contruirGridViewFinalizados();
        }
    }

    @UiThread
    public void reloadDataGridViewRemanecente(){
      synchronized (this){
        construirGridViewRemanecente();
      }
    }

    public void criarListas(){
        for (int i = 0; i < numQtdProcessadores; i++){
            processosList.add(new LinkedList<Processo>());
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
                case 0: processoAdapter1.setProcessos(processosList.get(0)); break;
                case 1: processoAdapter2.setProcessos(processosList.get(1)); break;
                case 2: processoAdapter3.setProcessos(processosList.get(2)); break;
                case 3: processoAdapter4.setProcessos(processosList.get(3)); break;
                case 4: processoAdapter5.setProcessos(processosList.get(4)); break;
                case 5: processoAdapter6.setProcessos(processosList.get(5)); break;
                case 6: processoAdapter7.setProcessos(processosList.get(6)); break;
                case 7: processoAdapter8.setProcessos(processosList.get(7)); break;
                case 8: processoAdapter9.setProcessos(processosList.get(8)); break;
                case 9: processoAdapter10.setProcessos(processosList.get(9)); break;
                case 10: processoAdapter11.setProcessos(processosList.get(10)); break;
                case 11: processoAdapter12.setProcessos(processosList.get(11)); break;
                case 12: processoAdapter13.setProcessos(processosList.get(12)); break;
                case 13: processoAdapter14.setProcessos(processosList.get(13)); break;
                case 14: processoAdapter15.setProcessos(processosList.get(14)); break;
                case 15: processoAdapter16.setProcessos(processosList.get(15)); break;
                case 16: processoAdapter17.setProcessos(processosList.get(16)); break;
                case 17: processoAdapter18.setProcessos(processosList.get(17)); break;
                case 18: processoAdapter19.setProcessos(processosList.get(18)); break;
                case 19: processoAdapter20.setProcessos(processosList.get(19)); break;
                case 20: processoAdapter21.setProcessos(processosList.get(20)); break;
                case 21: processoAdapter22.setProcessos(processosList.get(21)); break;
                case 22: processoAdapter23.setProcessos(processosList.get(22)); break;
                case 23: processoAdapter24.setProcessos(processosList.get(23)); break;
                case 24: processoAdapter25.setProcessos(processosList.get(24)); break;
                case 25: processoAdapter26.setProcessos(processosList.get(25)); break;
                case 26: processoAdapter27.setProcessos(processosList.get(26)); break;
                case 27: processoAdapter28.setProcessos(processosList.get(27)); break;
                case 28: processoAdapter29.setProcessos(processosList.get(28)); break;
                case 29: processoAdapter30.setProcessos(processosList.get(29)); break;
                case 30: processoAdapter31.setProcessos(processosList.get(30)); break;
                case 31: processoAdapter32.setProcessos(processosList.get(31)); break;
                case 32: processoAdapter33.setProcessos(processosList.get(32)); break;
                case 33: processoAdapter34.setProcessos(processosList.get(33)); break;
                case 34: processoAdapter35.setProcessos(processosList.get(34)); break;
                case 35: processoAdapter36.setProcessos(processosList.get(35)); break;
                case 36: processoAdapter37.setProcessos(processosList.get(36)); break;
                case 37: processoAdapter38.setProcessos(processosList.get(37)); break;
                case 38: processoAdapter39.setProcessos(processosList.get(38)); break;
                case 39: processoAdapter40.setProcessos(processosList.get(39)); break;
                case 40: processoAdapter41.setProcessos(processosList.get(40)); break;
                case 41: processoAdapter42.setProcessos(processosList.get(41)); break;
                case 42: processoAdapter43.setProcessos(processosList.get(42)); break;
                case 43: processoAdapter44.setProcessos(processosList.get(43)); break;
                case 44: processoAdapter45.setProcessos(processosList.get(44)); break;
                case 45: processoAdapter46.setProcessos(processosList.get(45)); break;
                case 46: processoAdapter47.setProcessos(processosList.get(46)); break;
                case 47: processoAdapter48.setProcessos(processosList.get(47)); break;
                case 48: processoAdapter49.setProcessos(processosList.get(48)); break;
                case 49: processoAdapter50.setProcessos(processosList.get(49)); break;
                case 50: processoAdapter51.setProcessos(processosList.get(50)); break;
                case 51: processoAdapter52.setProcessos(processosList.get(51)); break;
                case 52: processoAdapter53.setProcessos(processosList.get(52)); break;
                case 53: processoAdapter54.setProcessos(processosList.get(53)); break;
                case 54: processoAdapter55.setProcessos(processosList.get(54)); break;
                case 55: processoAdapter56.setProcessos(processosList.get(55)); break;
                case 56: processoAdapter57.setProcessos(processosList.get(56)); break;
                case 57: processoAdapter58.setProcessos(processosList.get(57)); break;
                case 58: processoAdapter59.setProcessos(processosList.get(58)); break;
                case 59: processoAdapter60.setProcessos(processosList.get(59)); break;
                case 60: processoAdapter61.setProcessos(processosList.get(60)); break;
                case 61: processoAdapter62.setProcessos(processosList.get(61)); break;
                case 62: processoAdapter63.setProcessos(processosList.get(62)); break;
                case 63: processoAdapter64.setProcessos(processosList.get(63)); break;

            }

            remanecenteAdapter.setProcessos(remanecentes);
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
