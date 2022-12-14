package com.example.inicio8_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class Login extends AppCompatActivity {

    EditText txtUsuario;
    EditText txtContrasenia;

    public User[] users =
            {
                    new User("Helen", "1234"),
                    new User("Nefi", "1234"),
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       /* Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        Button btnLogin = (Button)findViewById(R.id.btn_login);
        Button btnExit = (Button)findViewById(R.id.btn_exit);
        txtUsuario = (EditText)findViewById(R.id.txt_nombre);
        txtContrasenia = (EditText)findViewById(R.id.txt_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent call_principal = new Intent(view.getContext(), MainActivity.class);
                if(txtUsuario.getText().toString() == users[0].nombre && txtContrasenia.getText().toString() == users[0].contrasenia){
                    call_principal.putExtra("name_usuario", txtUsuario.getText().toString());
                    call_principal.putExtra("clave", txtContrasenia.getText().toString());
                    startActivity(call_principal);
                }else{
                    Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }
}