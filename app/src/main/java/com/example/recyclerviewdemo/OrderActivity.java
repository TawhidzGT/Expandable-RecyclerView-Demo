package com.example.recyclerviewdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ProductModel> productList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView=findViewById(R.id.order_recycler_view);
        initData();
        setRecyclerView();
    }

    private void setRecyclerView()
    {
        OrderAdapter orderAdapter= new OrderAdapter(this,productList);
        recyclerView.setAdapter(orderAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void initData()
    {
        productList=new ArrayList<>();
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));
        productList.add(new ProductModel("145968556", "400","30","20"));





    }

}
