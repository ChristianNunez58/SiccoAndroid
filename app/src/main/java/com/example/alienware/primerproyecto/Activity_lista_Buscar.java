package com.example.alienware.primerproyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Activity_lista_Buscar extends AppCompatActivity {

    private ListView listView;

    int contador = 0;
    //El limite de objetos que coiciden con la busqueda
    int limite = 0;
    String labusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__buscar);

        listView = findViewById(R.id.listaarticulos);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            switch (bundle.getInt("entrada"))
            {
                case 1:
                    labusqueda = bundle.getString("categoria");
                break;
                case 2:
                    labusqueda = bundle.getString("busqueda");
                    break;
            }
        }

        //Aqui se asigna el numero de resultados
        limite = 4;

        //Los vectores y arreglos que se llenaran con los datos
        String[][] datosProducto = new String[limite][2];
        int[] imagenes = new int[limite];

        //El ciclo en donde se llenara la matriz y vector
       /* while (contador < limite)
        {
            //Aqui se remplaza el nombre del producto
            datosProducto[contador][0] = labusqueda;
            //Aqui el precio
            datosProducto[contador][1] = "$" + labusqueda;
            //Aqui la respectiva imagen
            imagenes[contador] = R.drawable.ic_baseline_category_24px;
            contador++;
        }*/
        datosProducto[0][0] = "Hojas de carpeta";
        datosProducto[0][1] = "$" + "1.50";
        imagenes[0] = R.drawable.img_1;
        datosProducto[1][0] = "Carpeta morada de martha";
        datosProducto[1][1] = "$" + "15";
        imagenes[1] = R.drawable.img_2;
        datosProducto[2][0] = "Protectores de hoja";
        datosProducto[2][1] = "$" + "2";
        imagenes[2] = R.drawable.img_3;
        datosProducto[3][0] = "Hojas blancas";
        datosProducto[3][1] = "$" + "1";
        imagenes[3] = R.drawable.img_4;


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parnt, View view, int position, long id)
            {
                Intent intent = new Intent(Activity_lista_Buscar.this, Vendedor.class);
                startActivity(intent);

            }
        });

        listView.setAdapter(new AdaptadorBusqueda(this, datosProducto, imagenes));
    }
}
