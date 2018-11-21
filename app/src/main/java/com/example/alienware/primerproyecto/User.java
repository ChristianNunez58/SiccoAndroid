package com.example.alienware.primerproyecto;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class User {

    int count = 0;
    int id = count+1;
    String usuario, password, nombre, apellidoPat, apellidoMat, semestre, especialidad, noControl, edad, correo;

    public User (String usuario, String password, String nombre, String apellidoPat, String apellidoMat, String semestre, String especialidad, String noControl,  String edad, String correo) {

        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.semestre = semestre;
        this.especialidad = especialidad;
        this.noControl = noControl;
        this.edad = edad;
        this.correo = correo;
        count++;
        this.id = count+1;
    }

    public User(HashMap<String, String> usuario) {

        this.usuario = usuario.get("usuario");
        this.password = usuario.get("password");
        this.nombre = usuario.get("nombre");
        this.apellidoPat = usuario.get("apellidoPat");
        this.apellidoMat = usuario.get("apellidoPat");
        this.semestre = usuario.get("semestre");
        this.especialidad = usuario.get("especialidad");
        this.noControl = usuario.get("noControl");
        this.edad = usuario.get("edad");
        this.correo = usuario.get("correo");
        count++;
        this.id = count+1;
    }

    public String convertToJSONString(HashMap<String,String> hashMap) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.enableComplexMapKeySerialization().setPrettyPrinting().create();
        Type type = new TypeToken<HashMap<String,String>>(){}.getType();
        String json = gson.toJson(hashMap, type);
        return json;
    }

    public HashMap<String,String> convertToHashMap(String json) {
        String jsonString = "JSON string.";
        HashMap<String,String> hashMap = new Gson().fromJson(jsonString, new TypeToken<HashMap<String,String>>(){}.getType());
        return hashMap;
    }

    public void saveOnSharedPreferences() {

    }
}