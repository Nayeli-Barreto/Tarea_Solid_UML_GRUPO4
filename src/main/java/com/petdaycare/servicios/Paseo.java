package com.petdaycare.servicios;

public class Paseo implements IServicio {
    private double tarifa;
    private String tipo; 

    public Paseo(double tarifa, String tipo) {
        this.tarifa = tarifa;
        this.tipo = tipo;
    }

    @Override
    public double calcularPrecio() {
        return tarifa;
    }

    @Override
    public boolean verificarDisponibilidad() {
        System.out.println(">>> [Paseo] Verificando cuidadores disponibles para paseo...");
        return true;
    }

    @Override
    public String obtenerDescripcion() {
        return "Servicio de Paseo (" + tipo + ").";
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
