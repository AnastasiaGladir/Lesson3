package ru.mirea.gladirap.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        long dateInMillis = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateString = sdf.format(new Date(dateInMillis));

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("mirea", "КВАДРАТ МОЕГО ЗНАЧЕНИЯ ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ 9," + "а текущее время "
                + dateString);
        startActivity(intent);
    }
}