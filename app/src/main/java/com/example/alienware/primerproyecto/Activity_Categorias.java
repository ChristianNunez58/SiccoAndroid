package com.example.alienware.primerproyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity_Categorias extends AppCompatActivity {

    private ImageView artes;
    private ImageView ciencias;
    private ImageView cursos;
    private ImageView matematicas;
    private ImageView papeleria;
    private ImageView otros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout__categorias);

        artes = findViewById(R.id.artes);
        ciencias = findViewById(R.id.ciencias);
        cursos = findViewById(R.id.cursos);
        matematicas = findViewById(R.id.matematicas);
        papeleria = findViewById(R.id.papeleria);
        otros = findViewById(R.id.otros);

        artes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("1");
            }
        });
        ciencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("2");
            }
        });
        cursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("3");
            }
        });
        matematicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("4");
            }
        });
        papeleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("5");
            }
        });
        otros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("6");
            }
        });
    }

    public void goToActivity(String categoria) {
        Intent intent = new Intent(Activity_Categorias.this, Activity_lista_Buscar.class);
        intent.putExtra("entrada",1);
        intent.putExtra("categoria",categoria);
        startActivity(intent);
    }
}
