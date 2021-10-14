package com.company.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

     Animation animationImage,animationText;//inbuilt class of java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView2);

        animationImage = AnimationUtils.loadAnimation(this,R.anim.image_animation);//load animation file
        animationText=AnimationUtils.loadAnimation(this,R.anim.text_animation);

        imageView.setAnimation(animationImage);
        textView.setAnimation(animationText);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();

            }
        }.start();

    }
}