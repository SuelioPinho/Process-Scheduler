package com.example.sueliopss.escalonador;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListView;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




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

}
