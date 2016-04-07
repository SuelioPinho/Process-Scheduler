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
public class ProcessoIBAdapter extends BaseAdapter{

    @RootContext
    Context context;

    List<ProcessoIB> processos;

    public void setProcessos(List<ProcessoIB> processos){
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

        ProcessoIBItemView itemView = null;

        try{
            if (convertView == null){
                itemView = ProcessoIBItemView_.build(context);
            }else{
                itemView = (ProcessoIBItemView) convertView;
            }

            itemView.bind(processos.get(position));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            itemView.setPosition(position);

            return itemView;
        }


    }
}
