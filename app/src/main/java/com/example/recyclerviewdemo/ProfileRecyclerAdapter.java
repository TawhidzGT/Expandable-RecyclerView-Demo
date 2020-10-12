package com.example.recyclerviewdemo;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   // Declare Variables
    private Context ctx;
    private List<Integer> items = new ArrayList<>();
    private String[] titlesAdapter;
    private int selected=0;
    private int VIEW_TYPE_ADDRESS=2;

    ProfileRecyclerAdapter(Context context, String[] titles) {
        this.ctx = context;
        this.titlesAdapter = titles;

    }

    public static class OriginalViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cardView;
        FrameLayout addressFrame;
        ImageView selectedTickImg;

        OriginalViewHolder(View v) {
            super(v);
            cardView = v.findViewById(R.id.card_view_parent_layout);
            addressFrame=v.findViewById(R.id.address_frame);
            selectedTickImg=v.findViewById(R.id.address_frame_selected_tick);

        }
    }

    public static class LastItemViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cardView;

        LastItemViewHolder(View v) {
            super(v);
            cardView = v.findViewById(R.id.add_address_card_view_layout);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("POS",position+" count"+ getItemCount()+" ");
        int VIEW_TYPE_ADD_ADDRESS = 1;
        return (position == items.size()) ? VIEW_TYPE_ADD_ADDRESS : VIEW_TYPE_ADDRESS;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;

        if (viewType == VIEW_TYPE_ADDRESS) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_card_view, parent, false);
            vh = new ProfileRecyclerAdapter.OriginalViewHolder(v);
        }
        else
        {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_address_card_view, parent, false);
            vh = new ProfileRecyclerAdapter.LastItemViewHolder(v);
        }

        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ProfileRecyclerAdapter.OriginalViewHolder) {
            ProfileRecyclerAdapter.OriginalViewHolder vItem = (ProfileRecyclerAdapter.OriginalViewHolder) holder;

            if(selected==position)
            {
                vItem.addressFrame.setBackgroundResource(R.drawable.address_textview_border);
                vItem.selectedTickImg.setVisibility(View.VISIBLE);
            }
            else
            {
                vItem.addressFrame.setBackgroundResource(R.drawable.address_textview_border_unselected);
                vItem.selectedTickImg.setVisibility(View.INVISIBLE);
            }


            vItem.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ctx, "working", Toast.LENGTH_SHORT).show();
                    if(selected==position){
                        selected=0;
                        notifyDataSetChanged();
                        return;
                    }
                    selected = position;
                    notifyDataSetChanged();
                }
            });

        }
        else if(holder instanceof ProfileRecyclerAdapter.LastItemViewHolder)
        {
            ProfileRecyclerAdapter.LastItemViewHolder lastItem = (ProfileRecyclerAdapter.LastItemViewHolder) holder;
            lastItem.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ctx, "ADD", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        Integer[] count = new Integer[titlesAdapter.length];
        items = Arrays.asList(count);
        return items.size()+1;
    }

}
