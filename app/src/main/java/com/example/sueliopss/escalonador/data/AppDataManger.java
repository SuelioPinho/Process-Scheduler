package com.example.sueliopss.escalonador.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Suelio Sousa on 04/03/2018.
 */
@Singleton
public class AppDataManger implements DataManager{

    private Context context;

    @Inject
    public AppDataManger(Context context) {
        this.context = context;
    }
}
