package com.petdaycare.usuarios;

public class Administrador extends Usuario {
    private String idAdministrador;

    public Administrador(String correo, String telefono, String idAdministrador) {
        super(correo, telefono);
        this.idAdministrador = idAdministrador;
    }

    public void gestionarServicios() {
        System.out.println(">>> [Administrador " + idAdministrador + "] Configurando servicios, precios y horarios del centro.");
    }

    public void emitirPoliticaCancelacion() {
        System.out.println(">>> [Administrador] Estableciendo nuevas políticas de cancelación y penalización.");
    }

    public void emitirEstadoCuenta() {
        System.out.println(">>> [Administrador] Generando y emitiendo el estado de cuenta financiero.");
    }

    public void usarProveedor() {
        System.out.println(">>> [Administrador] Gestionando proveedores externos para el centro.");
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
