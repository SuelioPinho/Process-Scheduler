package com.example.sueliopss.escalonador;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.LinkedList;
import java.util.Random;
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

    @Bean
    ProcessadorIBAdapter processadorAdapter;
    @Bean
    ProcessoIBAdapter processoAdapter1;
    @Bean
    ProcessoIBAdapter processoAdapter2;
    @Bean
    ProcessoIBAdapter processoAdapter3;
    @Bean
    ProcessoIBAdapter processoAdapter4;
    @Bean
    ProcessoIBAdapter processoAdapter5;
    @Bean
    ProcessoIBAdapter processoAdapter6;
    @Bean
    ProcessoIBAdapter processoAdapter7;
    @Bean
    ProcessoIBAdapter processoAdapter8;
    @Bean
    ProcessoIBAdapter processoAdapter9;
    @Bean
    ProcessoIBAdapter processoAdapter10;

    @ViewById(R.id.scrollview_content_main)
    ScrollView scrollView;

    int numProcessos;

    int numQtdProcessadores;

    LinkedList<ProcessadorIB> processadores;

    LinkedList<LinkedList<ProcessoIB>> processosList = new LinkedList<>();

    LinkedList<ProcessoIB> finalizados;

    Semaphore semaphore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @AfterViews
    public void afterViews(){
        linear1.setVisibility(View.VISIBLE);
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

        int qntProcessadores = numQtdProcessadores;

        int qntprocessos = numProcessos;

        semaphore = new Semaphore(qntProcessadores);

        contruirGridViewProcessadores(qntProcessadores);

        contruirGridViewProcessos(qntprocessos);

        //contruirGridViewFinalizados();

        setGridViewHeightBasedOnChildren(gridProcessadores, 4);

    }

    public void contruirGridViewProcessadores(int numProcessadores){

        for (int i = 0; i < numProcessadores; i++){
            processadores.add(new ProcessadorIB());
        }

        processadorAdapter.setProcessadores(processadores);

        gridProcessadores.setAdapter(processadorAdapter);

    }

    public void contruirGridViewProcessos(int numProcesso){

        int count = 0;
        Random gerador = new Random();

        int tempoProcesso;
        int deadLine;

        for (int i = 0; i < numProcesso; i++) {
            tempoProcesso = gerador.nextInt(20) + 4;
            deadLine = gerador.nextInt(8) + 2;
            processosList.get(count).add(new ProcessoIB("P" + (i + 1), tempoProcesso, deadLine, Color.YELLOW, tempoProcesso,count));

            if (count == 3){
                count = 0;
            }else {
                count ++;
            }
        }

        gridAptos1.setNumColumns(processosList.get(0).size());
        gridAptos2.setNumColumns(processosList.get(1).size());
        gridAptos3.setNumColumns(processosList.get(2).size());
        gridAptos4.setNumColumns(processosList.get(3).size());

        gridViewSetting(gridAptos1, processosList.get(0).size());
        gridViewSetting(gridAptos2, processosList.get(1).size());
        gridViewSetting(gridAptos3, processosList.get(2).size());
        gridViewSetting(gridAptos4, processosList.get(3).size());

        processoAdapter1.setProcessos(processosList.get(0));
        processoAdapter2.setProcessos(processosList.get(1));
        processoAdapter3.setProcessos(processosList.get(2));
        processoAdapter4.setProcessos(processosList.get(3));

        gridAptos1.setAdapter(processoAdapter1);
        gridAptos2.setAdapter(processoAdapter2);
        gridAptos3.setAdapter(processoAdapter3);
        gridAptos4.setAdapter(processoAdapter4);

    }

    public void contruirGridViewFinalizados(){

//        gridCancelados.setNumColumns(finalizados.size());
//
//        gridViewSetting(gridCancelados, finalizados.size());
//
//        finalizadoAdapter.setProcessos(finalizados);
//
//        gridCancelados.setAdapter(finalizadoAdapter);

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

            }

        }

    }

    @UiThread
    public void reloadDataGridViewProcessador(LinkedList<ProcessadorIB> processadores){

        synchronized (getApplicationContext()){
            processadorAdapter.setProcessadores(processadores);
            processadorAdapter.notifyDataSetChanged();
        }

    }

    @UiThread
    public void reloadDataGridViewFinalizado(LinkedList<Processo> processos){

        synchronized (getApplicationContext()) {
            contruirGridViewFinalizados();
        }
    }

}
