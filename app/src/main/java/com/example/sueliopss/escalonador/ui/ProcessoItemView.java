package com.example.sueliopss.escalonador.ui;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sueliopss.escalonador.data.model.Process;

public class ProcessoItemView extends RelativeLayout{

    ImageView imageProcesso;

    TextView nomeProcesso;

    TextView tempoProcesso;

    TextView deadLine;

    TextView memoria;

    RelativeLayout relativeItemProcesso;

    int position;

    ShapeDrawable shape = new ShapeDrawable(new RectShape());

    public ProcessoItemView (Context context){
        super(context);
    }

    public void bind(Process process){

        pintarShape(process.color);
        relativeItemProcesso.setBackground(shape);

        nomeProcesso.setText(process.processName);
        tempoProcesso.setText("T" + process.processTime + "/" + process.tempoTotal);
        memoria.setText("M" + process.memory + "B");
        if(process.deadLine == -256){
            deadLine.setText("");
        }else{
            deadLine.setText("D "+ process.deadLine);
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
