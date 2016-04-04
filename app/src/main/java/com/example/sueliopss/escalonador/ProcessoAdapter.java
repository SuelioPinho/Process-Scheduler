package com.example.sueliopss.escalonador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by sueliopss on 30/03/16.
 */
@EBean
public class ProcessoAdapter extends BaseAdapter{
    @RootContext
    Context context;

    List<Processo> processos;

    public void setProcessos(List<Processo> processos){
        this.processos = processos;
    }

    @Override
    public int getCount() {
        return processos.size();
    }

    @Override
    public Object getItem(int position) {
        return processos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProcessoItemView itemView = null;

        if (convertView == null){
            itemView = ProcessoItemView_.build(context);
        }else{
            itemView = (ProcessoItemView) convertView;
        }

        itemView.bind(processos.get(position));
        itemView.setPosition(position);

        return itemView;
    }
}
