package com.example.sueliopss.escalonador;

/**
 * Created by sueliopss on 09/03/16.
 */
public class Processo {
    int prioridade;
    int tempoProcesso;
    String nomeProcesso;
    int tempoProcessar;

    public Processo(int prioridade, int tempoProcesso, String nomeProcesso, int tempoProcessar) {
        this.prioridade = prioridade;
        this.tempoProcesso = tempoProcesso;
        this.nomeProcesso = nomeProcesso;
        this.tempoProcessar = tempoProcessar;
    }
}
