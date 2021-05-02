package com.example.plantilla.ui.ui.Contrato;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;

import java.util.List;

public class ListaAdapterContrato extends ArrayAdapter<Contrato> {
    private Context context;
    private List<Contrato> lista;
    private LayoutInflater li;
    public ListaAdapterContrato(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if(itemView==null){
            itemView = li.inflate(R.layout.contrato_fragment, parent, false);
        }
        Contrato contrato = lista.get(position);

        TextView precio = itemView.findViewById(R.id.tvMontoContrato);
        precio.setText(contrato.getMontoAlquiler() +"");

        TextView fechaInicio = itemView.findViewById(R.id.tvFechaInicio);
        fechaInicio.setText(contrato.getFechaInicio());

        TextView fechaFinal = itemView.findViewById(R.id.tvFechaFinal);
        fechaFinal.setText(contrato.getFechaFin() +"");

        return itemView;
    }
}
