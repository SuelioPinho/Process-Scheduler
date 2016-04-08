package com.example.sueliopss.escalonador;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
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

    @ViewById
    RelativeLayout relativeItemProcessador;

    int position;
    ShapeDrawable shape = new ShapeDrawable(new RectShape());

    public ProcessadorIBItemView(Context context) {
        super(context);
    }


    public void bind(ProcessadorIB processador){
        


        if(processador.is_processando){

            pintarShape(processador.processoIB.color);
            relativeItemProcessador.setBackground(shape);

            imageProcesso.setVisibility(VISIBLE);
            imageProcesso.setColorFilter(processador.processoIB.color);
            nomeProcesso.setText(processador.processoIB.nomeProcesso);
            tempoProcesso.setText("T" + processador.processoIB.tempoProcesso + "/" + processador.processoIB.tempoTotal);

        } else {
            pintarShape(Color.TRANSPARENT);
            relativeItemProcessador.setBackground(shape);
           imageProcesso.setVisibility(GONE);
            nomeProcesso.setText("");
            tempoProcesso.setText("");
        }

    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void pintarShape(int color){
        shape.getPaint().setColor(color);
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(35);
    }
}
