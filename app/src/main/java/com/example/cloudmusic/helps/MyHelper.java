package com.example.cloudmusic.helps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context){
        super(context,"music.db",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE t_song(song_id INTEGER PRIMARY KEY AUTOINCREMENT,song_name VARCHAR(20)," +
                "author VARCHAR(20),song_url VARCHAR(255),song_cover VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
