package com.example.weatherapp.second_activity;

import android.widget.ImageView;
import android.widget.TextView;

public class HourItem {
    private String time;
    private int condition;
    private String temperature;

    public HourItem(String time, int condition, String temperature)
    {
        this.time = time;
        this.condition = condition;
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
