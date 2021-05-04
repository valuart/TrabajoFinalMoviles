package com.example.plantilla.ui.ui.Perfil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.ui.ui.MenuNavegable;

public class EditarPropietarioFragment extends Fragment {
    private EditarPropietarioViewModel editarPropietarioViewModel;
    public EditText etDni, etNombre, etApellido, etEmail, etTelefono;
    public Button btnGuardar;
    private Propietario usuarioActual;

    public static EditarPropietarioFragment newInstance() {
        return new EditarPropietarioFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        editarPropietarioViewModel= new ViewModelProvider(this).get(EditarPropietarioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_editar, container, false);

        InicializarVista(root);
        editarPropietarioViewModel.getOkMutable().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s == "EXITO")
                    startActivity(new Intent(getActivity(), MenuNavegable.class));
                else{
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Error")
                            .setMessage(s)
                            .setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                }
            }
        });
        editarPropietarioViewModel.getUsuarioMutable().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                usuarioActual = propietario;
                etDni.setText(String.valueOf(propietario.getDni()));
                etNombre.setText(propietario.getNombre());
                etApellido.setText(propietario.getApellido());
                etEmail.setText((propietario.getEmail()));
                etTelefono.setText(propietario.getTelefono());
            }
        });
        editarPropietarioViewModel.ObtenerPropietario();

        return root;
    }

    private void InicializarVista(View v){
        etDni = v.findViewById(R.id.etDni);
        etNombre = v.findViewById(R.id.etNombre);
        etApellido = v.findViewById(R.id.etApellido);
        etEmail = v.findViewById(R.id.etEmail);
        etTelefono = v.findViewById(R.id.etTelefono);
        btnGuardar = v.findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Propietario p = usuarioActual;
                p.setDni(TextUtils.isEmpty(etDni.getText())? -1 : Long.parseLong(etDni.getText().toString()));
                p.setNombre(etNombre.getText().toString());
                p.setApellido(etApellido.getText().toString());
                p.setEmail(etEmail.getText().toString());
                p.setTelefono(etTelefono.getText().toString());

                editarPropietarioViewModel.ActualizarPropietario(p);
            }
        });
    }

}


