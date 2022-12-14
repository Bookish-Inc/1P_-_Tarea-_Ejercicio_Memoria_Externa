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
                    new User("Renan", "1234"),
                    new User("Vane", "1234"),
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       /*Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);*/


        Button btnLogin = (Button) findViewById(R.id.btn_login);
        Button btnExit = (Button) findViewById(R.id.btn_exit);
        txtUsuario = (EditText) findViewById(R.id.txt_nombre);
        txtContrasenia = (EditText) findViewById(R.id.txt_password);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bandera = false;
                Intent call_principal = new Intent(view.getContext(), MainActivity.class);
                //System.out.println(txtUsuario.getText().toString());
                //System.out.println(txtContrasenia.getText().toString());
                //System.out.println(users[0].nombre.toString());
                //System.out.println(users[0].contrasenia.toString());
                //System.out.println("users.length = " + users.length);
                for (int i = 0; i < users.length; i = i + 1) {
                    System.out.println("users.length = " + users.length + "\n Nombre: " + users[i].nombre+ "\n Contraseña: " + users[i].contrasenia);
                    if ((txtUsuario.getText().toString().equals(users[i].nombre.toString())) && (txtContrasenia.getText().toString().equals(users[i].contrasenia.toString()))) {
                        call_principal.putExtra("name_usuario", txtUsuario.getText().toString());
                        call_principal.putExtra("clave", txtContrasenia.getText().toString());
                        startActivity(call_principal);
                        bandera = true;
                        break;
                    }
                }

                if (bandera == false) {
                    Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}