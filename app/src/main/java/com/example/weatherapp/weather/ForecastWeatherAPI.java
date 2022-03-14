package com.example.weatherapp.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface ForecastWeatherAPI {
    @GET("v1/forecast.json")
    Call<ForecastWeather> getForecastWeather(@Query("key") String API, @Query("q") String city, @Query("days") int days, @Query("aqi") String aqi, @Query("alerts") String alerts);
}
