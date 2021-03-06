package com.example.donate4life;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AcceptActivity extends AppCompatActivity implements VPFragment.OnFragmentInteractionListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    ArrayList<VPFragment> vpFragments;
    ArrayList<String> arrayList;
    CustomViewPageAdapter customViewPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager);

        arrayList = new ArrayList<>();

        arrayList.add("Blood");
        arrayList.add("Medical Equipments");

        vpFragments = new ArrayList<>();
        for (int i=0; i< arrayList.size(); i++){
            vpFragments.add(VPFragment.newInstance(arrayList.get(i)));
        }

        customViewPageAdapter = new CustomViewPageAdapter(getSupportFragmentManager(), arrayList, vpFragments);
        viewPager.setAdapter(customViewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void deleteFragment(VPFragment fragment) {
        vpFragments.remove(fragment);
        arrayList.remove(fragment.string1);
        customViewPageAdapter.notifyDataSetChanged();
    }
}
