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

    @ViewById(R.id.idMemoria)
    TextView idMemoria;

    @ViewById(R.id.memoriaBloco)
    TextView memoriaBloco;

    @ViewById(R.id.nomeProcesso)
    TextView nomeProcesso;

    @ViewById(R.id.memoriaProcesso)
    TextView memoriaProcesso;

    @ViewById(R.id.proximoBloco)
    TextView proximoBloco;

    @ViewById
    RelativeLayout relativeItemProcessador;

    int position;
    ShapeDrawable shape = new ShapeDrawable(new RectShape());

    public MemoriaItemView(Context context) {
        super(context);
    }

    public void bind(BlocoMemoria bloco){

        idMemoria.setText("ID " + (bloco.id + 1));
        memoriaBloco.setText("MB " + bloco.tamanho + "B");
        if(bloco.proximoBloco == null){
            proximoBloco.setText("PROX-" + null);
        }else{
            proximoBloco.setText("PROX-" + (bloco.proximoBloco + 1));
        }

        if (bloco.is_ocupado){
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
