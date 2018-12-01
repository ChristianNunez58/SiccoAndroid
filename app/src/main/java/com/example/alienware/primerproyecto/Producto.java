package com.example.alienware.primerproyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Producto extends AppCompatActivity {
   /* String nombre, nuevo;
    TextView vendedor = findViewById(R.id.txtVendedor);
    TextView nombreart = findViewById(R.id.textNombreProducto);
    TextView precio = findViewById(R.id.txtPrecio);
    TextView item = findViewById(R.id.txtitems);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

       /* Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            nombre = bundle.getString("nombre");

            if(nombre == nuevo)
            {

            }
            else
            {
                switch (nombre)
                {
                    case "Hojas de carpeta":
                        vendedor.setText("Jorge Omar Torres Sosa");
                        nombreart.setText(nombre);
                        precio.setText("");
                        item.setText("");
                        break;
                    case "Carpeta morada de martha":
                        break;
                    case "Protectores de hoja":
                        break;
                    case "Hojas blancas":
                        break;
                }

            }
        }*/
    }
}
