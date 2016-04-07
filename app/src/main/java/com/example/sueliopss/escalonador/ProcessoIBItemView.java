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
@EViewGroup(R.layout.processo_item_view)
public class ProcessoIBItemView extends RelativeLayout {

    @ViewById(R.id.imageProcesso)
    ImageView imageProcesso;

    @ViewById(R.id.nomeProcesso)
    TextView nomeProcesso;

    @ViewById
    TextView tempoProcesso;

    @ViewById
    TextView deadLine;

    int position;

    public ProcessoIBItemView (Context context){
        super(context);
    }

    public void bind(ProcessoIB processo){

        imageProcesso.setColorFilter(processo.color);
        nomeProcesso.setText(processo.nomeProcesso);
        tempoProcesso.setText("T" + processo.tempoProcesso + "/" + processo.tempoTotal);

        deadLine.setText("D "+ processo.deadLine);

    }

    public void setPosition(int position){
        this.position = position;
    }

}
