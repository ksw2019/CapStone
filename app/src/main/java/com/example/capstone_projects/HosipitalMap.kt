package com.example.capstone_projects

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.map.NaverMapSdk

class HosipitalMap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hosipital_map)

        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("xsilryo4zj")

    }
}
