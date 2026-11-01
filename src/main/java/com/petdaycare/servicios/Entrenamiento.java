package com.petdaycare.servicios;

public class Entrenamiento implements InterfaceServicio {
    private double tarifa;
    private String nivel; 

    public Entrenamiento(double tarifa, String nivel) {
        this.tarifa = tarifa;
        this.nivel = nivel;
    }

    @Override
    public double calcularPrecio() {
        return tarifa;
    }

    @Override
    public boolean verificarDisponibilidad() {
        System.out.println(">>> [Entrenamiento] Verificando horarios de entrenadores...");
        return true;
    }

    @Override
    public String obtenerDescripcion() {
        return "Servicio de Entrenamiento (Nivel: " + nivel + ").";
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
