package ru.mirea.gladirap.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ShareActivity extends AppCompatActivity {
    public EditText edit_tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        edit_tx = findViewById(R.id.editTextTextPersonName);
        setContentView(R.layout.activity_share);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView ageView = findViewById(R.id.textViewBook);
            String university = extras.getString(MainActivity.name);
            ageView.setText(String.format("Моя любимая книга: %s", university));
        }
    }

    public void onClick(View view){
        String text = String.valueOf(edit_tx.getText());

        Intent data = new Intent();
        data.putExtra(MainActivity.users_message, text);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}
