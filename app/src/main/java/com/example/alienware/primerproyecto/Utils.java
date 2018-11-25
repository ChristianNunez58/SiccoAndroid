package com.example.alienware.primerproyecto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class Utils {
    public static String convertMapToJSONOString(Map<String,String> map) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(map);
        return json;
    }

    public static Map<String,String> convertJSONStringToMap(String json) {
        Gson gson = new GsonBuilder().create();
        Type typeOfHashMap = new TypeToken<Map<String,String>>(){}.getType();
        Map<String,String> newMap =gson.fromJson(json,typeOfHashMap);
        return newMap;
    }

    public static void saveOnSharedPreferences (Context context, String data, boolean recordar) {
        if (recordar) {
            SharedPreferences preferences = context.getSharedPreferences("usuario",MODE_PRIVATE);
            preferences.edit().putString("hashmap",data).apply();
        }
    }

    public static void goToActivity (Context context,Class activity) {
        Intent intent = new Intent(context,activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
