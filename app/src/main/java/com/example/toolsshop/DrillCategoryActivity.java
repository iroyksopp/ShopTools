package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;
    private ArrayList<Drill> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        listViewDrills = findViewById(R.id.listViewDrills);
        drills = new ArrayList<>();
        drills.add(new Drill(getString(R.string.drill_interskole_title), getString(R.string.drill_interskole_description), R.drawable.interskol));
        drills.add(new Drill(getString(R.string.drill_makita_title), getString(R.string.drill_makita_descriptiom), R.drawable.makita));
        drills.add(new Drill(getString(R.string.drill_dewalt_title), getString(R.string.drill_dewalt_descriptiom), R.drawable.dewalt));

        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(getApplicationContext(),
                                     android.R.layout.simple_list_item_1, drills);
        listViewDrills.setAdapter(adapter);
        listViewDrills.setOnItemClickListener((adapterView, view, i, l) -> {
            Drill drill = drills.get(i);
            Intent intent = new Intent(this,DrillDetailActivity.class);
            intent.putExtra("title", drill.getTitle());
            intent.putExtra("description", drill.getDescription());
            intent.putExtra("resourceImageId",drill.getImageResourceId());
            startActivity(intent);

        });
    }
}