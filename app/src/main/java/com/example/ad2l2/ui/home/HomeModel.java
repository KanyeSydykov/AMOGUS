package com.example.ad2l2.ui.home;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Entity
public class HomeModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;

    public void setId(int id) {
        this.id = id;
    }
//      private DateFormat dateFormat = new SimpleDateFormat("dd MMM HH : mm");
    ///    private String date =dateFormat.format(new Date());

    //public String getDate() {

    ///  return date;
    //}
    public void setDate(String date) {
        //  this.date = date;
    }

    public HomeModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    //public DateFormat getDateFormat() {
    ///     return dateFormat;
    ///   }

    public int getId() {
        return id;
    }
}




