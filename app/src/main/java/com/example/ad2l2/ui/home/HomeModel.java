package com.example.ad2l2.ui.home;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class HomeModel  implements Serializable {
    private String title;
      private DateFormat dateFormat = new SimpleDateFormat("dd MMM HH : mm");
      private String date =dateFormat.format(new Date());

    public String getDate() {

        return date;
    }
       private int id = new Random().nextInt();
    public void setDate(String date) {
        this.date = date;
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

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public int getId() {
        return id;
    }
}




