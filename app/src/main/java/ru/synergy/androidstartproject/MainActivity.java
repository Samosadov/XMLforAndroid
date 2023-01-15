package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = 
        TextView textView = new TextView(this);
        textView.setText("Просто пример.");
        textView.setTextSize(22);
        setContentView(textView);

    }
}