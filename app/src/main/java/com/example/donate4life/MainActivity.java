package com.example.donate4life;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashSet<String> hashSet = new HashSet<String>();
        sf = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean b =  sf.getStringSet("Cookies", hashSet).isEmpty();

        if (!b){
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }

//        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
//        Intent i = new Intent(getApplicationContext(), AcceptActivity.class);
//        Intent i = new Intent(getApplicationContext(), DonateActivity.class);
//        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
//        startActivity(i);
//        finish();
    }


}
