package com.example.weatherapp.weather;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.weatherapp.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import design.ImageHandler;


public class WeatherMaster {
    private static final String API = "248a249476cd458ab38140300221902";
    private static final int DAYS = 3;

    private static Call<CurrentWeather> getCurrentWeather(String city) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.weatherapi.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        CurrentWeatherAPI currentWeatherAPI = retrofit.create(CurrentWeatherAPI.class);

        return currentWeatherAPI.getCurrentWeather(WeatherMaster.API, city);
    }

    public static Call<ForecastWeather> getForecastWeather(String city) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.weatherapi.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        ForecastWeatherAPI forecastWeatherAPI = retrofit.create(ForecastWeatherAPI.class);

        return forecastWeatherAPI.getForecastWeather(WeatherMaster.API, city, DAYS, "no", "no");
    }

    public static void setCurrentWeather(String city, TextView currentTemp, TextView currentCond, RelativeLayout layoutBG, ImageView curConditionimage, TextView feelsLike,TextView windSpeed, TextView curPressure) {
        Call<CurrentWeather> call = getCurrentWeather(city);
        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (response.code() != 200) {
                    return;
                }
                CurrentWeather currentWeather = response.body();
                Location location = currentWeather.getLocation();
                Current current = currentWeather.getCurrent();

                int is_day = current.isIs_day();
                int condition_code = current.getCondition().getCode();
                ImageHandler.setBackGroundAndCondition(condition_code, layoutBG, is_day, curConditionimage);
                currentTemp.setText(current.getTemp_c() + "℃");
                curPressure.setText(current.getPressure_mb() + " Mb");
                currentCond.setText(current.getCondition().getText());
                windSpeed.setText(current.getWind_kph()+ " Kp/h");
                feelsLike.setText("Feels like " + current.getFeelslike_c() +"℃");
            }
            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                return;
            }
        });
    }

    public static void setForecastWeather(String city, List<TextView> Title, List<TextView> ConditionPlace, List<TextView> Temperature, List<TextView> MinTemp, List<TextView> MaxTemp, List<TextView> WindSpeed, List<TextView> ChanceOfRain, List<ImageView> IconCondition) {
        Call<ForecastWeather> call = getForecastWeather(city);
        call.enqueue(new Callback<ForecastWeather>() {
            @Override
            public void onResponse(Call<ForecastWeather> call, Response<ForecastWeather> response) {
                if (response.code() != 200) {
                    return;
                }
                ForecastWeather forecastWeather = response.body();
                Forecast forecast = forecastWeather.getForecast();
                MainActivity.setForecastWeather(forecastWeather);
                List<Day> days = forecast.getForecastday();
                for (int i = 0; i < DAYS; i++) {
                    Day day = days.get(i);
                    DayWeather dayWeather = day.getDay();
                    Condition condition = dayWeather.getCondition();

                    Title.get(i).setText(day.getDate());
                    ConditionPlace.get(i).setText(condition.getText());
                    Temperature.get(i).setText(dayWeather.getAvgtemp_c() + "℃");
                    MinTemp.get(i).setText(dayWeather.getMintemp_c() + "℃");
                    MaxTemp.get(i).setText(dayWeather.getMaxtemp_c() + "℃");
                    WindSpeed.get(i).setText(dayWeather.getMaxwind_kph() + " Kp/h");
                    ChanceOfRain.get(i).setText("" + dayWeather.getDaily_chance_of_rain());
                    ImageHandler.setCondition(condition.getCode(), IconCondition.get(i));
                }

            }

            @Override
            public void onFailure(Call<ForecastWeather> call, Throwable t) {
                return;
            }
        });
    }



}
