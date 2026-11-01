package com.petdaycare.centro;

import com.petdaycare.reserva.Reserva;

public interface IVerificadorDisponibilidad {
    boolean verificar(Reserva reserva);
}
