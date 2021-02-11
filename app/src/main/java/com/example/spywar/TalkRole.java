package com.example.spywar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TalkRole extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talkrole);
        TextView roletext = (TextView) findViewById(R.id.roletext);
        TextView missiontext = (TextView) findViewById(R.id.missiontext);
        Button nextbtn = (Button) findViewById(R.id.nextbtn);
        // talknumber에서 게임을 진행하는 인원수를 받아옴
        Bundle intent = getIntent().getExtras();

        // 인원수에 따라 스파이 수를 다르게 지정하기 위해 인원수 저장
        int totalnum = Integer.parseInt(intent.getString("text"));
        int spynum ; // spy수
        int citizennum; // 시민수

        if(totalnum<=5)
            spynum = 1;
        else
            spynum = 2;

        citizennum = totalnum-spynum-1; // 시민수 = 전체수-스파이수-사회자1인

        ArrayList<String> roles = new ArrayList<String>();
        roles.add("사회자");
        for(int i=0;i<spynum;i++)
            roles.add("SPY");
        for(int i=0;i<citizennum;i++)
            roles.add("시민");

        //역할 셔플
        Collections.shuffle(roles);

        String[] role = (String[]) roles.toArray(new String[roles.size()]);


        // 시민 미션 초기설정
        String[] citizenmission = {"1","2","3","4","5","6"};
        // 미션 셔플(매번 랜덤으로 각 시민마다 미션이 다르게 나오기 위함)
        Collections.shuffle(Arrays.asList(citizenmission));

        // 스파이 미션 초기설정
        String[] spymission = {"1","2","3","4","5","6"};
        // 미션 셔플(매번 랜덤으로 각 스파이마다 미션이 다르게 나오기 위함)
        Collections.shuffle(Arrays.asList(spymission));
        String myrole;
        String mymission;


        for(int i=0; i<totalnum; i++){

            nextbtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                }
            });
        }


    }
}
