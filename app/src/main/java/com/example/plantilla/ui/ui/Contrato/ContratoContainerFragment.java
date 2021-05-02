package com.example.plantilla.ui.ui.Contrato;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;

import java.util.ArrayList;

public class ContratoContainerFragment extends Fragment {
    private ArrayList<Contrato> lista = new ArrayList<Contrato>();
    private ContratoContainerViewModel vm;
    private TextView tvTitulo;
    private ListView lv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_container_contrato, container, false);
        tvTitulo = view.findViewById(R.id.tvTituloContratoContainer);
        String x = getArguments().getString("direccion");
        tvTitulo.setText(x);
        tvTitulo.setBackgroundColor(Color.parseColor("#212121"));
        vm.cargarDatos(getLayoutInflater());
        lv = view.findViewById(R.id.listaContratos);

        return view;
    }

}
