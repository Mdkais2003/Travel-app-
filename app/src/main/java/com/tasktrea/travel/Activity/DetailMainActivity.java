package com.tasktrea.travel.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.tasktrea.travel.Domain.ItemDomen;
import com.tasktrea.travel.databinding.ActivityDetailMainBinding;

import java.util.Objects;

public class DetailMainActivity extends BaseActivity {
    ActivityDetailMainBinding binding;
    private ItemDomen object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();

    }

    private void setVariable() {
        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText("$"+object.getPrice());
        Objects.requireNonNull(binding.backBtn).setOnClickListener(view -> finish());
        binding.bedTex.setText(""+object.getBed());
        binding.durationTxt.setText(object.getDuration());
        binding.distanceTxt.setText(object.getDistance());
        binding.descriptionTxt.setText(object.getDescription());
        binding.addressTxt.setText(object.getAddress());
        binding.ratingTxt.setText(object.getPrice()+"Rating");
        binding.ratingBar.setRating((float) object.getScore());
        Glide.with(DetailMainActivity.this)
                .load(object.getPic())
                .into(binding.pic);

        binding.addToCartBtn.setOnClickListener(view -> {
           Intent intent=new Intent(DetailMainActivity.this,TicketActivity.class);
           intent.putExtra("object",object);
          startActivity(intent);


        });

    }

    private void getIntentExtra() {
        object= (ItemDomen) getIntent().getSerializableExtra("object");
    }
}