package com.example.orgware.backgroundserviceoreo;

import android.app.Application;

public class AppController extends Application {

    private MainThreadBus bus;
    private static AppController appController;

    public static AppController getInstance() {
        return appController;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appController = this;
        bus = new MainThreadBus();
    }

    public MainThreadBus getBus() {
        return bus;

    }

}