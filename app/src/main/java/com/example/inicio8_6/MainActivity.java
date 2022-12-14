package com.example.inicio8_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
// REVISAR LAS LIBRERÍAS DE LOS COMPONENTES

public class MainActivity extends AppCompatActivity {

    public int score = 0;
    public int contador = 0;
    public Preguntas[] pregunta_test =
            {
                    new Preguntas("¿Nos vamos al mundial?", "falso"),
                    new Preguntas("¿Todos pasarán la materia?", "falso"),
                    new Preguntas("¿El examen estará difícil?", "verdadero"),
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVerdadero = (Button) findViewById(R.id.btn_verdadero);
        Button btnFalso = (Button) findViewById(R.id.btn_falso);

        TextView txtJugador = (TextView) findViewById(R.id.txt_jugador);
        final TextView txtPregunta = (TextView) findViewById(R.id.txt_pregunta);
        final TextView txtPuntaje = (TextView) findViewById(R.id.txt_puntaje);

        Bundle bundle = getIntent().getExtras();
        String nombre_jugador = bundle.getString("name_usuario");
        txtJugador.setText("Jugador: " + nombre_jugador);

        Preguntas p1 = pregunta_test[0];
        txtPregunta.setText(p1.getPregunta());

        btnVerdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador = +1;
                if (p1.getRespuesta() == "verdadero")
                    score = +100;
                else
                    score = -100;
                txtPuntaje.setText(" " + String.valueOf(score) + " ");
                Preguntas p1 = pregunta_test[contador];
                txtPregunta.setText(p1.getPregunta());

            }
        });

        btnFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador = +1;
                if (p1.getRespuesta() == "falso")
                    score = +100;
                else
                    score = -100;
                txtPuntaje.setText(" " + String.valueOf(score) + " ");
                Preguntas p1 = pregunta_test[contador];
                txtPregunta.setText(p1.getPregunta());

            }
        });
    }
}