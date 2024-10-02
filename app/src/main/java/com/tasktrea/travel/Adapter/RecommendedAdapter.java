package com.tasktrea.travel.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tasktrea.travel.Activity.DetailMainActivity;
import com.tasktrea.travel.Domain.ItemDomen;
import com.tasktrea.travel.databinding.ViewholderRecommendedBinding;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.Viewholder> {
    ArrayList<ItemDomen> items;
    Context context;
    ViewholderRecommendedBinding binding;

    public RecommendedAdapter(ArrayList<ItemDomen> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecommendedAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ViewholderRecommendedBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        context=parent.getContext();
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        binding.titleTex.setText(items.get(position).getTitle());
        binding.pricrTxt.setText("$"+items.get(position).getPrice());
        binding.addressTex.setText(items.get(position).getAddress());
        binding.scoreTxt.setText(""+items.get(position).getScore());


        Glide.with(context)
                .load(items.get(position).getPic())
                .into(binding.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(context, DetailMainActivity.class);
                intent.putExtra("object",items.get(position));
                context.startActivities(new Intent[]{intent});


            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderRecommendedBinding binding) {
            super(binding.getRoot());
        }
    }
}
