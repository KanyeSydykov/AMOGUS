package com.example.ad2l2.ui.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ad2l2.ui.home.HomeModel;
import com.example.ad2l2.ui.home.HomeModel;

import java.util.List;
@Dao
public interface FillDao {
    @Insert
    void insert (HomeModel homeModel);
    @Update
    void update(HomeModel homeModel);
    @Delete
    void delete (HomeModel homeModel);

    @Query("SELECT * FROM homemodel")
    LiveData <List <HomeModel>> getAll();
}
