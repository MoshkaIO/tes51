package com.example.lab6;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MapKitFactory.setApiKey("a1e041910-975e-45b7-8451-09555ef3a8b7");
    }
}
