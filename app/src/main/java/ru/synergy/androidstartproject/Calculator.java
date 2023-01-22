package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        float num1 = Float.parseFloat(numA.getText().toString());
        float num2 = Float.parseFloat(numB.getText().toString());
        float res = 0;
        if(add.isChecked()) res = num1 + num2;
        if(sub.isChecked()) res = num1 - num2;
        if(mult.isChecked()) res = num1 * num2;
        if(div.isChecked()) {
            if(num2 == 0) {
                Toast.makeText(this, "На ноль делить нельзя.", Toast.LENGTH_SHORT).show();
                result.setText("ERROR");
                return;
            }
            else res = num1 / num2;
        }
        result.setText(String.valueOf(res));
    }
}