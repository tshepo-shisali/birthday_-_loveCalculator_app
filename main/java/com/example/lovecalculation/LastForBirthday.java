package com.example.lovecalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LastForBirthday extends AppCompatActivity {
    TextView last_one;
    TextView myDay;
    Button backHome, yes,no;
    Animation anim_last_birthday, anim_last_birthday2;
    ImageView happy,sad;
    String ordinal;
    Animation fromSide,fromTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_for_birthday);

        fromSide = AnimationUtils.loadAnimation(this,R.anim.rotating_annimation);
        fromTop = AnimationUtils.loadAnimation(this,R.anim.top_annimation);

        Intent intent = getIntent();
        int birthday = intent.getIntExtra(BirthdayGameScreen.EXTRA_DAY, 0);

        last_one = findViewById(R.id.textView5);

        myDay = findViewById(R.id.textView6);
        backHome = findViewById(R.id.buttonBirthdayLast);
        no = findViewById(R.id.button3);
        yes = findViewById(R.id.button);
        happy = findViewById(R.id.imageView2);
        sad = findViewById(R.id.imageView3);


        anim_last_birthday = AnimationUtils.loadAnimation(this,R.anim.top_annimation);
        anim_last_birthday2 = AnimationUtils.loadAnimation(this,R.anim.rotating_annimation);

        if(birthday ==1 || birthday == 21 ||  birthday == 31){
            ordinal = "st";
        }else if( birthday == 2 ||  birthday == 22){
            ordinal = "nd";
        }else if( birthday == 3 ||  birthday == 23){
            ordinal = "rd";
        }else
            ordinal = "th";

        last_one.setAnimation(fromTop);
        last_one.setText(" " + birthday + ordinal);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                happy.setAnimation(fromTop);
                happy.setVisibility(View.VISIBLE);
                myDay.setAnimation(fromTop);

                myDay.setText("Go have fun with other plays");
                yes.setEnabled(false);
                no.setEnabled(false);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sad.setAnimation(fromTop);
                sad.setVisibility(View.VISIBLE);
                myDay.setAnimation(fromTop);

                myDay.setText("Next time we'll be right");
                yes.setEnabled(false);
                no.setEnabled(false);
            }
        });




        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLast = new Intent(LastForBirthday.this, HomeScreen.class);
                startActivity(intentLast);
                finish();
            }
        });

    }
}