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

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyviewHolder> {
   private Context context;
    private List<CO2> co2List = new ArrayList<>();

    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_adapter, parent,false);
        //from(parent.getContext()).inflate(R.layout.fragment_co2,parent,false);
        return new MyviewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyviewHolder holder, int position) {
        CO2 currentList = co2List.get(position);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(currentList.getDate());
        holder.co2Image.setImageResource(R.drawable.ic_humidityicon);
        holder.co2ID.setText("ID : " + String.valueOf(currentList.getCO2ID()));
        holder.co2Value.setText("Value : "+String.valueOf(currentList.getCO2_value()));
        holder.co2Date.setText("Date : "+dateString);

    }

    public RecycleAdapter(Context context, List<CO2> co2List) {
        this.context = context;
        this.co2List = co2List;
    }

    public void setCo2List(List<CO2> co2List) {
        this.co2List = co2List;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
       if(co2List!=null)
           return co2List.size();
       return 0;
    }

    static class MyviewHolder extends RecyclerView.ViewHolder {
        private ImageView co2Image;
        private TextView co2ID;
        private TextView co2Value;
        private TextView co2Date;


        public MyviewHolder(View itemView) {
            super(itemView);
            co2Image = itemView.findViewById(R.id.imageview);
            co2ID = itemView.findViewById(R.id.textview2);
            co2Value = itemView.findViewById(R.id.textview1);
            co2Date = itemView.findViewById(R.id.textview3);

        }
    }
}