package com.boleng.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by boleng on 8/28/17.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 3;

    public DBOpenHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("","create tabel");
        sqLiteDatabase.execSQL("create table personData(_id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20), age integer,introduce varchar(200) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists personData");
        onCreate(sqLiteDatabase);
    }
}
