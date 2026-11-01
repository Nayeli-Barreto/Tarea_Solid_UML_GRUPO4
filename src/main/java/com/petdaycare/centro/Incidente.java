
package com.petdaycare.centro;

public class Incidente {

    private int id;
    private String descripcion;
    private String estado;

    public Incidente(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = "ABIERTO";
    }

    public void reportar() {
        System.out.println(
            "Incidente reportado: " + descripcion
        );
    }

    public void resolver() {
        estado = "RESUELTO";
    }

    public void escalar() {
        estado = "ESCALADO";
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }
}
