package com.example.lovecalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class LastForLove extends AppCompatActivity {

    Button home;
    int percentage;
    TextView messages;
    Animation tops, bottoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_for_love);

        tops = AnimationUtils.loadAnimation(this,R.anim.top_annimation);
        bottoms = AnimationUtils.loadAnimation(this,R.anim.bottom_annimation);

        //getting values from the previous activity
        Intent intent = getIntent();
        String textMine = intent.getStringExtra(LoveCalculatorScreen.EXTRA_TEXT);
        String textYours = intent.getStringExtra(LoveCalculatorScreen.EXTRA_TEXT2);

        String fileName = textMine + textYours + ".txt";
        String antiFileName = textYours + textMine + ".txt";
        percentage = (int) (Math.random() * 100);




        TextView textView1 = findViewById(R.id.textView7);
        TextView textView2 = findViewById(R.id.textView10);
        TextView textView3 = findViewById(R.id.textView11);

        messages = findViewById(R.id.textView12);
        home = findViewById(R.id.button4);

        textView1.setText(textMine);
        textView2.setText(textYours);

        textView3.setAnimation(tops);
        messages.setAnimation(bottoms);

        //call the class that write messages to the textview
        messages();

        //creating files and loading files with names being a combination of yours and mine
        FileInputStream fis = null;

        try {
            fis = openFileInput(fileName);

            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            textView3.setText(sb.toString());

        } catch (FileNotFoundException ex) {
            try {
                fis = openFileInput(antiFileName);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String text2;

                while ((text2 = br.readLine()) != null) {
                    sb.append(text2).append("\n");
                }
                textView3.setText(sb.toString());

            } catch (FileNotFoundException fileNotFoundException) {
                //trying
                FileOutputStream fos = null;
                String text = String.valueOf(percentage);
                textView3.setText(text);
                try {
                    fos = openFileOutput(fileName, MODE_PRIVATE);
                    fos.write(text.getBytes());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLast = new Intent(LastForLove.this, HomeScreen.class);
                startActivity(intentLast);
                finish();
            }
        });

    }

    public void messages() {
        if (percentage < 5) {
            String one = "Love is life. And if you miss love, you miss life";

        } else if ( percentage >= 5 && percentage < 10) {
            String one = "The hunger for love is so much difficult to remove than the hunger for food";
            messages.setText(one);
        } else if (percentage < 15 && percentage >= 10) {
            String one = "The best proof for love is trust";
            messages.setText(one);
        }else if (percentage < 20 && percentage >= 15) {
            String one = "Love is composed of a single soul inhabiting two bodies";
            messages.setText(one);
        }else if (percentage < 25 && percentage >= 20) {
            String one = "Love can sometimes be magic. But magic can sometimes....just be an illusion";
            messages.setText(one);
        }else if (percentage < 30 && percentage >= 25) {
            String one = "The best proof for love is trust";
            messages.setText(one);
        }else if (percentage < 35 && percentage >= 30) {
            String one = " “Love is that condition in which the happiness of another person is essential to your own.” —Robert A. Heinlein";
            messages.setText(one);
        }else if (percentage < 40 && percentage >= 35) {
            String one = "“Take my hand, take my whole life too. For I can’t help falling in love with you.” —Elvis Presley";
            messages.setText(one);
        }else if (percentage < 45 && percentage >= 40) {
            String one = " If I had a flower for every time I thought of you… I could walk through my garden forever. —Alfred Tennyson ";
            messages.setText(one);
        }else if (percentage < 50 && percentage >= 45) {
            String one = "I will never stop trying. Because when you find the one… you never give up.” —Crazy, Stupid, Love";
            messages.setText(one);
        }else if (percentage < 55 && percentage >= 50) {
            String one = "True love is rare, and it’s the only thing that gives life real meaning.”  ― Nicholas Sparks";
            messages.setText(one);
        }else if (percentage < 60 && percentage >= 55) {
            String one = "My love for you has no depth, its boundaries are ever-expanding.” – Christina White";
            messages.setText(one);
        }else if (percentage < 65 && percentage >= 60) {
            String one = "If you find someone you love in your life, then hang on to that love.” — Princess Diana";
            messages.setText(one);
        }else if (percentage < 70 && percentage >= 65) {
            String one = "I love that you are the last person I want to talk to before I go to sleep at night.” — When Harry Met Sally";
            messages.setText(one);
        }else if (percentage < 75 && percentage >= 70) {
            String one = "Sometimes all you need is a hug from the right person and all your stress will melt away.” —Unknown";
            messages.setText(one);
        }else if (percentage < 80 && percentage >= 75) {
            String one = "I love you and that’s the beginning and end of everything.” —F. Scott Fitzgerald";
            messages.setText(one);
        }else if (percentage < 85 && percentage >= 80) {
            String one = "I’ve tried so many times to think of a new way to say it, and it’s still I love you.” —Zelda Fitzgerald";
            messages.setText(one);
        }else if (percentage < 90 && percentage >= 85) {
            String one = "It was love at first sight, at last sight, at ever and ever sight.” ― Vladimir Nabokov";
            messages.setText(one);
        }else if (percentage < 95 && percentage >= 90) {
            String one = "I love you for all that you are, all that you have been and all that you will be.” —Unknown";
            messages.setText(one);
        }else if (percentage == 96) {
            String one = "You’re always the first and the last thing on this heart of mine. No matter where I go, or what I do, I’m thinking of you.” – Dierks Bentley";
            messages.setText(one);
        }else if (percentage ==97) {
            String one = "When you realize you want to spend the rest of your life with somebody, you want the rest of your life to start as soon as possible.” —When Harry Met Sally";
            messages.setText(one);
        }else if (percentage == 98) {
            String one = "I need you like a heart needs a beat.";
            messages.setText(one);
        }else if (percentage ==99) {
            String one = "I saw you were perfect, and so i loved you. Then I saw that you were not perfect and I loved you even more. - Angelita Lim";
            messages.setText(one);
        }else{
            String one = "You know you are in love if you can't fall asleep because reality if finally better than your dreams. -Dr.Seuss";
            messages.setText(one);
        }


    }
}
