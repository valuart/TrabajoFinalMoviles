package com.example.plantilla;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plantilla.modelo.Contrato;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.modelo.Pago;
import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.ui.MenuNavegable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    //sensores
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    long whip = 0;
    static final int SHAKE_THRESHOLD = 500;
//fin de sensores


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Agrego lo del sensor de movimiento
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) ;

        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);

        if (sensor == null) {
            Toast.makeText(this, "Usted no cuenta con este tipo de sensor.", Toast.LENGTH_LONG).show();
            finish();
        }
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                Sensor s = event.sensor;

                if (s.getType() == Sensor.TYPE_ACCELEROMETER) {
                    float x = event.values[0];
                    long currentTime = System.currentTimeMillis();
                    if ((currentTime - whip) > 120) {
                        long dif = (currentTime - whip);
                        whip = currentTime;
                        float mover = Math.abs(x) / dif * 700;
                        if (mover > SHAKE_THRESHOLD) {
                            hacerLlamada();
                        }
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        start();
        //termina el sensor

    }


    public void setActionBar(String perfil) {
    }

    //sensor de movimiento
    private void start(){
        sensorManager.registerListener(sensorEventListener, sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    private void  stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
       stop();
       super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }
    public void hacerLlamada(){
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel: 12345"));
        startActivity(i);

    }
    //termina sensor..


}