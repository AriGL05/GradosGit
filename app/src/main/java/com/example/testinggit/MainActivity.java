package com.example.testinggit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testinggit.models.Celsius;
import com.example.testinggit.models.Farenheit;
import com.example.testinggit.models.Kelvin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Celsius celsius = new Celsius(0.0,"C");
        celsius.setValor(10.0);
        Farenheit farenheit = new Farenheit(0.0,"F");
        Kelvin kelvin = new Kelvin(0.0,"K");
    }
}