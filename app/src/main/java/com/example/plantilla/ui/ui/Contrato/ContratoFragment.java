package com.example.plantilla.ui.ui.Contrato;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ContratoFragment extends Fragment {
    private ContratoViewModel vm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoViewModel.class);
        View root = inflater.inflate(R.layout.contrato_fragment, container, false);

        return root;
    }
}
