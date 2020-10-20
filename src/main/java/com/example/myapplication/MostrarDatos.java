package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MostrarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);


        final TextView nombre = (TextView) findViewById(R.id.nombre);
        final TextView fecha = (TextView) findViewById(R.id.fecha);
        final TextView telefono = (TextView) findViewById(R.id.telefono);
        final TextView email = (TextView) findViewById(R.id.email);
        final TextView descripcion = (TextView) findViewById(R.id.descripcion);
        Button editar = (Button) findViewById(R.id.editar);
        Intent i = getIntent();
        Bundle parametros = i.getExtras();

        nombre.setText((String)(parametros.getString(("Nombre"))));
        fecha.setText(parametros.getString("Fecha"));
        telefono.setText(parametros.getString("Teléfono"));
        email.setText(parametros.getString("Email"));
        descripcion.setText(parametros.getString("Descripcion"));

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        }
    }
