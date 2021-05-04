package com.example.plantilla.ui.ui.Contrato;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;
import com.example.plantilla.modelo.Inmueble;

import java.util.List;

public class ContratosFragment extends Fragment {
    private ContratosFragmentViewModel cvm;
    private Context contexto;
    private ContratoAdapter contratoAdapter;
    private  ListView LvContratos;
    private ContratoFragment c;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContratosFragment() {
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
    public static ContratosFragment newInstance(String param1, String param2) {
        ContratosFragment fragment = new ContratosFragment();
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
        View root=  inflater.inflate(R.layout.fragment_contratos, container, false);
        contexto = root.getContext();
        inicializarVista(root);

        return root;
    }

    private void inicializarVista(View v) {
        LvContratos = v.findViewById(R.id.listaInmuContratos);

        cvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosFragmentViewModel.class);

        cvm.cargarDatos();

        cvm.getListaDirecciones().observe(getViewLifecycleOwner(), new Observer<List<Contrato>>() {
            @Override
            public void onChanged(List<Contrato> c) {
                //GridLayoutManager gridLayoutManager = new GridLayoutManager(contexto,3,GridLayoutManager.VERTICAL,false);

                contratoAdapter = new ContratoAdapter(contexto,1,c,getLayoutInflater());
                LvContratos.setAdapter(contratoAdapter);

            }
        });



    }

}
