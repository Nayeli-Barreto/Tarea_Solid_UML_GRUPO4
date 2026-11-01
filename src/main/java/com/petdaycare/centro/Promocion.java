
package com.petdaycare.centro;

import java.time.LocalDate;

public class Promocion {

    private int id;
    private String nombre;
    private double descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Promocion(int id, String nombre,
                     double descuento,
                     LocalDate fechaInicio,
                     LocalDate fechaFin) {

        this.id = id;
        this.nombre = nombre;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public double aplicarPromocion(double precio) {

        LocalDate hoy = LocalDate.now();

        boolean vigente =
                !hoy.isBefore(fechaInicio)
                && !hoy.isAfter(fechaFin);

        if (!vigente || precio <= 0
                || descuento < 0 || descuento > 100) {
            return precio;
        }

        return precio - (precio * descuento / 100);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDescuento() {
        return descuento;
    }
}
