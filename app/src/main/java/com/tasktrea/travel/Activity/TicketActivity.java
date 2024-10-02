package com.tasktrea.travel.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.tasktrea.travel.Domain.ItemDomen;
import com.tasktrea.travel.R;
import com.tasktrea.travel.databinding.ActivityMainBinding;
import com.tasktrea.travel.databinding.ActivityTicketBinding;

public class TicketActivity extends BaseActivity {
    ActivityTicketBinding binding;
    private ItemDomen object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTicketBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();

    }

    private void setVariable() {
        Glide.with(TicketActivity.this)
                .load(object.getPic())
                .into(binding.pic);
        Glide.with(TicketActivity.this)
                .load(object.getTourGuidePic())
                .into(binding.profile);

        binding.backBtn.setOnClickListener(v->finish());
        binding.titleTxt.setText(object.getTitle());
        binding.durationTxt.setText(object.getDuration());
       binding.timeTxt.setText(object.getTimeTour());
       binding.tourGuideTxt.setText(object.getDateTour());
       binding.tourGuidNameTxt.setText(object.getTourGuideName());

       binding.callBtn.setOnClickListener(view -> {
           Intent sentIntent = new Intent(Intent.ACTION_VIEW);
           sentIntent.setData(Uri.parse("sms"+object.getTourGuidePhone()));
           sentIntent.putExtra("sms_body","type your sms");
           startActivity(sentIntent);
       });

       binding.messageBtn.setOnClickListener(view -> {
           String phone =object.getTourGuidePhone();
           Intent intent = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",phone,null));
           startActivity(intent);

       });
    }

    private void getIntentExtra() {
        object= (ItemDomen) getIntent().getSerializableExtra("object");
    }
}