package com.petdaycare.usuarios;

import com.petdaycare.centro.*;
import com.petdaycare.servicios.IServicio;

public class Administrador extends UsuarioSistema {

    private Centro centro;
    private Promocion promocion;
    private Restriccion restriccion;
    private PoliticaCancelacion politica;
    private IServicio anterior;
    private IServicio nuevo;

    public Administrador(int id, String nombre) {
        super(id, nombre);
    }

    public void asignarCentro(Centro centro) {
        if (centro == null) {
            throw new IllegalArgumentException("Centro obligatorio.");
        }

        this.centro = centro;
        promocion = null;
        restriccion = null;
        politica = null;
        anterior = null;
        nuevo = null;
    }

    private Centro centroAsignado() {
        if (centro == null) {
            throw new IllegalStateException(
                    "Asigne primero un centro.");
        }

        return centro;
    }

    public void prepararPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public void prepararRestriccion(Restriccion restriccion) {
        this.restriccion = restriccion;
    }

    public void prepararPolitica(PoliticaCancelacion politica) {
        this.politica = politica;
    }

    public void prepararServicio(IServicio anterior, IServicio nuevo) {
        this.anterior = anterior;
        this.nuevo = nuevo;
    }

    public void crearPromocion() {
        centroAsignado().agregarPromocion(promocion);
        promocion = null;
    }

    public void crearRestriccion() {
        centroAsignado().agregarRestriccion(restriccion);
        restriccion = null;
    }

    public void crearPoliticaCancelacion() {
        centroAsignado().configurarPolitica(politica);
        politica = null;
    }

    public void editarServicio() {
        centroAsignado().reemplazarServicio(anterior, nuevo);
        anterior = null;
        nuevo = null;
    }
}