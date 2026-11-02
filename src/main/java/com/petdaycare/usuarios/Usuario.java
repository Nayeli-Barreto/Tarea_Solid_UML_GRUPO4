package com.petdaycare.usuarios;

import com.petdaycare.mascota.Mascota;
import com.petdaycare.reserva.IReservaBuilder;
import com.petdaycare.reserva.Reserva;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends UsuarioSistema {

    protected String correo;
    protected String telefono;
    private Reserva reservaSeleccionada;
    private List<Reserva> reservas;
    private final List<Mascota> mascotas = new ArrayList<>();

    public Usuario(int id, String nombre,String correo, String telefono) {

        super(id, nombre);

        this.correo = correo;
        this.telefono = telefono;
        this.reservas = new ArrayList<>();
    }

    public void registrarMascota(Mascota mascota) {
    if (mascota == null) {
        throw new IllegalArgumentException("La mascota es obligatoria.");
    }

    boolean registrada = mascotas.stream()
            .anyMatch(m -> m.getId() == mascota.getId());

    if (registrada) {
        System.out.println("La mascota ya está registrada.");
        return;
    }

    mascotas.add(mascota);
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
    if (reservaSeleccionada == null) {
        throw new IllegalStateException("Seleccione una reserva.");
    }

    reservaSeleccionada.cancelar();
    reservaSeleccionada = null;
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

    public void seleccionarReserva(Reserva reserva) {
    if (reserva == null || !reservas.contains(reserva)) {
        throw new IllegalArgumentException(
                "La reserva no pertenece al usuario.");
    }

    reservaSeleccionada = reserva;
    }
}
