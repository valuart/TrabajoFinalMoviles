package com.example.plantilla.ui.ui.Logout;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.plantilla.R;
import com.example.plantilla.ui.MenuNavegable;

import static java.lang.System.exit;

public class LogoutFragment extends Fragment {
    private View v;
    private LogoutViewModel lvm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        lvm = new LogoutViewModel();
        View root = inflater.inflate(R.layout.logout_fragment, container, false);
        v = root;
        notificacion();
        return root;
    }

    private void notificacion() { new AlertDialog.Builder(getContext()).setTitle("Cerrar sesion")
            .setMessage("¿Desea cerrar sesion?")
            .setCancelable(false)
            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            })
            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    //Navigation.findNavController(v).navigate();
                }
            }).show();

    }

}