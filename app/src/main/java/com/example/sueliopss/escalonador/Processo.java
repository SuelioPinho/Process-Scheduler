package com.example.sueliopss.escalonador;

import android.graphics.Color;

/**
 * Created by sueliopss on 09/03/16.
 */
public class Processo implements Comparable<Processo> {
    int prioridade;
    int tempoProcesso;
    String nomeProcesso;
    int deadLine;
    int color;

    public Processo(String nomeProcesso, int tempoProcesso, int color) {
        this.tempoProcesso = tempoProcesso;
        this.nomeProcesso = nomeProcesso;
        this.color = color;
    }

    public Processo(String nomeProcesso, int tempoProcesso, int deadLine, int color) {
        this.tempoProcesso = tempoProcesso;
        this.nomeProcesso = nomeProcesso;
        this.deadLine = deadLine;
        this.color = color;
    }

    public int compareTo(Processo processo) {

        if(this.deadLine < processo.deadLine){
            return -1;
        }

        if (this.deadLine > processo.deadLine){
            return 1;
        }

        return 0;
    }
}
