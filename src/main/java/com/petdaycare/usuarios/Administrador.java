package com.petdaycare.usuarios;

public class Administrador extends UsuarioSistema {

    public Administrador(int id, String nombre) {
        super(id, nombre);
    }

    // Métodos del diagrama UML

    public void crearPromocion() {
        System.out.println(
            ">>> [Administrador] Creando una nueva promoción."
        );
    }

    public void crearRestriccion() {
        System.out.println(
            ">>> [Administrador] Creando una restricción."
        );
    }

    public void editarServicio() {
        System.out.println(
            ">>> [Administrador] Editando un servicio."
        );
    }

    public void crearPoliticaCancelacion() {
        System.out.println(
            ">>> [Administrador] Creando política de cancelación."
        );
    }

    // Métodos adicionales del código original

    public void gestionarServicios() {
        System.out.println(
            ">>> [Administrador] Configurando servicios, precios y horarios."
        );
    }

    public void emitirEstadoCuenta() {
        System.out.println(
            ">>> [Administrador] Generando estado de cuenta financiero."
        );
    }

    public void usarProveedor() {
        System.out.println(
            ">>> [Administrador] Gestionando proveedores externos."
        );
    }
}
