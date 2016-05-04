package com.example.sueliopss.escalonador;

/**
 * Created by sueliopss on 04/05/16.
 */
public class BlocoMemoria {

    int tamanho;
    boolean ocupado;
    Processo processo;

    public BlocoMemoria(int tamanho) {
        this.tamanho = tamanho;
        this.ocupado = false;
        this.processo = null;
    }
}
