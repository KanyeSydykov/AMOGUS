package com.example.ad2l2.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsHelper {
    private final String BOARD_KEY = "board key ";
     Context context;
     SharedPreferences.Editor editor;
     int PRIVATE_MODE = 0;
     private static  final String FOR_NAME = "name";
     private static final String IS_FIRST_TIME_LAUNCH = "firstTime";
    private SharedPreferences sharedPreferences = null;

          public PrefsHelper(Context context){
              this.context = context;
               sharedPreferences = context.getSharedPreferences("pref",Context.MODE_PRIVATE);
              editor = sharedPreferences.edit();
              }

            public void setIsFirstTimeLaunch (boolean firstTimeLaunch){
              editor.putBoolean(IS_FIRST_TIME_LAUNCH,firstTimeLaunch);
              editor.commit();
            }
         public  boolean isFirstTimeLaunch (){
              return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH,true);
         }
         public void setForName(String name){
              sharedPreferences.edit().putString(FOR_NAME,name).apply();
         }
       public String getForName(){return sharedPreferences.getString(FOR_NAME,"");}

        }

