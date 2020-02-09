package com.example.textswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    Button buttonNext , buttonPrevious;
   TextSwitcher textSwitcher;


    String[] lists = {"It is ball",
            "It is bat",
            "It is an apple" , "It is umbrella"};

    int position = -1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSwitcher = findViewById(R.id.textSwitcher);
        buttonNext = findViewById(R.id.btnNext);
        buttonPrevious = findViewById(R.id.btnPrevious);

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView  textView = new TextView(getApplicationContext());
                textView.setTextSize(18);
                textView.setTextSize(getResources().getColor(R.color.colorPrimaryDark));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

       buttonNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (position < lists.length - 1) {
                   position = position + 1;
                   textSwitcher.setText(lists[position]);
               }
           }
       });


       buttonPrevious.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (position > 0) {
                   position = position - 1;
                   textSwitcher.setText(lists[position]);
               }
           }
       });



        }
    }

