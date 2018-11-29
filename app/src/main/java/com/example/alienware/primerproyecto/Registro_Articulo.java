package com.example.alienware.primerproyecto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.HashMap;

public class Registro_Articulo extends AppCompatActivity {

    ImageView imagen;
    EditText editTextNombreArticulo, editTextPrecio, editTextDescripcion;
    Spinner spinnerTipo, spinnerCategoria;
    ImageButton buttonImage;
    HashMap<String,String> nuevoArticulo=new HashMap<>();

    Uri path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registro__articulo);
        FloatingActionButton fab =  findViewById(R.id.fab);

        imagen = findViewById(R.id.imagen_ImagenArticulo_resgistraarticulo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { Snackbar.make(view, "Articulo registrado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void SeleccionarImagen(View view){

        CargarImagen();
    }

    private void CargarImagen() {

        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(Intent.createChooser(intent,"Selecciona aplicación"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode,resultCode,data);

        if (resultCode == RESULT_OK){
            path = data.getData();
            imagen.setImageURI(path);

        }
    }

    public void loadWidgets() {
        editTextNombreArticulo = findViewById(R.id.editTextNombreArticulo);
        editTextPrecio = findViewById(R.id.editTextPrecioArticulo);
        editTextDescripcion = findViewById(R.id.editTextDescripcionArticulo);
        buttonImage = findViewById(R.id.boton_examinarimagen_registrarticulo);
    }

    public void loadMap() {
        nuevoArticulo.put("nombreArticulo",editTextNombreArticulo.getText().toString());
        nuevoArticulo.put("precioArticulo",editTextPrecio.getText().toString());
        nuevoArticulo.put("tipoArticulo",spinnerTipo.getSelectedItem().toString());
        nuevoArticulo.put("categoriaArticulo",spinnerCategoria.getSelectedItem().toString());
        nuevoArticulo.put("descripcionArticulo",editTextDescripcion.getText().toString());
        nuevoArticulo.put("imagenArticulo",path.getPath());
    }

    public void sharedpreferencesarticulo(){
        SharedPreferences sharedPreferences = getSharedPreferences("articulo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nombreArticulo",nuevoArticulo.get("nombreArticulo"));
        editor.putString("precio",nuevoArticulo.get("precioarticulo"));
        editor.putString("categoria",nuevoArticulo.get("categoriaArticulo"));
        editor.putString("descripcion",nuevoArticulo.get("descripcionArticulo"));
        editor.putString("imagen",nuevoArticulo.get("imagenArticulo"));
        editor.putString("tipo",nuevoArticulo.get("tipoArticulo"));
        editor.putString("image",nuevoArticulo.get("imagenArticulo"));
        editor.apply();
    }
}
