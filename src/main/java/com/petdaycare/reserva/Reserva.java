
package com.petdaycare.reserva;

import com.petdaycare.mascota.Mascota;
import com.petdaycare.pagos.IMetodoPago;
import com.petdaycare.servicios.IServicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private String idReserva;
    private Mascota mascota;
    private LocalDate fecha;
    private List<IServicio> servicios;
    private IMetodoPago metodoPago;
    private EstadoReserva estado;
    private FrecuenciaReserva frecuencia;

    public Reserva(ReservaBuilder builder) {
        this.idReserva = builder.getIdReserva();
        this.mascota = builder.getMascota();
        this.fecha = builder.getFecha();
        this.servicios = new ArrayList<>(builder.getServicios());
        this.metodoPago = builder.getMetodoPago();
        this.estado = builder.getEstado();
        this.frecuencia = builder.getFrecuencia();
    }

    public double calcularMonto() {
        double total = 0;

        for (IServicio servicio : servicios) {
            total += servicio.calcularPrecio();
        }

        return total;
    }

    public void confirmar() {

        if (servicios.isEmpty()) {
            System.out.println("No hay servicios asignados.");
            return;
        }

        for (IServicio servicio : servicios) {
            if (!servicio.verificarDisponibilidad()) {
                System.out.println(
                    "Servicio no disponible: "
                    + servicio.obtenerDescripcion()
                );
                return;
            }
        }

        if (metodoPago == null) {
            System.out.println(
                "No se ha seleccionado un método de pago."
            );
            return;
        }

        double total = calcularMonto();

        if (metodoPago.procesarPago(total)) {
            estado = EstadoReserva.CONFIRMADO;

            System.out.println(
                "Reserva " + idReserva
                + " confirmada para " + mascota.getNombre()
            );
        } else {
            System.out.println("El pago no pudo procesarse.");
        }
    }

    public void cancelar() {
        estado = EstadoReserva.CANCELADO;
        System.out.println("Reserva " + idReserva + " cancelada.");
    }

    public void programarRecurrencia() {
        if (frecuencia != FrecuenciaReserva.UNICA) {
            System.out.println(
                "Reserva programada con frecuencia: " + frecuencia
            );
        }
    }

    public String getIdReserva() {
        return idReserva;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<IServicio> getServicios() {
        return new ArrayList<>(servicios);
    }

    public IMetodoPago getMetodoPago() {
        return metodoPago;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public FrecuenciaReserva getFrecuencia() {
        return frecuencia;
    }
}
