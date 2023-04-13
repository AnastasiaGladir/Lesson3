package ru.mirea.gladirap.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> activityResultLauncher;
    static final String name = "book_name";
    static final String users_message="message";
    private TextView textViewUserBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewUserBook = findViewById(R.id.textViewBook);
        ActivityResultCallback<ActivityResult> callback = new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    String userBook = data.getStringExtra(users_message);
                    textViewUserBook.setText(userBook);
                }
            }
        };
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), callback);
    }
    public void getBookName (View view) {
        Intent intent = new Intent(this, ShareActivity.class);
        intent.putExtra(name, "Чистый код");
        activityResultLauncher.launch(intent);
    }
}