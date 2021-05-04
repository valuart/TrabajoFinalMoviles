package com.example.plantilla.ui.ui.Inquilino;

import android.content.Context;
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

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.ui.ui.Inmueble.InmuebleFragment;
import com.example.plantilla.ui.ui.Inmueble.InmueblesFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

/**
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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InquilinosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InquilinosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InquilinosFragment newInstance(String param1, String param2) {
        InquilinosFragment fragment = new InquilinosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
            }
        });
        return root;
    }

    private void inicializarVista(View v) {
        listaInmuebles = v.findViewById(R.id.listaInmuebles);
        //deberia mostrar la direccion, la foto del inmueble y con el boton ver, ir a los datos del inquilino
    }
}

