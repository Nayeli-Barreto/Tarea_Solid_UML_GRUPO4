package com.petdaycare.reserva;

import com.petdaycare.mascota.Mascota;
import com.petdaycare.pagos.IMetodoPago;
import com.petdaycare.servicios.InterfaceServicio;

import java.time.LocalDate;

public interface IReservaBuilder {
    IReservaBuilder setIdReserva(String idReserva);
    IReservaBuilder setMascota(Mascota mascota);
    IReservaBuilder setFecha(LocalDate fecha);
    IReservaBuilder setFrecuencia(FrecuenciaReserva frecuencia);
    IReservaBuilder agregarServicio(InterfaceServicio servicio);
    IReservaBuilder setMetodoPago(IMetodoPago metodoPago);
    IReservaBuilder setEstado(EstadoReserva estado);
    Reserva build();
}
