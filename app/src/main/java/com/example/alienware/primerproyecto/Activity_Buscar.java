package com.example.alienware.primerproyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Buscar extends AppCompatActivity {

    private  EditText busqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout__buscar);

        busqueda = findViewById(R.id.busqueda);

        busqueda.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    // Perform action on key press
                    String labusqueda = busqueda.getText().toString();
                    Intent intent = new Intent(Activity_Buscar.this, Activity_lista_Buscar.class);
                    intent.putExtra("entrada",2);
                    intent.putExtra("busqueda", labusqueda);
                    startActivity(intent);

                }
                return false;
            }
        });
    }




}


