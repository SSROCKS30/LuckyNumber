package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        edtxt = findViewById(R.id.edit_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtxt.getText().toString();

                //Explicit Intent: Used to navigate between different page within same application!
                Intent in = new Intent( // Intent is a class and this is object creation of that class.
                        getApplicationContext(),
                        SecondActivity.class
                );
                // Pass userName to SecondActivity in key-value pair
                in.putExtra("name",userName);
                //starting Activity whenever button is pressed and pass the Intent Instance.
                startActivity(in);
            }
        });
    }
}