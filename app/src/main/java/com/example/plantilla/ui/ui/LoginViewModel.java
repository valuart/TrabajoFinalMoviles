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

    private MutableLiveData<String> cartelEmail;
    private MutableLiveData<Boolean> cartelPass;
    private Context contexto;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        contexto = getApplication().getApplicationContext();
    }

    public LiveData<String> getCartelEmail() {
        if (cartelEmail == null) {
            cartelEmail = new MutableLiveData<String>();
        }
        return cartelEmail;
    }

    public LiveData<Boolean> getCartelPass() {
        if (cartelPass == null) {
            cartelPass = new MutableLiveData<Boolean>();
        }
        return cartelPass;
    }

    public void validar(String email, String clave) {
        if(email !=null && clave!=null && email.length()>0 && clave.length()>0){
            ApiClient api= ApiClient.getApi();
            Propietario propietario = api.login(email, clave);
            if (propietario != null){
                cartelEmail.setValue("Usuario y/o Contraseña incorrectos!");
            }else{
                cartelPass.setValue(true);
            }
        }else{
            cartelEmail.setValue("Los campos no pueden estar vacios");
        }

    }
}
