package com.example.exp8;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Correctly register the activity result launcher
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    // FIX 1: Added the 'if' statement for proper conditional check
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        String returned = result.getData().getStringExtra("result_key");
                        Toast.makeText(this, "Returned: " + returned, Toast.LENGTH_LONG).show();
                    }
                }
        );

        Button btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            // Added an extra to make the logic in SecondActivity work
            i.putExtra("MESSAGE", "Hello Second Activity");
            // FIX 2: Corrected method name from 'StartActivity' to 'startActivity'
            startActivity(i);
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ThirdActivity.class);
            i.putExtra("message", "Hello Third Activity");
            launcher.launch(i);
        });
    }
}