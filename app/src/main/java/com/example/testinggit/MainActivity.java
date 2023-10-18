package com.example.testinggit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.testinggit.models.Celsius;
import com.example.testinggit.models.Farenheit;
import com.example.testinggit.models.Grado;
import com.example.testinggit.models.Kelvin;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private EditText editTextValue;
    private EditText editTextResult;
    private Button buttonConvert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        editTextValue = findViewById(R.id.editTextValue);
        editTextResult = findViewById(R.id.editTextResult);
        buttonConvert = findViewById(R.id.buttonConvert);

        Grado celsius = new Celsius(0.0,"C");
        celsius.setValor(10.0);
        Grado farenheit = new Farenheit(0.0,"F");
        Grado kelvin = new Kelvin(0.0,"K");

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performConversion();
            }
        });
    }
    private void performConversion() {
        int fromIndex = spinnerFrom.getSelectedItemPosition();
        int toIndex = spinnerTo.getSelectedItemPosition();

        if (fromIndex >= 0 && toIndex >= 0) {
            try {
                double value = Double.parseDouble(editTextValue.getText().toString());

                Grado fromGrado = createGradoInstance(fromIndex, value);
                double result = convertGrado(fromGrado, toIndex);
                editTextResult.setText(String.valueOf(result));
            } catch (NumberFormatException e) {
                editTextResult.setText("Invalid input");
            }
        } else {
            editTextResult.setText("Select units");
        }
    }

    private Grado createGradoInstance(int unitIndex, double value) {
        switch (unitIndex) {
            case 0:
                return new Celsius(value, "C");
            case 1:
                return new Farenheit(value, "F");
            case 2:
                return new Kelvin(value, "K");
            default:
                return null; // Handle this case accordingly
        }
    }

    private double convertGrado(Grado fromGrado, int toIndex) {
        if (fromGrado == null) {
            return 0.0; // Handle this case accordingly
        }

    }

}
