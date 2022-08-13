package com.example.newwelcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.MainActivity_Calculator;
import com.example.quiz.MainActivity_Quiz;


public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }

    public void calculator(View view) {
        Intent intentCalculator=new Intent(Activity1.this, MainActivity_Calculator.class);
        startActivity(intentCalculator);


    }

    public void quiz(View view) {
        Intent intentQuiz=new Intent(Activity1.this, MainActivity_Quiz.class);
        startActivity(intentQuiz);

    }
}