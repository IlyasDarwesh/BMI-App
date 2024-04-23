package com.example.bmiapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.joanzapata.pdfview.PDFView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConversionMethod extends AppCompatActivity {

    PDFView pdfView;
    String pdffile = "conversion.pdf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_method);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"})

        TextView txt=(TextView) findViewById(R.id.link);


        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.back_arrow);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        pdfView=(PDFView) findViewById(R.id.pdfview);

        pdfView.fromAsset(pdffile).defaultPage(1).load();


        SpannableString content = new SpannableString("Content");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        txt.setText(content);
        TextView linkTextView = findViewById(R.id.link);
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the URL to open
                String url = "https://example.com"; // Replace "https://example.com" with your URL

                // Create an Intent to open the URL in a web browser
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Start the activity to open the URL
                startActivity(intent);
            }
        });


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