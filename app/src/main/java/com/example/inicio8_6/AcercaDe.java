package com.example.inicio8_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Button btnRegreso = (Button) findViewById(R.id.btn_regresar);

        btnRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Llamar a Login
                Intent call = new Intent(view.getContext(), Login.class);
                startActivity(call);
            }
        });
    }
}