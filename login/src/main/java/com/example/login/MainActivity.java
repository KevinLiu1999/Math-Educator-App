package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newwelcome.WelcomeFlash;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        /**
         * user name: mathquiz
         * password : mathquiz
         */

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("mathquiz") && password.getText().toString().equals("mathquiz")){
                    //right user name and password
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this, WelcomeFlash.class);
                    startActivity(intent);
                }else
                    //user name and password is not matching, wrong one
                    Toast.makeText(MainActivity.this,"LOGIN FAILED !",Toast.LENGTH_SHORT).show();
            }
        });


    }
}