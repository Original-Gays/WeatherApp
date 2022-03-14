package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.util.Log;
import android.util.LogPrinter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;

import com.example.weatherapp.second_activity.ForecastActivity;
import com.example.weatherapp.weather.CurrentWeather;
import com.example.weatherapp.weather.Forecast;
import com.example.weatherapp.weather.ForecastWeather;
import com.example.weatherapp.weather.WeatherMaster;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static void setForecastWeather(ForecastWeather forecastWeather) {
        MainActivity.forecastWeather = forecastWeather;
    }

    public static ForecastWeather getForecastWeather() {
        return forecastWeather;
    }

    private static ForecastWeather forecastWeather = new ForecastWeather();


    private RelativeLayout RLHome, RLGeneralBackG;
    private ImageView IVCurCondition, IVBlockCondition;
    private TextInputEditText EDTCity;
    private TextInputLayout hint;
    private TextView TVCurTemp, TVCondition, TVFeelsLike, TVWindSpeed, TVPressure, TVBlockTitle,
    TVBlockCondition;

    private List<TextView> Titles;
    private List<TextView> ConditionPlaces;
    private List<TextView> Temperatures;
    private List<TextView> MinTemperatures;
    private List<TextView> MaxTemperatures;
    private List<TextView> WindSpeeds;
    private List<TextView> ChancesOfRain;
    private List<ImageView> IconsCondition;

    private RelativeLayout First;
    private RelativeLayout Second;
    private RelativeLayout Third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_new_main);
        //forecastHolder = new ForecastHolder();
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

           First = findViewById(R.id.idRLFirst);
           Second = findViewById(R.id.idRLSecond);
           Third = findViewById(R.id.idRLThird);

           Titles = new ArrayList<TextView>();
           ConditionPlaces = new ArrayList<TextView>();
           Temperatures = new ArrayList<TextView>();
           MinTemperatures = new ArrayList<TextView>();
           MaxTemperatures = new ArrayList<TextView>();
           WindSpeeds = new ArrayList<TextView>();
           ChancesOfRain = new ArrayList<TextView>();
           IconsCondition = new ArrayList<ImageView>();

           Titles.add(findViewById(R.id.idTVTomorrowTitle));
           Titles.add(findViewById(R.id.idTV2BlockTitle));
           Titles.add(findViewById(R.id.idTV3BlockTitle));

           ConditionPlaces.add(findViewById(R.id.idTVTomorrowCondition));
           ConditionPlaces.add(findViewById(R.id.idTV2BlockCondition));
           ConditionPlaces.add(findViewById(R.id.idTV3BlockCondition));

           Temperatures.add(findViewById(R.id.idTV1BlockTemperature));
           Temperatures.add(findViewById(R.id.idTV2BlockTemperature));
           Temperatures.add(findViewById(R.id.idTV3BlockTemperature));

           MinTemperatures.add(findViewById(R.id.idTV1BlockMinTemp));
           MinTemperatures.add(findViewById(R.id.idTV2BlockMinTemp));
           MinTemperatures.add(findViewById(R.id.idTV3BlockMinTemp));

           MaxTemperatures.add(findViewById(R.id.idTV1BlockMaxTemp));
           MaxTemperatures.add(findViewById(R.id.idTV2BlockMaxTemp));
           MaxTemperatures.add(findViewById(R.id.idTV3BlockMaxTemp));

           WindSpeeds.add(findViewById(R.id.idTV1BlockWindSpeed));
           WindSpeeds.add(findViewById(R.id.idTV2BlockWindSpeed));
           WindSpeeds.add(findViewById(R.id.idTV3BlockWindSpeed));

           ChancesOfRain.add(findViewById(R.id.idTV1BlockRainChance));
           ChancesOfRain.add(findViewById(R.id.idTV2BlockRainChance));
           ChancesOfRain.add(findViewById(R.id.idTV3BlockRainChance));

           IconsCondition.add(findViewById(R.id.idIVTomorrowCondition));
           IconsCondition.add(findViewById(R.id.idIV2BlockCondition));
           IconsCondition.add(findViewById(R.id.idIV3BlockCondition));
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
                            try {
                                Thread.sleep(100);
                            }
                            catch (InterruptedException ex) {

                            }
                            WeatherMaster.setForecastWeather(EDTCity.getText().toString(), Titles, ConditionPlaces, Temperatures, MinTemperatures, MaxTemperatures, WindSpeeds, ChancesOfRain, IconsCondition);
                            hint.setHint("");
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        First.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForecastActivity.class);
                intent.putExtra("Day", 0);
                startActivity(intent);
            }
        });

        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForecastActivity.class);
                intent.putExtra("Day", 1);
                startActivity(intent);
            }
        });

        Third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForecastActivity.class);
                intent.putExtra("Day", 2);
                startActivity(intent);
            }
        });
    }
}