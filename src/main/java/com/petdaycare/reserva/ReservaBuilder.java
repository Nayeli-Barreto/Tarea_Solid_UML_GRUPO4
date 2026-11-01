package com.petdaycare.reserva;

import com.petdaycare.mascota.Mascota;
import com.petdaycare.pagos.IMetodoPago;
import com.petdaycare.servicios.IServicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaBuilder implements IReservaBuilder {

    private String idReserva;
    private Mascota mascota;
    private LocalDate fecha;
    private FrecuenciaReserva frecuencia;
    private List<IServicio> servicios;
    private IMetodoPago metodoPago;
    private EstadoReserva estado;

    public ReservaBuilder() {
        this.servicios = new ArrayList<>();
        this.estado = EstadoReserva.DISPONIBLE;
        this.frecuencia = FrecuenciaReserva.UNICA;
    }

    @Override
    public IReservaBuilder setIdReserva(String idReserva) {
        this.idReserva = idReserva;
        return this;
    }

    @Override
    public IReservaBuilder setMascota(Mascota mascota) {
        this.mascota = mascota;
        return this;
    }

    @Override
    public IReservaBuilder setFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    @Override
    public IReservaBuilder setFrecuencia(
            FrecuenciaReserva frecuencia) {
        this.frecuencia = frecuencia;
        return this;
    }

    @Override
    public IReservaBuilder agregarServicio(IServicio servicio) {
        if (servicio != null) {
            this.servicios.add(servicio);
        }
        return this;
    }

    @Override
    public IReservaBuilder setMetodoPago(IMetodoPago metodoPago) {
        this.metodoPago = metodoPago;
        return this;
    }

    @Override
    public IReservaBuilder setEstado(EstadoReserva estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public Reserva build() {
        return new Reserva(this);
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

    public FrecuenciaReserva getFrecuencia() {
        return frecuencia;
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
}
