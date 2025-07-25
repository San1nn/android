package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText number1, number2;
    Button addBtn, subBtn, mulBtn, divBtn;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        number1=findViewById(R.id.number1);
        number2=findViewById(R.id.number2);
        addBtn=findViewById(R.id.btn_add);
        subBtn=findViewById(R.id.btn_sub);
        mulBtn=findViewById(R.id.btn_div);
        divBtn=findViewById(R.id.btn_mul);
        answer=findViewById(R.id.answer);

        addBtn.setOnClickListener(view -> calculate('+'));
        subBtn.setOnClickListener(View -> calculate('-'));
        mulBtn.setOnClickListener(View -> calculate('*'));
        divBtn.setOnClickListener(view -> calculate('/'));

    }

    private void calculate(char operator) {
        String input1 = number1.getText().toString();
        String input2 = number2.getText().toString();
        if (input1.isEmpty() || input2.isEmpty()) {
            answer.setText("Please enter both numbers.");
            return;
        }

        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double res = 0;

        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    answer.setText("Cannot divide by zero");
                    return;
                }
                res = num1 / num2;
                break;
        }

        answer.setText("Result: " + res);
    }
}

