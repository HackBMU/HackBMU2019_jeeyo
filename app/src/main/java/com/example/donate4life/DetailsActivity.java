package com.example.donate4life;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView tv = findViewById(R.id.info);
        String s = "Donate 4 Life is a non profit organization established to create end to end communication between Donor and Acceptor. Donate 4 Life accepts 5 types of Donation namely Blood, Money, Medical Equipments  and left Over Food from parties as well as there are two types of request- accept and donate Blood and Medical Equipments.";
        tv.setText(s);
    }
}
