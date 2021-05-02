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

    private MutableLiveData <List<Inquilino>> listaInqMutable;
    private Context context;
    private Inmueble inmueble;

    public LiveData<List<Inquilino>> getListaInqMutable(){
        if(listaInqMutable == null){
            listaInqMutable = new MutableLiveData<>();
        }
         return listaInqMutable;
    }

    public void obtenerInquilino(){
        ApiClient Api = ApiClient.getApi();
        Inquilino inq = Api.obtenerInquilino(inmueble);
    }
}
