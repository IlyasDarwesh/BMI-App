package com.example.bmiapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    TabLayout tab;
    ViewPager viewPager;
    private SharedViewModel sharedViewModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = (TabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        ViewPagerMessengerAdapter adapter = new ViewPagerMessengerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_items, menu);
        MenuItem about = menu.findItem(R.id.about);
        MenuItem tips = menu.findItem(R.id.tips);
        MenuItem convert_info = menu.findItem(R.id.convert_info);
        MenuItem favourite=menu.findItem(R.id.favourite);



        about.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {

                Intent intent= new Intent(MainActivity.this,About.class);
                startActivity(intent);
                return true;

            }
        });

        tips.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {


                Intent intent= new Intent(MainActivity.this,HealthyTips.class);
                startActivity(intent);
                return true;
            }
        });
        convert_info.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                Intent intent= new Intent(MainActivity.this,ConversionMethod.class);
                startActivity(intent);
                return true;
            }
        });

        favourite.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                String githubUrl = "https://github.com/ilyasdarwesh"; // Replace with your GitHub URL

                // Create an Intent to open the GitHub URL in a web browser
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));

                // Start the activity to open the GitHub URL
                startActivity(intent);

                // Return true to indicate that the click event has been handled
                return true;
            }
        });

        return true;
    }




}