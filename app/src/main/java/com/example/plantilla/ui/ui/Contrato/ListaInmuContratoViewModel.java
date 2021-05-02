package com.example.plantilla.ui.ui.Contrato;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class ListaInmuContratoViewModel extends AndroidViewModel {
    private MutableLiveData<List<String>> listaDirecciones;
    private Context context;

    public ListaInmuContratoViewModel(@NonNull Application application) {
        super(application);
        context = getApplication().getApplicationContext();
    }

    public LiveData<List<String>> getListaDirecciones(){
        if(listaDirecciones == null) {
            listaDirecciones = new MutableLiveData<>();
        }
        return listaDirecciones;
    }

    public void cargarDatos(){
        SharedPreferences pref = context.getSharedPreferences("token", 0);
        String t = pref.getString("token", "vacio");

    }
}
