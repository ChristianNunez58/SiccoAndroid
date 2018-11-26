package com.example.alienware.primerproyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Spinner spnSemestre = findViewById(R.id.spinnerSemestre);
        Spinner spnEspecialidad = findViewById(R.id.spinnerEspecialidad);

        ArrayList<String> ListaSemestre = new ArrayList<>();
        ArrayList<String> ListaEspecialidad = new ArrayList<>();
        ListaEspecialidad.add("Programacion");
        ListaEspecialidad.add("Electronica");
        ListaEspecialidad.add("Logistica");
        ListaEspecialidad.add("Administracion");

        ListaSemestre.add("1ro Primero");
        ListaSemestre.add("2do Segundo");
        ListaSemestre.add("3ro Tercero");
        ListaSemestre.add("4to Cuarto");
        ListaSemestre.add("5to Quinto");
        ListaSemestre.add("6to Sexto");

        ArrayAdapter<String> arrayAdapterEspecialidad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ListaEspecialidad);
        arrayAdapterEspecialidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> arrayAdapterSemestre = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ListaSemestre);
        arrayAdapterSemestre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnEspecialidad.setAdapter(arrayAdapterEspecialidad);
        spnSemestre.setAdapter(arrayAdapterSemestre);
        spnEspecialidad.setSelection(0);
        spnSemestre.setSelection(0);


        spnEspecialidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Usuario.this, "Seleccionado" +
                        String.valueOf(parent.getAdapter().getItem(position)), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Usuario.this, "Nada",Toast.LENGTH_SHORT).show();
            }
        });

        spnSemestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Usuario.this, "Seleccionado" +
                        String.valueOf(parent.getAdapter().getItem(position)), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Usuario.this, "Nada",Toast.LENGTH_SHORT).show();
            }
        });
        }

}
