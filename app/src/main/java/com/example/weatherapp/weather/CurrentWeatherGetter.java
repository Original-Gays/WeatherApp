package com.example.weatherapp.weather;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrentWeatherGetter {
    private static String API = "248a249476cd458ab38140300221902";

    private static Call<CurrentWeather> Parse(String city) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.weatherapi.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        CurrentWeatherAPI currentWeatherAPI = retrofit.create(CurrentWeatherAPI.class);

        return currentWeatherAPI.getCurrentWeather(CurrentWeatherGetter.API, city);
    }

    public static void getCurrentWeatherMetric(String city, TextView Temperature, TextView Condition, TextView CityName, ImageView CondIcon, ImageView Background) {
        Call<CurrentWeather> call = Parse(city);
        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (response.code() != 200) {
                    return;
                }
                CurrentWeather currentWeather = response.body();
                Location location = currentWeather.getLocation();
                Current current = currentWeather.getCurrent();

                CityName.setText(location.getName());
                Temperature.setText(current.getTemp_c()+"°C");
                Condition.setText(current.getCondition().getText());
                Picasso.get().load("https:"+current.getCondition().getIcon()).into(CondIcon);

                if (current.isIs_day() == 1)
                {
                    Picasso.get().load("https://images.unsplash.com/photo-1548670123-2d3bb97f4678?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80").into(Background);
                }
                else
                {
                    Picasso.get().load("https://images.unsplash.com/photo-1454177697940-c43d9f9a7307?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80").into(Background);
                }

                /*String res = location.getName() + ", " + location.getRegion() + ", " + location.getCountry() + "\n" +
                             location.getLocaltime() + "\n" +
                             "Temperature: " + current.getTemp_c() + ", " +
                             current.getCondition().getText() + "\n" +
                             "Feels like: " + current.getFeelslike_c() + "\n" +
                             "Wind: " + current.getWind_kph();
                dataPlace.setText(res);*/
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                return;
            }
        });
    }

    public static String getCurrentWeatherGaySystem(String city) {
        return "sada";
    }
}
