package com.example.sueliopss.escalonador.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.sueliopss.escalonador.data.model.Process;

import java.util.List;

/**
 * Created by sueliopss on 30/03/16.
 */
public class ProcessoAdapter extends BaseAdapter{
    Context context;

    List<Process> processes;

    public void setProcesses(List<Process> processes){
        this.processes = processes;
    }

    @Override
    public int getCount() {
        return processes.size();
    }

    @Override
    public Object getItem(int position) {
        return processes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProcessoItemView itemView = null;

        try{
            if (convertView == null){
//                itemView = ProcessoItemView_.build(context);
            }else{
                itemView = (ProcessoItemView) convertView;
            }

            itemView.bind(processes.get(position));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            itemView.setPosition(position);

            return itemView;
        }


    }
}
