package com.example.plantilla.ui.ui.Perfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class PerfilFragment extends Fragment {
    EditText dni, apellido, nombres, tel, email, pass;
    Button aceptar,editar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.perfil_fragment, container, false);
        ((MainActivity) getActivity()).setActionBar("Perfil");

        dni=root.findViewById(R.id.dni);
        apellido=root.findViewById(R.id.apellido);
        nombres=root.findViewById(R.id.nombres);
        tel=root.findViewById(R.id.tel);
        email=root.findViewById(R.id.mail);
        pass=root.findViewById(R.id.pass);

        aceptar=root.findViewById(R.id.aceptar);
        editar=root.findViewById(R.id.editar);

        fijarDatos();

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar();
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setTitle("").setMessage("Desea guardar los datos?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        aceptar();
                        fijarDatos();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fijarDatos();
                    }
                }).show();
            }
        });

        return root;
    }

    public void editar(){
        dni.setEnabled(true);
        apellido.setEnabled(true);
        nombres.setEnabled(true);
        tel.setEnabled(true);
        email.setEnabled(true);
        pass.setEnabled(true);

        editar.setVisibility(View.GONE);
        aceptar.setVisibility(View.VISIBLE);

    }

    public void aceptar(){
        MainActivity.sesion.setDni((long) Integer.parseInt(dni.getText().toString()));
        MainActivity.sesion.setApellido(apellido.getText().toString());
        MainActivity.sesion.setNombre(nombres.getText().toString());
        MainActivity.sesion.setTelefono(tel.getText().toString());
        MainActivity.sesion.setEmail(email.getText().toString());
        MainActivity.sesion.setContraseña(pass.getText().toString());

    }

    public void fijarDatos(){

    }
}
