package com.example.alienware.primerproyecto;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Articulo extends AppCompatActivity {

    public static String nombre;
    public static  String nuevo ;
    TextView vendedor;
    TextView nombreart;
    TextView precio;
    TextView item;
    ImageView imagen;
    String nombreNuevo, vendedorNuevo, precioNuevo, itemNuevo, imagenNuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);
        vendedor = findViewById(R.id.txtVendedor);
        nombreart = findViewById(R.id.txtNombreProducto);
        precio = findViewById(R.id.txtPrecio);
        item = findViewById(R.id.txtitems);
        imagen = findViewById(R.id.imageViewProducto);

       Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            SharedPreferences sharedPreferences = getSharedPreferences("articulo",MODE_PRIVATE);
            nombreNuevo = sharedPreferences.getString("nombreArticulo","");
            nombre = bundle.getString("nombre");

            if (nombre != null) {
                if(nombre.equals(nuevo))
                {


                    precioNuevo = sharedPreferences.getString("precio","");
                    SharedPreferences sharedPreferences1 = getSharedPreferences("user",MODE_PRIVATE);
                    vendedorNuevo = sharedPreferences1.getString("nombreUser","");
                    itemNuevo = "3";
                }
                else
                {
                    switch (nombre)
                    {
                        case "Hojas de carpeta":
                            imagen.setImageResource(R.drawable.img_1);
                            vendedor.setText("Abner");
                            nombreart.setText("Hojas de carpeta");
                            precio.setText("$21");
                            item.setText("5");
                            break;
                        case "Carpeta morada de martha":
                            imagen.setImageResource(R.drawable.img_2);
                            vendedor.setText("Elian");
                            nombreart.setText("Carpeta morada de martha");
                            precio.setText("$15");
                            item.setText("3");
                            break;
                        case "Protectores de hoja":
                            imagen.setImageResource(R.drawable.img_3);
                            vendedor.setText("Christian");
                            nombreart.setText("Protectores de hoja");
                            precio.setText("$2");
                            item.setText("5");
                            break;
                        case "Hojas blancas":
                            imagen.setImageResource(R.drawable.img_4);
                            vendedor.setText("Jorge");
                            nombreart.setText("Hojas blancas");
                            precio.setText("$1");
                            item.setText("150");
                            break;
                    }
                }
            }
        }
    }
}
