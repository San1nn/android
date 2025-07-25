package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editTextText2);
        passwordEditText = findViewById(R.id.editTextNumberPassword);
        loginButton = findViewById(R.id.button8);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });
    }

    private void checkLogin() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString();

        if (username.equals("admin") && password.equals("password")) {
            Toast.makeText(MainActivity.this, " Login successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, " Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
