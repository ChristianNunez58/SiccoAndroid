package com.example.alienware.primerproyecto;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegistrarUsuarioActivity extends AppCompatActivity {

    EditText editTextNombre, editTextAP, editTextAM, editTextUsuario, editTextPassword, editTextNoControl, editTextEmail;
    Spinner spinnerSemestre, spinnerEspecialidad;
    Button buttonRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        loadWidgets();
        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser();
                Utils.goToActivity(getApplicationContext(),LoginActivity.class);
            }
        });
    }

    public void loadWidgets () {
        editTextAM = findViewById(R.id.editTextApPat);
        editTextAP = findViewById(R.id.editTextApMat);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextNoControl = findViewById(R.id.editTextNoControl);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextPassword =findViewById(R.id.editTextPassword);
        spinnerEspecialidad = findViewById(R.id.spinnerEspecialidad);
        spinnerSemestre = findViewById(R.id.spinnerSemestre);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);
        editTextUsuario = findViewById(R.id.editTextUsuarioRegistro);
    }

    public void saveNewUser () {
        SharedPreferences userPreferences = getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor editor = userPreferences.edit();
        editor.putString("emailUser",editTextEmail.getText().toString());
        editor.putString("passwordUser",editTextPassword.getText().toString());
        editor.putString("nombreUser",editTextNombre.getText().toString());
        editor.putString("usuarioUser",editTextUsuario.getText().toString());
        editor.putString("apellidoPatUser",editTextAP.getText().toString());
        editor.putString("apellidoMatUser",editTextAM.getText().toString());
//        editor.putString("especialidadUser",spinnerEspecialidad.getSelectedItem().toString());
//        editor.putString("semestreUser",spinnerSemestre.getSelectedItem().toString());
        editor.putString("noControlUser",editTextNoControl.getText().toString());
        editor.apply();
    }
}
