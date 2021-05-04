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

public class listaContratoFragment extends Fragment {
    private ArrayList<Contrato> lista = new ArrayList<Contrato>();
    private listaContratoViewModel vm;
    private TextView tvTitulo;
    private ListView lvc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(listaContratoViewModel.class);
        vm.getAdapter().observe(this, new Observer<ArrayAdapter<Contrato>>() {
            @Override
            public void onChanged(ArrayAdapter<Contrato> pagoArrayAdapter) {
                lvc.setAdapter(pagoArrayAdapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_contrato_lista, container, false);
        tvTitulo = view.findViewById(R.id.tvTituloContrato);
        String x = getArguments().getString("direccion");
        tvTitulo.setText(x);
        tvTitulo.setBackgroundColor(Color.parseColor("#212121"));
        vm.cargarDatos(getLayoutInflater());
        lvc = view.findViewById(R.id.listaInmuContratos);

        return view;
    }

}