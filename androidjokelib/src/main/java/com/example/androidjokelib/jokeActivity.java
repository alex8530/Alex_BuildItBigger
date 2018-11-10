package com.example.androidjokelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class jokeActivity extends AppCompatActivity {
    public static final String JOKE_KEY="JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);


        Intent intent = getIntent();
        if (intent !=null){
            if (intent.getStringExtra(JOKE_KEY)!=null){
                String joke= intent.getStringExtra(JOKE_KEY);
                TextView textView= findViewById(R.id.tvJoke);
                textView.setText(joke);
            }
        }
    }
}
