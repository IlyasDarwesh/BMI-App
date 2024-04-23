package com.example.bmiapp;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class StandardFragment extends Fragment {

    EditText weight, heightFt, heightInc;
    Button btnCalculate, clearscreen;
    TextView textResult, Resultbmi, status_value, Resultbmivalue;

    LinearLayout linear;

    ImageView smile1, smile2, smile3, smile4;
    Animation anim;
    private SharedViewModel sharedViewModel;

    public StandardFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_standard, container, false);


        weight = view.findViewById(R.id.weight);
        heightFt = view.findViewById(R.id.heightFt);
        heightInc = view.findViewById(R.id.heightInc);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        clearscreen = view.findViewById(R.id.clearscreen);
        textResult = view.findViewById(R.id.textResult);
        linear = view.findViewById(R.id.linear_main);
        Resultbmi = view.findViewById(R.id.Resultbmi);
        status_value = view.findViewById(R.id.status_value);
        Resultbmivalue = view.findViewById(R.id.Resultbmivalue);
        smile1 = view.findViewById(R.id.smile1);
        smile2 = view.findViewById(R.id.smile2);
        smile3 = view.findViewById(R.id.smile3);
        smile4 = view.findViewById(R.id.smile4);


        anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(100); // Duration of the blinking animation
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatCount(20);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(weight.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter your Weight please", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(heightFt.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter your Height feet please", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(heightInc.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter your Height inches please", Toast.LENGTH_SHORT).show();
                    return;
                }


                Calculation();


                Bundle args = new Bundle();

                args.putString("bmi", Resultbmivalue.getText().toString());
                getParentFragmentManager().setFragmentResult("datafrom1",args);





            }
        });

        clearscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight.setText("");
                heightFt.setText("");
                heightInc.setText("");
                status_value.setText("");
                Resultbmivalue.setText("");
            }
        });

        return view;
    }


    void Calculation() {


        int wt = Integer.parseInt(weight.getText().toString());
        int Ft = Integer.parseInt(heightFt.getText().toString());
        int In = Integer.parseInt(heightInc.getText().toString());


        int totalIn = Ft * 12 + In;
        double totalCm = totalIn * 2.53;
        double totalMtr = totalCm / 100;
        double bmi = wt / (totalMtr * totalMtr);


        if (bmi > 30) {
            status_value.setText("You are Obesity");
            Resultbmivalue.setText(String.valueOf(bmi));
            //  linear.setBackground(new ColorDrawable(getResources().getColor(R.color.Obesity)));
            smile1.startAnimation(anim);

        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status_value.setText("Normal Weight");
            Resultbmivalue.setText(String.valueOf(bmi));
            // linear.setBackground(new ColorDrawable(getResources().getColor(R.color.NormalWeight)));
            smile2.startAnimation(anim);
        } else if (bmi < 18.5) {
            status_value.setText("You are Under Weight");
            Resultbmivalue.setText(String.valueOf(bmi));
            // linear.setBackground(new ColorDrawable(getResources().getColor(R.color.UnderWeight)));
            smile3.startAnimation(anim);

        } else {
            status_value.setText("You are Over Weight");
            Resultbmivalue.setText(String.valueOf(bmi));
            //  linear.setBackground(new ColorDrawable(getResources().getColor(R.color.OverWeight)));
            smile4.startAnimation(anim);


        }

    }


}