package com.petdaycare.servicios;

public class SesionesBienestar implements IServicio {
    private double tarifa;
    private String tipoBienestar; 

    public SesionesBienestar(double tarifa, String tipoBienestar) {
        this.tarifa = tarifa;
        this.tipoBienestar = tipoBienestar;
    }

    @Override
    public double calcularPrecio() {
        return tarifa;
    }

    @Override
    public boolean verificarDisponibilidad() {
        System.out.println(">>> [SesionesBienestar] Verificando cabinas y especialistas de bienestar...");
        return true;
    }

    @Override
    public String obtenerDescripcion() {
        return "Sesión de bienestar (" + tipoBienestar + ").";
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getTipoBienestar() {
        return tipoBienestar;
    }

    public void setTipoBienestar(String tipoBienestar) {
        this.tipoBienestar = tipoBienestar;
    }
}
