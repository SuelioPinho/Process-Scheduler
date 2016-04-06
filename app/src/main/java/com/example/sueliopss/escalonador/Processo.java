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
    int quantum;
    int tempoTotal;

    public Processo(String nomeProcesso, int tempoProcesso, int tempoTotal, int color, int prioridade, int quantum) {
        this.tempoProcesso = tempoProcesso;
        this.nomeProcesso = nomeProcesso;
        this.tempoTotal = tempoTotal;
        this.color = color;
        this.prioridade = prioridade;
        this.quantum = quantum;
    }

    public Processo(String nomeProcesso, int tempoProcesso, int deadLine, int tempoTotal, int color) {
        this.tempoProcesso = tempoProcesso;
        this.nomeProcesso = nomeProcesso;
        this.deadLine = deadLine;
        this.tempoTotal = tempoTotal;
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
