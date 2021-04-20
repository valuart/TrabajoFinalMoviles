package com.example.plantilla.modelo;

import java.io.Serializable;
import java.util.Date;

public class Pago implements Serializable {

    private int idPago;
    private int numero;
    private Contrato contrato;
    private double importe;
    private String fechaDePago;

    public Pago(int idPago, Contrato cuno, int i, Date date, double v) {}

    public Pago(int idPago, int numero, Contrato contrato, double importe, String fechaDePago) {
        this.idPago = idPago;
        this.numero = numero;
        this.contrato = contrato;
        this.importe = importe;
        this.fechaDePago = fechaDePago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(String fechaDePago) {
        this.fechaDePago = fechaDePago;
    }
}
