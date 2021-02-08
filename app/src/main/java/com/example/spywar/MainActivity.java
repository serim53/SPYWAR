package com.example.spywar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton helpbtn = (ImageButton) findViewById(R.id.help_button);
        helpbtn.setBackgroundResource(R.drawable.gun);

        ImageButton startbtn = (ImageButton) findViewById(R.id.start_button);
        startbtn.setBackgroundResource(R.drawable.spy);


        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                customDialog.callFunction();
            }
        });
        startbtn.setOnClickListener(buttonClick);

        TextView textView = (TextView)findViewById(R.id.gamestart);
        TextView textView2 = (TextView)findViewById(R.id.howto);

    }

    View.OnClickListener buttonClick = new View.OnClickListener() {
        public void onClick(View v){
            // 인텐트 선언 : 현재 엑티비티, 넘어갈 엑티비티
            Intent intent = new Intent(MainActivity.this, SelectPage.class);
            // 인텐트 실행
            startActivity(intent);
        }
    };
}