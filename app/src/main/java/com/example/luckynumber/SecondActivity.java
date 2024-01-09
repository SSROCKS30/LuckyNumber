package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = findViewById(R.id.button);
        txt = findViewById(R.id.textView3);

        //Retrieve Intent from MainActivity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        int number = RandomNumber(); // Calling RandomNumber Method
        txt.setText((""+number));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Share(userName, number);
            }
        });
    }
    public int RandomNumber(){
        Random random = new Random(); //Accessing Random Library in JAVA and creating its instance
        int number = random.nextInt(1000);//UpperLimit is indicated in brackets (It will generate random number from 0 to 1000).
        return number;
    }

    public void Share(String name, int number){
        // Implicit Intent: Use to navigate to different application
        Intent i = new Intent(Intent.ACTION_SEND); // Intent.ACTION_SEND is a predefined constant to send data in different application.
        i.setType("text/plain"); //What type of action we are performing.
        // i.putExtra is a method in Intent class to add additional information to Intent
        // Intent.EXTRA_SUBJECT is a constant used to provide a Subject to send an Action
        // It is mainly used whenever sending an email or msg with a fixed SUBJECT.
        i.putExtra(Intent.EXTRA_SUBJECT, name + " got lucky today!");
        // Intent.EXTRA_TEXT: To write in the body of an email or msg.
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + number);
        //Intent.createChooser: It uses mobile resources to find which application is able to handle this Intent.
        startActivity(Intent.createChooser(i, "Choose a Platform"));
    }
}