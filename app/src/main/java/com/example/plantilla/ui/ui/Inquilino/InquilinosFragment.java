package com.example.plantilla.ui.ui.Inquilino;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.ui.ui.Inmueble.InmuebleFragment;
import com.example.plantilla.ui.ui.Inmueble.InmueblesFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link InquilinosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InquilinosFragment extends Fragment {

    private InquilinosFragmentViewModel ifvm;
    private ListView listaInmuebles;
    private EditText direccion;
    ImageView foto;
    Button ver;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ifvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinosFragmentViewModel.class);
        // Inflamos el Layout para este fragment
        View root = inflater.inflate(R.layout.iteminquilino, container, false);
        inicializarVista(root);
        ifvm.getListaInmuebleMutable().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                List<Inmueble> lista = (List<Inmueble>) ifvm.getListaInmuebleMutable();
                ArrayAdapter<Inmueble> adapter = new ArrayAdapter<Inmueble>(getContext(), android.R.layout.simple_list_item_1, lista);
                listaInmuebles.setAdapter(adapter);
                /*Glide.with(getContext())
                        .load()*/
                //aca debo cargar la direccion y la foto usando glide
            }
        });
        return root;
    }

    private void inicializarVista(View v) {
        listaInmuebles = v.findViewById(R.id.listaInmuebles);
        //deberia mostrar la direccion, la foto del inmueble y con el boton ver, ir a los datos del inquilino
        direccion = v.findViewById(R.id.etDireccion);
        foto = v.findViewById(R.id.imagen);
        ver = v.findViewById(R.id.btnVer);
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), InquilinoFragment.class);
                startActivity(i);
            }
        });
    }
}

