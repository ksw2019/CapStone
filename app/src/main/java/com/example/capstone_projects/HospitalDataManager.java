package com.example.capstone_projects;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class HospitalDataManager {
    private Context context;

    public HospitalDataManager(Context context) {
        this.context = context;
    }

    public List<Hospital> loadHospitalData() {
        String jsonString = getJsonDataFromAsset("hospital.json");
        Gson gson = new Gson();
        Type listHospitalType = new TypeToken<List<Hospital>>() {}.getType();
        return gson.fromJson(jsonString, listHospitalType);
    }

    private String getJsonDataFromAsset(String fileName) {
        String json;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public List<Hospital> getHospitalsByCategory(String name) {
        List<Hospital> hospitals = loadHospitalData();
        hospitals.removeIf(hospital -> !hospital.getName().equals(name));
        return hospitals;
    }
}

class Hospital {
    private String name;
    private String location;
    private String category;
    // Constructor, getters, and setters
    public Hospital(String name, String location,String category) {
        this.name = name;
        this.location = location;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

