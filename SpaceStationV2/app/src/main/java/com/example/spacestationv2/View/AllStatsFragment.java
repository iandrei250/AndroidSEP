package com.example.spacestationv2.View;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//Bar Chart
import com.example.spacestationv2.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class AllStatsFragment extends Fragment {
    public BarChart mpBarChart;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_stats, container, false);
        mpBarChart = view.findViewById(R.id.barChart);




    BarDataSet barDataSet1=new BarDataSet(barEntries1(),"CO2");
        barDataSet1.setColors(Color.RED);
    BarDataSet barDataSet2=new BarDataSet(barEntries2(),"Humidity");
        barDataSet2.setColors(Color.BLUE);
    BarDataSet barDataSet3=new BarDataSet(barEntries3(),"Luminosity");
        barDataSet3.setColors(Color.YELLOW);


    BarData data = new BarData(barDataSet1,barDataSet2,barDataSet3);
        mpBarChart.setData(data);

    String[] days=new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    XAxis xAxis=mpBarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        mpBarChart.setDragEnabled(true);
        mpBarChart.setVisibleXRangeMaximum(3);

    float barSpace=0.05f;
    float groupSpace=0.16f;
        data.setBarWidth(0.16f);

        mpBarChart.getXAxis().setAxisMinimum(0);
        mpBarChart.getXAxis().setAxisMaximum(0+mpBarChart.getBarData().getGroupWidth(groupSpace,barSpace)*7);
        mpBarChart.getAxisLeft().setAxisMinimum(0);

        mpBarChart.groupBars(0,groupSpace,barSpace);

        mpBarChart.invalidate();
        return view;
}

    private ArrayList<BarEntry> barEntries1()
    {
        ArrayList<BarEntry>barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(1,900));
        barEntries.add(new BarEntry(2,500));
        barEntries.add(new BarEntry(3,2000));
        barEntries.add(new BarEntry(4,1500));
        barEntries.add(new BarEntry(5,690));
        barEntries.add(new BarEntry(6,2400));
        barEntries.add(new BarEntry(7,1700));
        return barEntries;
    }
    private ArrayList<BarEntry>barEntries2()
    {
        ArrayList<BarEntry>barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(1,300));
        barEntries.add(new BarEntry(2,900));
        barEntries.add(new BarEntry(3,500));
        barEntries.add(new BarEntry(4,1000));
        barEntries.add(new BarEntry(5,2000));
        barEntries.add(new BarEntry(6,1000));
        barEntries.add(new BarEntry(7,1200));
        return barEntries;
    }
    private ArrayList<BarEntry>barEntries3()
    {
        ArrayList<BarEntry>barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(1,700));
        barEntries.add(new BarEntry(2,1000));
        barEntries.add(new BarEntry(3,300));
        barEntries.add(new BarEntry(4,1200));
        barEntries.add(new BarEntry(5,2100));
        barEntries.add(new BarEntry(6,1300));
        barEntries.add(new BarEntry(7,1500));
        return barEntries;
    }
}

