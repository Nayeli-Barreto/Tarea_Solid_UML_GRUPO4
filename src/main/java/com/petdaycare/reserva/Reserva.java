package com.petdaycare.reserva;

import com.petdaycare.mascota.Mascota;
import com.petdaycare.pagos.IMetodoPago;
import com.petdaycare.servicios.InterfaceServicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String idReserva;
    private Mascota mascota;
    private LocalDate fecha;
    private List<InterfaceServicio> servicios;
    private IMetodoPago metodoPago;
    private boolean confirmada;

    private Reserva(ReservaBuilder builder) {
        this.idReserva = builder.idReserva;
        this.mascota = builder.mascota;
        this.fecha = builder.fecha;
        this.servicios = builder.servicios;
        this.metodoPago = builder.metodoPago;
        this.confirmada = false;
    }

    public double calcularMontoTotal() {
        double total = 0.0;
        for (InterfaceServicio servicio : servicios) {
            total += servicio.calcularPrecio();
        }
        return total;
    }

    public boolean procesarReserva() {
        if (servicios.isEmpty()) {
            System.out.println(">>> [Reserva " + idReserva + "] No se asignaron servicios a la reserva.");
            return false;
        }

        for (InterfaceServicio servicio : servicios) {
            if (!servicio.verificarDisponibilidad()) {
                System.out.println(">>> [Reserva " + idReserva + "] Servicio sin disponibilidad: " + servicio.obtenerDescripcion());
                return false;
            }
        }

        double total = calcularMontoTotal();
        if (metodoPago != null && metodoPago.procesarPago(total)) {
            this.confirmada = true;
            System.out.println(">>> [Reserva " + idReserva + "] Confirmada exitosamente para " + mascota.getNombre());
            return true;
        }

        System.out.println(">>> [Reserva " + idReserva + "] Error al procesar el pago.");
        return false;
    }

    public String getIdReserva() { return idReserva; }
    public Mascota getMascota() { return mascota; }
    public LocalDate getFecha() { return fecha; }
    public List<InterfaceServicio> getServicios() { return servicios; }
    public IMetodoPago getMetodoPago() { return metodoPago; }
    public boolean isConfirmada() { return confirmada; }

    public static class ReservaBuilder {
        private String idReserva;
        private Mascota mascota;
        private LocalDate fecha;
        private List<InterfaceServicio> servicios;
        private IMetodoPago metodoPago;

        public ReservaBuilder(String idReserva, Mascota mascota, LocalDate fecha) {
            this.idReserva = idReserva;
            this.mascota = mascota;
            this.fecha = fecha;
            this.servicios = new ArrayList<>();
        }

        public ReservaBuilder agregarServicio(InterfaceServicio servicio) {
            this.servicios.add(servicio);
            return this;
        }

        public ReservaBuilder metodoPago(IMetodoPago metodoPago) {
            this.metodoPago = metodoPago;
            return this;
        }

        public Reserva build() {
            return new Reserva(this);
        }
    }
}
