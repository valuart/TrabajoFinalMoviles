package com.example.plantilla.ui.ui.Contrato;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Contrato;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.request.ApiClient;

import java.util.ArrayList;

public class ContratosFragmentViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Contrato>> listDireccionesMutable;
    private Context context;
    private Inmueble inmueble;


    public LiveData<ArrayList<Contrato>> getListaDirecciones(){
        if(listDireccionesMutable == null) {
            listDireccionesMutable = new MutableLiveData<ArrayList<Contrato>>();
        }
        return listDireccionesMutable;
    }

    public void obtenerContratoVigente(){
        ApiClient Api = ApiClient.getApi();
        Contrato c = Api.obtenerContratoVigente(inmueble);

    }
}
