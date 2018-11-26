package com.example.alienware.primerproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Activity_misArticulos extends AppCompatActivity {

    private ListView listView;

    int contador = 0;
    //El limite de objetos que coiciden con la busqueda
    int limite = 9;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_misarticulos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_misArticulos.this, Registro_Articulo.class);
                startActivity(intent);
            }
        });
        listView = findViewById(R.id.listamisarticulos);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            usuario = bundle.getString("usuario");
        }

        //Aqui se asigna el numero de resultados
        limite = 1;

        //Los vectores y arreglos que se llenaran con los datos
        String[][] datosProducto = new String[limite][2];
        int[] imagenes = new int[limite];

        //El ciclo en donde se llenara la matriz y vector
        while (contador < limite)
        {
            //Aqui se remplaza el nombre del producto
            datosProducto[contador][0] = usuario;
            //Aqui el precio
            datosProducto[contador][1] = "$" + usuario;
            //Aqui la respectiva imagen
            imagenes[contador] = R.drawable.ic_baseline_category_24px;
            contador++;
        }

        /*datosProducto[0][0] = "Hojas blancas";
        datosProducto[0][1] = "1";
        imagenes[0] = R.drawable.img_4;*/


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
