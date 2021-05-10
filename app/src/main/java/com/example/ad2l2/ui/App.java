package com.example.ad2l2.ui;
import android.app.Application;

import androidx.room.Room;

import com.example.ad2l2.ui.room.FillDatabase;
import com.example.ad2l2.utils.PrefsHelper;

public class App extends Application {
    public static FillDatabase fillDatabase;
    private static App instance;
    public static PrefsHelper prefsHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        prefsHelper = new PrefsHelper(this);


        fillDatabase = Room.databaseBuilder(
                this, FillDatabase.class,"database"
        ).allowMainThreadQueries()
                .build();
    }
}