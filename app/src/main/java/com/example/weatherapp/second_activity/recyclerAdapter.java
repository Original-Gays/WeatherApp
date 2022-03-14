package com.example.weatherapp.second_activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;

import java.util.ArrayList;

import design.ImageHandler;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<HourItem> hours;

    public recyclerAdapter(ArrayList<HourItem> hours)
    {
        this.hours = hours;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView time;
        private ImageView condition;
        private TextView temperature;

        public MyViewHolder(final View view) {
            super(view);
            time = view.findViewById(R.id.textView2);
            condition = view.findViewById(R.id.imageView);
            temperature = view.findViewById(R.id.textView4);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View hourView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hour_item, parent, false);
        return new MyViewHolder(hourView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String timeStr = hours.get(position).getTime();
        int conditionStr = hours.get(position).getCondition();
        String temperatureStr = hours.get(position).getTemperature();

        holder.time.setText(timeStr);
        ImageHandler.setCondition(conditionStr, holder.condition);
        holder.temperature.setText(temperatureStr);
    }

    @Override
    public int getItemCount() {
        return hours.size();
    }
}
