package com.example.spacestationv2.View;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//Bar Chart
import com.example.spacestationv2.Model.Api;
import com.example.spacestationv2.Model.RepositoryHumidity;
import com.example.spacestationv2.Model.Servo;
import com.example.spacestationv2.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.spacestationv2.ViewModel.RestAdapter.getUnsafeOkHttpClient;

public class AllStatsFragment extends Fragment {
    public BarChart mpBarChart;
    public Button spinButton;
    private RepositoryHumidity repo;
    private Api api;
    private Gson gson;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_stats, container, false);
        mpBarChart = view.findViewById(R.id.barChart);
        spinButton = view.findViewById(R.id.Spin);
        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinServo();
            }
        });

        BarDataSet barDataSet1 = new BarDataSet(barEntries1(), "CO2");
        barDataSet1.setColors(Color.RED);
        BarDataSet barDataSet2 = new BarDataSet(barEntries2(), "Humidity");
        barDataSet2.setColors(Color.BLUE);
        BarDataSet barDataSet3 = new BarDataSet(barEntries3(), "Luminosity");
        barDataSet3.setColors(Color.YELLOW);


        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3);
        mpBarChart.setData(data);

        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        XAxis xAxis = mpBarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        mpBarChart.setDragEnabled(true);
        mpBarChart.setVisibleXRangeMaximum(3);

        float barSpace = 0.05f;
        float groupSpace = 0.16f;
        data.setBarWidth(0.16f);

        mpBarChart.getXAxis().setAxisMinimum(0);
        mpBarChart.getXAxis().setAxisMaximum(0 + mpBarChart.getBarData().getGroupWidth(groupSpace, barSpace) * 7);
        mpBarChart.getAxisLeft().setAxisMinimum(0);

        mpBarChart.groupBars(0, groupSpace, barSpace);

        mpBarChart.invalidate();
        return view;
    }

    private ArrayList<BarEntry> barEntries1() {

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1, 900));
        barEntries.add(new BarEntry(2, 500));
        barEntries.add(new BarEntry(3, 2000));
        barEntries.add(new BarEntry(4, 1500));
        barEntries.add(new BarEntry(5, 690));
        barEntries.add(new BarEntry(6, 2400));
        barEntries.add(new BarEntry(7, 1700));

        return barEntries;
    }

    private ArrayList<BarEntry> barEntries2() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 300));
        barEntries.add(new BarEntry(2, 900));
        barEntries.add(new BarEntry(3, 500));
        barEntries.add(new BarEntry(4, 1000));
        barEntries.add(new BarEntry(5, 2000));
        barEntries.add(new BarEntry(6, 1000));
        barEntries.add(new BarEntry(7, 1200));
        return barEntries;
    }

    private ArrayList<BarEntry> barEntries3() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 700));
        barEntries.add(new BarEntry(2, 1000));
        barEntries.add(new BarEntry(3, 300));
        barEntries.add(new BarEntry(4, 1200));
        barEntries.add(new BarEntry(5, 2100));
        barEntries.add(new BarEntry(6, 1300));
        barEntries.add(new BarEntry(7, 1500));
        return barEntries;
    }

    public void spinServo() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = getUnsafeOkHttpClient();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Retrofit retro = new Retrofit.Builder().baseUrl("https://10.0.2.2:5001/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
        api = retro.create(Api.class);


        Servo servo = new Servo(1, true, new Date(2020, 06, 04));
        String serialize = gson.toJson(servo);
        Call<Servo> servoCall = api.createPost("toilet", serialize);
        servoCall.enqueue(new Callback<Servo>() {
            @Override
            public void onResponse(Call<Servo> call, Response<Servo> response) {
                String random = response.body() + "";
                Toast.makeText(getContext().getApplicationContext(), random, Toast.LENGTH_SHORT);
            }

            @Override
            public void onFailure(Call<Servo> call, Throwable t) {
                t.getMessage();
            }
        });
    }

}

