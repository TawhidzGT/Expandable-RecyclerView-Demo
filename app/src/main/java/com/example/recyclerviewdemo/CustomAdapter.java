package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataSet;
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView orderItem;
        TextView orderItemCount;
        TextView orderItemPrice;
        MyViewHolder(View itemView) {
            super(itemView);
            this.orderItem =  itemView.findViewById(R.id.OrderItemName);
            this.orderItemCount =  itemView.findViewById(R.id.OrderItemCount);
            this.orderItemPrice = itemView.findViewById(R.id.OrderItemPrice);
        }
    }
    CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_new, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        TextView orderItem = holder.orderItem;
        TextView orderItemCount = holder.orderItemCount;
        TextView orderItemPrice = holder.orderItemPrice;
        orderItem.setText(dataSet.get(listPosition).getOrderItem());
        orderItemCount.setText(dataSet.get(listPosition).getOrderItemCount());
        orderItemPrice.setText(dataSet.get(listPosition).getOrderItemPrice());
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}