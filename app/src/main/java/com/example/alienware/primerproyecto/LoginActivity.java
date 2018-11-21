package com.example.alienware.primerproyecto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextPassword;
    Button buttonLogin, buttonRegistrarUsuario;
    Switch switchRecordar;

    HashMap<String,String> user1 = new HashMap<String,String>();
    HashMap<String,String> user2 = new HashMap<String,String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadWidgets();
        loadUsers();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCorrect = checkUser(editTextUsuario.getText().toString(),editTextPassword.getText().toString());
                if (isCorrect) {
                    goToActivity(PantallaInicio.class);
                } else {
                    Toast.makeText(getApplicationContext(), "Credencial invalida, por favor ingresa nuevamente.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(RegistrarUsuarioActivity.class);
            }
        });
    }

    public void loadWidgets() {
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegistrarUsuario = findViewById(R.id.buttonRegistrarUsuario);
        switchRecordar = findViewById(R.id.switchRecordarPassword);


    }

    public String convertHashMap (HashMap hashMap) {
        Gson gson = new Gson();
        String hashmapString = gson.toJson(hashMap);

    }

    public void saveOnSharedPreferences (String data) {
        SharedPreferences preferences = getSharedPreferences("usuario",MODE_PRIVATE);
        preferences.edit().putString("hashString",data).apply();
    }
    public void loadUsers() {
        user1.put("usuario","aa");
        user1.put("password","4321");
        user1.put("nombre","Elian");
        user1.put("apellido_paterno","Cruz");
        user1.put("apellido_materno","Esquivel");
        user1.put("Especialidad","1");
        user1.put("semestre","5");
        user1.put("no_control","1");
        user1.put("edad","17");
        user1.put("correo","aa@gmail.com");

        user2.put("usuario","lalupis");
        user2.put("password","1234");
        user2.put("nombre","Lupita");
        user2.put("apellido_paterno","Solorio");
        user2.put("apellido_materno","Duran");
        user2.put("Especialidad","1");
        user2.put("semestre","5");
        user2.put("no_control","555");
        user2.put("edad","15");
        user2.put("correo","lupita1112tec@gmail.com");
    }

    public boolean checkUser(String usuario, String password) {
        if (usuario.equals(user1.get("usuario"))&&password.equals(user1.get("password"))) { return true; }
        else if (usuario.equals(user2.get("usuario"))&&password.equals(user2.get("password"))) { return true; }
        else { return false; }
    }

    public void goToActivity (Class activity) {
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }
}