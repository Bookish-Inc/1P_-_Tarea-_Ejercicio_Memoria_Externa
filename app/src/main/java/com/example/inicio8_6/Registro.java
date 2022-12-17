package com.example.inicio8_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registro extends AppCompatActivity {
    String spinnerSelected = "";
    String sexo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        List<String> estadoCivilList = Arrays.asList("Casado(a)", "Conviviente", "Viudo(a)", "Soltero(a)", "Anulado(a)","Casi algo","MejorAmigo", "Solo es un amigo");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, estadoCivilList));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSelected = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onRadioClickButtom(View view) {
        RadioButton buttomR = ((RadioButton) view);
        if (!buttomR.isChecked()) {
            return;
        }
        if (view.getId() == R.id.rdb_masculino) {
            Toast.makeText(getApplicationContext(), "Selecciono masculino", Toast.LENGTH_SHORT).show();
            sexo = "Masculino";
        } else if (view.getId() == R.id.rdb_femenino) {
            Toast.makeText(getApplicationContext(), "Selecciono femenino", Toast.LENGTH_SHORT).show();
            sexo = "Femenino";
        }
    }
}