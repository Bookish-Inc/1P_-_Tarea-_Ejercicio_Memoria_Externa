/*Considerando la tarea creada sobre formularios se deberá:

Almacenar los datos del registro en formato txt. Cada campo puede separarlos con ;
Recuperar los datos registrados en el archivo mediante el click del boton respectivo.
Podrá mostrarlo sobre alguna ventana adicional y/o según convenga al grupo.
En ningun caso podrá usar el Toast para mostrar dichos datos recuperados.

Deberá enviar un archivo PDF con el código legible (en caso que no esté legible, no tendrá toda la calificación), capture de las diferentes pantallas para demostrar el funcionamiento de lo requerido.

Nota: Deberá agregar al archivo el Link del video donde se muestre el funcionamiento de la actividad.
*/

package com.example.inicio8_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class Registro extends AppCompatActivity {
    String spinnerSelected = "";
    String sexo = "";
    EditText txtNombre;
    EditText txtApellido;
    EditText txtEdad;
    EditText txtTelefono;
    EditText txtCorreo;
    EditText txtContresenia;
    RadioButton rbtFemenino;
    RadioButton rbtMasculino;
    Spinner spnrEstadoCivil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        init();
        List<String> estadoCivilList = Arrays.asList("    ", "Casado(a)", "Conviviente", "Viudo(a)", "Soltero(a)", "Anulado(a)", "Casi algo", "MejorAmigo", "Solo es un amigo");

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

    private void init() {
        txtNombre = (EditText) findViewById(R.id.txt_nombre);
        txtApellido = (EditText) findViewById(R.id.txt_apellido);
        txtEdad = (EditText) findViewById(R.id.txt_edad);
        txtTelefono = (EditText) findViewById(R.id.txt_telefono);
        txtCorreo = (EditText) findViewById(R.id.txt_correo);
        txtContresenia = (EditText) findViewById(R.id.txt_contrasenia);
        rbtFemenino = (RadioButton) findViewById(R.id.rdb_femenino);
        rbtMasculino = (RadioButton) findViewById(R.id.rdb_masculino);
        spnrEstadoCivil = (Spinner) findViewById(R.id.spinner);

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


    public void onBtnRegistrar(View v) {
        //Mostrar mensaje de usuario registrado
        Toast.makeText(getApplicationContext(), "Estimado " + txtNombre.getText() + " " + txtApellido.getText() + " su cuenta fue creada con exito", Toast.LENGTH_SHORT).show();
    }

    public void onBtnBorrar(View v) {
        Boolean valor = false;
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtContresenia.setText("");
        rbtFemenino.setChecked(false);
        rbtMasculino.setChecked(false);
        spnrEstadoCivil.setSelection(0);

    }

    public void onBtnCancelar(View v) {
        //Mensaje
        Toast.makeText(getApplicationContext(), "Selecciono cancelar", Toast.LENGTH_SHORT).show();
        //Llamar a Log in
        Intent call_login = new Intent(v.getContext(), Login.class);
        startActivity(call_login);
    }

    public void GuardarFichero(View v) {
        int status = verificarStatus();
        String info;
        if (status == 0) {
            try {
                File f = new File(getExternalFilesDir(null), "registroBookish.txt");
                System.out.println("Archivo guardado: "+ f.getAbsolutePath());
                OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f, true));
                info = txtNombre.getText().toString() + ";" + txtApellido.getText().toString() + ";" +
                        sexo + ";" + spinnerSelected + ";" + txtEdad.getText().toString() + ";" +
                        txtTelefono.getText().toString() + ";" + txtCorreo.getText().toString() + ";" +
                        txtContresenia.getText().toString() + "\n";
                fout.write(info);
                fout.close();
                Toast.makeText(getApplicationContext(), "Archivo guardado con éxito", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Log.e("Ficheros", "Error al escribir generar el fichero");
            }
        } else {
            Toast.makeText(getApplicationContext(), "No se puede guardar", Toast.LENGTH_SHORT).show();
        }

    }

    public int verificarStatus() {
        String estado = Environment.getExternalStorageState();
        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(getApplicationContext(), "Montado SD", Toast.LENGTH_SHORT).show();
            return 0;
        } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            Toast.makeText(getApplicationContext(), "Montado solo lectura", Toast.LENGTH_SHORT).show();
            return 1;
        } else {
            Toast.makeText(getApplicationContext(), "No está montado", Toast.LENGTH_SHORT).show();
            return 2;
        }
    }

    public void RecuperarDatosFichero(View v) {
        String nomarchivo = "registroBookish.txt";
        File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(getExternalFilesDir(null), nomarchivo);
        try {
            System.out.println("FileExiste <----------------------------"  + file.getAbsolutePath());
            if (file.exists()) {
                try (BufferedReader input = new BufferedReader(new FileReader(file))) {
                    String line;
                    String datos = "";
                    while ((line = input.readLine()) != null) {
                        datos = line.replace(";", "\n");
                    }
                    //Llamar a pantalla activity_muestra_datos_fichero
                    Intent call_mostrar = new Intent(v.getContext(), MuestraDatosFichero.class);
                    call_mostrar.putExtra("textoFichero", datos);
                    startActivity(call_mostrar);
                }
            }


        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "No se encontró el archivo", Toast.LENGTH_SHORT).show();
        }
    }
}