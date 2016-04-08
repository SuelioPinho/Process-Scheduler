package com.example.sueliopss.escalonador;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by sueliopss on 14/03/16.
 */
@EViewGroup(R.layout.processador_item_view)
public class ProcessadorItemView extends RelativeLayout{

    @ViewById
    ImageView imageProcessador;

    @ViewById(R.id.imagePcso)
    ImageView imageProcesso;

    @ViewById(R.id.nomeProcesso)
    TextView nomeProcesso;

    @ViewById(R.id.tempoProcesso)
    TextView tempoProcesso;

    int position;

    public ProcessadorItemView(Context context) {
        super(context);
    }


    public void bind(Processador processador){

        if(processador.is_processando){

            imageProcesso.setVisibility(VISIBLE);
            imageProcesso.setColorFilter(processador.processo.color);
            nomeProcesso.setText(processador.processo.nomeProcesso);
            tempoProcesso.setText("T" + processador.processo.tempoProcesso + "/" + processador.processo.tempoTotal);

        } else {


            imageProcesso.setVisibility(GONE);
            nomeProcesso.setText("");
            tempoProcesso.setText("");


        }

    }

    public void setPosition(int position) {
        this.position = position;
    }
}
