package com.example.plantilla.ui;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MenuNavegableViewModel extends AndroidViewModel {
    private MutableLiveData<String> cartelEmail;
    private MutableLiveData<String> cartelPass;
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

    public LiveData<String> getCartelPass() {
        if (cartelPass == null) {
            cartelPass = new MutableLiveData<String>();
        }
        return cartelPass;
    }

    public void validar(String email, String clave) {
        final int cantMail = email.length();
        final int cantContra = clave.length();
        if (cantMail <= 0) {
            cartelEmail.setValue("*Obligatorio");
        } else {
            cartelEmail.setValue("");
        }
        if (cantContra <= 0) {
            cartelPass.setValue("*Obligatorio");
        } else {
            cartelEmail.setValue("");
        }

    }
}
