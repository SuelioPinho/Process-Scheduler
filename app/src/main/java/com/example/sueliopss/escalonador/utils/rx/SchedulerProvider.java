package com.example.sueliopss.escalonador.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Larissa Rebouças on 04/03/2018.
 */

public interface SchedulerProvider {

    public Scheduler computation();

    public Scheduler io();

    public Scheduler ui();
}
