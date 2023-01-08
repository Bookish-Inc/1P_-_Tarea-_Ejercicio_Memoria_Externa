package com.example.inicio8_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MuestraDatosFichero extends AppCompatActivity {

    EditText txtMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_datos_fichero);

        txtMostrar = (EditText) findViewById(R.id.txt_mostrar);
        Bundle bundle = getIntent().getExtras();
        String texto = bundle.getString("textoFichero");
        txtMostrar.setText(texto);
    }

    public void onBtnRegresar(View v){
        //Llamar a Registro
        Intent call_registro = new Intent(v.getContext(), Registro.class);
        startActivity(call_registro);
    }
}