package com.example.plantilla.ui.ui.Contrato;

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


import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class ListaInmuContratoFragment extends Fragment {
    private ListView lv;
    ArrayList<Inmueble> lista = new ArrayList<>();
    private ListaInmuContratoViewModel vm;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ListaInmuContratoViewModel.class);
        vm.getListaDirecciones().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, strings);
                lv.setAdapter(adapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_inmu_contrato, container, false);
        lv = view.findViewById(R.id.listaInmueble);
        vm.cargarDatos();
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)view;
                Bundle bundle = new Bundle();
                bundle.putString("direccion", tv.getText().toString());
               // Navigation.findNavController(view).navigate(R.id.nav_contenedor_contrato, bundle);
            }
        });
        return view;
    }
}
