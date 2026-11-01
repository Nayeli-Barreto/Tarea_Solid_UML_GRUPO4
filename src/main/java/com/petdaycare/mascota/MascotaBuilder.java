package com.petdaycare.mascota;

import java.util.ArrayList;
import java.util.List;

public class MascotaBuilder implements IMascotaBuilder {
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private TamanoMascota tamano;
    private List<AlertaSalud> alertasSalud;

    public MascotaBuilder() {
        this.alertasSalud = new ArrayList<>();
    }

    @Override
    public IMascotaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @Override
    public IMascotaBuilder setEspecie(String especie) {
        this.especie = especie;
        return this;
    }

    @Override
    public IMascotaBuilder setRaza(String raza) {
        this.raza = raza;
        return this;
    }

    @Override
    public IMascotaBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    @Override
    public IMascotaBuilder setTamano(TamanoMascota tamano) {
        this.tamano = tamano;
        return this;
    }

    @Override
    public IMascotaBuilder agregarAlertaSalud(AlertaSalud alerta) {
        this.alertasSalud.add(alerta);
        return this;
    }

    @Override
    public Mascota build() {
        return new Mascota(this);
    }

    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public int getEdad() { return edad; }
    public TamanoMascota getTamano() { return tamano; }
    public List<AlertaSalud> getAlertasSalud() { return alertasSalud; }
}
