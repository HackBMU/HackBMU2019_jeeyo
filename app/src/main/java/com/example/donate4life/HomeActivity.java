package com.example.donate4life;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    ViewPager viewPager;
    int images[] = { R.drawable.download, R.drawable.images, R.drawable.download2, R.drawable.donatemedicalequipment,R.drawable.food};
    SliderAdapter sliderAdapter;
    Button accptBtn, donBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        accptBtn = findViewById(R.id.acceptButton);
        donBtn = findViewById(R.id.donateButton);

        accptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AcceptActivity.class);
                startActivity(i);
            }
        });

        donBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DonateActivity.class);
                startActivity(i);
            }
        });

        sliderAdapter = new SliderAdapter(HomeActivity.this, images);
        viewPager.setAdapter(sliderAdapter);
    }
}
