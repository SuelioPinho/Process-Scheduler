package com.example.sueliopss.escalonador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.LinkedList;

/**
 * Created by sueliopss on 04/05/16.
 */
@EBean
public class MemoriaAdapter extends BaseAdapter{

    @RootContext
    Context context;

    LinkedList<BlocoMemoria> memoria = new LinkedList<>();

    public void setBlocos( LinkedList<BlocoMemoria> memoria){
        this.memoria = memoria;
    }

    @Override
    public int getCount() {
        return memoria.size();
    }

    @Override
    public Object getItem(int position) {
        return memoria.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MemoriaItemView itemView = null;

        if(convertView == null){
            itemView = MemoriaItemView_.build(context);
        }else{
            itemView = (MemoriaItemView) convertView;
        }

        itemView.bind(memoria.get(position));
        itemView.setPosition(position);
        return itemView;
    }
}
