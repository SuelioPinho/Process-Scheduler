package com.example.sueliopss.escalonador;

import android.content.Context;
import android.media.Image;
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
    private List<Integer> images;

    public ProcessadorAdapter(Context context){
        this.context = context;
    }

    public void setImageList(List<Integer> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
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

        itemView.bind(images.get(position),position+1);
        itemView.setPosition(position);
        return itemView;
    }
}
