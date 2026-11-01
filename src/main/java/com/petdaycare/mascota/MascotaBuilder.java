
package com.petdaycare.mascota;

import java.util.ArrayList;
import java.util.List;

public class MascotaBuilder {

    private int id;
    private String nombre;
    private String especie;
    private String raza;
    private TamanoMascota tamano;
    private int edad;
    private List<AlertaSalud> alertasSalud;

    public MascotaBuilder() {
        this.alertasSalud = new ArrayList<>();
    }

    public MascotaBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public MascotaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public MascotaBuilder setEspecie(String especie) {
        this.especie = especie;
        return this;
    }

    public MascotaBuilder setRaza(String raza) {
        this.raza = raza;
        return this;
    }

    public MascotaBuilder setTamano(TamanoMascota tamano) {
        this.tamano = tamano;
        return this;
    }

    public MascotaBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public MascotaBuilder agregarAlertaSalud(AlertaSalud alerta) {
        if (alerta != null) {
            alertasSalud.add(alerta);
        }
        return this;
    }

    public Mascota build() {

        Mascota mascota = new Mascota(
            id, nombre, especie, raza, tamano, edad
        );

        for (AlertaSalud alerta : alertasSalud) {
            mascota.agregarAlertaSalud(alerta);
        }

        return mascota;
    }
}
