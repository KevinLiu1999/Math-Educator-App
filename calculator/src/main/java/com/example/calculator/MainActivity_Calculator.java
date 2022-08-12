package com.example.calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity_Calculator extends AppCompatActivity{
    TextView working;
    TextView result;
    String work="";
    boolean leftBracket=true;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);

        init();

    }
    private void init() {
        working =  findViewById(R.id.working);
        result = findViewById(R.id.result);
    }

    private void setWork(String value){
        work=work+value;
        working.setText(work);

    }

    public void clearOnClick(View view){
        working.setText("");
        work="";
        result.setText("");
        leftBracket=true;
    }


    public void divisionOnClick(View view) {
        setWork("/");
    }

    public void sevenOnClick(View view) {
        setWork("7");
    }

    public void eightOnClick(View view) {
        setWork("8");
    }

    public void nineOnClick(View view) {
        setWork("9");
    }

    public void fourOnClick(View view) {
        setWork("4");
    }

    public void fiveOnClick(View view) {
        setWork("5");
    }

    public void sixOnClick(View view) {
        setWork("6");
    }

    public void oneOnClick(View view) {
        setWork("1");
    }

    public void twoOnClick(View view) {
        setWork("2");
    }

    public void threeOnClick(View view) {
        setWork("3");
    }

    public void zeroOnClick(View view) {
        setWork("0");
    }

    public void equalsOnClick(View view) {
        Double results=null;
        ScriptEngine engine=new ScriptEngineManager().getEngineByName("rhino");

        try {
            results=(double)engine.eval(work);
        } catch (ScriptException e) {
            Toast.makeText(this,"invalid input",Toast.LENGTH_SHORT).show();
        }

        if(results!=null){
            result.setText(String.valueOf(results.doubleValue()));
        }

    }

    public void dotOnClick(View view) {
        setWork(".");
    }

    public void addOnClick(View view) {
        setWork("+");
    }

    public void subtractOnClick(View view) {
        setWork("-");
    }

    public void multiplyOnClick(View view) {
        setWork("*");
    }
    public void leftBracketOnClick(View view) {
        if(leftBracket) {
            setWork("(");
            leftBracket = false;
        }


    }

    public void rightBracketOnClick(View view) {
        if(!leftBracket){
            setWork(")");
            leftBracket=true;
        }

    }
}