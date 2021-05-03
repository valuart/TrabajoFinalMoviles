package com.example.plantilla.ui.ui.Perfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import com.example.plantilla.MainActivity;
import com.example.plantilla.R;
import com.example.plantilla.modelo.Propietario;

public class PerfilFragment extends Fragment {
    private TextView tvResultado;
    private EditText etDni, etApellido, etNombre, etTelefono, etEmail, etContrasenia;
    private Button btnEditarPerfil;
    private PerfilViewModel vm;
    private Propietario p = new Propietario();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);

        vm.getPropietario().observe(this, new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etDni.setText(propietario.getDni().toString());
                etApellido.setText(propietario.getApellido());
                etNombre.setText(propietario.getNombre());
                etTelefono.setText(propietario.getTelefono());
                etEmail.setText(propietario.getEmail());
                etContrasenia.setText(propietario.getContraseña());

                p.setId(propietario.getId());
                p.setDni(propietario.getDni());
                p.setApellido(propietario.getApellido());
                p.setNombre(propietario.getNombre());
                p.setTelefono(propietario.getTelefono());
                p.setEmail(propietario.getEmail());
                p.setContraseña(propietario.getContraseña());
            }
        });
        vm.getEstado().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etDni.setEnabled(aBoolean);
                etApellido.setEnabled(aBoolean);
                etNombre.setEnabled(aBoolean);
                etTelefono.setEnabled(aBoolean);
                etEmail.setEnabled(aBoolean);
                etContrasenia.setEnabled(aBoolean);
            }
        });
        vm.getTextoBoton().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                btnEditarPerfil.setText(s);
            }
        });
        vm.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvResultado.setText(s);
                tvResultado.setTextColor(Color.parseColor("#00CB11"));
                tvResultado.setTextSize(17);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.perfil_fragment, container, false);
        tvResultado = root.findViewById(R.id.tvMensaje);
        etDni = root.findViewById(R.id.etNroDocumento);
        etApellido = root.findViewById(R.id.etApellido);
        etNombre = root.findViewById(R.id.etNombre);
        etTelefono = root.findViewById(R.id.etTelefono);
        etEmail = root.findViewById(R.id.etEmail);
        etContrasenia = root.findViewById(R.id.etContrasenia);
        btnEditarPerfil = root.findViewById(R.id.btnEditarPerfil);



        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setDni((long) Integer.parseInt(etDni.getText().toString()));
                p.setApellido(etApellido.getText().toString());
                p.setNombre(etNombre.getText().toString());
                p.setTelefono(etTelefono.getText().toString());
                p.setEmail(etEmail.getText().toString());
                p.setContraseña(etContrasenia.getText().toString());

            }
        });

        return root;
    }
}
