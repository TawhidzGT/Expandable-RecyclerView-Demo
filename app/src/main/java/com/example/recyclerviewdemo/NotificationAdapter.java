package com.example.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.OrderOA> {
    List<ProductModel> productList;
    //list of android version names
    String[] orderItemName = {"Cupcake", "Donut", "Eclair", "Froyo",
            "Gingerbread", "Honeycomb", "Ice Cream Sandwich 260gm Sandwich 260gm Sandwich 260gmSandwich 260gm",
            "JellyBean", "Kitkat", "Lollipop", "Delivery Charge"};
    //list of android version
    String[] orderItemCount = {"x5", "x6", "x1",
            "x3", "x7", "x6", "x4", "x1",
            "x4", "x1","x2"};
    //list of android version
    String[] orderItemPrice = {"1.53", "1.62", "2.02",
            "222", "237", "3032", "4040", "41",
            "443", "5.0","25"};
    Context ctx;


    public NotificationAdapter(Context ctx,List<ProductModel> productList) {
        this.productList = productList;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public NotificationAdapter.OrderOA onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_card_view,parent,false);
        return new OrderOA(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.OrderOA holder, int position) {

        boolean isExpandable=productList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        if(isExpandable)
        {
            holder.collapsedLayout.setBackgroundResource(0);
            holder.rightArrow.setImageResource(R.drawable.ic_spinner);
            holder.notificationTimeCollapsed.setVisibility(View.INVISIBLE);
            holder.delete.setVisibility(View.INVISIBLE);
        }
        else
        {
            holder.collapsedLayout.setBackgroundResource(R.drawable.notification_textview_border);
            holder.rightArrow.setImageResource(R.drawable.ic_right_arrow);
            holder.notificationTimeCollapsed.setVisibility(View.VISIBLE);
            holder.delete.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class OrderOA extends RecyclerView.ViewHolder
    {
        CardView notificationCardLayout;
        LinearLayout expandableLayout,collapsedLayout;
        TextView notificationTimeCollapsed;
        ImageView rightArrow,delete;

        public OrderOA(@NonNull View itemView) {
            super(itemView);

            notificationCardLayout=itemView.findViewById(R.id.NotificationCardLayout);
            expandableLayout=itemView.findViewById(R.id.NotificationExpandLayout);
            collapsedLayout=itemView.findViewById(R.id.NotificationCollapsedLayout);
            rightArrow=itemView.findViewById(R.id.NotificationCollapsedImg);
            notificationTimeCollapsed=itemView.findViewById(R.id.NotificationReceivedTimeCollapsed);
            delete=itemView.findViewById(R.id.NotificationDeleteImg);
            notificationCardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ProductModel productModel=productList.get(getAdapterPosition());
                    productModel.setExpandable(!productModel.isExpandable());
                    collapsedLayout.setBackgroundResource(0);
                    rightArrow.setImageResource(R.drawable.ic_spinner);
                    notificationTimeCollapsed.setVisibility(View.INVISIBLE);
                    delete.setVisibility(View.INVISIBLE);
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
