package com.example.weatherapp.weather;

public class DayWeather {
    private double maxtemp_c;
    private double maxtemp_f;
    private double mintemp_c;
    private double mintemp_f;
    private double avgtemp_c;
    private double avgtemp_f;
    private double maxwind_mph;
    private double maxwind_kph;
    private double totalprecip_mm;
    private double totalprecip_in;
    private double avgvis_km;
    private double avgvis_miles;
    private double avghumidity;
    private int daily_will_it_rain;
    private int daily_chance_of_rain;
    private int daily_will_it_snow;
    private int daily_chance_of_snow;
    private Condition condition;
    private double uv;

    public double getMaxtemp_c() {
        return maxtemp_c;
    }

    public double getMaxtemp_f() {
        return maxtemp_f;
    }

    public double getMintemp_c() {
        return mintemp_c;
    }

    public double getMintemp_f() {
        return mintemp_f;
    }

    public double getAvgtemp_c() {
        return avgtemp_c;
    }

    public double getAvgtemp_f() {
        return avgtemp_f;
    }

    public double getMaxwind_mph() {
        return maxwind_mph;
    }

    public double getMaxwind_kph() {
        return maxwind_kph;
    }

    public double getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public double getTotalprecip_in() {
        return totalprecip_in;
    }

    public double getAvgvis_km() {
        return avgvis_km;
    }

    public double getAvgvis_miles() {
        return avgvis_miles;
    }

    public double getAvghumidity() {
        return avghumidity;
    }

    public int getDaily_will_it_rain() {
        return daily_will_it_rain;
    }

    public int getDaily_chance_of_rain() {
        return daily_chance_of_rain;
    }

    public int getDaily_will_it_snow() {
        return daily_will_it_snow;
    }

    public int getDaily_chance_of_snow() {
        return daily_chance_of_snow;
    }

    public Condition getCondition() {
        return condition;
    }

    public double getUv() {
        return uv;
    }
}
