package com.example.plantilla.ui.ui.Inmueble;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

public class InmuebleFragment extends Fragment {
    private Inmueble inmueble;
    private Switch disponible;
    private EditText direccion, ambientes, precio,tipo, uso;;
    private InmuebleViewModel inmuebleViewModel;
    private InmuebleAdapter listaAdapter;


    public InmuebleFragment(Inmueble i) {
        inmueble = i;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_item_inmueble, container, false);
        inicializar(root);
        inmuebleViewModel.getInmuebleMutable().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                direccion.setText(inmueble.getDireccion());
                ambientes.setText(inmueble.getAmbientes());
                precio.setText(inmueble.getPrecio()+"");
                tipo.setText(inmueble.getTipo());
                uso.setText(inmueble.getUso());
                disponible.setText(inmueble.isEstado()+"");
            }
        });
        inmuebleViewModel.ObtenerDetalles();
        return root;
    }

    private void inicializar(View root) {
        direccion = root.findViewById(R.id.direccion);
        ambientes = root.findViewById(R.id.ambientes);
        precio = root.findViewById(R.id.precio);
        tipo = root.findViewById(R.id.tipo);
        uso = root.findViewById(R.id.uso);
        disponible = root.findViewById(R.id.disponible);

    }


}



