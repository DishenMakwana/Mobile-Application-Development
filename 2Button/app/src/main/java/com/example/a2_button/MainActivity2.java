package com.example.a2_button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        Log.d("Message","Second Activity onCreate");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message","Second Activity onDestroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message","Second Activity onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message","Second Activity onStop");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Message","Second Activity onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message","Second Activity onResume");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Message","Second Activity onRestart");
    }
}