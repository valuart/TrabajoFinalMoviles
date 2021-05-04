package com.example.plantilla.ui.ui.Logout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plantilla.R;
import com.example.plantilla.ui.ui.MenuNavegable;

public class LogoutFragment extends Fragment {
    private View v;
    private LogoutViewModel lvm;
    private boolean salir = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        lvm = new LogoutViewModel();
        View root = inflater.inflate(R.layout.logout_fragment, container, false);
        v = root;
        notificacion();
        return root;
    }

    public void notificacion() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Cerrar sesión")
                .setMessage("¿Desea cerrar sesión?")
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        if(!salir)
                            startActivity(new Intent(getActivity(), MenuNavegable.class));
                    }
                })
                .setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        salir = true;
                        startActivity(new Intent(getActivity(), MenuNavegable.class));
                    }
                }).show();
    }



}