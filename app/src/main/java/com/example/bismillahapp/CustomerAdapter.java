package com.example.bismillahapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bismillahapp.model.Customer;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    Context context;
    ArrayList<Customer> customerArrayList;

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }
    public void setCustomerArrayList(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }


    public CustomerAdapter(Context context, ArrayList<Customer> customerArrayList) {
        this.context = context;
        this.customerArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public CustomerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapter.ViewHolder holder, int position) {
        holder.tvItem.setText(getCustomerArrayList().get(position).getName());
        holder.tvQty.setText(getCustomerArrayList().get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return getCustomerArrayList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvItem, tvQty;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.item_name);
            tvQty = itemView.findViewById(R.id.item_quantity);
        }
    }
}
