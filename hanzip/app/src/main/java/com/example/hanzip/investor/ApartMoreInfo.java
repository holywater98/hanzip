package com.example.hanzip.investor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hanzip.R;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;

public class ApartMoreInfo extends Fragment implements OnMapReadyCallback {
    private MapView mapView;

    public static ApartMoreInfo newInstance(){
        return new ApartMoreInfo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.activity_apart_more_info,container,false);

        mapView = view.findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);

        naverMapBasicSettings();
        return view;
    }

    private void naverMapBasicSettings() {
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        UiSettings uiSettings = naverMap.getUiSettings();

        uiSettings.setLocationButtonEnabled(false);

        naverMap.setMapType(NaverMap.MapType.Basic);
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRANSIT, false);

        LatLng coord = new LatLng(37.5148834,127.0835543);


    }
}