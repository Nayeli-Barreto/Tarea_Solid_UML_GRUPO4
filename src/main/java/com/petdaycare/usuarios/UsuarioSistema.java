package com.petdaycare.usuarios;

public abstract class UsuarioSistema {

    protected int id;
    protected String nombre;

    public UsuarioSistema(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
