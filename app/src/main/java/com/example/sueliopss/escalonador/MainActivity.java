package com.example.sueliopss.escalonador;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Semaphore;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.gridProcessadores)
    GridView gridProcessadores;

    @ViewById(R.id.gridAptos)
    GridView gridAptos;

    @Bean
    ProcessadorAdapter processadorAdapter;

    @ViewById
    HorizontalScrollView horizontalScrollView;

    EditText numProcessadores;

    EditText numProcesso;

    AlertDialog.Builder builder;

    LinkedList<Integer> imagesProcessos;

    LinkedList<Integer> imagesProcessadores;

    LinkedList<Integer> processadoresLivres;

    Button escalonar;

    Semaphore semaphore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AlertDialog dialog = createDialog(savedInstanceState);
        dialog.show();

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

    }

    @Background
    public void iniciarEscalonamento(){

        while(true){

            if (imagesProcessos.isEmpty()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                semaphore.acquire();
                processar(imagesProcessos.pop());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }


        }
    }

    @UiThread
    public void processar(Integer integer){

        View view = gridProcessadores.getAdapter().getView(integer, null, null);
        view.setBackgroundColor(Color.GREEN);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    @ItemClick(R.id.gridProcessadores)
    public void alert(int position){
        Toast.makeText(this,(position+1)+"",Toast.LENGTH_SHORT).show();
    }

    public AlertDialog createDialog(Bundle savedInstanceState){
        builder = new AlertDialog.Builder(this);

        LayoutInflater layoutInflater = this.getLayoutInflater();

        View dialog = layoutInflater.inflate(R.layout.dialog_main_escalonador, null);

        builder.setView(dialog);

        //builder.setCancelable(false);

        escalonar = (Button) dialog.findViewById(R.id.buttonEscalonar);

        numProcessadores = (EditText) dialog.findViewById(R.id.editTextNumProcessador);

        numProcesso = (EditText) dialog.findViewById(R.id.editTextNumProcesso);

        return builder.create();
    }

    private void gridViewSetting(GridView gridview, int size) {

        // Calculated single Item Layout Width for each grid element ....
        int width = 50 ;

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
        imagesProcessadores = new LinkedList<>();
        imagesProcessos = new LinkedList<>();
        processadoresLivres = new LinkedList<>();
        int processadores = Integer.parseInt(numProcessadores.getText().toString());
        int processos = Integer.parseInt(numProcesso.getText().toString());

        semaphore = new Semaphore(processadores);

        for (int i = 0; i < processadores; i++){
            imagesProcessadores.add(R.mipmap.ic_insert_chart_black_24dp);
            processadoresLivres.add(i);
        }

        contruirGridView(imagesProcessadores, gridProcessadores);

        processadorAdapter = new ProcessadorAdapter(this);

        for (int i = 0; i < processos; i++){
            imagesProcessos.add(R.mipmap.ic_insert_chart_black_24dp);
        }

        gridAptos.setNumColumns(imagesProcessos.size());
        gridViewSetting(gridAptos, imagesProcessos.size());
        contruirGridView(imagesProcessos, gridAptos);


    }

    public void contruirGridView(List<Integer> images, GridView grid){

        processadorAdapter.setImageList(images);
        grid.setAdapter(processadorAdapter);

    }

}
