package com.example.program2;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "MainActivity: onCreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "MainActivity: onCreate");

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "MainActivity: onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "MainActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "MainActivity: onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "MainActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "MainActivity: onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "MainActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "MainActivity: onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "MainActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "MainActivity: onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "MainActivity: onDestroy");
    }
}
