package com.example.plantilla.ui.ui.Inquilino;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class InquilinosFragmentViewModel extends ViewModel {

    private MutableLiveData <List<Inmueble>> listaInmuebleMutable;
    private Context context;
    private Inmueble inmueble;

    public LiveData<List<Inmueble>> getListaInmuebleMutable(){
        if(listaInmuebleMutable == null){
            listaInmuebleMutable = new MutableLiveData<>();
        }
         return listaInmuebleMutable;
    }

    public void obtenerPropiedades(){
        ApiClient Api = ApiClient.getApi();
        List<Inmueble> lista = Api.obtenerPropiedadesAlquiladas();
        listaInmuebleMutable.setValue(lista);
    }
}
