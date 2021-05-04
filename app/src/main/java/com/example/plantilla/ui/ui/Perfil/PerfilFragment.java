package com.example.plantilla.ui.ui.Perfil;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Propietario;

public class PerfilFragment extends Fragment {
    private EditText etDni, etApellido, etNombre, etTelefono, etEmail, etContrasenia;
    private Button btnEditarPerfil;
    private PerfilViewModel vm;
    private Propietario p = new Propietario();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vm =
                new ViewModelProvider(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.perfil_fragment, container, false);

        InicializarVista(root);
        vm.getUsuMutable().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etDni.setText(propietario.getDni().toString());
                etApellido.setText(propietario.getApellido());
                etNombre.setText(propietario.getNombre());
                etTelefono.setText(propietario.getTelefono());
                etEmail.setText(propietario.getEmail());
                etContrasenia.setText(propietario.getContraseña());

            }
        });
        vm.ObtenerUsuario();

        return root;
    }

    private void InicializarVista(View v) {

        etDni = v.findViewById(R.id.etNroDocumento);
        etApellido = v.findViewById(R.id.etApellido);
        etNombre = v.findViewById(R.id.etNombre);
        etTelefono = v.findViewById(R.id.etTelefono);
        etEmail = v.findViewById(R.id.etEmail);
        etContrasenia = v.findViewById(R.id.etContrasenia);
        btnEditarPerfil = v.findViewById(R.id.btnEditarPerfil);
        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController((Activity) getContext(), R.id.nav_host_fragment).navigate(R.id.nav_perfil);
            }
        });
    }
}