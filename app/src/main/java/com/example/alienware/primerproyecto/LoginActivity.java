package com.example.alienware.primerproyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsuario;
    EditText editTextPassword;
    Button buttonRegistrarUsuario;
    Button buttonLogin;
    Switch switchRecordar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoadWidgets();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editTextUsuario.getText().toString();
                String password = editTextPassword.getText().toString();
                login(usuario,password);
            }
        });
    }
    public void login(String usuario, String password) {
        boolean result = IsValidFormat(usuario,password);
        loginAction(result);
    }

    public void loginAction(boolean result) {
        if (result) {
            Toast.makeText(this,"Formato valido, Bienvenido.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this,PantallaInicio.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        } else {
            Toast.makeText(this,"Formato invalido, problema en transferencia de datos.", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean IsValidFormat(String usuario, String password) {
        if (!usuario.isEmpty()&&!password.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public void LoadWidgets() {
        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegistrarUsuario = (Button) findViewById(R.id.buttonRegistrarUsuario);
    }
}
