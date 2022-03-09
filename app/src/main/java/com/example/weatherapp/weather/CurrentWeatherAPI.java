package com.example.weatherapp.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface CurrentWeatherAPI {
    @GET("v1/current.json")
    Call<CurrentWeather> getCurrentWeather(@Query("key") String API, @Query("q") String city);
}
