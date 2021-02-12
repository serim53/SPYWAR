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
        TextView missionis = (TextView) findViewById(R.id.missionis);
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
        String[] citizenmission = {
                "'눈치게임 1'을 외치고 \n다른 사람들이 받아줘서 \n4까지 간다면 성공! \n성공시 사회자에게 \n스파이에 대한 \n추상힌트를 요구할 수 있다",
                "2명의 어깨를 들키지 않고 \n털어주면 성공! \n성공시 사회자에게 \n스파이에 대한 \n추상힌트를 요구할 수 있다",
                "[비밀경찰] \n스파이를 찾아 \n사회자에게 카톡으로 알려라! \n당신이 고발한 사람이 \n스파이라면 스파이아웃, \n틀렸다면 당신이 아웃된다.",
                "2명에게 물을 따라주던, 건내주던 \n권하는 행동을 하여 \n마시게 하면 성공! \n성공시 사회자에게 \n스파이에 대한 \n추상힌트를 요구할 수 있다",
                "양옆 사람의 손을 사진 찍어 \n사회자에게 보내면 성공! \n성공시 사회자에게 \n스파이에 대한 \n추상힌트를 요구할 수 있다",
                "모두를 자리에서 \n일어나게하면 성공! \n성공시 사회자에게 \n스파이에 대한 \n추상힌트를 요구할 수 있다"
        };
        // 미션 셔플(매번 랜덤으로 각 시민마다 미션이 다르게 나오기 위함)
        Collections.shuffle(Arrays.asList(citizenmission));

        // 스파이 미션 초기설정
        String[] spymission = {
                "사회자와 함께 특정 단어를 정하고 \n시민이 그 단어를 말하게 할 것. \n단어를 말한 시민은 아웃!",
                "시민들의 물건을 하나씩 몰래 훔쳐 \n사회자에게 모두 전달하면 \n스파이 우승!",
                "사회자와 함께 특정 물건을 정하고 \n시민이 그 물건을 만지게 할 것. \n물건을 만진 시민은 아웃!",
                "자신있는 게임을 시작해라. \n3번 이상 top2에 든다면 스파이 우승, \n2번 이상 탈락순서 2인이 된다면 \n스파이 아웃.",
                "[자유미션] \n사회자와 함께 미션을 정해라. \n단, 너무 쉽지 않도록 \n사회자가 난이도를 조절해줄 것."
        };
        // 미션 셔플(매번 랜덤으로 각 스파이마다 미션이 다르게 나오기 위함)
        Collections.shuffle(Arrays.asList(spymission));


        // 사회자에게 모두의 미션을 알려주기 위해 저장
        ArrayList<String> tomoderator = new ArrayList<String>();


        final int[] index = {0}; // 버튼 클릭 횟수

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 버튼을 누른 횟수가 totalnum(전체 인원)이 될 때까지만 실행됨.
                if (index[0] <= totalnum){

                    // 다시 버튼을 클릭시 역할과 미션이 가시화가 됨.
                    roletext.setVisibility(View.VISIBLE);
                    missiontext.setVisibility(View.VISIBLE);

                    missionis.setVisibility(View.VISIBLE);

                    roletext.setText(roles.get(index[0]));

                    if(roles.get(index[0])=="시민"){
                        missiontext.setText(citizenmission[index[0]]);
                        tomoderator.add(citizenmission[index[0]]);
                    }
                    else if(roles.get(index[0])=="SPY"){
                        missiontext.setText(spymission[index[0]]);
                        tomoderator.add(spymission[index[0]]);
                    }
                    else if(roles.get(index[0])=="사회자"){
                        missiontext.setText("당신은 사회자. \n시민과 스파이들의 미션을 \n확인하고 \n게임을 진행하세요! ");
                        missionis.setVisibility(View.GONE);
                    }

                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        public void run() {

                            // 다음 사람에게 이전 사람의 역할과 미션이 보이지 않도록
                            // 미션을 확인할 6초가 지나면 확인하는 사람의 미션과 역할 text가 안보이게 됨
                            roletext.setVisibility(View.INVISIBLE);
                            missiontext.setVisibility(View.INVISIBLE);
                                }
                             }, 6000); // 6초후

                    // 버튼을 클릭할 때마다 클릭 횟수가 증가하여 role이 겹치지 않게 설정됨.
                    index[0] = index[0] +1;
                }
                else if((index[0] > totalnum)){
                    // 인텐트 선언 : 현재 엑티비티, 넘어갈 엑티비티
                    Intent intent = new Intent(TalkRole.this, Talknumber.class);
                    // 인텐트 실행
                    startActivity(intent);
                }

            }
        });


    }
}
