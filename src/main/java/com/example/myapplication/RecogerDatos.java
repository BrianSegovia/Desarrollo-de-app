package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class RecogerDatos extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoger_datos);
        final EditText fechaDeNacimiento = (EditText) findViewById(R.id.fechaDeNacimiento);
        final EditText nombre = (EditText) findViewById(R.id.nombre);
        final EditText telefono = (EditText) findViewById(R.id.telefono);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText descripcion = (EditText) findViewById(R.id.descripcion);
        final Button siguiente = (Button) findViewById(R.id.siguiente);



// onclick on edit text
        fechaDeNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(RecogerDatos.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                fechaDeNacimiento.setText(dayOfMonth + "/"+ (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RecogerDatos.this,MostrarDatos.class);
                intent.putExtra("Nombre", nombre.getText().toString()) ;
                intent.putExtra("Fecha" , fechaDeNacimiento.getText().toString());
                intent.putExtra("Teléfono", telefono.getText().toString());
                intent.putExtra("Email",email.getText().toString());
                intent.putExtra("Descripcion",descripcion.getText().toString());
                startActivity(intent);
            }
        });

    }

}