package com.example.sueliopss.escalonador;

import android.app.AlertDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
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
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

@EActivity(R.layout.activity_round_r)
public class RoundRActivity extends AppCompatActivity {

    @ViewById(R.id.gridProcessadores)
    GridView gridProcessadores;

    @ViewById(R.id.gridAptos1)
    GridView gridAptos1;

    @ViewById(R.id.gridAptos2)
    GridView gridAptos2;

    @ViewById(R.id.gridAptos3)
    GridView gridAptos3;

    @ViewById(R.id.gridAptos4)
    GridView gridAptos4;

    @ViewById
    GridView gridCancelados;

    @ViewById(R.id.scrollview_content_main)
    ScrollView scrollView;

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
    ProcessoAdapter finalizadoAdapter;

    @ViewById(R.id.iniciar)
    FloatingActionButton iniciar;

    @Extra
    int numProcessos;

    @Extra
    int numQtdProcessadores;

    @Extra
    int numQuantum;

    EditText numProcessadores;

    EditText numProcesso;

    EditText quantum;

    AlertDialog.Builder builder;

    LinkedList<Processador> processadores;

    LinkedList<LinkedList<Processo>> processosList = new LinkedList<>();

    LinkedList<Processo> finalizados;

    Button escalonar;

    Semaphore semaphore;

    Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* final AlertDialog dialog = createDialog(savedInstanceState);
        dialog.show();*/

        processadores = new LinkedList<>();
        processosList.add(new LinkedList<Processo>());
        processosList.add(new LinkedList<Processo>());
        processosList.add(new LinkedList<Processo>());
        processosList.add(new LinkedList<Processo>());

        finalizados = new LinkedList<>();


        /*escalonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });*/

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

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                try {
                    semaphore.acquire();

                    for (Processador processador : processadores) {
                        if (!processador.is_processando) {
                            for (int i = 0; i < 4; i++) {

                                if (!processosList.get(count).isEmpty()) {
                                    processador.processo = processosList.get(count).pop();
                                    processador.is_processando = true;
                                    reloadDataGridViewProcessos(count);
                                    if (count == 3) {
                                        count = 0;
                                    } else {
                                        count++;
                                    }
                                    break;
                                }
                                if (count == 3) {
                                    count = 0;
                                } else {
                                    count++;
                                }
                            }
                        }
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                        if (processador.processo.tempoProcesso == 0) {

                            finalizados.add(processador.processo);
                            processadores.get(j).processo = null;
                            processadores.get(j).is_processando = false;
                            reloadDataGridViewFinalizado(finalizados);
                            semaphore.release();

                        } else if (processador.processo.quantum == 0) {

//                            processador.processo.quantum = Integer.parseInt(quantum.getText().toString());
                            processador.processo.quantum = numQuantum;
                            processosList.get(processador.processo.prioridade).add(processador.processo);
                            reloadDataGridViewProcessos(processador.processo.prioridade);
                            processadores.get(j).processo = null;
                            processadores.get(j).is_processando = false;
                            semaphore.release();

                         }else {

                            processadores.get(j).processo.quantum--;
                            processadores.get(j).processo.tempoProcesso--;

                        }
                    }
                }

                reloadDataGridViewProcessador(processadores);

            }
        }, 0, 1000);


    }

    public void preencherProcessadores(){

        count = 0;

        for (int i = 0; i < processadores.size(); i++){

            if(!processosList.get(count).isEmpty()){
                processadores.get(i).processo = processosList.get(count).pop();
                processadores.get(i).is_processando = true;
                if (count == 3){
                    count = 0;
                }else{
                    count++;
                }
            }
        }

        reloadDataGridViewProcessos(0);
        reloadDataGridViewProcessos(1);
        reloadDataGridViewProcessos(2);
        reloadDataGridViewProcessos(3);


        reloadDataGridViewProcessador(processadores);
        processar();
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

    public AlertDialog createDialog(Bundle savedInstanceState){

        builder = new AlertDialog.Builder(this);

        LayoutInflater layoutInflater = this.getLayoutInflater();

        View dialog = layoutInflater.inflate(R.layout.dialog_round_r, null);

        builder.setView(dialog);

        builder.setCancelable(false);

        escalonar = (Button) dialog.findViewById(R.id.buttonEscalonar);

        numProcessadores = (EditText) dialog.findViewById(R.id.editTextNumProcessador);

        numProcesso = (EditText) dialog.findViewById(R.id.editTextNumProcesso);

        quantum = (EditText) dialog.findViewById(R.id.editTextQuantum);

        return builder.create();
    }

    public void prepararEscalonamento(){

       // int qntProcessadores = Integer.parseInt(numProcessadores.getText().toString());
        int qntProcessadores = numQtdProcessadores;

       // int qntprocessos = Integer.parseInt(numProcesso.getText().toString());
        int qntprocessos = numProcessos;

        semaphore = new Semaphore(qntProcessadores);

        contruirGridViewProcessadores(qntProcessadores);

        contruirGridViewProcessos(qntprocessos);

        contruirGridViewFinalizados();

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

        int count = 0;
        Random gerador = new Random();

        int tempoProcesso;

       // int quant = Integer.parseInt(quantum.getText().toString());
        int quant = numQuantum;

        for (int i = 0; i < numProcesso; i++) {
            tempoProcesso = gerador.nextInt(20) + 4;

            processosList.get(count).add(new Processo("P" + (i + 1), tempoProcesso, tempoProcesso, Color.YELLOW, count, quant));

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
    public void reloadDataGridViewProcessador(LinkedList<Processador> processadores){

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
