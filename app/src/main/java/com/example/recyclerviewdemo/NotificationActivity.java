package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ProductModel> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        recyclerView=findViewById(R.id.notification_recycler_view);
        initData();
        setRecyclerView();
    }
    private void setRecyclerView()
    {
        NotificationAdapter notificationAdapter= new NotificationAdapter(this,productList);
        recyclerView.setAdapter(notificationAdapter);
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
