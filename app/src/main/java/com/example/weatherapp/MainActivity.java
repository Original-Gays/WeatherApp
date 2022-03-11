package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;

import com.example.weatherapp.weather.CurrentWeather;
import com.example.weatherapp.weather.WeatherMaster;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout RLHome, RLGeneralBackG;
    private ImageView IVCurCondition, IVBlockCondition;
    private TextInputEditText EDTCity;
    private TextInputLayout hint;
    private TextView TVCurTemp, TVCondition, TVFeelsLike, TVWindSpeed, TVPressure, TVBlockTitle,
    TVBlockCondition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_new_main);
        {
       RLHome = findViewById(R.id.idRLHome);
       EDTCity = findViewById(R.id.idEDTCity);
       hint = findViewById(R.id.idTILCity);
       RLGeneralBackG = findViewById(R.id.idRLGeneralBack);
       TVCurTemp = findViewById(R.id.idTVCurTemp);
       TVCondition= findViewById(R.id.idTVCondition);
       IVCurCondition = findViewById(R.id.idIVConditionIconN);
       TVFeelsLike = findViewById(R.id.idTVFeelsLike);
       TVWindSpeed = findViewById(R.id.idTVWindSpeed);
       TVPressure = findViewById(R.id.idTVPressure);
       TVBlockTitle = findViewById(R.id.idTVTomorrowTitle);
       TVBlockCondition = findViewById(R.id.idTVTomorrowCondition);
       IVBlockCondition = findViewById(R.id.idIVTomorrowCondition);
        }

       EDTCity.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
       EDTCity.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            WeatherMaster.setCurrentWeather(EDTCity.getText().toString(), TVCurTemp, TVCondition, RLGeneralBackG, IVCurCondition, TVFeelsLike, TVWindSpeed, TVPressure);
                            //WeatherMaster.setForecastWeather(EDTCity.getText().toString(), 1, TVBlockTitle, TVBlockCondition, block_avgTemp, block_minTemp, block_maxTemp, block_windSpeed, block_rainChance, IVBlockCondition);
                            hint.setHint("");
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

    }

    public void getWeather(View view) {
        //WeatherMaster.setCurrentWeather(enteredData.getText().toString(), dataPlace);
        //WeatherMaster.setForecastWeather(enteredData.getText().toString(), 3, dataPlace);
    }

    public void updateWeather() {

    }
}