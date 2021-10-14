package com.example.singlepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Message","onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message","onDestroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message","onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message","onStop");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Message","onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message","onResume");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Message","onRestart");
    }
}