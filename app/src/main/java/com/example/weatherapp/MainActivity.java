package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.weatherapp.weather.CurrentWeatherGetter;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    /*private EditText enteredData;
    private TextView dataPlace;*/

    private RelativeLayout RLHome;
    private ImageView IVBack, IVSearchIcon, IVConditionIcon;
    private TextView TVTemperature, TVCondition, TVCityName;
    private TextInputEditText EDTCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_main);

        RLHome = findViewById(R.id.idRLHome);
        IVBack = findViewById(R.id.idIVBack);
        IVSearchIcon = findViewById(R.id.idIVSearchIcon);
        IVConditionIcon = findViewById(R.id.idIVConditionIcon);
        TVTemperature = findViewById(R.id.idTVTemperature);
        TVCondition = findViewById(R.id.idTVCondition);
        TVCityName = findViewById(R.id.idTVCityName);
        EDTCity = findViewById(R.id.idEDTCity);

        IVSearchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWeather(view);
            }
        });

        /*enteredData = findViewById(R.id.gettingData);
        dataPlace = findViewById(R.id.data_place);*/

    }

    public void getWeather(View view) {
        /*CurrentWeatherGetter.getCurrentWeatherMetric(EDTCity.getText().toString(), TVCityName);
        EDTCity.setText("");*/
        CurrentWeatherGetter.getCurrentWeatherMetric(EDTCity.getText().toString(), TVTemperature, TVCondition, TVCityName, IVConditionIcon, IVBack);
        EDTCity.setText("");
    }
}