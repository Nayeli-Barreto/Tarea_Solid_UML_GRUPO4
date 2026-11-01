package com.petdaycare;

import com.petdaycare.centro.Centro;
import com.petdaycare.centro.PoliticaCancelacion;
import com.petdaycare.mascota.AlertaSalud;
import com.petdaycare.mascota.Mascota;
import com.petdaycare.mascota.MascotaBuilder;
import com.petdaycare.mascota.TamanoMascota;
import com.petdaycare.observer.NotificacionApp;
import com.petdaycare.observer.NotificacionEmail;
import com.petdaycare.observer.NotificacionSMS;
import com.petdaycare.pagos.IMetodoPago;
import com.petdaycare.pagos.PagoTarjeta;
import com.petdaycare.reserva.EstadoReserva;
import com.petdaycare.reserva.FrecuenciaReserva;
import com.petdaycare.reserva.Reserva;
import com.petdaycare.reserva.ReservaBuilder;
import com.petdaycare.servicios.Hospedaje;
import com.petdaycare.servicios.Paquete;
import com.petdaycare.servicios.Paseo;
import com.petdaycare.usuarios.Cliente;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      INICIANDO SISTEMA DE PRUEBA: PETDAYCARE     ");
        System.out.println("==================================================");

        Cliente cliente = new Cliente("C001", "Ana Pérez", "ana.perez@email.com", "0991234567");
        System.out.println("\n[1] Cliente registrado: " + cliente.getNombre() + " (" + cliente.getCorreo() + ")");

        Mascota mascota = new MascotaBuilder()
                .setNombre("Firulais")
                .setEspecie("Canino")
                .setRaza("Golden Retriever")
                .setEdad(3)
                .setTamano(TamanoMascota.GRANDE)
                .agregarAlertaSalud(new AlertaSalud("Alergia", "Alergico al pollo", new Date(), false))
                .build();
        System.out.println("[2] Mascota creada con Builder: " + mascota.getNombre() + " (" + mascota.getRaza() + ", Tamaño: " + mascota.getTamano() + ")");

        Hospedaje hospedaje = new Hospedaje(25.0, "Hospedaje nocturno por 1 noche", 1);
        Paseo paseo = new Paseo(10.0, "Paseo matutino de 1 hora", "Parque Lineal");

        Paquete paqueteServicios = new Paquete("PK01", "Paquete Vacaciones Felices");
        paqueteServicios.agregarServicio(hospedaje);
        paqueteServicios.agregarServicio(paseo);
        System.out.println("[3] Servicios creados (Patrón Composite) - Costo total del paquete: $" + paqueteServicios.calcularPrecio());

        IMetodoPago metodoPago = new PagoTarjeta("1234-5678-9876-5432");
        boolean pagoExitoso = metodoPago.procesarPago(paqueteServicios.calcularPrecio());
        if (pagoExitoso) {
            System.out.println("[4] Pago procesado exitosamente con Tarjeta.");
        }

        Reserva reserva = new ReservaBuilder()
                .setIdReserva("RES-2026-001")
                .setMascota(mascota)
                .setFecha(LocalDate.now().plusDays(2))
                .setFrecuencia(FrecuenciaReserva.UNICA)
                .agregarServicio(paqueteServicios)
                .setMetodoPago(metodoPago)
                .setEstado(EstadoReserva.CONFIRMADA)
                .build();
        System.out.println("[5] Reserva generada con ID: " + reserva.getIdReserva() + " - Estado: " + reserva.getEstado());

        PoliticaCancelacion politica = new PoliticaCancelacion(100.0, 1, "Reembolso total cancelando con 24h de anticipación", true);
        Centro centro = new Centro("PetDayCare Guayaquil", "Av. Principal del Norte", politica);
        centro.registrarReserva(reserva);
        System.out.println("[6] Reserva registrada en el centro: " + centro.getNombre());

        System.out.println("\n--- ENVIANDO NOTIFICACIONES (Patrón Observer) ---");
        NotificacionEmail email = new NotificacionEmail();
        NotificacionSMS sms = new NotificacionSMS();
        NotificacionApp app = new NotificacionApp();

        String mensajeNotificacion = "¡Hola Ana! Tu reserva " + reserva.getIdReserva + " para " + mascota.getNombre() + " ha sido confirmada con éxito.";
        
        email.enviar(cliente, mensajeNotificacion);
        sms.enviar(cliente, mensajeNotificacion);
        app.enviar(cliente, mensajeNotificacion);

        System.out.println("\n==================================================");
        System.out.println("      PRUEBA FINALIZADA EXITOSAMENTE            ");
        System.out.println("==================================================");
    }
}
