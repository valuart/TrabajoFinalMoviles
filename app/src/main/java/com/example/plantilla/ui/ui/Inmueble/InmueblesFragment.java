package com.example.plantilla.ui.ui.Inmueble;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.plantilla.ui.ui.MenuNavegable.R;
import com.example.plantilla.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InmueblesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InmueblesFragment extends Fragment {

    private InmueblesFragmentViewModel Ivm;
    private Context contexto;
    private InmuebleAdapter inmuebleAdapter;
    private  ListView LvInmuebles;
    private InmuebleFragment i;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InmueblesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InmueblesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InmueblesFragment newInstance(String param1, String param2) {
        InmueblesFragment fragment = new InmueblesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=  inflater.inflate(R.layout.fragment_inmuebles, container, false);
        contexto = root.getContext();
        inicializarVista(root);

        return root;
    }

    private void inicializarVista(View v) {
        LvInmuebles = v.findViewById(R.id.listaInmueble);

    Ivm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmueblesFragmentViewModel.class);
        Ivm.leerDatos();

        Ivm.getListInmuebleMutable().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                        //GridLayoutManager gridLayoutManager = new GridLayoutManager(contexto,3,GridLayoutManager.VERTICAL,false);

               inmuebleAdapter = new InmuebleAdapter(contexto,1,inmuebles,getLayoutInflater());
                LvInmuebles.setAdapter(inmuebleAdapter);

            }
        });

        
    }

}

