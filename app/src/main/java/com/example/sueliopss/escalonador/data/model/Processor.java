package com.example.sueliopss.escalonador.data.model;

import java.util.LinkedList;

public class Processor {

    public boolean is_processando;
    public Process process;

    public LinkedList<Integer> blocksAddress;

    public Processor() {
        is_processando = false;
        blocksAddress = new LinkedList<>();
    }
}
