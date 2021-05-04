package com.example.plantilla.ui.ui.Contrato;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.ui.ui.Inmueble.InmueblesFragment;

import java.util.ArrayList;
import java.util.List;

public class ContratosFragment extends Fragment {
    private ListView lvc;
    ArrayList<Inmueble> lista = new ArrayList<>();
    private ContratosFragmentViewModel Cvm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Cvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosFragmentViewModel.class);
       /* Cvm.getListaDirecciones().observe(this, (Observer<? super ArrayList<Contrato>>) new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, strings);
                lvc.setAdapter(adapter);
            }
        })*/;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_contrato, container, false);
        lvc= view.findViewById(R.id.listaInmuContratos);
        Cvm.cargarDatos();
        lvc.setClickable(true);
        lvc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)view;
                Bundle bundle = new Bundle();
                bundle.putString("direccion", tv.getText().toString());
               // Navigation.findNavController(view).navigate(R.id.contrato, bundle);
            }
        });
        return view;
    }
}