package com.example.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderOA> {
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


    public OrderAdapter(Context ctx,List<ProductModel> productList) {
        this.productList = productList;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public OrderAdapter.OrderOA onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_new,parent,false);
        return new OrderOA(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderOA holder, int position) {
        ProductModel productModel=productList.get(position);
        holder.orderNumber.setText(productModel.getOrderNumber());
        holder.orderSubTotal.setText(productModel.getOrderSubTotal());
        holder.orderDeliveryCharge.setText(productModel.getOrderDeliveryCharge());
        holder.orderDiscount.setText(productModel.getOrderDiscount());

        boolean isExpandable=productList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        if(isExpandable)
        {
            holder.collapsedLayout.setBackgroundResource(R.color.white);
            holder.orderDetailsIcon.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_spinner,0);
        }
        else
        {
            holder.collapsedLayout.setBackgroundResource(R.color.background_shape);
            holder.orderDetailsIcon.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_right_arrow,0);
        }

        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<DataModel> data = new ArrayList<>();
        for (int i = 0; i < orderItemName.length; i++) {
            data.add(new DataModel(
                    orderItemName[i],
                    orderItemCount[i],
                    orderItemPrice[i]
            ));
        }

        RecyclerView.Adapter adapter = new CustomAdapter(data);
        holder.recyclerView.setAdapter(adapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager((ctx)));
       // holder.recyclerView.addOnItemTouchListener(mScrollTouchListener);
    }

    RecyclerView.OnItemTouchListener mScrollTouchListener = new RecyclerView.OnItemTouchListener() {
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            int action = e.getAction();
            switch (action) {
                case MotionEvent.ACTION_MOVE:
                    rv.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    };

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class OrderOA extends RecyclerView.ViewHolder
    {
        LinearLayout linearLayout,expandableLayout,collapsedLayout;
        TextView orderNumber,orderSubTotal,orderDeliveryCharge,orderDiscount,orderDetailsIcon;
        RecyclerView recyclerView;

        public OrderOA(@NonNull View itemView) {
            super(itemView);
            orderNumber=itemView.findViewById(R.id.OrderNumber);
            orderSubTotal=itemView.findViewById(R.id.OrderSubTotal);
            orderDeliveryCharge=itemView.findViewById(R.id.OrderDeliveryCharge);
            orderDiscount=itemView.findViewById(R.id.OrderDiscount);
            orderDetailsIcon=itemView.findViewById(R.id.OrderDetails);
            linearLayout=itemView.findViewById(R.id.linear_layout_order);
            expandableLayout=itemView.findViewById(R.id.expandable_layout_order);
            collapsedLayout=itemView.findViewById(R.id.order_collapsed_layout);

            recyclerView = itemView.findViewById(R.id.order_inner_recycler_view);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ProductModel productModel=productList.get(getAdapterPosition());
                    productModel.setExpandable(!productModel.isExpandable());
                    collapsedLayout.setBackgroundResource(R.color.white);
                    orderDetailsIcon.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_spinner,0);
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
