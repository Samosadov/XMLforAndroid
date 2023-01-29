package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private static final String LogcatTag = "CALCULATOR_ACTIVITY";
    private static final String LifecycleTag = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTag, "I'm onCreate() and I'm started.");
        setContentView(R.layout.activity_calculator);

//  ======= Context training
//        TextView textView = new TextView(this);
//        ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), );
//// Доступ из Activity - наследник Context
//        getSystemService(LAYOUT_INFLATER_SERVICE);
////        shared prefs - доступ с использованием
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);
///


        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogcatTag, "Button have been pushed.");
                calculateAnswer();
                Intent i = new Intent(Calculator.this, MainActivity.class); //создать сообщение
                startActivity(i); // отправить сообщение
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifecycleTag, "I'm onStart() and I'm started.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifecycleTag, "I'm onStop() and I'm started.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifecycleTag, "I'm onDestroy() and I'm started.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifecycleTag, "I'm onPause() and I'm started.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifecycleTag, "I'm onResume() and I'm started.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    private void calculateAnswer() {
        EditText numA = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numB = (EditText) findViewById(R.id.editTextNumberDecimal1);
        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.sub);
        RadioButton mult = (RadioButton) findViewById(R.id.mult);
        RadioButton div = (RadioButton) findViewById(R.id.div);
        TextView result = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "All views have been found");

        float num1 = (numA.getText().toString().isEmpty() || numA.getText() == null)
                ? 0 : Float.parseFloat(numA.getText().toString());
        float num2 = (numB.getText().toString().isEmpty() || numB.getText() == null)
                ? 0 : Float.parseFloat(numB.getText().toString());

        Log.d(LogcatTag,"All data have been read from input fields.");
        Log.d(LogcatTag, "a = " + numA + ", b = " + numB);

        float res = 0;
        if(add.isChecked()) {
            Log.d(LogcatTag, "Operation: adding.");
            res = num1 + num2;
        }
        if(sub.isChecked()) {
            Log.d(LogcatTag, "Operation: subtracting");
            res = num1 - num2;
        }
        if(mult.isChecked()) {
            Log.d(LogcatTag, "Operation: multiplication.");
            res = num1 * num2;
        }
        if(div.isChecked()) {
            Log.d(LogcatTag, "Operation: dividing.");
            if(num2 == 0) {
                Toast.makeText(this, "На ноль делить нельзя.", Toast.LENGTH_SHORT).show();
                result.setText("ERROR");
                return;
            }
            res = num1 / num2;
        }
        Log.d(LogcatTag, "Result = " + res);
        result.setText(String.valueOf(res));
    }
}