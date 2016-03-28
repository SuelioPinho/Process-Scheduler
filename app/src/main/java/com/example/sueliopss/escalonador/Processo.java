package com.example.sueliopss.escalonador;

/**
 * Created by sueliopss on 09/03/16.
 */
public class Processo {
    int prioridade;
    int tempoProcesso;
    String nomeProcesso;
    int deadLine;

    public Processo(int tempoProcesso, String nomeProcesso) {
        this.tempoProcesso = tempoProcesso;
        this.nomeProcesso = nomeProcesso;
    }
}
