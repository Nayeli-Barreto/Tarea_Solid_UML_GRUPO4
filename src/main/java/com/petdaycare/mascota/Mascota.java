package com.petdaycare.mascota;
public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private TamanoMascota tamano;
    private String observacionesMedicas;

    private Mascota(MascotaBuilder builder) {
        this.nombre = builder.nombre;
        this.especie = builder.especie;
        this.raza = builder.raza;
        this.edad = builder.edad;
        this.tamano = builder.tamano;
        this.observacionesMedicas = builder.observacionesMedicas;
    }

    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public int getEdad() { return edad; }
    public TamanoMascota getTamano() { return tamano; }
    public String getObservacionesMedicas() { return observacionesMedicas; }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", tamano=" + tamano +
                ", observacionesMedicas='" + observacionesMedicas + '\'' +
                '}';
    }

    public static class MascotaBuilder {
        private String nombre;
        private String especie;
        private String raza;
        private int edad;
        private TamanoMascota tamano;
        private String observacionesMedicas;

        public MascotaBuilder(String nombre, String especie) {
            this.nombre = nombre;
            this.especie = especie;
        }

        public MascotaBuilder raza(String raza) {
            this.raza = raza;
            return this;
        }

        public MascotaBuilder edad(int edad) {
            this.edad = edad;
            return this;
        }

        public MascotaBuilder tamano(TamanoMascota tamano) {
            this.tamano = tamano;
            return this;
        }

        public MascotaBuilder observacionesMedicas(String observacionesMedicas) {
            this.observacionesMedicas = observacionesMedicas;
            return this;
        }

        public Mascota build() {
            return new Mascota(this);
        }
    }
}
