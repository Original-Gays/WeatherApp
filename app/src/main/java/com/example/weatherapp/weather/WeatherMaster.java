package com.example.weatherapp.weather;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import design.ImageHandler;

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

    public static Call<ForecastWeather> getForecastWeather(String city, int days) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.weatherapi.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        ForecastWeatherAPI forecastWeatherAPI = retrofit.create(ForecastWeatherAPI.class);

        return forecastWeatherAPI.getForecastWeather(WeatherMaster.API, city, days);
    }


    // city & place where you should put the data
    public static void setCurrentWeather(String city, TextView currentTemp, TextView currentCond, RelativeLayout layoutBG, ImageView curConditionimage, TextView feelsLike,TextView windSpeed, TextView curPressure) {
        Call<CurrentWeather> call = getCurrentWeather(city);
        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (response.code() != 200) {
                    return;
                }
                CurrentWeather currentWeather = response.body();
                WeatherMaster.currentWeather(currentWeather, currentTemp, currentCond, layoutBG, curConditionimage, feelsLike, windSpeed, curPressure);
            }
            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                return;
            }
        });
    }

    public static void setForecastWeather(String city, int days, TextView where) {
        Call<ForecastWeather> call = getForecastWeather(city, days);
        call.enqueue(new Callback<ForecastWeather>() {
            @Override
            public void onResponse(Call<ForecastWeather> call, Response<ForecastWeather> response) {
                if (response.code() != 200) {
                    return;
                }
                ForecastWeather forecastWeather = response.body();
                // change this fckn code from this -->
                //WeatherMaster.testForecastWeather(forecastWeather, where);
                // <-- to this \\ instead of tests put ur code
            }

            @Override
            public void onFailure(Call<ForecastWeather> call, Throwable t) {
                return;
            }
        });
    }

    public static void currentWeather(CurrentWeather currentWeather, TextView curTemp, TextView curCond, RelativeLayout bg, ImageView condIV, TextView feelsLike, TextView windSpeed, TextView curPressure)
    {

        Location location = currentWeather.getLocation();
        Current current = currentWeather.getCurrent();

        int is_day = current.isIs_day();
        int condition_code = current.getCondition().getCode();
        ImageHandler.setBackGround(condition_code, bg, is_day);
        curTemp.setText(current.getTemp_c() + "℃");
        curPressure.setText(current.getPressure_mb() + " Mb");
        curCond.setText(current.getCondition().getText());
        windSpeed.setText(current.getWind_kph()+ " Kp/h");
        feelsLike.setText("Feels like " + current.getFeelslike_c() +"℃");
        Picasso.get().load("https:"+current.getCondition().getIcon()).into(condIV);
    }

    public static void testCurrentWeather(CurrentWeather currentWeather, TextView where) {
        Location location = currentWeather.getLocation();
        Current current = currentWeather.getCurrent();
        String res = location.getName() + ", " + location.getRegion() + ", " + location.getCountry() + "\n" +
                location.getLocaltime() + "\n" +
                "Temperature: " + current.getTemp_c() + ", " +
                current.getCondition().getText() + "\n" +
                "Feels like: " + current.getFeelslike_c() + "\n" +
                "Wind: " + current.getWind_kph();
        where.setText(res);
    }

    public static void testForecastWeather(ForecastWeather forecastWeather, TextView where) {
        Forecast forecast = forecastWeather.getForecast();
        String res = "";
        for (Day day: forecast.getForecastday()) {
            res += day.getDate() + "\n";
        }
        where.setText(res);
    }
}
