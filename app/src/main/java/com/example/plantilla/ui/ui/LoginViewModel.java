package com.example.plantilla.ui.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.request.ApiClient;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<String> cartelMensaje;
    private MutableLiveData<Boolean> cartelOk;
    private Context contexto;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        contexto = getApplication().getApplicationContext();
    }

    public LiveData<String> getCartelMensaje() {
        if (cartelMensaje == null) {
            cartelMensaje = new MutableLiveData<String>();
        }
        return cartelMensaje;
    }

    public LiveData<Boolean> getCartelOk() {
        if (cartelOk == null) {
            cartelOk = new MutableLiveData<Boolean>();
        }
        return cartelOk;
    }

    public void validar(String usuario, String contrasenia){
        if(usuario != null && contrasenia != null && usuario.length()>0 && contrasenia.length()>0){
            ApiClient api= ApiClient.getApi();
            Propietario p = api.login(usuario, contrasenia);
            if (p == null){
                cartelMensaje.setValue("Mail y/o contraseña incorrectos");
            }else{
                cartelOk.setValue(true);
            }
        }else{
            cartelMensaje.setValue("Por favor complete todos los campos");
        }



    }
}
