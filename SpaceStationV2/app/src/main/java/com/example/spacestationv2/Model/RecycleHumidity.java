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

public class RecycleHumidity extends RecyclerView.Adapter<RecycleHumidity.MyviewHolder> {
    private Context context;
    private List<Humidity> humidityList = new ArrayList<>();

    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_adapter, parent,false);
        //from(parent.getContext()).inflate(R.layout.fragment_co2,parent,false);
        return new MyviewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecycleHumidity.MyviewHolder holder, int position) {
        Humidity currentList = humidityList.get(position);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(currentList.getDate());
        holder.humidityImage.setImageResource(R.drawable.ic_humidityicon);
        holder.humidityID.setText("ID : " + String.valueOf(currentList.getHUM_ID()));
        holder.humidityValue.setText("Value : "+String.valueOf(currentList.getHUM_value()));
        holder.humidityDate.setText("Date : "+dateString);

    }

    public RecycleHumidity(Context context, List<Humidity> humidityList) {
        this.context = context;
        this.humidityList = humidityList;
    }

    public void setHumidityList(List<Humidity> humidityList ) {
        this.humidityList = humidityList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(humidityList!=null)
            return humidityList.size();
        return 0;
    }

    static class MyviewHolder extends RecyclerView.ViewHolder {
        private ImageView humidityImage;
        private TextView humidityID;
        private TextView humidityValue;
        private TextView humidityDate;


        public MyviewHolder(View itemView) {
            super(itemView);
            humidityImage = itemView.findViewById(R.id.imageview);
            humidityID = itemView.findViewById(R.id.textview2);
            humidityValue = itemView.findViewById(R.id.textview1);
            humidityDate = itemView.findViewById(R.id.textview3);

        }
    }
}