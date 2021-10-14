package com.company.numberguessinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView textViewLast,textViewRight,textViewhint;
    private Button buttonconfirm;
    private EditText editTextGuess;

    boolean twodigits,threedigits,fourdigits;
    Random r =new Random();//inbuit class of java
    int random;
    int remainingRight=10;

    ArrayList<Integer> guessesList = new ArrayList<>();
    int userAttempt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textViewhint=findViewById(R.id.textView_hint);
        textViewRight=findViewById(R.id.textview_right);
        textViewLast=findViewById(R.id.textView_last);
        buttonconfirm=findViewById(R.id.button_confirm);
        editTextGuess=findViewById(R.id.editTextGuess);

        twodigits=getIntent().getBooleanExtra("two",false);//choose number by user
        threedigits=getIntent().getBooleanExtra("three",false);
        fourdigits=getIntent().getBooleanExtra("four",false);

        if(twodigits)
        {
            random=r.nextInt(90)+10;
        }
        if(threedigits)
        {
            random=r.nextInt(900)+100;
        }
        if(fourdigits)
        {
            random=r.nextInt(9000)+1000;
        }

        buttonconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess =editTextGuess.getText().toString();

                if(guess.equals(""))
                {
                    Toast.makeText(GameActivity.this,"Please Enter a guess",Toast.LENGTH_LONG).show();
                }
                else
                {
                    textViewLast.setVisibility(View.VISIBLE);
                    textViewhint.setVisibility(View.VISIBLE);
                    textViewRight.setVisibility(View.VISIBLE);

                    userAttempt++;

                    remainingRight--;

                    int userGuess = Integer.parseInt(guess);

                    guessesList.add(userGuess);//array list
                    textViewLast.setText("Your last guess is : "+guess);
                    textViewRight.setText("Your remaining right :"+remainingRight);

                    if(random==userGuess)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Number Guessing Game");
                        builder.setCancelable(false);
                        builder.setMessage("Congratulations.My guess was"+random
                        +"\n\n You know my number in "+userAttempt +"attempts.\n\n Your guesses :"+guessesList+"\n\n Would you like to play Again?");
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                            }
                        });
                        builder.create().show();
                    }
                    if(random < userGuess)
                    {
                       textViewhint.setText("Decrease Your Guess ");
                    }
                    if(random > userGuess)
                    {
                        textViewhint.setText("Increase Your Guess");
                    }
                    if(remainingRight==0)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Number Guessing Game");
                        builder.setCancelable(false);
                        builder.setMessage("Sorry,Your right to guess is over  "
                                +"\n\n My guess was "+random + "attempts.\n\n Your guesses :"+guessesList+"\n\n Would you like to play Again?");
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });
                        builder.create().show();
                    }
                    editTextGuess.setText("");

                }
            }
        });
    }
}