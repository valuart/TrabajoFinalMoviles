package com.example.plantilla.ui.ui.Inquilino;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.request.ApiClient;

public class InquilinoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Inquilino> mutableInq;
    private Inmueble inmu;
    public LiveData<Inquilino> InquilinoViewModel() {
        if(mutableInq == null){
            mutableInq = new MutableLiveData<>();
        }
        return mutableInq;
    }

    public void obtenerInquilino()  {
        ApiClient api = ApiClient.getApi();
        Inquilino inq = api.obtenerInquilino(inmu);
        mutableInq.setValue(inq);
    }
}