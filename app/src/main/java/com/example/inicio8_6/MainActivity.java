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
    Preguntas lastPregunta;
    public Preguntas[] pregunta_test =
            {
                    new Preguntas("¿Nos vamos al mundial?", false),
                    new Preguntas("¿Todos pasarán la materia?", false),
                    new Preguntas("¿El examen estará difícil?", true),
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

        lastPregunta = pregunta_test[0];
        txtPregunta.setText(lastPregunta.getPregunta());

        btnVerdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // no sirve el usar estas cosas:  =+ =-
                contador = contador + 1;
                if (lastPregunta.getRespuesta())
                    score = score + 100;
                else
                    score = score - 100;
                update();
                txtPuntaje.setText(" " + score + " ");
                txtPregunta.setText(lastPregunta.getPregunta());

            }
        });

        btnFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador = contador + 1;
                if (!lastPregunta.getRespuesta())
                    score = score + 100;
                else
                    score = score - 100;
                update();
                txtPuntaje.setText(" " + score + " ");
                txtPregunta.setText(lastPregunta.getPregunta());

            }
        });
    }

    private void update(){
        if (contador >= pregunta_test.length){
            contador =0;
            score = 0;
        }
        lastPregunta = pregunta_test[contador];
    }
}