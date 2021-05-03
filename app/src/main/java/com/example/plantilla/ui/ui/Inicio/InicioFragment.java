package com.example.plantilla.ui.ui.Inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.plantilla.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InicioFragment extends Fragment {

    private InicioViewModel inicioViewModel;
    private GoogleMap mapa;
    private static final LatLng inmobiliaria = new LatLng(-33.29690, -66.33100);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inicioViewModel =
                new ViewModelProvider(this).get(InicioViewModel.class);
        View root = inflater.inflate(R.layout.inicio_fragment, container, false);

        ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map)).getMapAsync(new MapaActual());
        return root;
    }

    private class MapaActual implements OnMapReadyCallback {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mapa = googleMap;
            mapa.addMarker(new MarkerOptions().position(inmobiliaria)).setTitle("Inmobiliaria Petrino");

            CameraPosition camPos = new CameraPosition.Builder().target(inmobiliaria).zoom(19).bearing(45).tilt(70).build();
            CameraUpdate camUpdate = CameraUpdateFactory.newCameraPosition(camPos);

            mapa.animateCamera(camUpdate);
        }
    }
}