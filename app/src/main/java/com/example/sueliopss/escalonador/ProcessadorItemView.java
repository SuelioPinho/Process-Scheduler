package com.example.sueliopss.escalonador;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by sueliopss on 14/03/16.
 */
@EViewGroup(R.layout.processador_item_view)
public class ProcessadorItemView extends LinearLayout{

    @ViewById
    ImageView imageProcessador;

    @ViewById(R.id.position)
    TextView textView;

    int position;

    public ProcessadorItemView(Context context) {
        super(context);
    }


    public void bind(int image,int position){
        imageProcessador.setImageResource(image);
        textView.setText(position+"");
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
