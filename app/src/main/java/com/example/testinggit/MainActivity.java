package com.example.testinggit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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


// Create an array of units (e.g., Celsius, Fahrenheit, Kelvin)
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};

// Create an adapter to display the units
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Set the adapter for the spinner
        spinnerFrom.setAdapter(adapter);

        spinnerTo.setAdapter(adapter);


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
        switch (toIndex) {
            case 0: // Conversion to Celsius
                if (fromGrado instanceof Celsius) {
                    return fromGrado.getValor();
                } else if (fromGrado instanceof Farenheit) {
                    return ((Farenheit) fromGrado).parse(new Celsius(fromGrado.getValor(), "C")).getValor();
                } else if (fromGrado instanceof Kelvin) {
                    return ((Kelvin) fromGrado).parse(new Celsius(fromGrado.getValor(), "C")).getValor();
                }
                break;

            case 1: // Conversion to Fahrenheit
                if (fromGrado instanceof Celsius) {
                    return ((Celsius) fromGrado).parse(new Farenheit(fromGrado.getValor(), "F")).getValor();
                } else if (fromGrado instanceof Farenheit) {
                    return fromGrado.getValor();
                } else if (fromGrado instanceof Kelvin) {
                    return ((Kelvin) fromGrado).parse(new Farenheit(fromGrado.getValor(), "F")).getValor();
                }
                break;

            case 2: // Conversion to Kelvin
                if (fromGrado instanceof Celsius) {
                    return ((Celsius) fromGrado).parse(new Kelvin(fromGrado.getValor(), "K")).getValor();
                } else if (fromGrado instanceof Farenheit) {
                    return ((Farenheit) fromGrado).parse(new Kelvin(fromGrado.getValor(), "K")).getValor();
                } else if (fromGrado instanceof Kelvin) {
                    return fromGrado.getValor();
                }
                break;
        }
        return 0.0;

    }

}
