package com.example.alienware.primerproyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorBusqueda extends BaseAdapter
{
    private static  LayoutInflater inflater = null;

    private Context context;
    String[][] datos;
    int[] imagenes;

    public AdaptadorBusqueda(Context context, String[][] datos , int[]imagenes)
    {
        this.context = context;
        this.datos = datos;
        this.imagenes = imagenes;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent)
    {
        final View vista = inflater.inflate(R.layout.busqueda_item, null);

        TextView nombreProducto = vista.findViewById(R.id.textNombreProducto);
        TextView precioProducto = vista.findViewById(R.id.textPrecioProducto);
        ImageView imagen = vista.findViewById(R.id.imagenproducto);

        nombreProducto.setText(datos[i][0]);
        precioProducto.setText("$" + datos[i][1]);
        imagen.setImageResource(imagenes[i]);

        return vista;
    }

    @Override
    public int getCount()
    {
        return this.imagenes.length;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int id)
    {
        return 0;
    }


}
