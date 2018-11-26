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

    String url = "http://www.sicconviene.com/loginAndroid2.php";
    Map<String, String> params = new HashMap<String,String>();
    String json = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(LoginActivity.this, PantallaInicio.class);
        startActivity(intent);
        loadWidgets();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMap(params);
                try {
                    JSONRequest(params);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

    public void JSONRequest(Map<String,String>map) throws JSONException {
        json = Utils.convertMapToJSONOString(map);
        JSONObject jsonBody = new JSONObject(json);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET, url, jsonBody, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.names().get(0).equals("success")) {
                        Toast.makeText(getApplicationContext(),response.getString("success"),Toast.LENGTH_SHORT).show();
                        Utils.saveOnSharedPreferences(getApplicationContext(),json,switchRecordar.isChecked());
                        Utils.goToActivity(getApplicationContext(),PantallaInicio.class);
                    } else {
                        Toast.makeText(getApplicationContext(),response.getString("error"),Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}