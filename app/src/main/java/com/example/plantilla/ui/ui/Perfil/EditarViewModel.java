package com.example.plantilla.ui.ui.Perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.request.ApiClient;

public class EditarViewModel extends ViewModel {
    public MutableLiveData<Propietario> usuarioMutable;
    public MutableLiveData<String> okMutable;

    public LiveData<Propietario> getUsuarioMutable(){
        if (usuarioMutable == null){
            usuarioMutable = new MutableLiveData<>();
        }
        return usuarioMutable;
    }

    public LiveData<String> getOkMutable(){
        if (okMutable == null){
            okMutable = new MutableLiveData<>();
        }
        return okMutable;
    }

    public void ObtenerPropietario(){
        ApiClient api = ApiClient.getApi();
        Propietario p = api.obtenerUsuarioActual();
        usuarioMutable.setValue(p);
    }

    public void ActualizarPropietario(Propietario p){
            ApiClient api = ApiClient.getApi();
            api.actualizarPerfil(p);
            okMutable.setValue("Guardado");
        }
    }


