package com.example.plantilla.ui.ui.Inquilino;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inquilino;

public class InquilinoFragment extends Fragment {

    private Inquilino inquilino;
    private EditText cod, nombre, apellido, dni, email, telefono, garante, telGarante;
    private InquilinoViewModel InqVM;
    private InquilinosAdapter listaInq;

    public InquilinoFragment(Inquilino i) {
        inquilino = i;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inquilino_fragment, container, false);

        inicializar(root);
        return root;

    }

    private void inicializar(View root){

        cod = root.findViewById(R.id.etCod);
        nombre = root.findViewById(R.id.etNombre);
        apellido = root.findViewById(R.id.etApellido);
        dni = root.findViewById(R.id.etDni);
        email = root.findViewById(R.id.etEmail);
        telefono = root.findViewById(R.id.etTelefono);
        garante = root.findViewById(R.id.etGarante);
        telGarante = root.findViewById(R.id.etTelGarante);
    }

}