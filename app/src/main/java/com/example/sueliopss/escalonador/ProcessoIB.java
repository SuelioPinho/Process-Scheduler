package com.example.sueliopss.escalonador;

/**
 * Created by sueliopss on 07/04/16.
 */
public class ProcessoIB implements Comparable<ProcessoIB> {

    String nomeProcesso;
    int tempoProcesso;
    int deadLine;
    int color;
    int tempoTotal;
    int processador_id;

    public ProcessoIB(String nomeProcesso, int tempoProcesso, int deadLine, int color, int tempoTotal, int processador_id) {
        this.nomeProcesso = nomeProcesso;
        this.tempoProcesso = tempoProcesso;
        this.deadLine = deadLine;
        this.color = color;
        this.tempoTotal = tempoTotal;
        this.processador_id = processador_id;
    }

    @Override
    public int compareTo(ProcessoIB processoIB) {

        if((this.deadLine) < (processoIB.deadLine)){
            return -1;
        }

        if ((this.deadLine) > (processoIB.deadLine)){
            return 1;
        }

        return 0;

    }
}
