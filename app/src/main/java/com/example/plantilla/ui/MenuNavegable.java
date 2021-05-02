package com.example.plantilla.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plantilla.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuNavegable extends AppCompatActivity {
    private EditText etEmail, etPass;
    private Button btnIngresar;
    private TextView cartelEmail, cartelPass;
    private MenuNavegableViewModel Mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Mvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MenuNavegableViewModel.class);
        inicializarVista();
        Mvm.getCartelEmail().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mensaje) {
                new AlertDialog.Builder(MenuNavegable.this)
                        .setTitle("Advertencia!")
                        .setMessage(mensaje)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });

        Mvm.getCartelPass().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Intent intent = new Intent(getApplicationContext(), MenuNavegable.class);
                    startActivity(intent);
                }
            }
        });

    }
    private void inicializarVista() {
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etContrasenia);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mvm.validar(etEmail.getText().toString(), etPass.getText().toString());
            }
        });
    }

    }

