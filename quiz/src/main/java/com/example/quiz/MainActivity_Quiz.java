package com.example.quiz;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity_Quiz extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonPlayAgain;
    TextView sumTextview;
    TextView timez;
    TextView rite;
    TextView wrang;
    TextView res;

    ArrayList<Float> answerList = new ArrayList<Float>();
    ArrayList<Integer> highsList = new ArrayList<Integer>();

    public void newQuestion(){

        String operatorSwitch;
        float c=0;
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        int operator = rand.nextInt(4);

        switch (operator){

            case 0: operatorSwitch= "+";
                c = a+b;
                break;
            case 1: operatorSwitch= "-";
                c = a-b;
                break;
            case 2: operatorSwitch= "*";
                c = a*b;
                break;
            case 3: operatorSwitch= "/";
                c = a/b;
                break;
            default: operatorSwitch= "";
        }

        sumTextview.setText(Integer.toString(a)+operatorSwitch+Integer.toString(b));

        locationOfCorrectAns=rand.nextInt(4);

        answerList.clear();

        float wrongans;

        for(int i=0;i<4;i++){
            if(i==locationOfCorrectAns){
                answerList.add(c);
            }else{

                wrongans=rand.nextInt(41);
                while(wrongans==c){
                    wrongans=rand.nextInt(41);
                }
                answerList.add(wrongans);
            }
        }

        buttonOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(MainActivity_Quiz.this, R.raw.click);
                mp.start();
                return false;
            }
        });

        buttonTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(MainActivity_Quiz.this, R.raw.click);
                mp.start();
                return false;
            }
        });

        buttonThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(MainActivity_Quiz.this, R.raw.click);
                mp.start();
                return false;
            }
        });

        buttonFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(MainActivity_Quiz.this, R.raw.click);
                mp.start();
                return false;
            }
        });

        buttonOne.setText(Double.toString(answerList.get(0)));
        buttonTwo.setText(Double.toString(answerList.get(1)));
        buttonThree.setText(Double.toString(answerList.get(2)));
        buttonFour.setText(Double.toString(answerList.get(3)));

    }


    int locationOfCorrectAns;
    int rt,wr=0;

    public void choice(View view){
        Log.i("Tag",(String) view.getTag());
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAns))){

            res=(TextView)findViewById(R.id.result);
            res.setText("Correct");
            rt++;
            rite=(TextView)findViewById(R.id.right);
            rite.setText("RIGHT:"+Integer.toString(rt));

        }
        else{
            res=(TextView)findViewById(R.id.result);
            res.setText("Wrong");
            wr++;
            wrang=(TextView)findViewById(R.id.wrong);
            wrang.setText("WRONG:"+Integer.toString(wr));
        }
        newQuestion();
    }


    public void playag(View view){
        App2.refresh(this);
    }

    public void start(View view){

        ImageView startButton=(ImageView)findViewById(R.id.sb);

        startButton.setVisibility(View.INVISIBLE);
        TextView startText=(TextView)findViewById(R.id.starttext);
        startText.setVisibility(View.INVISIBLE);

        buttonOne =(Button)findViewById(R.id.an1);
        buttonTwo =(Button)findViewById(R.id.an2);
        buttonThree =(Button)findViewById(R.id.an3);
        buttonFour =(Button)findViewById(R.id.an4);
        buttonPlayAgain =(Button)findViewById(R.id.playagain);
        rite=(TextView)findViewById(R.id.right);
        wrang=(TextView)findViewById(R.id.wrong);
        sumTextview=(TextView) findViewById(R.id.problem);
        timez=(TextView)findViewById(R.id.time);
        res=(TextView)findViewById(R.id.result);

        buttonOne.setVisibility(View.VISIBLE);
        buttonTwo.setVisibility(View.VISIBLE);
        buttonThree.setVisibility(View.VISIBLE);
        buttonFour.setVisibility(View.VISIBLE);
        buttonPlayAgain.setVisibility(View.INVISIBLE);
        sumTextview.setVisibility(View.VISIBLE);
        timez.setVisibility(View.VISIBLE);
        rite.setVisibility(View.VISIBLE);
        wrang.setVisibility(View.VISIBLE);
        res.setVisibility(View.VISIBLE);

        buttonOne.animate().alpha(1f).setDuration(300);
        buttonTwo.animate().alpha(1f).setDuration(300);
        buttonThree.animate().alpha(1f).setDuration(300);
        buttonFour.animate().alpha(1f).setDuration(300);
        sumTextview.animate().alpha(1f).setDuration(300);
        timez.animate().alpha(1f).setDuration(300);
        rite.animate().alpha(1f).setDuration(300);
        wrang.animate().alpha(1f).setDuration(300);
        buttonPlayAgain.animate().translationYBy(1000f);

        new CountDownTimer(30300,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timez.setText("TIME:"+String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish(){
                highsList.add(rt);

                System.out.print("Highest Score="+Collections.max(highsList));
                Log.i("Highest Score",""+ highsList);

                timez.setText("TIME:0s");
                res.setText("YOUR SCORE = "+Integer.toString(rt)+"\n\t\t\t\t\t\t\tTIME OUT");
                res.animate().alpha(1f).setDuration(300);
                buttonPlayAgain.animate().translationYBy(-1000f).setDuration(1000);


                buttonPlayAgain =(Button)findViewById(R.id.playagain);
                buttonPlayAgain.setVisibility(View.VISIBLE);

                buttonOne.setEnabled(false);
                buttonTwo.setEnabled(false);
                buttonThree.setEnabled(false);
                buttonFour.setEnabled(false);
            }
        }.start();

    }

}
