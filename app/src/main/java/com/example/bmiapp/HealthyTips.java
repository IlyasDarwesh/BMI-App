package com.example.bmiapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.joanzapata.pdfview.PDFView;

public class HealthyTips extends AppCompatActivity {
    PDFView pdfView;

    String pdffile = "healthtips.pdf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_tips);

        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.back_arrow);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        pdfView=(PDFView) findViewById(R.id.pdfview);

        pdfView.fromAsset(pdffile).defaultPage(1).load();



    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        if (item.getItemId()==android.R.id.home){
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}