package com.example.sueliopss.escalonador;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import static android.graphics.Color.*;


@EViewGroup(R.layout.processo_item_view)
public class ProcessoItemView extends RelativeLayout{

    @ViewById(R.id.imageProcesso)
    ImageView imageProcesso;

    @ViewById(R.id.nomeProcesso)
    TextView nomeProcesso;

    @ViewById
    TextView tempoProcesso;

    @ViewById
    TextView deadLine;

    @ViewById
    RelativeLayout relativeItemProcesso;

    int position;

    ShapeDrawable shape = new ShapeDrawable(new RectShape());

    public ProcessoItemView (Context context){
        super(context);
    }

    public void bind(Processo processo){

        pintarShape(processo.color);
        relativeItemProcesso.setBackground(shape);

        nomeProcesso.setText(processo.nomeProcesso);
        tempoProcesso.setText("T" + processo.tempoProcesso + "/" + processo.tempoTotal);
        if(processo.deadLine == -256){
            deadLine.setText("");
        }else{
            deadLine.setText("D "+ processo.deadLine);
        }

    }

    public void setPosition(int position){
        this.position = position;
    }

    public void pintarShape(int color){
        shape.getPaint().setColor(color);
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(35);
    }

}
