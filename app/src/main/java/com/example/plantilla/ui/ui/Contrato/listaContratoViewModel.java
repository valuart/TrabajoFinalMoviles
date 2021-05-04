package com.example.plantilla.ui.ui.Contrato;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;

import java.util.ArrayList;

public class listaContratoViewModel extends ViewModel {
    private MutableLiveData<ArrayAdapter<Contrato>> adapterMutableLiveData;
    private Context context;
    
    public LiveData<ArrayAdapter<Contrato>> getAdapter(){
        if(adapterMutableLiveData == null) {
            adapterMutableLiveData = new MutableLiveData<>();
        }
        return adapterMutableLiveData;
    }
    public void cargarDatos(LayoutInflater li){
        
        ArrayList<Contrato> lista = new ArrayList<>();
     /*   lista.add(new Contrato(1000, "2020-05-15","2020-05-30",5000, 1, 1));
        lista.add(new Contrato(2000, "2021-06-16","2021-06-31",3000, 1, 1));
        lista.add(new Contrato(3000, "2022-07-17","2022-08-1",7000, 1, 2));
        ArrayAdapter<Contrato> adapter = new ContratoAdapter(context.getApplicationContext(), R.layout.fragment_contratos, lista, li);
        adapterMutableLiveData.setValue();*/
    }

}

