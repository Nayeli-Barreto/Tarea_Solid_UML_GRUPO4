package com.petdaycare.usuarios;

import com.petdaycare.reserva.IReservaBuilder;
import com.petdaycare.reserva.Reserva;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends UsuarioSistema {

    protected String correo;
    protected String telefono;

    private List<Reserva> reservas;

    public Usuario(int id, String nombre,String correo, String telefono) {

        super(id, nombre);

        this.correo = correo;
        this.telefono = telefono;
        this.reservas = new ArrayList<>();
    }

    public void registrarMascota() {
        System.out.println(
            ">>> [PetDayCare] Registrando mascota para " + nombre
        );
    }

    public Reserva crearReserva(IReservaBuilder constructor) {
        if (constructor == null) {
            throw new IllegalArgumentException(
                    "Se requieren los datos de la reserva.");
        }

        Reserva reserva = constructor.build();

        if (reserva == null) {
            throw new IllegalStateException(
                    "No se pudo construir la reserva.");
        }

        agregarReserva(reserva);
        return reserva;
    }

    public void cancelarReserva() {
        System.out.println(
            ">>> [PetDayCare] Solicitud de cancelación procesada."
        );
    }

    public void reportarIncidente() {
        System.out.println(
            ">>> [PetDayCare] Reportando incidente..."
        );
    }

    public void reportarIncidente(String descripcion) {
        System.out.println(
            ">>> [Incidente Reportado]: " + descripcion
        );
    }

    public List<Reserva> consultarReservas() {
        System.out.println(
            ">>> [PetDayCare] Consultando reservas activas..."
        );

        return new ArrayList<>(reservas);
    }

    public void agregarReserva(Reserva reserva) {
        if (reserva != null) {
            reservas.add(reserva);
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
