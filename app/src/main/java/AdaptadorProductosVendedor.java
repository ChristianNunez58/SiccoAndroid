import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alienware.primerproyecto.R;

import java.util.ArrayList;

public class AdaptadorProductosVendedor extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private  static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> NombreProductos = new ArrayList<>();
    private ArrayList<String> PrecioProductos = new ArrayList<>();
    private ArrayList<String> Imagenes = new ArrayList<>();
    private Context contexto;

    public AdaptadorProductosVendedor(Context context, ArrayList<String> nombres, ArrayList<String> precio, ArrayList<String> imagenes) {
        PrecioProductos = precio;
        Imagenes = imagenes;
        NombreProductos = nombres;
        contexto = context;

    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vendedor,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, int i) {
        Log.d(TAG, "onCreateViewHolder: called.");

    }

    @Override
    public int getItemCount() {
        return Imagenes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imagenArticulo;
        TextView NombreProducto;
        TextView PrecioProducto;
        public ViewHolder(View itemView)
        {
            super(itemView);
            imagenArticulo = itemView.findViewById(R.id.imagen_articulo_vendedor);
            NombreProducto = itemView.findViewById(R.id.NombreProducto_vendedor);
            PrecioProducto = itemView.findViewById(R.id.PrecioProducto_vendedor);
        }
    }
}
