package com.example.spywar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamestart);

        Button restartbtn = (Button) findViewById(R.id.restart);

        restartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인텐트 선언 : 현재 엑티비티, 넘어갈 엑티비티
                Intent intent = new Intent(GameStart.this, MainActivity.class);
                // 인텐트 실행
                startActivity(intent);
            }
        });
    }
}
