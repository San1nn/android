package com.example.exp8;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView text = findViewById(R.id.textView);
        Button btnBack = findViewById(R.id.button3);

        String str = getIntent().getStringExtra("MESSAGE");

        // FIX 3: Used the correct variable names 'str' and 'text'
        if (str != null) {
            text.setText(str);
        }

        btnBack.setOnClickListener(v -> finish());
    }
}