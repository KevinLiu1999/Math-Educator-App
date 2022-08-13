package com.example.newwelcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeFlash extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, teamInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_flash);
        int SPLASH_TIME_OUT = 3000;

        topAnim = AnimationUtils.loadAnimation(this, R.anim.open_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.end_animation);

        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.logoView);
        teamInfo = findViewById(R.id.teamView);

        image.setAnimation(bottomAnim);
        teamInfo.setAnimation(topAnim);
        logo.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(WelcomeFlash.this, Activity1.class);
                startActivity(homeIntent);
            }
        }, SPLASH_TIME_OUT);
    }
}