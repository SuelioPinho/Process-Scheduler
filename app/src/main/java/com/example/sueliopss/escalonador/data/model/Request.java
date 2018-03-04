package com.example.sueliopss.escalonador.data.model;

import android.support.annotation.NonNull;

/**
 * Created by sueliopss on 19/05/16.
 */
public class Request implements Comparable<Request> {
    int amount;
    int timesRequired;

    public Request(int amount){
        this.amount = amount;
        this.timesRequired = 1;
    }

    @Override
    public int compareTo(@NonNull Request another) {
        if(this.timesRequired < another.timesRequired){
            return 1;
        }

        if (this.timesRequired > another.timesRequired){
            return -1;
        }

        return 0;
    }
}
