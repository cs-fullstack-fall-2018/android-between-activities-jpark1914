package com.example.student.betweenactivites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityMain extends AppCompatActivity {
    TextView counterView = null;
    Button addButton = null;
    Button winButton = null;
    int counter = 0;
    String loss = "Not enough points";
    String text;
    private TextView mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterView = (TextView) findViewById(R.id.textView);
        addButton = (Button) findViewById(R.id.button_add);
        winButton = (Button) findViewById(R.id.button_win);
        mMessageEditText = findViewById(R.id.textView);

    }


    public static final String EXTRA_MESSAGE =
            "com.example.student.betweenactivites.extra.MESSAGE";


    public void addUp(View view) {
        counter = counter +1;
        String addOne = "" + counter;
        counterView.setText(addOne);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        String message = "Your total amount of clicks were: " + mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        if(counter >= 5) {
            text = "Total number of clicks: " + counter;
            startActivity(intent);
        }
        else{
            counterView.setText(loss);
        }
    }
}

