package com.example.plantilla.ui.ui.Inquilino;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.request.ApiClient;

public class InquilinoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Inquilino> InqMutable;
    private Inmueble inmu;

    public LiveData<Inquilino> getInquilinoViewModel() {
        if(InqMutable == null){
            InqMutable = new MutableLiveData<>();
        }
        return InqMutable;
    }

    public void obtenerInquilino()  {
        ApiClient api = ApiClient.getApi();
        Inquilino inq = api.obtenerInquilino(inmu);
        InqMutable.setValue(inq);
    }
}