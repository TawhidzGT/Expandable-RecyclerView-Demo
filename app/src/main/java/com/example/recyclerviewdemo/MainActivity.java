package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //list of android version names
    String[] orderItem = {"Cupcake", "Donut", "Eclair", "Froyo",
            "Gingerbread", "Honeycomb", "Ice Cream Sandwich pizza burgers 260gm",
            "JellyBean", "Kitkat", "Lollipop", "Delivery Charge"};
    //list of android version
    String[] orderItemCount = {"x5", "x6", "x1",
            "x3", "x7", "x6", "x4", "x1",
            "x4", "x1",""};
    //list of android version
    String[] orderItemPrice = {"1.53", "1.62", "2.02",
            "222", "237", "3032", "4040", "41",
            "443", "5.0-","25"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<DataModel> data = new ArrayList<>();
        for (int i = 0; i < orderItem.length; i++) {
            data.add(new DataModel(
                    orderItem[i],
                    orderItemCount[i],
                    orderItemPrice[i]
            ));
        }
        RecyclerView.Adapter adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
