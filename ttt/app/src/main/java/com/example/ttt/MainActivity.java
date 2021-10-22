package com.example.ttt;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=0;
    int countP1=0;
    int countP2=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winpos={{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnTap(View view) {
        ImageView img=(ImageView) view;
        int tagnum=Integer.parseInt(img.getTag().toString());
        if(gameState[tagnum]==2)
        {
            gameState[tagnum]=player;
            img.setTranslationY(-1000f);
            if(player==0)
            {
                img.setImageResource(R.drawable.o);
                player=1;
            }
            else
            {
                img.setImageResource(R.drawable.x);
                player=0;
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] a:winpos)
        {
            if(gameState[a[0]]==gameState[a[1]]&&gameState[a[1]]==gameState[a[2]]&&gameState[a[0]]!=2)
            {
                if(gameState[a[0]]==0)
                {
                    Toast.makeText(this,"Player 1 Win",Toast.LENGTH_SHORT).show();
                    countP1++;
                    TextView p1=(TextView)findViewById(R.id.scoreOfP1);
                    String setp1=""+countP1;
                    p1.setText(setp1);
                    reset(view);
                }
                else
                {
                    Toast.makeText(this,"Player 2 Win",Toast.LENGTH_SHORT).show();
                    countP2++;
                    TextView p2=(TextView)findViewById(R.id.scoreOfP2);
                    String setP2=""+countP2;
                    p2.setText(setP2);
                    reset(view);
                }
            }
        }

    }

    public void reset(View view) {
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.image0)).setImageResource(0);
        ((ImageView)findViewById(R.id.image1)).setImageResource(0);
        ((ImageView)findViewById(R.id.image2)).setImageResource(0);
        ((ImageView)findViewById(R.id.image3)).setImageResource(0);
        ((ImageView)findViewById(R.id.image4)).setImageResource(0);
        ((ImageView)findViewById(R.id.image5)).setImageResource(0);
        ((ImageView)findViewById(R.id.image6)).setImageResource(0);
        ((ImageView)findViewById(R.id.image7)).setImageResource(0);
        ((ImageView)findViewById(R.id.image8)).setImageResource(0);

    }


    public void resetPlayrerscore(View view) {
        countP1=0;
        countP2=0;
        String p1=""+countP1;
        String p2=""+countP2;
        TextView rp1=findViewById(R.id.scoreOfP1);
        rp1.setText(p1);
        TextView rp2=findViewById((R.id.scoreOfP2));
        rp2.setText(p2);
    }
}