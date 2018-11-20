package com.example.alienware.primerproyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Busqueda extends AppCompatActivity {

    private ListView listView;

    int contador = 0;
   //El limite de objetos que coiciden con la busqueda
    int limite = 9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout__busqueda);

        listView = findViewById(R.id.listbusqueda);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            String labusqueda = bundle.getString("busqueda");
        }

        //Los vectores y arreglos que se llenaran con los datos
        String[][] datosProducto = new String[limite][2];
        int[] imagenes = new int[limite];

        //El ciclo en donde se llenara la matriz y vector
        while (contador < limite)
        {
           //Aqui se remplaza el nombre del producto
           datosProducto[contador][0] = "Lapiz";
           //Aqui el precio
           datosProducto[contador][1] = "$Precio";
           //Aqui la respectiva imagen
           imagenes[contador] = R.drawable.ic_baseline_category_24px;
            contador++;
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parnt, View view, int position, long id)
            {

            }
        });

        listView.setAdapter(new AdaptadorBusqueda(this, datosProducto, imagenes));
    }
}

