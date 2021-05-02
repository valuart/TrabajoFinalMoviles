package com.example.plantilla.ui.ui.Contrato;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;

public class ContratoFragment extends Fragment {
    private Contrato contrato;
    private EditText fechaInicio, fechaFin, montoAlquiler;
    private ContratoViewModel vm;
    private ContratoAdapter listaAdapter;

    public ContratoFragment(Contrato c ) {
        contrato = c;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_item_contrato, container, false);

        inicializar(root);
        return root;
    }
    private void inicializar(View root) {
        fechaInicio = root.findViewById(R.id.fechaInicio);
        fechaFin = root.findViewById(R.id.fechaFin);
        montoAlquiler = root.findViewById(R.id.importe);
    }
}
