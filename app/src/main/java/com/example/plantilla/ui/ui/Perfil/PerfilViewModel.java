package com.example.plantilla.ui.ui.Perfil;

import android.content.Context;
import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.request.ApiClient;

public class PerfilViewModel extends ViewModel {
    public MutableLiveData<Propietario> usuarioMutable;

    public LiveData<Propietario> getUsuMutable(){
        if (usuarioMutable == null){
         usuarioMutable = new MutableLiveData<>();
        }
        return usuarioMutable;
    }

    public void ObtenerUsuario(){
        ApiClient api = ApiClient.getApi();
        Propietario p = api.obtenerUsuarioActual();
        usuarioMutable.setValue(p);
    }
}
