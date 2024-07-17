package com.example.lovecalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoveCalculatorScreen extends AppCompatActivity {
    public static final  String EXTRA_TEXT = "com.example.lovecalculation.EXTRA_TEXT";
    public static final  String EXTRA_TEXT2 = "com.example.lovecalculation.EXTRA_TEXT2";
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_calculator_screen);


        calculate = findViewById(R.id.buttonGo);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLastForLove();
            }
        });


    }

    public void openLastForLove(){

        EditText your_name = findViewById(R.id.editTextTextPersonName);
        EditText partner_name = findViewById(R.id.editTextTextPersonName3);

        String textMine = your_name.getText().toString();
        String textYours = partner_name.getText().toString();

        if(textMine.equals("")){

            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show();

        }else if(textYours.equals("")){
            Toast.makeText(this, "Please enter your partner's name", Toast.LENGTH_LONG).show();
        }else{

            Intent intent = new Intent(this,LastForLove.class);
            intent.putExtra(EXTRA_TEXT, textMine);
            intent.putExtra(EXTRA_TEXT2, textYours);
            startActivity(intent);

        }


    }
}