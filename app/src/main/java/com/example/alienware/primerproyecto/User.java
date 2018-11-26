package com.example.alienware.primerproyecto;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

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
}

