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
import com.example.spacestationv2.Model.Humidity;
import com.example.spacestationv2.R;
import com.example.spacestationv2.ViewModel.HumidityViewModel;
import java.util.List;
import androidx.lifecycle.ViewModelProviders;


public class HumidityFragment extends Fragment {

    private View rootView;
    private TextView view;
    private HumidityViewModel humidityViewModel;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_humidity, container, false);
        view=rootView.findViewById(R.id.retrofit_Humidity);
        humidityViewModel= ViewModelProviders.of(this).get(HumidityViewModel.class);
        humidityViewModel.init();
        humidityViewModel.getHumidityRepo().observe(this, new Observer<List<Humidity>>() {
                    @Override
                    public void onChanged(List<Humidity> humidities) {
                        if (!humidities.isEmpty()) {
                            view.setText("");
                            for (Humidity n : humidities) {
                                String content = "";
                                content += "HUM_ID: " + n.getHUM_ID() + "\n";
                                content += "HUM_value: " + n.getHUM_value() + "\n";
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




