package com.example.plantilla.ui;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.plantilla.request.ApiClient;

public class MenuNavegableViewModel extends AndroidViewModel {
    private MutableLiveData<String> cartelEmail;
    private MutableLiveData<Boolean> cartelPass;
    private Context contexto;

    public MenuNavegableViewModel(@NonNull Application application) {
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
            if (api.login(email, clave)!=null){
                cartelEmail.setValue("Bienvenidos a Inmobiliaria Team Moviles");
                cartelPass.setValue(true);
            }else{
                cartelEmail.setValue("Mail o contraseña incorrecta");
            }
        }else{
            cartelEmail.setValue("Debe completar todos sus datos");
        }

    }
}
