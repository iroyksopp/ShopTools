package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewDescription;
    private ImageView imageViewDrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        textViewDescription = findViewById(R.id.textViewDescription);
        textViewTitle = findViewById(R.id.textViewTitle);
        imageViewDrill = findViewById(R.id.imageViewDrill);
        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("description") && intent.hasExtra("resourceImageId")) {
            String title = intent.getStringExtra("title");
            String description = intent.getStringExtra("description");
            int resourceImageId = intent.getIntExtra("resourceImageId", -1);
            textViewTitle.setText(title);
            textViewDescription.setText(description);
            imageViewDrill.setImageResource(resourceImageId);
        } else {
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }

    }
}