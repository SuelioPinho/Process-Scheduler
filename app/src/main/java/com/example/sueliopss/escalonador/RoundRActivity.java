package com.example.sueliopss.escalonador;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
