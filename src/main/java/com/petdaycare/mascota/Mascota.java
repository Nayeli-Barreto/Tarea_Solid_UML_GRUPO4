package com.petdaycare.mascota;

import java.util.List;

public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private TamanoMascota tamano;
    private List<AlertaSalud> alertasSalud;


    public Mascota(MascotaBuilder builder) {
        this.nombre = builder.getNombre();
        this.especie = builder.getEspecie();
        this.raza = builder.getRaza();
        this.edad = builder.getEdad();
        this.tamano = builder.getTamano();
        this.alertasSalud = builder.getAlertasSalud();
    }


    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public int getEdad() { return edad; }
    public TamanoMascota getTamano() { return tamano; }
    public List<AlertaSalud> getAlertasSalud() { return alertasSalud; }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", tamano=" + tamano +
                ", alertasSalud=" + alertasSalud +
                '}';
    }
}
