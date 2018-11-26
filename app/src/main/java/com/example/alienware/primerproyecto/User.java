package com.example.alienware.primerproyecto;

import android.app.Activity;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class User extends Activity {
    int count = 0, id;
    String typeOfData, nombre, apellidoPat, apellidoMat, especialidad, semestre, noControl, edad, nombreUsuario, password, correo;
    String nombreArticulo, precio, categoria, tipo, descripcion, imagen;

    public User(HashMap<String, String> map) {
        count++;
        this.id = count + 1;
        String type = map.get("typeOfData");
        this.typeOfData = type;
        if (type.equals("user")) {
            this.nombre = map.get("nombre");
            this.apellidoPat = map.get("apellidoPat");
            this.apellidoMat = map.get("apellidoMat");
            this.especialidad = map.get("especialidad");
            this.semestre = map.get("semestre");
            this.noControl = map.get("noControl");
            this.edad = map.get("edad");
            this.nombreUsuario = map.get("usuario");
            this.password = map.get("password");
            this.correo = map.get("correo");
            this.nombreArticulo = null;
            this.precio = null;
            this.categoria = null;
            this.tipo = null;
            this.descripcion = null;
        } else {
            this.nombreArticulo = map.get("nombre");
            this.precio = map.get("precio");
            this.categoria = map.get("categoria");
            this.tipo = map.get("tipo");
            this.descripcion = map.get("descripcion");
            this.imagen = null;
            this.nombre = null;
            this.apellidoPat = null;
            this.apellidoMat = null;
            this.especialidad = null;
            this.semestre = null;
            this.noControl = null;
            this.edad = null;
            this.nombreUsuario = null;
            this.password = null;
            this.correo = null;
        }

    }

    public void saveOnPreferences(HashMap<String, String> map) {
        String jsonString = convertToJSONString(map);
        SharedPreferences sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE);
        sharedPreferences.edit().putString("newData", jsonString).apply();
    }

    public String convertToJSONString(HashMap<String, String> map) {
        Gson gson = new Gson();
        String result = gson.toJson(map);
        return result;
    }

    public boolean checkUser () {
        boolean isRight = true;
        return isRight;
    }
/*    public HashMap<String, String> getFromSharedPreferences(HashMap<String, String> queryMap) {
        SharedPreferences sharedPreferences = getSharedPreferences("getUser", MODE_PRIVATE);
        Gson gson = new Gson();
        String jsonString = sharedPreferences.getString("saveUser", "oops");
        java.lang.reflect.Type type = new TypeToken<HashMap<String, String>>() {
        }.getType();
        HashMap<String, String> mapFromSH = gson.fromJson(jsonString, type);

        HashMap<String, String> resultMap = null;

        String value, mapKey;
        for (int i = 0; i < queryMap.size() + 1; i++) {
            mapKey = queryMap.get(i);
            value = mapFromSH.get(mapKey);
            resultMap.put(mapKey, value);
        }
        return resultMap;
    }*/
}

