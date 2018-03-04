package com.example.sueliopss.escalonador.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sueliopss.escalonador.data.model.Processor;

public class ProcessadorItemView extends RelativeLayout{

    ImageView imageProcessador;

    ImageView imageProcesso;

    TextView nomeProcesso;

    TextView tempoProcesso;

    RelativeLayout relativeItemProcessador;

    int position;
    ShapeDrawable shape = new ShapeDrawable(new RectShape());

    public ProcessadorItemView(Context context) {
        super(context);
    }

    public void bind(Processor processor){

        if(processor.is_processando){

            pintarShape(processor.processo.color);
            relativeItemProcessador.setBackground(shape);

            imageProcesso.setVisibility(VISIBLE);
            imageProcesso.setColorFilter(processor.processo.color);
            nomeProcesso.setText(processor.processo.nomeProcesso);
            tempoProcesso.setText("T" + processor.processo.tempoProcesso + "/" + processor.processo.tempoTotal);

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
