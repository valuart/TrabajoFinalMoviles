package com.example.plantilla.ui.ui.Inmueble;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.request.ApiClient;

import java.util.ArrayList;
import java.util.List;


public class InmueblesFragmentViewModel extends ViewModel {


    private MutableLiveData<List<Inmueble>> listInmuebleMutable;
    private Context contexto;

    public LiveData<List<Inmueble>> getListInmuebleMutable(){
        if(listInmuebleMutable == null){
            listInmuebleMutable = new MutableLiveData<>();
        }
        return listInmuebleMutable;
    }

    public void leerDatos(){
        ApiClient api = ApiClient.getApi();
        ArrayList<Inmueble> i = api.obtnerPropiedades();
        listInmuebleMutable.setValue(i);
    }

}


