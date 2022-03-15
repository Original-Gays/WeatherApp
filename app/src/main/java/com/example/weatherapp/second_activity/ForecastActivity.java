package com.example.weatherapp.second_activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.MainActivity;
import com.example.weatherapp.R;
import com.example.weatherapp.weather.Condition;
import com.example.weatherapp.weather.Current;
import com.example.weatherapp.weather.Day;
import com.example.weatherapp.weather.DayWeather;
import com.example.weatherapp.weather.Forecast;
import com.example.weatherapp.weather.ForecastWeather;
import com.example.weatherapp.weather.Hour;
import com.example.weatherapp.weather.Location;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import design.ImageHandler;

public class ForecastActivity extends AppCompatActivity {
    private ForecastWeather forecastWeather;
    private Forecast forecast;
    private Location location;
    private Day day;
    private DayWeather dayWeather;
    private Condition condition;
    private List<Hour> hours;

    private RelativeLayout GeneralBack;
    private int whichDay;

    private TextView TVCity;
    private TextView TVDate;
    private TextView TVTemp;
    private TextView TVCondition;
    private TextView TVMaxMinTemp;

    private String Date;

    private ArrayList<HourItem> hourItems;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private recyclerAdapter recycleradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_day);

        Intent receiver = getIntent();
        whichDay = receiver.getIntExtra("Day", 0);
        GeneralBack = findViewById(R.id.idRLGeneralBack);

        TVCity = findViewById(R.id.idTVCity);
        TVDate = findViewById(R.id.idTVDate);
        TVTemp = findViewById(R.id.idTemp);
        TVCondition = findViewById(R.id.idCond);
        TVMaxMinTemp = findViewById(R.id.idMaxMinTemp);


        forecastWeather = MainActivity.getForecastWeather();
        location = forecastWeather.getLocation();
        forecast = forecastWeather.getForecast();
        day = forecast.getForecastday().get(whichDay);
        dayWeather = day.getDay();
        Date = day.getDate();
        condition = dayWeather.getCondition();
        hours = day.getHour();

        hourItems = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        TVCity.setText(location.getName());

        switch ("" + Date.charAt(5) + Date.charAt(6)) {
            case "01":
                TVDate.setText("January " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "02":
                TVDate.setText("February " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "03":
                TVDate.setText("March " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "04":
                TVDate.setText("April " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "05":
                TVDate.setText("May " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "06":
                TVDate.setText("June " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "07":
                TVDate.setText("July " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "08":
                TVDate.setText("August " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "09":
                TVDate.setText("September " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "10":
                TVDate.setText("October " +((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "11":
                TVDate.setText("November " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
            case "12":
                TVDate.setText("December " + ((Date.charAt(8) == '0') ? "" : Date.charAt(8)) + Date.charAt(9));
                break;
        }

        ImageHandler.setBackGround(condition.getCode(), GeneralBack, (whichDay == 0 ? forecastWeather.getCurrent().isIs_day() : 1));
        TVTemp.setText(dayWeather.getAvgtemp_c() + "°");
        TVCondition.setText(condition.getText());
        TVMaxMinTemp.setText("↑" + dayWeather.getMaxtemp_c() + "°   ↓" + dayWeather.getMintemp_c() + "°");


        fillHours();
        makegraph();
    }

    private void fillHours() {
        for (int i = 1; i <= 12; i++) {
            hourItems.add(new HourItem(i + "AM", hours.get(i).getCondition().getCode(), hours.get(i).getTemp_c() + "°"));
        }
        for (int i = 13; i < 24; i++) {
            hourItems.add(new HourItem(i + "PM", hours.get(i).getCondition().getCode(), hours.get(i).getTemp_c() + "°"));
        }
        hourItems.add(new HourItem(24 + "AM", hours.get(0).getCondition().getCode(), hours.get(0).getTemp_c() + "°"));
        recycleradapter = new recyclerAdapter(hourItems);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycleradapter);
    }

    private void makegraph() {
        ArrayList<Entry> temperature = new ArrayList<>();
        LineChart lineChart = findViewById(R.id.idLCGraph);

        for (int i = 0; i < 24; i++) {
            temperature.add(new Entry(i, (float)hours.get(i).getTemp_c()));
        }

        LineDataSet lineDataSet = new LineDataSet(temperature, "Temperature");

        lineDataSet.setColor(Color.WHITE);
        lineDataSet.setLineWidth(3f);
        lineDataSet.setDrawValues(false);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setMode(LineDataSet.Mode.LINEAR);
        lineDataSet.setDrawFilled(false);

        LineData lineData = new LineData(lineDataSet);
        lineData.setDrawValues(true);
        lineData.setValueTextSize(16f);
        lineData.setValueTextColor(Color.WHITE);

        lineChart.setData(lineData);

        lineChart.getLegend().setEnabled(false);
        lineChart.getXAxis().setEnabled(false);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getAxisRight().setEnabled(false);

    }
}
