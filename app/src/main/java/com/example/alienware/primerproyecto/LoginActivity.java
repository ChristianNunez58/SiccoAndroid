package com.example.alienware.primerproyecto;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextPassword;
    Button buttonLogin, buttonRegistrarUsuario;
    Switch switchRecordar;

    User userAdmin, newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadWidgets();
        uploadAdminUser();
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        boolean firstTime = sharedPreferences.getBoolean("firstrun",false);
        boolean isChecked = sharedPreferences.getBoolean("guardar",false);
        if (firstTime) {
            sharedPreferences.edit().putBoolean("firstrun",false).apply();
            sharedPreferences.edit().putBoolean("guardar",false).apply();
            uploadNewUser();
            saveNewUser();
            saveUserAdmin();

        }else if (isChecked) {
            Utils.goToActivity(getApplicationContext(),PantallaInicio.class);
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadNewUser();
                String usuario = editTextUsuario.getText().toString();
                String password = editTextPassword.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
                if (usuario.equals(userAdmin.nombreUsuario) && password.equals(userAdmin.password)) {
                    if (switchRecordar.isChecked()) {
                        sharedPreferences.edit().putBoolean("guardar",true).apply();
                    }
                    sharedPreferences.edit().putString("token","user").apply();
                    Toast.makeText(getApplicationContext(),"Bienvenido "+userAdmin  .nombreUsuario,Toast.LENGTH_SHORT).show();
                    Utils.goToActivity(getApplicationContext(),PantallaInicio.class);
                } else if (usuario.equals(newUser.nombreUsuario) && password.equals(newUser.password)){
                    sharedPreferences.edit().putString("token","user").apply();
                    if (switchRecordar.isChecked()) {
                        sharedPreferences.edit().putBoolean("guardar",true).apply();
                    }
                    Toast.makeText(getApplicationContext(),"Bienvenido "+newUser.nombreUsuario,Toast.LENGTH_SHORT).show();
                    Utils.goToActivity(getApplicationContext(),PantallaInicio.class);
                } else {
                    Toast.makeText(getApplicationContext(),"Usuario invalido, por favor intenta nuevamente",Toast.LENGTH_SHORT).show();
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
        editTextUsuario = findViewById(R.id.editTextUsuarioRegistro);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegistrarUsuario = findViewById(R.id.buttonRegistrarUsuario);
        switchRecordar = findViewById(R.id.switchRecordarPassword);
    }

    public void uploadAdminUser() {
        HashMap<String, String> user1 = new HashMap<>();
        user1.put("typeOfData","user");
        user1.put("nombre","Elian");
        user1.put("apellidoPat","Cruz");
        user1.put("apellidoMat","Esquivel");
        user1.put("especialidad","1");
        user1.put("semestre","5");
        user1.put("noControl","458720125");
        user1.put("edad","17");
        user1.put("usuario","aa");
        user1.put("password","4321");
        user1.put("correo","aa@gmail.com");

        userAdmin = new User(user1);
    }

    public void uploadNewUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        HashMap<String, String> user1 = new HashMap<>();
        user1.put("typeOfData","user");
        user1.put("nombre",sharedPreferences.getString("nombreUser",""));
        user1.put("apellidoPat",sharedPreferences.getString("apellidoPatUser",""));
        user1.put("apellidoMat",sharedPreferences.getString("apellidoMatUser",""));
        user1.put("especialidad",sharedPreferences.getString("especialidadUser",""));
        user1.put("semestre",sharedPreferences.getString("semestreUser",""));
        user1.put("noControl",sharedPreferences.getString("noControlUser",""));
        //user1.put("edad",sharedPreferences.getString("edadUser",""));
        user1.put("usuario",sharedPreferences.getString("usuarioUser",""));
        user1.put("password",sharedPreferences.getString("passwordUser",""));
        user1.put("correo",sharedPreferences.getString("emailUser",""));
        newUser = new User(user1);
    }

    public void saveUserAdmin() {
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("firstrun",false);
        editor.putString("emailAdmim",userAdmin.correo);
        editor.putString("passwordAdmin",userAdmin.password);
        editor.putString("nombreAdmin",userAdmin.nombre);
        editor.putString("usuarioAdmin",userAdmin.nombreUsuario);
        editor.putString("apellidoPatAdmin",userAdmin.apellidoPat);
        editor.putString("apellidoMatAdmin",userAdmin.apellidoMat);
        editor.putString("especialidadAdmin",userAdmin.especialidad);
        editor.putString("semestreAdmin",userAdmin.semestre);
        editor.putString("noControlAdmin",userAdmin.noControl);
        editor.putString("edadAdmin",userAdmin.edad);
        editor.putString("token","admin");
        editor.apply();
    }

    public void saveNewUser () {
        SharedPreferences userPreferences = getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor editor = userPreferences.edit();
        editor.putString("emailUser",null);
        editor.putString("passwordUser",null);
        editor.putString("nombreUser",null);
        editor.putString("usuarioUser",null);
        editor.putString("apellidoPatUser",null);
        editor.putString("apellidoMatUser",null);
        editor.putString("especialidadUser",null);
        editor.putString("semestreUser",null);
        editor.putString("noControlUser",null);
        editor.putString("edadUser",null);
        editor.apply();
    }
}