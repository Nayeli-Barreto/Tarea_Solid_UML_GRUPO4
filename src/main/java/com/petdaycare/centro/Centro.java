package com.petdaycare.centro;

import java.util.ArrayList;
import java.util.List;

import com.petdaycare.usuarios.Cuidador;
import com.petdaycare.servicios.IServicio;
import com.petdaycare.reserva.Reserva;

public class Centro {

    private int id;
    private String nombre;
    private String direccion;
    private int capacidad;
    private String horario;

    private List<IServicio> servicios;
    private List<Cuidador> cuidadores;
    private List<Reserva> reservas;

    private PoliticaCancelacion politicaCancelacion;

    public Centro(int id, String nombre, String direccion,
                  int capacidad,
                  PoliticaCancelacion politicaCancelacion) {

        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.politicaCancelacion = politicaCancelacion;

        this.horario = "No establecido";
        this.servicios = new ArrayList<>();
        this.cuidadores = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarServicio(IServicio servicio) {
        if (servicio != null) {
            servicios.add(servicio);
        }
    }

    public void eliminarServicio(IServicio servicio) {
        servicios.remove(servicio);
    }

    public void agregarCuidador(Cuidador cuidador) {
        if (cuidador != null) {
            cuidadores.add(cuidador);
        }
    }

    public void registrarReserva(Reserva reserva) {
        if (reserva != null) {
            reservas.add(reserva);
        }
    }

    public boolean verificarDisponibilidad() {
        long reservasActivas = reservas.stream()
            .filter(r -> r.getEstado() != null
                && r.getEstado() != com.petdaycare.reserva.EstadoReserva.CANCELADO)
            .count();

        return reservasActivas < capacidad;
    }

    public void actualizarHorario(String horario) {
        if (horario != null && !horario.isBlank()) {
            this.horario = horario;
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getHorario() {
        return horario;
    }

    public List<IServicio> getServicios() {
        return new ArrayList<>(servicios);
    }

    public List<Cuidador> getCuidadores() {
        return new ArrayList<>(cuidadores);
    }

    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }
}
