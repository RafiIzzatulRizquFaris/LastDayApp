package com.example.bismillahapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bismillahapp.R;
import com.example.bismillahapp.model.Services;

import java.util.ArrayList;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Services> customerArrayList;

    public ArrayList<Services> getServicesArrayList() {
        return customerArrayList;
    }

    public void setServicesArrayList(ArrayList<Services> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    public ServicesAdapter(Context context, ArrayList<Services> customerArrayList) {
        this.context = context;
        this.customerArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public ServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.ViewHolder holder, int position) {
        holder.tvItem.setText(getServicesArrayList().get(position).getServiceName());
        holder.tvQty.setText(getServicesArrayList().get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return getServicesArrayList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem, tvQty;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.item_name);
            tvQty = itemView.findViewById(R.id.item_quantity);
        }
    }
}