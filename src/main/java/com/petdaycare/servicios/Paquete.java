package com.petdaycare.servicios;

import java.util.ArrayList;
import java.util.List;

public class Paquete implements InterfaceServicio {
    private String nombrePaquete;
    private List<InterfaceServicio> servicios;

    public Paquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
        this.servicios = new ArrayList<>();
    }

    public void agregarServicio(InterfaceServicio servicio) {
        this.servicios.add(servicio);
    }

    @Override
    public double calcularPrecio() {
        double total = 0.0;
        for (InterfaceServicio servicio : servicios) {
            total += servicio.calcularPrecio();
        }
  
        return total * 0.90;
    }

    @Override
    public boolean verificarDisponibilidad() {
        System.out.println(">>> [Paquete: " + nombrePaquete + "] Verificando disponibilidad de los servicios agrupados...");
        for (InterfaceServicio servicio : servicios) {
            if (!servicio.verificarDisponibilidad()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String obtenerDescripcion() {
        StringBuilder desc = new StringBuilder("Paquete: " + nombrePaquete + " (Contiene: ");
        for (InterfaceServicio servicio : servicios) {
            desc.append("[").append(servicio.obtenerDescripcion()).append("] ");
        }
        desc.append(")");
        return desc.toString();
    }


    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public List<InterfaceServicio> getServicios() {
        return servicios;
    }
}
