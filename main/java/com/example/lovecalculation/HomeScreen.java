package com.example.lovecalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    Animation fun, fun2;
    TextView forHome, forFun;
    Button birthday, loveCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        fun = AnimationUtils.loadAnimation(this,R.anim.top_annimation);
        fun2 = AnimationUtils.loadAnimation(this,R.anim.bottom_annimation);

        forHome = findViewById(R.id.textView);
        forFun = findViewById(R.id.textView4);
        birthday = findViewById(R.id.button1);
        loveCalculator = findViewById(R.id.button2);

        forHome.setAnimation(fun2);
        forFun.setAnimation(fun);

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomeScreen.this, BirthdayGameScreen.class);
                startActivity(intent2);
            }
        });

        loveCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(HomeScreen.this, LoveCalculatorScreen.class);
                startActivity(intent3);
            }
        });
    }
}