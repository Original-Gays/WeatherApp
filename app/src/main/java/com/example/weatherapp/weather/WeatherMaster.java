package com.example.weatherapp.weather;

import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherMaster {
    private static String API = "248a249476cd458ab38140300221902";

    private static Call<CurrentWeather> getCurrentWeather(String city) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.weatherapi.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        CurrentWeatherAPI currentWeatherAPI = retrofit.create(CurrentWeatherAPI.class);

        return currentWeatherAPI.getCurrentWeather(WeatherMaster.API, city);
    }


    // city & place where you should put the data
    public static void setCurrentWeather(String city, TextView where) {
        Call<CurrentWeather> call = getCurrentWeather(city);
        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (response.code() != 200) {
                    return;
                }
                CurrentWeather currentWeather = response.body();
                // putting data
                // change this fckn code from this -->
                Location location = currentWeather.getLocation();
                Current current = currentWeather.getCurrent();
                String res = location.getName() + ", " + location.getRegion() + ", " + location.getCountry() + "\n" +
                             location.getLocaltime() + "\n" +
                             "Temperature: " + current.getTemp_c() + ", " +
                             current.getCondition().getText() + "\n" +
                             "Feels like: " + current.getFeelslike_c() + "\n" +
                             "Wind: " + current.getWind_kph();
                where.setText(res);
                // <-- to this
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                return;
            }
        });
    }
}
