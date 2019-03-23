package com.example.donate4life;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DonateActivity extends AppCompatActivity {

    Spinner spinner;
    List<String> list;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        spinner = findViewById(R.id.spinner);
        list = new ArrayList<String>();
        list.add("blood");
        list.add("money");
        list.add("medical equipments");
        list.add("books");
        list.add("left over food");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (spinner.getSelectedItemId()==0){
                    Intent i = new Intent(getApplicationContext(), BloodForm.class);
                    startActivity(i);
                }
                else if (spinner.getSelectedItemId()==1){
                    Intent i = new Intent(getApplicationContext(), MoneyActivity.class);
                    startActivity(i);
                }
                else if (spinner.getSelectedItemId()==2){
                    Intent i = new Intent(getApplicationContext(), EquipmentsActivity.class);
                    startActivity(i);
                }
                else if (spinner.getSelectedItemId()==3){
                    Intent i = new Intent(getApplicationContext(), BooksActivity.class);
                    startActivity(i);
                }
                else if (spinner.getSelectedItemId()==4){
                    Intent i = new Intent(getApplicationContext(), LeftFoodActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(DonateActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}
