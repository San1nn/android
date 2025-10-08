
package com.example.exp8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // FIX 5: Added the missing closing parenthesis ')'
        TextView tv = findViewById(R.id.textView2);
        String msg = getIntent().getStringExtra("message");
        if (msg != null) {
            tv.setText(msg);
        }

        Button btnReturn = findViewById(R.id.button4);
        btnReturn.setOnClickListener(v -> {
            Intent result = new Intent();
            result.putExtra("result_key", "This is result from Third");
            setResult(Activity.RESULT_OK, result);
            finish();
        });
    }
}