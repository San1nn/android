package com.example.exp9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etEmail, etPassword;
    private Button btnRegister;

    private SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // make sure this layout file exists and contains these view ids
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString();

                // Basic validations
                if (TextUtils.isEmpty(name)) {
                    etName.setError("Name required");
                    etName.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Valid email required");
                    etEmail.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password) || password.length() < 6) {
                    etPassword.setError("Password (min 6 chars)");
                    etPassword.requestFocus();
                    return;
                }

                // Hash the password before storing (simple SHA-256). For production use encrypted storage.
                String hashedPassword = sha256(password);

                // Store data in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", name);
                editor.putString("Email", email);
                editor.putString("PasswordHash", hashedPassword);
                editor.apply();

                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                // Move to ProfileActivity and finish Registration so back button won't return here
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Simple SHA-256 hashing helper
    private String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException ex) {
            ex.printStackTrace();
            // fallback: return plain (not ideal)
            return base;
        }
    }
}
