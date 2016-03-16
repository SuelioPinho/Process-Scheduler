package com.example.sueliopss.escalonador;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
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
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.gridProcessadores)
    GridView gridProcessadores;

    @Bean
    ProcessadorAdapter processadorAdapter;

    @ViewById
    HorizontalScrollView horizontalScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //createDialog(savedInstanceState).show();


    }

    @AfterViews
    public void afterViews(){


        List<Integer> images = new ArrayList<>();



        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);
        images.add(R.mipmap.ic_insert_chart_black_24dp);

        gridProcessadores.setNumColumns(images.size());
        gridViewSetting(gridProcessadores, images.size());


        processadorAdapter.setImageList(images);
        gridProcessadores.setAdapter(processadorAdapter);


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


    public void test(){

    }

    @ItemClick(R.id.gridProcessadores)
    public void alert(int position){
        Toast.makeText(this,(position+1)+"",Toast.LENGTH_SHORT).show();
    }

    public Dialog createDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater layoutInflater = this.getLayoutInflater();

        builder.setView(layoutInflater.inflate(R.layout.dialog_main_escalonador, null));

        //builder.setCancelable(false);

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

}
