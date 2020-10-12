package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private final String[] titles = {"Opening Hour 9am-10pm", "Opening Hour 9am-10pm","Opening Hour 9am-10pm","Opening","Opening"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupRecyclerView();
    }

    private void setupRecyclerView()
    {
        RecyclerView recyclerView = findViewById(R.id.address_recycler_view);
        // Add LayoutManager for Recycler View
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Add Some behavioral properties to RecyclerView (Optional)
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        // Create Adapter for RecyclerView
        ProfileRecyclerAdapter rvAdapter = new ProfileRecyclerAdapter(ProfileActivity.this, titles);

        //Attach Adapter for RecyclerView
        recyclerView.setAdapter(rvAdapter);
    }

}
