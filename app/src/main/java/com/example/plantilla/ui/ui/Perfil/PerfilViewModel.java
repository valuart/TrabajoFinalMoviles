package com.example.plantilla.ui.ui.Perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.telecom.Call;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.request.ApiClient;
import com.google.android.gms.common.api.Response;

import javax.security.auth.callback.Callback;

public class PerfilViewModel extends ViewModel {
    private MutableLiveData<Propietario> propietarioMutableLiveData;
    private MutableLiveData<Boolean> estado;
    private  MutableLiveData<String> textoBoton;
    private MutableLiveData<String> resultado;
    private Context context;

    public PerfilViewModel() {

    }

    public LiveData<Propietario> getPropietario(){
        if(propietarioMutableLiveData == null) {
            propietarioMutableLiveData = new MutableLiveData<>();
        }
        return propietarioMutableLiveData;
    }

    public LiveData<Boolean> getEstado(){
        if(estado == null){
            estado = new MutableLiveData<>();
        }
        return estado;
    }

    public LiveData<String> getTextoBoton(){
        if(textoBoton == null){
            textoBoton = new MutableLiveData<>();
        }
        return textoBoton;
    }

    public LiveData<String> getResultado(){
        if(resultado == null){
            resultado = new MutableLiveData<>();
        }
        return resultado;
    }

    public void ObtenerDatos(){
        ApiClient apiClient = ApiClient.getApi();
        Propietario p = apiClient.obtenerUsuarioActual();
        propietarioMutableLiveData.setValue(p);
    }

    public void Editar(int id, Long dni, String nombre, String apellido, String email, String contraseña, String telefono){
        ApiClient apiClient = ApiClient.getApi();
        Propietario propietario = new Propietario(id, dni, nombre, apellido, email, contraseña, telefono);
        apiClient.actualizarPerfil(propietario);
        propietarioMutableLiveData.setValue(propietario);
    }
}