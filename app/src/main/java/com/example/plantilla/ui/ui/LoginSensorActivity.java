package com.example.plantilla.ui.ui;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.plantilla.R;

public class LoginSensorActivity extends AppCompatActivity  {
    private EditText etEmail, etPass;
    private Button btnIngresar;
    private TextView cartelEmail; //, cartelPass;
    private LoginViewModel Mvm;
    //private Context contexto;
    //sensores
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;
    private long whip = 0;
    private static final int SHAKE_THRESHOLD = 600;
    //fin de sensores
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) ;

        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);

        Mvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);
        inicializarVista();
        Mvm.getCartelEmail().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String mensaje) {
                        new AlertDialog.Builder(LoginSensorActivity.this)
                                .setTitle("Advertencia!")
                                .setMessage(mensaje)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();


                    }
        });

        Mvm.getCartelPass().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Intent intent = new Intent(getApplicationContext(), MenuNavegable.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });



        //Sensor de movimiento
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


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
                    if ((currentTime - whip) > 100) {
                        long dif = (currentTime - whip);
                        whip = currentTime;
                        float mover = Math.abs(x) / dif * 100000;
                        if (mover > SHAKE_THRESHOLD) {
                            hacerLlamada();
                        }
                    }
                }
               start();
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    private void inicializarVista() {
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mvm.validar(etEmail.getText().toString(), etPass.getText().toString());

            }
        });
    }

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