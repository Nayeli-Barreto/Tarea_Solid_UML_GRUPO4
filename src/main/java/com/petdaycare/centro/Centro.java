package com.petdaycare.centro;

import com.petdaycare.mascota.Mascota;
import com.petdaycare.reserva.Reserva;
import com.petdaycare.usuarios.Administrador;
import com.petdaycare.usuarios.Cliente;
import com.petdaycare.usuarios.Cuidador;

import java.util.ArrayList;
import java.util.List;

public class Centro {
    private String nombre;
    private String direccion;
    private List<Reserva> reservas;
    private List<Cliente> clientes;
    private List<Cuidador> cuidadores;
    private List<Administrador> administradores;
    private PoliticaCancelacion politicaCancelacion;
    private List<HistorialAtencion> historialAtenciones;

    public Centro(String nombre, String direccion, PoliticaCancelacion politicaCancelacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.politicaCancelacion = politicaCancelacion;
        this.reservas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.cuidadores = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.historialAtenciones = new ArrayList<>();
    }

    public void registrarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void cancelarReserva(String idReserva) {
        reservas.removeIf(r -> r.getIdReserva().equals(idReserva));
        System.out.println(">>> [Centro] Reserva " + idReserva + " cancelada.");
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void agregarCuidador(Cuidador cuidador) {
        this.cuidadores.add(cuidador);
    }

    public void agregarHistorial(HistorialAtencion historial) {
        this.historialAtenciones.add(historial);
    }

    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public List<Reserva> getReservas() { return reservas; }
    public List<Cliente> getClientes() { return clientes; }
    public List<Cuidador> getCuidadores() { return cuidadores; }
    public PoliticaCancelacion getPoliticaCancelacion() { return politicaCancelacion; }
    public void setPoliticaCancelacion(PoliticaCancelacion politica) { this.politicaCancelacion = politica; }
}
