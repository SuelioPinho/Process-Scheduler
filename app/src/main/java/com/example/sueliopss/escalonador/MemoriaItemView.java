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
 * Created by sueliopss on 04/05/16.
 */
@EViewGroup(R.layout.memoria_item_view)
public class MemoriaItemView extends RelativeLayout{

    @ViewById(R.id.imageProcessador)
    ImageView imageMemoria;

    @ViewById(R.id.tamanhoMemoria)
    TextView tamanhoMemoria;

    @ViewById(R.id.nomeProcesso)
    TextView nomeProcesso;

    @ViewById(R.id.tamanhoProcesso)
    TextView tamanhoProcesso;

    @ViewById
    RelativeLayout relativeItemProcessador;

    int position;
    ShapeDrawable shape = new ShapeDrawable(new RectShape());

    public MemoriaItemView(Context context) {
        super(context);
    }

    public void bind(BlocoMemoria bloco){

        if(bloco.is_ocupado){
            pintarShape(bloco.processo.color);
            relativeItemProcessador.setBackground(shape);
            nomeProcesso.setText(bloco.processo.nomeProcesso);
            tamanhoProcesso.setText("Mp" + bloco.processo.tempoProcesso + "/" + bloco.processo.tempoTotal);
        }else{
            pintarShape(Color.TRANSPARENT);
            relativeItemProcessador.setBackground(shape);
            tamanhoMemoria.setText("Mm"+bloco.tamanho);
            nomeProcesso.setText("");
            tamanhoProcesso.setText("");

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
