package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Calculator extends AppCompatActivity {

    private static final String logcatTag = "CALCULATOR_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(logcatTag, "Button have been pushed.");
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        EditText numA = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numB = (EditText) findViewById(R.id.editTextNumberDecimal1);
        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.sub);
        RadioButton mult = (RadioButton) findViewById(R.id.mult);
        RadioButton div = (RadioButton) findViewById(R.id.div);
        TextView result = (TextView) findViewById(R.id.result);

        Log.d(logcatTag, "All views have been found");

        float num1 = Float.parseFloat(numA.getText().toString());
        float num2 = Float.parseFloat(numB.getText().toString());

        Log.d(logcatTag,"All data have been read from input fields.");
        Log.d(logcatTag, "a = " + numA + ", b = " + numB);

        float res = 0;
        if(add.isChecked()) {
            Log.d(logcatTag, "Operation: adding.");
            res = num1 + num2;
        }
        if(sub.isChecked()) {
            Log.d(logcatTag, "Operation: subtracting");
            res = num1 - num2;
        }
        if(mult.isChecked()) {
            Log.d(logcatTag, "Operation: multiplication.");
            res = num1 * num2;
        }
        if(div.isChecked()) {
            Log.d(logcatTag, "Operation: dividing.");
            if(num2 == 0) {
                Toast.makeText(this, "На ноль делить нельзя.", Toast.LENGTH_SHORT).show();
                result.setText("ERROR");
                return;
            }
            res = num1 / num2;
        }
        Log.d(logcatTag, "Result = " + res);
        result.setText(String.valueOf(res));
    }
}