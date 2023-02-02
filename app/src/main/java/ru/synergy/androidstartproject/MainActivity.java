package ru.synergy.androidstartproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQ_C = 1;
    EditText et;
    private TextView tv;
    private Button button1, button2, button3;
    ActivityResultLauncher<Intent> mStartActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    tv.setText(intent.getStringExtra("tv"));
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        et = (EditText) findViewById(R.id.edittext1);
        tv = (TextView) findViewById(R.id.textview1);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_OK:
                tv.setText(data.getStringExtra("et"));
                break;

        }
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.button1:
                i = new Intent(this, MainActivity2.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, ToInfActivity.class);
                String str = et.getText().toString();
                i.putExtra("edittext1", str);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this, ComeBackActivity.class);

                mStartActivityForResult.launch(i);
                break;

        }

    }
}