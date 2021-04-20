package com.example.plantilla.ui.ui.Inmueble;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

public class InmuebleFragment extends Fragment {
    private Inmueble inmueble;
    private Switch disponible;
    private EditText direccion, ambientes, precio;
    private Spinner tipo, uso;
    private InmuebleViewModel inmuebleViewModel;

    public InmuebleFragment() {
    }

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

        direccion = root.findViewById(R.id.direccion);
        ambientes = root.findViewById(R.id.ambientes);
        precio = root.findViewById(R.id.precio);
        tipo = root.findViewById(R.id.tipo);
        uso = root.findViewById(R.id.uso);
        disponible = root.findViewById(R.id.disponible);

        return root;
    }

}
