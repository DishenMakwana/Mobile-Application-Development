package com.company.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class Game extends AppCompatActivity {

    TextView score;
    TextView life;
    TextView time;

    TextView question;
    EditText answer;

    Button ok;
    Button next;

    Random random = new Random();
    int num1;
    int num2;
    int useranswer;
    int realanswer;
    int userScore=0;
    int userlife=3;

    CountDownTimer timer;
    private static final long START_TIMER_IN_MILIS = 10000;
    boolean timer_running;
    long time_left_in_mills=START_TIMER_IN_MILIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score=findViewById(R.id.textViewScore);
        life=findViewById(R.id.textViewLife);
        time=findViewById(R.id.textViewTime);
        question=findViewById(R.id.textViewQuestion);
        answer=findViewById(R.id.editTextAnswer);
        ok=findViewById(R.id.buttonOk);
        next=findViewById(R.id.buttonNext);

        gameContinue();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                useranswer = Integer.valueOf(answer.getText().toString());
                pauseTimer();
                if(useranswer == realanswer)
                {
                    userScore = userScore + 10;
                    score.setText(""+userScore);
                    question.setText("Congratulations,Your answer is true");
                }
                else
                {
                    userlife = userlife -1;
                    life.setText(""+ userlife);
                    question.setText("Sorry,Your answer is wrong");
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("");
                gameContinue();
                resetTimer();

            }
        });

    }

    public void gameContinue()
    {
          num1 = random.nextInt(100);//limit
          num2= random.nextInt(100);

          realanswer = num1 + num2 ;

          question.setText(num1 + "+" + num2);
          startTimer();

    }

    public void startTimer()
    {
        timer=new CountDownTimer(time_left_in_mills,1000) {
            @Override
            public void onTick(long l) {
                time_left_in_mills = l;
                updateText();

            }

            @Override
            public void onFinish() {
                  timer_running=false;
                  pauseTimer();
                  resetTimer();
                  updateText();
                  userlife=userlife - 1;
                  life.setText(""+userlife);
                  question.setText("Sorry! Time is Up!");
            }
        }.start();
       timer_running=true;
    }

    public void updateText()
    {
                int second = (int)(time_left_in_mills / 1000 ) % 60 ;
                String time_left = String.format(Locale.getDefault(),"%02d",second);
                time.setText(time_left);

    }

    public void pauseTimer()
    {

        timer.cancel();
        timer_running = false;
    }
    public  void resetTimer()
    {
        time_left_in_mills = START_TIMER_IN_MILIS;
        updateText();

    }
}