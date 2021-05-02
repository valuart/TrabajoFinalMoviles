package com.example.plantilla.ui.ui.Inmueble;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

import java.util.List;

//Agrego la Lista de inmuebles
public class InmuebleAdapter extends ArrayAdapter<Inmueble> {

    private Context contexto;
    private List<Inmueble> inmuebles;
    private LayoutInflater li;

    public InmuebleAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.contexto = context;
        this.inmuebles = objects;
        this.li = li;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        View itemView = convertView;
        if (itemView == null) {
            itemView = li.inflate(R.layout.item, parent, false);
        }
        Inmueble i = inmuebles.get(position);

        ImageView foto = itemView.findViewById(R.id.foto);
        foto.setImageResource(Integer.parseInt(i.getImagen()));

        TextView direccion = itemView.findViewById(R.id.Direccion);
        direccion.setText(i.getDireccion());

        TextView precio = itemView.findViewById(R.id.Precio);
        precio.setText(i.getPrecio() + "");
        return itemView;
    }

}