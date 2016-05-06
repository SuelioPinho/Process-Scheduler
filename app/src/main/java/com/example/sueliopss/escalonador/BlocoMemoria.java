package com.example.sueliopss.escalonador;

/**
 * Created by sueliopss on 04/05/16.
 */
public class BlocoMemoria {

    int id;
    int tamanho;
    boolean is_ocupado;
    Processo processo;
    String proximoBloco;
    int endereco;

    public BlocoMemoria(int id, int tamanho, String proximoBloco) {
        this.id = id;
        this.tamanho = tamanho;
        this.is_ocupado = false;
        this.processo = null;
        this.proximoBloco = proximoBloco;
    }

    public BlocoMemoria(int id, int tamanho, Processo processo, String proximoBloco) {
        this.id = id;
        this.tamanho = tamanho;
        this.is_ocupado = true;
        this.processo = processo;
        this.proximoBloco = proximoBloco;
    }

    public BlocoMemoria(int id, int tamanho, String proximoBloco, int endereco) {
        this.id = id;
        this.tamanho = tamanho;
        this.is_ocupado = false;
        this.processo = null;
        this.proximoBloco = proximoBloco;
        this.endereco = endereco;
    }


}
