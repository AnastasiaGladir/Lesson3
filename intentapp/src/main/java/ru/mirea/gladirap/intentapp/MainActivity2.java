package ru.mirea.gladirap.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String value = (String) getIntent().getSerializableExtra("mirea");

        textView = findViewById(R.id.TextView);
        textView.setText(value);
    }
}