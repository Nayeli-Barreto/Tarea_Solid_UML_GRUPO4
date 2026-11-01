package com.petdaycare.servicios;

public class Hospedaje implements IServicio {
    private int dias;
    private double tarifaDiaria;

    public Hospedaje(int dias, double tarifaDiaria) {
        this.dias = dias;
        this.tarifaDiaria = tarifaDiaria;
    }

    @Override
    public double calcularPrecio() {
        return dias * tarifaDiaria;
    }

    @Override
    public boolean verificarDisponibilidad() {
        System.out.println(">>> [Hospedaje] Verificando habitaciones/cubículos disponibles...");
        return true; 
    }

    @Override
    public String obtenerDescripcion() {
        return "Servicio de Hospedaje por " + dias + " días.";
    }

    
    public int getDias() { return dias; }
    public void setDias(int dias) { this.dias = dias; }

    public double getTarifaDiaria() { return tarifaDiaria; }
    public void setTarifaDiaria(double tarifaDiaria) { this.tarifaDiaria = tarifaDiaria; }
}
