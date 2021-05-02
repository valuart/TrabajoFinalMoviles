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

import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;

import java.util.ArrayList;

public class ContratoContainerViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayAdapter<Contrato>> adapterMutableLiveData;
    private Context context;

    public ContratoContainerViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
    public LiveData<ArrayAdapter<Contrato>> getAdapter(){
        if(adapterMutableLiveData == null) {
            adapterMutableLiveData = new MutableLiveData<>();
        }
        return adapterMutableLiveData;
    }
    public void cargarDatos(LayoutInflater li){
        SharedPreferences pref = context.getSharedPreferences("token", 0);
        String t = pref.getString("token", "vacio");

        //Call<Contrato> listaContratos = ApiClient.getMyApiClient().obtenerContratoPorInmueble(t, );
        ArrayList<Contrato> lista = new ArrayList<>();
        ArrayAdapter<Contrato> adapter = new ListaAdapterContrato(getApplication().getApplicationContext(), R.layout.contrato_fragment, lista, li);
        adapterMutableLiveData.setValue(adapter);
    }
}
