package com.company.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addition;
    Button subtraction;
    Button multi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addition=findViewById(R.id.buttonAdd);
        subtraction=findViewById(R.id.buttonSub);
        multi=findViewById(R.id.buttonMul);


        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//open second activity
                Intent intent = new Intent(MainActivity.this,Game.class);
                startActivity(intent);
            }
        });
    }
}