package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ToInfActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_inf);
        textView = (TextView) findViewById(R.id.textView1);
        String str = getIntent().getStringExtra("et");
        textView.setText(str);
    }
}