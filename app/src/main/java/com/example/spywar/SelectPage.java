package com.example.spywar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SelectPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Button talkbtn = (Button) findViewById(R.id.talkbutton);
        Button nametagbtn = (Button) findViewById(R.id.nametagbutton);

        talkbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // 인텐트 선언 : 현재 엑티비티, 넘어갈 엑티비티
                Intent intent = new Intent(SelectPage.this, TalkRole.class);
                // 인텐트 실행
                startActivity(intent);
            }
        });

        nametagbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // 인텐트 선언 : 현재 엑티비티, 넘어갈 엑티비티
                Intent intent = new Intent(SelectPage.this, NameRole.class);
                // 인텐트 실행
                startActivity(intent);
            }
        });
    }
}
