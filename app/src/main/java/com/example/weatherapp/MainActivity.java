package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import com.example.weatherapp.weather.CurrentWeather;
import com.example.weatherapp.weather.WeatherMaster;

public class MainActivity extends AppCompatActivity {

    private EditText enteredData;
    private TextView dataPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredData = findViewById(R.id.gettingData);
        dataPlace = findViewById(R.id.data_place);
    }

    public void getWeather(View view) {
        //WeatherMaster.setCurrentWeather(enteredData.getText().toString(), dataPlace);
        WeatherMaster.setForecastWeather(enteredData.getText().toString(), 3, dataPlace);
    }

    public void updateWeather() {

    }
}