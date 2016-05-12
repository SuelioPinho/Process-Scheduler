package com.example.sueliopss.escalonador;

import android.graphics.Color;


public class Processo implements Comparable<Processo> {
    int prioridade;
    int tempoProcesso;
    String nomeProcesso;
    int deadLine;
    int color;
    int quantum;
    int tempoTotal;
    int memoria;
    int instanteMemoria;
    int memoriaAdicional;

    public Processo(){

    }

    public Processo(String nomeProcesso, int tempoProcesso, int tempoTotal, int color, int prioridade, int quantum, int memoria) {
        this.tempoProcesso = tempoProcesso;
        this.nomeProcesso = nomeProcesso;
        this.tempoTotal = tempoTotal;
        this.color = color;
        this.prioridade = prioridade;
        this.quantum = quantum;
        this.memoria = memoria;
    }

    public Processo(String nomeProcesso, int tempoProcesso, int deadLine, int tempoTotal, int color, int memoria) {
        this.tempoProcesso = tempoProcesso;
        this.nomeProcesso = nomeProcesso;
        this.deadLine = deadLine;
        this.tempoTotal = tempoTotal;
        this.color = color;
        this.memoria = memoria;
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
