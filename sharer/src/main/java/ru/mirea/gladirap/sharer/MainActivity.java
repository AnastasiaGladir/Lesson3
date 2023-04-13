package ru.mirea.gladirap.sharer;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("*/*");
        ActivityResultCallback<Instrumentation.ActivityResult> callback = new ActivityResultCallback<Instrumentation.ActivityResult>() {
            @Override
            public void onActivityResult(Instrumentation.ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getResultData();
                    Log.d(MainActivity.class.getSimpleName(), "Data:" + data.getDataString());
                }
            }
        };
    }
}
