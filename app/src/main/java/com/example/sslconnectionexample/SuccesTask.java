package com.example.sslconnectionexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SuccesTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_task);

        TextView tvResult = findViewById(R.id.tvResult);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tvResult.setText(extras.getString("helloKey"));
        }
    }
}