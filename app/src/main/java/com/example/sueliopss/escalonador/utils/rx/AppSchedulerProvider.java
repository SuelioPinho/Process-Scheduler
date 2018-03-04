package com.example.sueliopss.escalonador.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Larissa Rebouças on 04/03/2018.
 */

public class AppSchedulerProvider implements SchedulerProvider {
    @Override
    public Scheduler computation() {
        return null;
    }

    @Override
    public Scheduler io() {
        return null;
    }

    @Override
    public Scheduler ui() {
        return null;
    }
}
