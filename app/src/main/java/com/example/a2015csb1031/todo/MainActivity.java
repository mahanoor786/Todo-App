package com.example.a2015csb1031.todo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import android.view.View;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase sqldb;
    public static ArrayList<String> todo = new ArrayList<String>();

    public static int count=0;
    DBHelper newdb=new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sqldb=newdb.getWritableDatabase();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent=getIntent();
        if(intent.hasExtra(Intent.EXTRA_TEXT)) {
            String s = intent.getStringExtra(Intent.EXTRA_TEXT);
            this.onadd(s);
        }
        else{
            String selectQuery = "SELECT * FROM " + Contract.Entry.TABLE_NAME;
            Cursor cursor = sqldb.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {

                    String ss=cursor.getString(cursor.getColumnIndex(Contract.Entry.COLUMN_NAME));
                    TextView new_todo = new TextView(this);
                    Log.i("count", String.valueOf(count));
                    new_todo.setText( "..... " + ss);
                    LinearLayout scroll = (LinearLayout) this.findViewById(R.id.scroll);
                    scroll.addView(new_todo);

                } while (cursor.moveToNext());
            }



        }






    }
    public void deleteclick(View view){
        sqldb.delete(Contract.Entry.TABLE_NAME,null,null);
        setContentView(R.layout.activity_main);

    }

    public void addclick(View view){
        Context context=MainActivity.this;
        Class destination=Add.class;
        Intent intent=new Intent(context,destination);
        startActivity(intent);
    }



    public void onadd(String s){


        ContentValues value=new ContentValues();
        value.put(Contract.Entry.COLUMN_NAME,s);
        sqldb.insert(Contract.Entry.TABLE_NAME,null,value);
        todo.add(s);
        String selectQuery = "SELECT * FROM " + Contract.Entry.TABLE_NAME;
        Cursor cursor = sqldb.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                String ss=cursor.getString(cursor.getColumnIndex(Contract.Entry.COLUMN_NAME));
                TextView new_todo = new TextView(this);
                Log.i("count", String.valueOf(count));
                new_todo.setText( "..... " + ss);
                LinearLayout scroll = (LinearLayout) this.findViewById(R.id.scroll);
                scroll.addView(new_todo);

            } while (cursor.moveToNext());
        }


    }



}
