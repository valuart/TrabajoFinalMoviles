package com.example.plantilla.ui.ui.Inquilino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;

import java.util.List;

public class InquilinosAdapter extends ArrayAdapter<Inquilino> {

    private Context context;
    private List<Inquilino> listaInq;
    private LayoutInflater li;
    private List<Inmueble> listaInmueble;

    public InquilinosAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.listaInq = objects;
        this.li = li;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View itemInq = convertView;

        if(itemInq == null){
            itemInq = li.inflate(R.layout.iteminquilino, parent, false);
        }

        Inmueble i = listaInmueble.get(position);

        ImageView foto = itemInq.findViewById(R.id.imagen);
        foto.setImageResource(Integer.parseInt(i.getImagen()));

        TextView direccion = itemInq.findViewById(R.id.etDireccion);
        direccion.setText(i.getDireccion());

        return itemInq;

    }

}
