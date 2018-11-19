package com.example.alienware.primerproyecto;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences mySharedPreferences;

    EditText editTextUsuario;
    EditText editTextPassword;
    Button buttonRegistrarUsuario;
    Button buttonLogin;
    Switch switchRecordar;
    RequestQueue requestQueue;
    static final String URL = "http://www.sicconviene.com/loginAndroid.php";
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mySharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_login);
        LoadWidgets();
        requestQueue = Volley.newRequestQueue(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            String usuario = editTextUsuario.getText().toString();
            String password = editTextPassword.getText().toString();
            @Override
            public void onClick(View view) {

                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.names().get(0).equals("success")) {

                                Toast.makeText(getApplicationContext(),jsonObject.getString("success"),Toast.LENGTH_SHORT).show();
                                saveUserOnSharedPreferences(usuario,password);
                                goToActivity(PantallaInicio.class);

                            } else {
                                Toast.makeText(getApplicationContext(),jsonObject.getString("error"),Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        hashMap.put("usuario",usuario);
                        hashMap.put("password",password);
                        return hashMap;
                    }
                };

                requestQueue.add(request);
            }
        });

        buttonRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(RegistrarUsuarioActivity.class);
            }
        });

    }

    public void LoadWidgets() {
        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegistrarUsuario = (Button) findViewById(R.id.buttonRegistrarUsuario);
    }



    public void saveUserOnSharedPreferences(String usuario, String password) {
        if(switchRecordar.isChecked()) {
            SharedPreferences.Editor myEditor = mySharedPreferences.edit();
            myEditor.putString("usuario",usuario);
            myEditor.putString("password",password);
            myEditor.commit();
            myEditor.apply();
        }
    }

    public void goToActivity(Class activity) {
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }
}
