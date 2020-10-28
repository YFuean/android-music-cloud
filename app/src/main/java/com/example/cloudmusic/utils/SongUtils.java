package com.example.cloudmusic.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cloudmusic.activitys.MainActivity;
import com.example.cloudmusic.adapters.MusicListAdapter;
import com.example.cloudmusic.helps.MyHelper;

public class SongUtils {
    public long insert(Context context ,String songName, String author, String songUrl, String songCover){
        MyHelper helper = new MyHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("song_name",songName);
        values.put("author",author);
        values.put("song_url",songUrl);
        values.put("song_cover",songCover);
        long id = db.insert("t_song",null,values);
        db.close();
        return id;
    }

    public Cursor findAll(Context context){
        MyHelper helper = new MyHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("t_song" ,null,null,new String[]{},null,null,null);
        if (cursor.getCount() != 0){
            return cursor;
        }
        return null;
    }
}
