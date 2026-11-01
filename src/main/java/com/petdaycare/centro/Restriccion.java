package com.petdaycare.centro;

public class Restriccion {

    private int id;
    private String descripcion;

    public Restriccion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public boolean validar() {
        return descripcion != null
                && !descripcion.isBlank();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
