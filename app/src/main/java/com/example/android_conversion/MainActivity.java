package com.example.android_conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android_conversion.models.Celcius;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Celcius c= new Celcius(0.0);
    }
}