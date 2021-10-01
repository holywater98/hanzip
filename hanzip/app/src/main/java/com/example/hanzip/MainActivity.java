package com.example.hanzip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hanzip.investor.InvestorMain;

public class MainActivity extends AppCompatActivity {

    private Button btn_investor; //저는 예비 투자자입니다.
    private Button btn_mentor; //저는 투자 멘토입니다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_mapinvestor = (Button)findViewById(R.id.btn_mapinvestor);
        btn_mapinvestor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InvestorMain.class);
                startActivity(intent);
            }
        });

        btn_investor = findViewById(R.id.btn_investor);
        btn_investor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , investor_Activity.class);
                startActivity(intent); // 투자자 소개란으로 이동
            }
        });

        btn_mentor = findViewById(R.id.btn_mentor);
        btn_mentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , mentor1_Activity.class);
                startActivity(intent); //투자멘토 설명란으로 이
            }
        });
    }



}