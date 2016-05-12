package com.example.sueliopss.escalonador;

import java.util.LinkedList;

public class Processador {

    boolean is_processando;
    Processo processo;

    LinkedList<Integer> enderecoBlocos;

    public Processador() {
        is_processando = false;
        enderecoBlocos = new LinkedList<>();
    }
}
