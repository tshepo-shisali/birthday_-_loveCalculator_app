package com.example.lovecalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    Animation top_anim, bottom_anim;
    ImageView diamond;
    TextView logo, slogen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //ANIMATION
        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_annimation);
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_annimation);

        //hooks
        diamond = findViewById(R.id.imageView);
        logo = findViewById(R.id.textView2);
        slogen = findViewById(R.id.textView3);


        logo.setAnimation(bottom_anim);
        slogen.setAnimation(bottom_anim);
        diamond.setAnimation(top_anim);

       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}