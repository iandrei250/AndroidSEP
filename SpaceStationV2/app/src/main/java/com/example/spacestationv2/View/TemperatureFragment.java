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




