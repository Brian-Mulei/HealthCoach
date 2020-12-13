package com.example.healthcoach;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcoach.Models.RetrieveModel;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<RetrieveModel> listData;

    public DataAdapter(List<RetrieveModel> listData) {
        this.listData = listData;
    }
    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_exercise,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        RetrieveModel ld=listData.get(position);
        holder.execise.setText(ld.getExercise());
        holder.excalori.setText(ld.getCalorieBurned());
     }

    @Override
    public int getItemCount() {
return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView execise,excalori;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            execise=(TextView)itemView.findViewById(R.id.execise);
            excalori=(TextView)itemView.findViewById(R.id.exxcalories);




        }
    }
}
