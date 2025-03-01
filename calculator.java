package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private EditText input;
    private String currentInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        setButtonListeners();
    }

    private void setButtonListeners() {
        int[] buttonIds = {
            R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
            R.id.buttonPlus, R.id.buttonMinus, R.id.buttonMultiply, R.id.buttonDivide,
            R.id.buttonDot, R.id.buttonClear, R.id.buttonEquals
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            if (button != null) {
                button.setOnClickListener(this::onButtonClick);
            }
        }
    }

    private void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("AC")) {
            currentInput = "";
        } else if (buttonText.equals("=")) {
            try {
                currentInput = evaluateExpression(currentInput);
            } catch (Exception e) {
                currentInput = "Error";
            }
        } else {
            currentInput += buttonText;
        }

        input.setText(currentInput);
    }

    private String evaluateExpression(String expression) {
        try {
            return String.valueOf(new javax.script.ScriptEngineManager()
                    .getEngineByName("rhino").eval(expression));
        } catch (Exception e) {
            return "Error";
        }
    }
}
package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private EditText input;
    private String currentInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        setButtonListeners();
    }

    private void setButtonListeners() {
        int[] buttonIds = {
            R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
            R.id.buttonPlus, R.id.buttonMinus, R.id.buttonMultiply, R.id.buttonDivide,
            R.id.buttonDot, R.id.buttonClear, R.id.buttonEquals
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            if (button != null) {
                button.setOnClickListener(this::onButtonClick);
            }
        }
    }

    private void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("AC")) {
            currentInput = "";
        } else if (buttonText.equals("=")) {
            try {
                currentInput = evaluateExpression(currentInput);
            } catch (Exception e) {
                currentInput = "Error";
            }
        } else {
            currentInput += buttonText;
        }

        input.setText(currentInput);
    }

    private String evaluateExpression(String expression) {
        try {
            return String.valueOf(new javax.script.ScriptEngineManager()
                    .getEngineByName("rhino").eval(expression));
        } catch (Exception e) {
            return "Error";
        }
    }
}
