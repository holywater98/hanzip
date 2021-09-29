package com.example.hanzip.investor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hanzip.R;

public class Payment extends AppCompatActivity {

    public static Payment newInstance(){
        return new Payment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }
}