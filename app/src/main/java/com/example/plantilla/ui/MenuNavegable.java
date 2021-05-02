package com.example.plantilla.ui;

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
    private EditText email, pass;
    TextView cartelEmail, cartelPass;
    Button ingresar;
    MenuNavegableViewModel Mvm;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_navegable);
        configurarVista();
        Mvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MenuNavegableViewModel.class);
        Mvm.getCartelEmail().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                cartelEmail.setText(s);
                cartelEmail.setTextColor(0xffff0000);
            }
        });
        Mvm.getCartelPass().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                cartelPass.setText(s);
                cartelPass.setTextColor(0xffff0000);
            }
        });
    }
    private void configurarVista(){
        email = findViewById(R.id.etEmail);
        pass = findViewById(R.id.etPass);
        ingresar = findViewById(R.id.btnIngresar);
        cartelPass = findViewById(R.id.tvPass);
        cartelEmail = findViewById(R.id.tvEmail);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mvm.validar(email.getText().toString(), pass.getText().toString());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navegable, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setActionBarTitle(String cerrar_sesión) {
    }
}