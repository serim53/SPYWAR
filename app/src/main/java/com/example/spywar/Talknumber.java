package com.example.spywar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Talknumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talknumber);

        EditText editText = (EditText) findViewById(R.id.number);

        Button input = (Button) findViewById(R.id.numberinput);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 인텐트 선언 : 현재 엑티비티, 넘어갈 엑티비티
                Intent intent = new Intent(Talknumber.this, TalkRole.class);

                final String text = editText.getText().toString();
                intent.putExtra("text",text);
                // 인텐트 실행
                startActivity(intent);

            }
        });

    }
}
