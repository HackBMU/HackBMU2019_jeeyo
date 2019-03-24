package com.example.donate4life;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    ViewPager viewPager;
    int images[] = { R.drawable.aa, R.drawable.bb, R.drawable.cc, R.drawable.dd,R.drawable.images};
    SliderAdapter sliderAdapter;
    Button accptBtn, donBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textView = (TextView) this.findViewById(R.id.marquee);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setText("200 units of Blood Successfully donated.  70 children have been given priviledge of education.");
        textView.setSelected(true);
        textView.setSingleLine(true);

        String s = "Donate 4 Life is a non profit organization established to create end to end communication between Donor and...[Read More]";
        TextView details = findViewById(R.id.details);
        details.setText(s);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DetailsActivity.class);
                startActivity(i);
            }
        });


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                logout();
                return true;
            case R.id.history:
                history();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void history() {
    }

    private void logout() {

        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        editor.clear();
        editor.apply();

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
