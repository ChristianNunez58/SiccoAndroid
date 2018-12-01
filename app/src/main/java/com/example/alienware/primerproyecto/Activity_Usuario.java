package com.example.alienware.primerproyecto;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Usuario extends AppCompatActivity {

    EditText spinnerSemestre;
    EditText spinnerEspecialidad;
    EditText editTextNombre,editTextUsuario, editTextEdad, editTextCorreo, editTextNoControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__usuario);
        loadWidgets();
        loadUser();
        /*spinnerEspecialidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Activity_Usuario.this, "Seleccionado" +
                        String.valueOf(parent.getAdapter().getItem(position)), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Activity_Usuario.this, "Nada",Toast.LENGTH_SHORT).show();
            }
        });

        spinnerSemestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Activity_Usuario.this, "Seleccionado" +
                        String.valueOf(parent.getAdapter().getItem(position)), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Activity_Usuario.this, "Nada",Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    private void loadUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        String token = sharedPreferences.getString("token","admin");
        if (token.equals("admin")) {
            editTextNombre.setText(sharedPreferences.getString("nombreAdmin",""));
            editTextUsuario.setText(sharedPreferences.getString("usuarioAdmin",""));
            editTextCorreo.setText(sharedPreferences.getString("emailAdmin",""));
            editTextNoControl.setText(sharedPreferences.getString("noControlAdmin",""));
            editTextEdad.setText("17");
            spinnerSemestre.setText(sharedPreferences.getString("semestreAdmin",""));
        } else {
            editTextNombre.setText(sharedPreferences.getString("nombreUser",""));
            editTextUsuario.setText(sharedPreferences.getString("usuarioUser",""));
            editTextCorreo.setText(sharedPreferences.getString("emailUser",""));
            editTextNoControl.setText(sharedPreferences.getString("noControlUser",""));
            editTextEdad.setText("17");
            spinnerSemestre.setText(sharedPreferences.getString("semestreUser",""));
        }
    }

    public void loadWidgets() {
        editTextNombre = findViewById(R.id.NombreUsuario_usuario);
        editTextEdad = findViewById(R.id.Edad_usuario);
        editTextCorreo = findViewById(R.id.correoelectronico_usuario);
        editTextNoControl = findViewById(R.id.nocontrol_usuario);
        editTextUsuario = findViewById(R.id.Usuario_usuario);
        spinnerSemestre = findViewById(R.id.spnSemestre);
        spinnerEspecialidad = findViewById(R.id.spnEspecialidad);
    }


}
