package com.example.plantilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
        error=findViewById(R.id.error);

    sesion = new Propietario (1,379999999,"Perez","Juan",1133423476,"juancito22@gmail.com","admin","admin");
    Inmueble icero=new Inmueble (1,sesion, "Las Heras 1225",3,"Casa","Residencial",5000,true);
    Inmueble iuno=new Inmueble(2,sesion,"San Martin y Lavalle",5,"Departamento","Residencial",7500,false);
    Inmueble idos=new Inmueble(3,sesion,"Justo Darac 322",1,"Local","Comercial",15000,true);
    Inmueble itres=new Inmueble(4,sesion,"Perú 205",2,"Departamento","Residencial",6000,false);
    Inquilino incero=new Inquilino(1,33234321,"Vanesa","Lucero","valusanluis@gmail.com",1221212223);
    Inquilino inuno=new Inquilino(2,44332112,"Robocop","Piola","roboCorazones@g.c",918313819);
    Inquilino indos=new Inquilino(3,32112332,"Maravilla","Ricardo","adictoAti@g.c",17398182);
    Contrato ccero=new Contrato(1,incero,iuno,iuno.getPrecio()*24,new Date(),null,0);
    Contrato cuno=new Contrato(2,inuno,idos,idos.getPrecio()*24,new Date(),new Date(),0);
    Contrato cdos=new Contrato(3,indos,itres,itres.getPrecio()*24,new Date(),null,0);
    Pago pcero=new Pago(1,cuno,1,new Date(),idos.getPrecio()*24);
    Pago puno=new Pago(2,ccero,1,new Date(),ccero.getInmueble().getPrecio());
    Pago pdos=new Pago(3,cdos,1,new Date(),cdos.getInmueble().getPrecio());
    Pago ptres=new Pago(4,ccero,2,new Date(),ccero.getInmueble().getPrecio());
    Pago pcuatro=new Pago(5,cdos,2,new Date(),cdos.getInmueble().getPrecio());
    Pago pcinco=new Pago(6,ccero,3,new Date(),ccero.getInmueble().getPrecio());
    Pago pseis=new Pago(7,cdos,3,new Date(),cdos.getInmueble().getPrecio());

        inmuebles.add(icero);inmuebles.add(iuno);inmuebles.add(idos);inmuebles.add(itres);
        inquilinos.add(incero);inquilinos.add(inuno);inquilinos.add(indos);
        contratos.add(ccero);contratos.add(cuno);contratos.add(cdos);
        pagos.add(pcero);pagos.add(puno);pagos.add(pdos);pagos.add(ptres);pagos.add(pcuatro);pagos.add(pcinco);pagos.add(pseis);
}

    public void ingresar(android.view.View view){
        String usuario=name.getText().toString();
        String contra=pass.getText().toString();

        if(usuario.equals(sesion.getUsername())&&contra.equals(sesion.getContraseña())){
            error.setVisibility(View.GONE);
            Intent ingresar=new Intent(this, MenuNavegable.class);
            MainActivity.this.startActivity(ingresar);
        } else {
            error.setVisibility(View.VISIBLE);
        }
    }

    public void setActionBar(String perfil) {
    }
}