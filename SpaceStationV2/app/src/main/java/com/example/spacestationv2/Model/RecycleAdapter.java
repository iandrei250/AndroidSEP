package com.example.spacestationv2.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacestationv2.R;

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
        holder.co2ID.setText(String.valueOf(currentList.getCO2ID()));
        holder.co2Value.setText(String.valueOf(currentList.getCO2_value()));
        holder.co2Date.setText(String.valueOf(currentList.getDate()));
        System.out.println(co2List.get(position).getCO2_value());
        System.out.println(co2List.get(position).getDate());
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
        private TextView co2ID;
        private TextView co2Value;
        private TextView co2Date;


        public MyviewHolder(View itemView) {
            super(itemView);
            co2ID = itemView.findViewById(R.id.nav_co2ID);
            co2Value = itemView.findViewById(R.id.nav_co2Value);
            co2Date = itemView.findViewById(R.id.nav_co2Date);

        }
    }
}