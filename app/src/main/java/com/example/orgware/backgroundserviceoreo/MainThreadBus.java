package com.example.orgware.backgroundserviceoreo;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

public class MainThreadBus extends Bus {
    private final Handler mainThreadHandler;

    public MainThreadBus() {
        mainThreadHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainThreadHandler.post(new Runnable() {
                @Override
                public void run() {
                    MainThreadBus.this.post(event);
                }
            });
        } else {
            super.post(event);
        }
    }
}

