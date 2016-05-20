package com.example.sueliopss.escalonador;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.media.Image;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

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

    @ViewById
    RelativeLayout relativeItemProcessador;

    int position;
    ShapeDrawable shape = new ShapeDrawable(new RectShape());

    public ProcessadorItemView(Context context) {
        super(context);
    }

    public void bind(Processador processador){

        if(processador.is_processando){

            pintarShape(processador.processo.color);
            relativeItemProcessador.setBackground(shape);

            imageProcesso.setVisibility(VISIBLE);
            imageProcesso.setColorFilter(processador.processo.color);
            nomeProcesso.setText(processador.processo.nomeProcesso);
            tempoProcesso.setText("T" + processador.processo.tempoProcesso + "/" + processador.processo.tempoTotal);

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
