package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weatherapp.weather.CurrentWeatherGetter;

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
        CurrentWeatherGetter.getCurrentWeatherMetric(enteredData.getText().toString(), dataPlace);
        enteredData.setText("");
    }
}