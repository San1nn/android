package com.example.program6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    RadioButton rbMale, rbFemale;
    CheckBox cbTerms;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        cbTerms = findViewById(R.id.cbTerms);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();

        if(TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email");
            return;
        }

        if(password.length() < 6) {
            etPassword.setError("Password must contain at least 6 characters");
            return;
        }

        String gender="";
        if(rbMale.isChecked()) {
            gender="Male";
        } else if (rbFemale.isChecked()) {
            gender="Female";
        } else {
            Toast.makeText(this,"Select your gender",Toast.LENGTH_SHORT).show();
            return;
        }

        if(!cbTerms.isChecked()) {
            Toast.makeText(this,"Please accept terms and conditions",Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this,"Form Submitted Successfully",Toast.LENGTH_LONG).show();
    }
}
