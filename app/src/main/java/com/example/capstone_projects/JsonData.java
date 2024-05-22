package com.example.capstone_projects;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class JsonData extends AppCompatActivity {

    private HospitalDataManager hospitalDataManager;

    private TextView hospitalNameTextView;
    private TextView hospitalLocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataload_test);

        hospitalNameTextView = findViewById(R.id.hospitalNameTextView);
        hospitalLocationTextView = findViewById(R.id.hospitalLocationTextView);
        hospitalDataManager = new HospitalDataManager(this);

        // "종류"가 "정형외과"인 병원 데이터 검색
        List<Hospital> orthopedicHospitals = hospitalDataManager.getHospitalsByCategory("영업/정상");

        if (!orthopedicHospitals.isEmpty()) {
            // 첫 번째 병원 정보 가져오기
            Hospital hospital = orthopedicHospitals.get(0);

            // 이름과 위치 정보 텍스트뷰에 설정
            hospitalNameTextView.setText("병원 이름: " + hospital.getName());
            hospitalLocationTextView.setText("위치: " + hospital.getLocation());
        } else {
            // 해당 카테고리의 병원이 없는 경우
            hospitalNameTextView.setText("해당 카테고리의 병원이 없습니다.");
            hospitalLocationTextView.setText("");
        }
    }
}
