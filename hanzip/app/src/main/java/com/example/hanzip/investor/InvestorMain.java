package com.example.hanzip.investor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.hanzip.R;

public class InvestorMain extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private ApartInfo apartinfo;
    private InvestorMypage mypage;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investor_main);

        fragmentManager = getSupportFragmentManager();

        apartinfo = new ApartInfo();
        mypage = new InvestorMypage();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, apartinfo).commitAllowingStateLoss();
    }

    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();

        switch(view.getId())
        {
            case R.id.btn_fragmentA:
                transaction.replace(R.id.frameLayout, apartinfo).commitAllowingStateLoss();
                break;
//            case R.id.btn_fragmentB:
//                transaction.replace(R.id.frameLayout, apartinfo).commitAllowingStateLoss();
//                break;
//            case R.id.btn_fragmentC:
//                transaction.replace(R.id.frameLayout, apartinfo).commitAllowingStateLoss();
//                break;
            case R.id.btn_fragmentD:
                transaction.replace(R.id.frameLayout, mypage).commitAllowingStateLoss();
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
}