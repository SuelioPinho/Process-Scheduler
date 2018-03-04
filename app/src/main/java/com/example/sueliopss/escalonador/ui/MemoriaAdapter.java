package com.example.sueliopss.escalonador.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.sueliopss.escalonador.data.model.MemoryBlock;

import java.util.LinkedList;

/**
 * Created by sueliopss on 04/05/16.
 */
public class MemoriaAdapter extends BaseAdapter{

    Context context;

    LinkedList<MemoryBlock> memoria = new LinkedList<>();

    public void setBlocos( LinkedList<MemoryBlock> memoria){
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
//            itemView = MemoriaItemView_.build(context);
        }else{
            itemView = (MemoriaItemView) convertView;
        }

        itemView.bind(memoria.get(position));
        itemView.setPosition(position);
        return itemView;
    }
}
