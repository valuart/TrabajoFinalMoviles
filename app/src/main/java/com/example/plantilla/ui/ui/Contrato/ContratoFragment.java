package com.example.plantilla.ui.ui.Contrato;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ContratoFragment extends Fragment {
    private Context context;
    private List<Contrato> lista;
    private LayoutInflater inflador;
    private ContratoViewModel mViewModel;

    public ContratoFragment newInstance(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater inflador) {

        this.context = context;
        this.lista = objects;
        this.inflador = inflador;

        return null;
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=inflador.inflate(R.layout.contrato,parent,false);
        }
        Contrato contrato=lista.get(position);

        String inicio = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(contrato.getFechaInicio());

        TextView numero=itemView.findViewById(R.id.fechaInicio);
        numero.setText(inicio);

        String fin;
        if(contrato.getFechaFin()!=null){
            fin = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(contrato.getFechaFin());
        } else {
            fin=null;
        }

        TextView fecha=itemView.findViewById(R.id.fechaFin);
        fecha.setText(fin);

        TextView importe=itemView.findViewById(R.id.valor);
        importe.setText("$"+contrato.getMontoAlquiler()+",-");

        TextView valorEn=itemView.findViewById(R.id.valorEn);
        if(contrato.getFechaFin()==null){
            valorEn.setText("Vigente");
        } else {
            valorEn.setText("Caducado");
        }


        return itemView;
    }
}
