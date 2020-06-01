package com.example.spacestationv2.View;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.example.spacestationv2.Model.Temperature;
import com.example.spacestationv2.R;
import com.example.spacestationv2.ViewModel.TemperatureViewModel;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import androidx.lifecycle.ViewModelProviders;


public class TemperatureFragment extends Fragment {

    private View rootView;
    private TextView view;
    private TemperatureViewModel temperatureViewModel;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_temperature, container, false);
        view=rootView.findViewById(R.id.retrofit_Temperature);
        temperatureViewModel= ViewModelProviders.of(this).get(TemperatureViewModel.class);
        temperatureViewModel.init();
        temperatureViewModel.getTemperatureRepo().observe(this, new Observer<List<Temperature>>() {
                    @Override
                    public void onChanged(List<Temperature> temperatures) {
                        if (!temperatures.isEmpty()) {
                            view.setText("");
                            for (Temperature n : temperatures) {
                                String content = "";
                                content += "TEMP_ID: " + n.getTEMP_ID() + "\n";
                                content += "TEMP_value: " + n.getTEMP_value() + "\n";
                                content += "Date: " + n.getDate() + "\n";
                                view.append(content);
                            }
                        } else {
                            view.setText("Empty");
                        }
                    }
                }
        );

        return rootView;

    }

}
/*
    @Override
    public void onChanged(List<Temperature> temperatures) {
        if (!temperatures.isEmpty()) {

            view.setText("");
            temperatures_t = testData(temperatures);
            List<Temperature> temperatureList = temperatures_t;

            long minX = temperatures.get(0).getDate().getDay();// - (1000 * 60 * 60 * 24);
            Date minXDate = new Date(minX);

            final HashMap<Integer, String> numMap = new HashMap<>();
            for (Temperature temperature : temperatureList) {
                Date date = temperature.getDate();
                int x = (int) (date.getTime() - minX) / 86400000;

                String label = date.getDay() + "/" + (date.getMonth() + 1);
                numMap.put(x, label);
            }

            lineChart = rootView.findViewById(R.id.fragment_temperature_linechart);

            YAxis yAxis = lineChart.getAxisLeft();
            yAxis.setAxisMinimum(0);
            yAxis.setAxisMaximum(40);

            XAxis xAxis = lineChart.getXAxis();
            xAxis.setGranularity(1.0f);

            xAxis.setValueFormatter(new IAxisValueFormatter() {
                @Override
                public String getFormattedValue(float value, AxisBase axis) {
                    return numMap.get((int) value);
                }

            });

            getEntries();
            setUpLineData();

        } else {
            view.setText("Empty");
        }
    }
}
        );


                return rootView;

                }


private void setUpLineData() {
        lineDataSet = new LineDataSet(lineEntries, "");
        lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(18f);

        }

private void getEntries() {

//        temperatureViewModel.getTemperatureData().observe(this, new Observer<List<Temperature>>() {
//            @Override
//            public void onChanged(List<Temperature> temperatures) {
//                if (!temperatures.isEmpty()) {
//                    lineEntries = new ArrayList<>();
//                    for (Temperature n : temperatures) {
//                        date
//                       lineEntries.add(new Entry(n.getValue(), date));
//
//                    }
//                }
//            }
//        });


        List<Temperature> data = temperatures_t;
        lineEntries = new ArrayList<>();


        long minX = data.get(0).getDate().getTime() - (1000 * 60 * 60 * 24);

        for (Temperature temperature : data) {
        Date date = temperature.getDate();
        int x = (int) ((date.getTime() - minX) / 86400000);
        lineEntries.add(new Entry(x, temperature.getValue()));
        }
        }
private List<Temperature> testData(List<Temperature> data) {

        ArrayList<Temperature> temperatures = new ArrayList<>();

        for(int i=0;i<data.size();i++)
        {
        temperatures.add(new Temperature(data.get(i).getValue(), data.get(i).getDate()));
        }

        return temperatures;
        }


 */



