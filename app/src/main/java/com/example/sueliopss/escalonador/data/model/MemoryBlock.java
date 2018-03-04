package com.example.sueliopss.escalonador.data.model;

import android.support.annotation.NonNull;

/**
 * Created by sueliopss on 04/05/16.
 */
public class MemoryBlock implements Comparable<MemoryBlock>{

    public int id;
    public int amount;
    public boolean isBusy;
    public Process process;
    public Integer nextBlock;
    public int address;

    public MemoryBlock(int id, int amount, Integer nextBlock) {
        this.id = id;
        this.amount = amount;
        this.isBusy = false;
        this.process = null;
        this.nextBlock = nextBlock;
    }

    public MemoryBlock(int id, int amount, Process process, Integer nextBlock) {
        this.id = id;
        this.amount = amount;
        this.isBusy = true;
        this.process = process;
        this.nextBlock = nextBlock;
    }

    public MemoryBlock(int id, int amount, Integer nextBlock, int address) {
        this.id = id;
        this.amount = amount;
        this.isBusy = false;
        this.process = null;
        this.nextBlock = nextBlock;
        this.address = address;
    }

    @Override
    public int compareTo(@NonNull MemoryBlock another) {

        if(this.id < another.id){
            return -1;
        }

        if (this.id > another.id){
            return 1;
        }

        return 0;
    }
}