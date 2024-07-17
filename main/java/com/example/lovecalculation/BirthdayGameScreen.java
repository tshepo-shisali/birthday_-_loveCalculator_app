package com.example.lovecalculation;

import androidx.appcompat.app.AppCompatActivity;
import com.example.lovecalculation.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


public class BirthdayGameScreen extends AppCompatActivity {

    public static final String EXTRA_DAY ="com.example.lovecalculation.EXTRA_DAY";

    TextView display_set, questionTextView;
    Button yesButton;
    Button noButton;
    int day = 0;
    int i = 1;

    Animation fun2, forButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_game_screen);

        fun2 = AnimationUtils.loadAnimation(this,com.example.lovecalculation.rotating_annimation);
        forButtons = AnimationUtils.loadAnimation(this,R.anim.bottom_annimation);
        String set1 ="1 3 5 7\n" +
                "9 11 13 15\n" +
                "17 19 21 23\n" +
                "25 27 29 31\n";
        display_set = findViewById(R.id.textViewBirthday2);
        questionTextView = findViewById(R.id.textViewBirthday1);
        display_set.setText(set1);
        yesButton = findViewById(R.id.buttonBirthday1);
        noButton = findViewById(R.id.buttonBirthday2);

        questionTextView.setAnimation(fun2);


        yesButton.setAnimation(forButtons);
        noButton.setAnimation(forButtons);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i == 1) {
                    questionTextView.setText("What about on these?");
                    questionTextView.setAnimation(fun2);
                    String set2 = "2 3 6 7\n" +
                            "10 11 14 15\n" +
                            "18 19 22 23\n" +
                            "26 27 30 31\n";
                    display_set.setText(set2);
                    day = day + 1;

                } else if(i==2) {
                    questionTextView.setText("What about on these also?");
                    questionTextView.setAnimation(fun2);
                    String set3 = "4 5 6 7\n" +
                            "12 13 14 15\n" +
                            "20 21 22 23\n" +
                            "28 29 30 31\n";
                    display_set.setText(set3);
                    day = day + 2;

                }else if(i==3){
                    questionTextView.setText("Also on these?");
                    questionTextView.setAnimation(fun2);
                    String set4 = "8 9 10 11\n" +
                            "12 13 14 15\n" +
                            "24 25 26 27\n" +
                            "28 29 30 31\n";
                    display_set.setText(set4);
                    day = day + 4;

                }else if(i==4){
                    questionTextView.setText("What about on these last ones?");
                    questionTextView.setAnimation(fun2);
                    String set5 = "16 17 18 19\n" +
                            "20 21 22 23\n" +
                            "24 25 26 27\n" +
                            "28 29 30 31\n";
                    display_set.setText(set5);
                    day = day +8;

                }else{

                    day = day + 16;


                    openLastForBirthday();


                }


                i++;

            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 1) {
                    questionTextView.setText("What about on these?");
                    questionTextView.setAnimation(fun2);
                    String set2 = "2 3 6 7\n" +
                            "10 11 14 15\n" +
                            "18 19 22 23\n" +
                            "26 27 30 31\n";
                    display_set.setText(set2);

                } else  if(i ==2){
                    questionTextView.setText("What about on these also?");
                    questionTextView.setAnimation(fun2);
                    String set3 = "4 5 6 7\n" +
                            "12 13 14 15\n" +
                            "20 21 22 23\n" +
                            "28 29 30 31\n";
                    display_set.setText(set3);

                }else if(i==3){
                    questionTextView.setText("Also on these?");
                    questionTextView.setAnimation(fun2);
                    String set4 = "8 9 10 11\n" +
                            "12 13 14 15\n" +
                            "24 25 26 27\n" +
                            "28 29 30 31\n";
                    display_set.setText(set4);

                }else if(i ==4){
                    questionTextView.setText("What about on these last ones?");
                    questionTextView.setAnimation(fun2);
                    String set5 = "16 17 18 19\n" +
                            "20 21 22 23\n" +
                            "24 25 26 27\n" +
                            "28 29 30 31\n";
                    display_set.setText(set5);

                }else
                {

                    openLastForBirthday();

                }

                i++;
            }
        });



    }

    public void openLastForBirthday(){
        Intent intent5 = new Intent(this, LastForBirthday.class);
        intent5.putExtra(EXTRA_DAY,day);
        startActivity(intent5);
    }

}