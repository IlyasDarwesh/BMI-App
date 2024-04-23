package com.example.bmiapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class DerivedFragment extends Fragment {
    TextView tvR, tvPython, tvCPP, tvJava, first_status, first_bmi;
    PieChart pieChart;
    private SharedViewModel sharedViewModel;


    public DerivedFragment() {

    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_derived, container, false);
        tvR = view.findViewById(R.id.tvR);
        tvPython = view.findViewById(R.id.tvPython);
        tvCPP = view.findViewById(R.id.tvCPP);
        //first_status = view.findViewById(R.id.first_status);
        first_bmi = view.findViewById(R.id.first_bmi);
        tvJava = view.findViewById(R.id.tvJava);
        pieChart = view.findViewById(R.id.piechart);

        getParentFragmentManager().setFragmentResultListener("datafrom1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String data1 = result.getString("bmi");

                float bmiValue = Float.parseFloat(data1);

// Format the BMI value with two decimal points
                String formattedBMI = String.format("%.2f", bmiValue);

// Concatenate the percent sign (%) to the formatted BMI string
                String bmiWithPercent = formattedBMI + "%";

               // first_status.setText(data);
                first_bmi.setText(bmiWithPercent);


            }
        });

        setData();


        return view;
    }


    @SuppressLint("StringFormatMatches")
    private void setData() {


        double lowerBound1 = 30;
        double upperBound1 = 100;
        tvR.setText(getString(R.string.range_format, lowerBound1 + "%", upperBound1 + "%"));

        double lowerBound2 = 18.5;
        double upperBound2 = 24.9;
        tvPython.setText(getString(R.string.range_format, lowerBound2 + "%", upperBound2 + "%"));

        double lowerBound3 = 18.5;
        double upperBound3 = 1;
        tvCPP.setText(getString(R.string.range_format, lowerBound3 + "%", upperBound3 + "%"));

        double lowerBound4 = 25;
        double upperBound4 = 29.9;
        tvJava.setText(getString(R.string.range_format, lowerBound4 + "%", upperBound4 + "%"));

        pieChart.clearChart();
        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "obesity",
                        (int) lowerBound1, // Convert to int
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Normal Weight",
                        (int) lowerBound2, // Convert to int
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Under Weight",
                        (int) lowerBound3, // Convert to int
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "Over weight",
                        (int) lowerBound4, // Convert to int
                        Color.parseColor("#29B6F6")));

        // To animate the pie chart
        pieChart.startAnimation();
    }

}


