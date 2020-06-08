package com.example.spacestationv2.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.spacestationv2.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RecycleTemperature extends RecyclerView.Adapter<RecycleTemperature.MyviewHolder> {
    private Context context;
    private List<Temperature> temperatureList = new ArrayList<>();

    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_adapter, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleTemperature.MyviewHolder holder, int position) {
        Temperature currentList = temperatureList.get(position);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(currentList.getDate());
        holder.temperatureImage.setImageResource(R.drawable.ic_temperatureicon);
        holder.temperatureID.setText("ID : " + String.valueOf(currentList.getTEMP_ID()));
        holder.temperatureValue.setText("Value : " + String.valueOf(currentList.getTEMP_value()));
        holder.temperatureData.setText("Date : " + dateString);

    }

    public RecycleTemperature(Context context, List<Temperature> temperatureList) {
        this.context = context;
        this.temperatureList = temperatureList;
    }

    public void setTemperatureList(List<Temperature> temperatureList) {
        this.temperatureList = temperatureList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (temperatureList != null)
            return temperatureList.size();
        return 0;
    }

    static class MyviewHolder extends RecyclerView.ViewHolder {
        private ImageView temperatureImage;
        private TextView temperatureID;
        private TextView temperatureValue;
        private TextView temperatureData;


        public MyviewHolder(View itemView) {
            super(itemView);
            temperatureImage = itemView.findViewById(R.id.imageview);
            temperatureID = itemView.findViewById(R.id.textview2);
            temperatureValue = itemView.findViewById(R.id.textview1);
            temperatureData = itemView.findViewById(R.id.textview3);

        }
    }
}