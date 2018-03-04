package com.example.sueliopss.escalonador.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.sueliopss.escalonador.data.model.Processor;

import java.util.List;

public class ProcessadorAdapter extends BaseAdapter {
    Context context;
    private List<Processor> processadores;
    public ProcessadorAdapter(Context context){
        this.context = context;
    }

    public void setProcessadores(List<Processor> processadores) {
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
//            itemView = ProcessadorItemView_.build(context);
        }else{
            itemView = (ProcessadorItemView) convertView;
        }

        itemView.bind(processadores.get(position));
        itemView.setPosition(position);
        return itemView;
    }
}
