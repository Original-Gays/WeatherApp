package com.example.weatherapp.weather;

public class Hour {
    private long time_epoch;
    private String time;
    private double temp_c;
    private double temp_f;
    private int is_day;
    private Condition condition;
    private double wind_mph;
    private double wind_kph;
    private int wind_degree;
    private String wind_dir;
    private double pressure_mb;
    private double pressure_in;
    private double precip_mm;
    private double precip_in;
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private double feelslike_f;
    private double windchill_c;
    private double windchill_f;
    private double heatindex_c;
    private double heatindex_f;
    private double dewpoint_c;
    private double dewpoint_f;
    private int will_it_rain;
    private int chance_of_rain;
    private int will_it_snow;
    private int chance_of_snow;
    private double vis_km;
    private double vis_miles;
    private double gust_mph;
    private double gust_kph;
    private double uv;

    public long getTime_epoch() {
        return time_epoch;
    }

    public String getTime() {
        return time;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public double getTemp_f() {
        return temp_f;
    }

    public int getIs_day() {
        return is_day;
    }

    public Condition getCondition() {
        return condition;
    }

    public double getWind_mph() {
        return wind_mph;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public double getPressure_mb() {
        return pressure_mb;
    }

    public double getPressure_in() {
        return pressure_in;
    }

    public double getPrecip_mm() {
        return precip_mm;
    }

    public double getPrecip_in() {
        return precip_in;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public double getFeelslike_f() {
        return feelslike_f;
    }

    public double getWindchill_c() {
        return windchill_c;
    }

    public double getWindchill_f() {
        return windchill_f;
    }

    public double getHeatindex_c() {
        return heatindex_c;
    }

    public double getHeatindex_f() {
        return heatindex_f;
    }

    public double getDewpoint_c() {
        return dewpoint_c;
    }

    public double getDewpoint_f() {
        return dewpoint_f;
    }

    public int getWill_it_rain() {
        return will_it_rain;
    }

    public int getChance_of_rain() {
        return chance_of_rain;
    }

    public int getWill_it_snow() {
        return will_it_snow;
    }

    public int getChance_of_snow() {
        return chance_of_snow;
    }

    public double getVis_km() {
        return vis_km;
    }

    public double getVis_miles() {
        return vis_miles;
    }

    public double getGust_mph() {
        return gust_mph;
    }

    public double getGust_kph() {
        return gust_kph;
    }

    public double getUv() {
        return uv;
    }
}
