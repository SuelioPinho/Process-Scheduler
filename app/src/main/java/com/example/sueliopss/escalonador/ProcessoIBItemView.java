package com.example.sueliopss.escalonador;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

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

    @ViewById
    RelativeLayout relativeItemProcesso;

    int position;

    ShapeDrawable shape = new ShapeDrawable(new RectShape());

    public ProcessoIBItemView (Context context){
        super(context);
    }

    public void bind(ProcessoIB processo){

        pintarShape(processo.color);
        relativeItemProcesso.setBackground(shape);

        //imageProcesso.setColorFilter(processo.color);
        nomeProcesso.setText(processo.nomeProcesso);
        tempoProcesso.setText("T" + processo.tempoProcesso + "/" + processo.tempoTotal);

        deadLine.setText("D " + processo.deadLine);

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
