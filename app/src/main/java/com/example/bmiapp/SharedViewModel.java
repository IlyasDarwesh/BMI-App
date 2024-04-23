package com.example.bmiapp;

import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private String statusValue;
    private String resultBmiValue;

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getResultBmiValue() {
        return resultBmiValue;
    }

    public void setResultBmiValue(String resultBmiValue) {
        this.resultBmiValue = resultBmiValue;
    }
}
