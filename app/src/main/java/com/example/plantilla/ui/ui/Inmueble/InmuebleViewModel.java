package com.example.plantilla.ui.ui.Inmueble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.request.ApiClient;

import java.util.ArrayList;

public class InmuebleViewModel extends ViewModel {

    private MutableLiveData<Inmueble> InmuebleMutable;
    private Inmueble inm;
   public LiveData<Inmueble> getInmuebleMutable(){
       if(InmuebleMutable == null){
           InmuebleMutable = new MutableLiveData<>();
       }
       return InmuebleMutable;
   }
public void ObtenerDetalles(){
       ApiClient api = ApiClient.getApi();
       api.actualizarInmueble(inm);
       InmuebleMutable.setValue(inm);
}

    }
