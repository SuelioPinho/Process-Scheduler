package com.example.sueliopss.escalonador.data.model;

public class Process implements Comparable<Process> {
    public int priority;
    public int processTime;
    public String processName;
    public int deadLine;
    public int color;
    public int quantum;
    public int tempoTotal;
    public int memory;
    public int instanteMemoria;
    public int additionalMemory;

    public Process(){}

    public Process(String processName, int processTime, int tempoTotal, int color, int priority, int quantum, int memory) {
        this.processTime = processTime;
        this.processName = processName;
        this.tempoTotal = tempoTotal;
        this.color = color;
        this.priority = priority;
        this.quantum = quantum;
        this.memory = memory;
    }

    public Process(String processName, int processTime, int deadLine, int tempoTotal, int color, int memory) {
        this.processTime = processTime;
        this.processName = processName;
        this.deadLine = deadLine;
        this.tempoTotal = tempoTotal;
        this.color = color;
        this.memory = memory;
    }

    public int compareTo(Process process) {

        if(this.deadLine < process.deadLine){
            return -1;
        }

        if (this.deadLine > process.deadLine){
            return 1;
        }

        return 0;
    }
}
