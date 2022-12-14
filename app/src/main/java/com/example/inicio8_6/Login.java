package com.example.inicio8_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class Login extends AppCompatActivity {

    EditText txtUsuario;
    EditText txtContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        Button btnLogin = (Button)findViewById(R.id.btn_login);
        txtUsuario = (EditText)findViewById(R.id.txt_nombre);
        txtContrasenia = (EditText)findViewById(R.id.txt_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent call_principal = new Intent(view.getContext(), MainActivity.class);
                call_principal.putExtra("name_usuario", txtUsuario.getText().toString());
                call_principal.putExtra("clave", txtContrasenia.getText().toString());
                startActivity(call_principal);
            }
        });
    }

    private void setSupportActionBar(Toolbar myToolbar) {
    }
}