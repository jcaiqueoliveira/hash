package kanda.hashretry.presentation;

import android.app.Application;

import kanda.hashretry.presentation.dependencies.ApplicationDependencies;

/**
 * Created by jcosilva on 11/25/2016.
 */

public class MainApplication extends Application {

    public HashComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        mainComponent = DaggerHashComponent.builder()
                .applicationDependencies(new ApplicationDependencies(this))
                .build();
    }

    public HashComponent getComponent() {
        return mainComponent;
    }

}