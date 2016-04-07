package com.example.sueliopss.escalonador;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by sueliopss on 07/04/16.
 */
@EViewGroup(R.layout.processador_item_view)
public class ProcessadorIBItemView extends RelativeLayout{
    @ViewById
    ImageView imageProcessador;

    @ViewById(R.id.imagePcso)
    ImageView imageProcesso;

    @ViewById(R.id.nomeProcesso)
    TextView nomeProcesso;

    @ViewById(R.id.tempoProcesso)
    TextView tempoProcesso;

    int position;

    public ProcessadorIBItemView(Context context) {
        super(context);
    }


    public void bind(ProcessadorIB processador){

        if(processador.is_processando){

            imageProcesso.setVisibility(VISIBLE);
            imageProcesso.setColorFilter(processador.processoIB.color);
            nomeProcesso.setText(processador.processoIB.nomeProcesso);
            tempoProcesso.setText("T" + processador.processoIB.tempoProcesso + "/" + processador.processoIB.tempoTotal);

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
