package com.example.sueliopss.escalonador;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedList;

/**
 * Created by sueliopss on 04/05/16.
 */
public class MemoriaAdapter extends BaseAdapter{

    LinkedList<BlocoMemoria> memoria = new LinkedList<>();
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
        return null;
    }
}
