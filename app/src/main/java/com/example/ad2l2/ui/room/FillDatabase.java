package com.example.ad2l2.ui.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.ad2l2.ui.home.HomeModel;

@Database(entities = {HomeModel.class}, version = 1)
public  abstract  class FillDatabase extends RoomDatabase {
    public abstract FillDao fillDao();
}
