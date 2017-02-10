package com.wordpress.farhantanvirutshaw.connect3;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int timeCounter = 0;
    TextView counter_text_view;
    TextView time_text_view;
    LinearLayout main_menu;
    TextView currentScore_text_view;

    int number ;
    boolean isOdd;
    Button pressedButton ;

    Random random = null;

    public void submit(View view)
    {
        pressedButton = (Button)view;
        if(pressedButton.getId()==R.id.odd_button_view)
        {
            isOdd = true;
        }
        else
            isOdd = false;
        switch (number%2)
        {
            case 1:
                if(isOdd==true)
                    score++;
                else
                    score-=2;
                break;
            case 0:
                if(isOdd==false)
                    score++;
                else
                    score-=2;
                break;
        }
        currentScore_text_view.setText(String.valueOf(score));
        number = random.nextInt(1000)+1;
        counter_text_view.setText(String.valueOf(number));
    }

    public void play(View view)
    {
        score = 0;
        timeCounter = 0;
        currentScore_text_view.setText(String.valueOf(0));
        main_menu.setVisibility(View.INVISIBLE);
        number = random.nextInt(1000)+1;
        counter_text_view.setText(String.valueOf(number));
        new CountDownTimer(12000,1000)
        {
            public void onTick(long millisUntilFinished)
            {
                time_text_view.setText("00:"+String.valueOf(timeCounter)+":00");
                timeCounter++;
            }
            public void onFinish()
            {
                main_menu.setVisibility(View.VISIBLE);
                TextView score_text_view = (TextView)findViewById(R.id.score_text_view);
                score_text_view.setVisibility(View.VISIBLE);
                score_text_view.setText("SCORE:"+score);
            }
        }.start();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter_text_view = (TextView)findViewById(R.id.counter_text_view);
        main_menu = (LinearLayout)findViewById(R.id.main_menu);
        random = new Random();
        time_text_view = (TextView)findViewById(R.id.time_text_view);
        currentScore_text_view = (TextView)findViewById(R.id.currentScore_text_view);
    }


}
