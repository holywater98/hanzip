package com.example.hanzip.investor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hanzip.R;

public class ApartInfo extends Fragment {

    public static ApartInfo newInstance(){
        return new ApartInfo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.activity_apart_info,container,false);

        Button detail_btn = (Button) view.findViewById(R.id.btn_detail);
        detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((InvestorMain)getActivity()).replaceFragment(ApartMoreInfo.newInstance());

            }
        });
        return view;
    }
}