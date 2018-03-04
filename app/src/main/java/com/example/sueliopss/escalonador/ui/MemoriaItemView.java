package com.example.sueliopss.escalonador.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sueliopss.escalonador.R;
import com.example.sueliopss.escalonador.data.model.MemoryBlock;

/**
 * Created by sueliopss on 04/05/16.
 */
public class MemoriaItemView extends RelativeLayout{

    ImageView imageMemoria;

    TextView idMemoria;

    TextView memoriaBloco;

    TextView nomeProcesso;

    TextView memoriaProcesso;

    TextView proximoBloco;

    RelativeLayout relativeItemProcessador;

    int position;
    ShapeDrawable shape = new ShapeDrawable(new RectShape());

    public MemoriaItemView(Context context) {
        super(context);
    }

    public void bind(MemoryBlock bloco){

        idMemoria.setText("ID " + (bloco.id + 1));
        memoriaBloco.setText("MB " + bloco.amount + "B");
        if(bloco.nextBlock == null){
            proximoBloco.setText("PROX-" + null);
        }else{
            proximoBloco.setText("PROX-" + (bloco.nextBlock + 1));
        }

        if (bloco.isBusy){
            pintarShape(Color.RED);
            nomeProcesso.setText(bloco.processo.nomeProcesso);
            memoriaProcesso.setText("MP " + bloco.processo.memoria + "B");
        }else{
            pintarShape(getResources().getColor(R.color.verdeProcesso));
            nomeProcesso.setText("");
            memoriaProcesso.setText("");
        }

        relativeItemProcessador.setBackground(shape);
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
