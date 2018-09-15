package com.example.a2015csb1031.todo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void buttonclick(View view){

        EditText edittext= (EditText) findViewById(R.id.edittext);
        String s=edittext.getText().toString();
        Context context=Add.this;
        Class destination=MainActivity.class;
        Intent intent=new Intent(context,destination);
        intent.putExtra(Intent.EXTRA_TEXT,s);
        startActivity(intent);


    }

}
