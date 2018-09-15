package com.example.a2015csb1031.todo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
/**
 * Created by 2015csb1031 on 14-09-2018.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="todos.db";
    public static final int DATEBASE_VERSION=1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATEBASE_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + Contract.Entry.TABLE_NAME + " ( " +
                Contract.Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Contract.Entry.COLUMN_NAME + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }
}
