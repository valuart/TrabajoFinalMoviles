package com.example.plantilla.ui.ui.Logout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.plantilla.R;
import com.example.plantilla.ui.MenuNavegable;

import static java.lang.System.exit;

public class LogoutFragment extends Fragment {

    Button salir;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.logout_fragment, container, false);
        ((MenuNavegable) getActivity()).setActionBarTitle("Cerrar Sesión");

        salir = root.findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setTitle("").setMessage("Desea cerrar sesión?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exit(0);
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        });

        return root;
    }
}