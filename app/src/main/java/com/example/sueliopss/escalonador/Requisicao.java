package com.example.sueliopss.escalonador;

/**
 * Created by sueliopss on 19/05/16.
 */
public class Requisicao implements Comparable<Requisicao> {
    int tamanho;
    int vezesRequisitadas;

    public Requisicao(int tamanho){
        this.tamanho = tamanho;
        this.vezesRequisitadas = 1;
    }

    @Override
    public int compareTo(Requisicao another) {
        if(this.vezesRequisitadas < another.vezesRequisitadas){
            return 1;
        }

        if (this.vezesRequisitadas > another.vezesRequisitadas){
            return -1;
        }

        return 0;
    }
}
