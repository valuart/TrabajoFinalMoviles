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

import com.example.plantilla.R;
import com.example.plantilla.modelo.Contrato;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.modelo.Pago;
import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.ui.MenuNavegable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText name,pass;
    private TextView error;
    public static Propietario sesion;
    public static List<Inmueble> inmuebles=new ArrayList<>();
    public static List<Pago> pagos=new ArrayList<>();
    public static List<Inquilino> inquilinos=new ArrayList<>();
    public static List<Contrato> contratos=new ArrayList<>();
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    long whip=0;
    static final int SHAKE_THRESHOLD = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Agrego lo del sensor de movimiento
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) ;

        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);

        if(sensor == null){
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
                        float mover = Math.abs(x) / dif * 1000;
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


        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
        error=findViewById(R.id.error);
}

    public void ingresar(android.view.View view){
        String usuario=name.getText().toString();
        String contra=pass.getText().toString();

       /* if(usuario.equals(sesion.getContraseña())&&contra.equals(sesion.getContraseña())){
            error.setVisibility(View.GONE);
            Intent ingresar=new Intent(this, MenuNavegable.class);
            MainActivity.this.startActivity(ingresar);
        } else {
            error.setVisibility(View.VISIBLE);
        }*/
        Intent ingresar=new Intent(this, MenuNavegable.class);
        MainActivity.this.startActivity(ingresar);
    }

    public void setActionBar(String perfil) {
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
}