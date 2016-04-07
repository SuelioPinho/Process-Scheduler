package com.example.sueliopss.escalonador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by sueliopss on 07/04/16.
 */
@EBean
public class ProcessadorIBAdapter extends BaseAdapter {

    @RootContext
    Context context;
    private List<ProcessadorIB> processadores;

    public ProcessadorIBAdapter(Context context){
        this.context = context;
    }

    public void setProcessadores(List<ProcessadorIB> processadores) {
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

        ProcessadorIBItemView itemView = null;

        if(convertView == null){
            itemView = ProcessadorIBItemView_.build(context);
        }else{
            itemView = (ProcessadorIBItemView) convertView;
        }

        itemView.bind(processadores.get(position));

        itemView.setPosition(position);

        return itemView;
    }
}
