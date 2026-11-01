package com.petdaycare.mascota;

public class AlertaSalud {
    private String descripcion;
    private String nivelUrgencia; 

    public AlertaSalud(String descripcion, String nivelUrgencia) {
        this.descripcion = descripcion;
        this.nivelUrgencia = nivelUrgencia;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getNivelUrgencia() { return nivelUrgencia; }
    public void setNivelUrgencia(String nivelUrgencia) { this.nivelUrgencia = nivelUrgencia; }

    @Override
    public String toString() {
        return "AlertaSalud{" + "descripcion='" + descripcion + '\'' + ", nivelUrgencia='" + nivelUrgencia + '\'' + '}';
    }
}
