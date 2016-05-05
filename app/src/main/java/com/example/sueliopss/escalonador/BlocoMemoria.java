package com.example.sueliopss.escalonador;

/**
 * Created by sueliopss on 04/05/16.
 */
public class BlocoMemoria {

    int tamanho;
    boolean is_ocupado;
    Processo processo;

    public BlocoMemoria(int tamanho) {
        this.tamanho = tamanho;
        this.is_ocupado = false;
        this.processo = null;
    }
}
