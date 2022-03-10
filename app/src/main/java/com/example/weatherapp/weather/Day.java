package com.example.weatherapp.weather;

import java.util.List;

public class Day {
    private String date;
    private long date_epoch;
    private DayWeather day;
    private Astro astro;
    private List<Hour> hour;

    public String getDate() {
        return date;
    }

    public long getDate_epoch() {
        return date_epoch;
    }

    public DayWeather getDay() {
        return day;
    }

    public Astro getAstro() {
        return astro;
    }

    public List<Hour> getHour() {
        return hour;
    }
}
