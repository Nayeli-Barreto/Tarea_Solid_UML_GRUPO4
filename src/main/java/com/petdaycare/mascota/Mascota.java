package com.petdaycare.mascota;

import java.util.ArrayList;
import java.util.List;

public class Mascota {

    private int id;
    private String nombre;
    private String especie;
    private String raza;
    private TamanoMascota tamano;
    private int edad;

    private List<String> necesidadesEspeciales;
    private List<String> preferenciasTrato;
    private List<AlertaSalud> alertasSalud;

    public Mascota(int id, String nombre, String especie,
                   String raza, TamanoMascota tamano, int edad) {

        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.tamano = tamano;
        this.edad = edad;

        this.necesidadesEspeciales = new ArrayList<>();
        this.preferenciasTrato = new ArrayList<>();
        this.alertasSalud = new ArrayList<>();
    }

    public void agregarNecesidadEspecial(String necesidad) {
        if (necesidad != null && !necesidad.isBlank()) {
            necesidadesEspeciales.add(necesidad);
        }
    }

    public void agregarPreferenciaTrato(String preferencia) {
        if (preferencia != null && !preferencia.isBlank()) {
            preferenciasTrato.add(preferencia);
        }
    }

    public void agregarAlertaSalud(AlertaSalud alerta) {
        if (alerta != null) {
            alertasSalud.add(alerta);
        }
    }

    public void actualizarDatos(String nombre, String especie,
                                String raza, TamanoMascota tamano,
                                int edad) {

        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.tamano = tamano;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public TamanoMascota getTamano() {
        return tamano;
    }

    public int getEdad() {
        return edad;
    }

    public List<String> getNecesidadesEspeciales() {
        return new ArrayList<>(necesidadesEspeciales);
    }

    public List<String> getPreferenciasTrato() {
        return new ArrayList<>(preferenciasTrato);
    }

    public List<AlertaSalud> getAlertasSalud() {
        return new ArrayList<>(alertasSalud);
    }
}
