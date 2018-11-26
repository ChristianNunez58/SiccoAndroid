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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextPassword;
    Button buttonLogin, buttonRegistrarUsuario;
    Switch switchRecordar;

    Map<String, String> params = new HashMap<String,String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadWidgets();


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMap(params);

            }
        });

        buttonRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.goToActivity(getApplicationContext(),RegistrarUsuarioActivity.class);
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

    public void loadMap(Map<String,String> map) {
        String usuario = editTextUsuario.getText().toString();
        String password = editTextUsuario.getText().toString();
        map.put("usuario",usuario);
        map.put("password",password);
    }

    public void uploadDefaultUsers() {
        boolean firstTime = getSharedPreferences("preferences",MODE_PRIVATE).getBoolean("firstrun",true);

        if (firstTime) {
            //aqui va codigo para login, ahorita me lo aviento.
        }
    }
}