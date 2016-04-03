package com.example.sueliopss.escalonador;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by sueliopss on 14/03/16.
 */
@EBean
public class ProcessadorAdapter extends BaseAdapter {
    @RootContext
    Context context;
    private List<Processador> processadores;

    public ProcessadorAdapter(Context context){
        this.context = context;
    }

    public void setProcessadores(List<Processador> processadores) {
        this.processadores = processadores;
    }

    @Override
    public int getCount() {
        return processadores.size();
    }

    @Override
    public Object getItem(int position) {
        return processadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProcessadorItemView itemView = null;

        if(convertView == null){
            itemView = ProcessadorItemView_.build(context);
        }else{
            itemView = (ProcessadorItemView) convertView;
        }

        itemView.bind(processadores.get(position));

        itemView.setPosition(position);

        return itemView;
    }
}
