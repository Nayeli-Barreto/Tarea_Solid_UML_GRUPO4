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
import com.petdaycare.pagos.PagoTarjeta;
import com.petdaycare.reserva.Reserva;
import com.petdaycare.reserva.ReservaBuilder;
import com.petdaycare.reserva.FrecuenciaReserva;
import com.petdaycare.servicios.Hospedaje;
import com.petdaycare.servicios.Paquete;
import com.petdaycare.servicios.Paseo;
import com.petdaycare.servicios.SesionesBienestar;
import com.petdaycare.usuarios.Cliente;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       SISTEMA PETDAYCARE");
        System.out.println("==================================");

        // 1. Registrar cliente
        Cliente cliente = new Cliente(
            1,
            "Ana Pérez",
            "ana.perez@email.com",
            "0991234567"
        );

        System.out.println("\nCliente registrado: "
                + cliente.getCorreo());

        // 2. Registrar mascota
        Mascota mascota = new MascotaBuilder()
                .setId(1)
                .setNombre("Firulais")
                .setEspecie("Canino")
                .setRaza("Golden Retriever")
                .setEdad(3)
                .setTamano(TamanoMascota.GRANDE)
                .agregarAlertaSalud(
                    new AlertaSalud(
                        "Alergia al pollo",
                        "Alta"
                    )
                )
                .build();

        System.out.println("\nMascota registrada: "
                + mascota.getNombre());

        // 3. Seleccionar servicios
        Hospedaje hospedaje = new Hospedaje(1, 25.0);

        Paseo paseo = new Paseo(10.0, "Matutino");

        SesionesBienestar bienestar =
                new SesionesBienestar(15.0, "Relajación");

        // 4. Crear paquete
        Paquete paquete = new Paquete("Vacaciones Felices");

        paquete.agregarServicio(hospedaje);
        paquete.agregarServicio(paseo);
        paquete.agregarServicio(bienestar);

        System.out.println("\nPrecio del paquete: $"
                + paquete.calcularPrecio());

        // 5. Seleccionar método de pago
        PagoTarjeta metodoPago = new PagoTarjeta(
            "1234567890123456",
            "Ana Perez"
        );

        // 6. Crear reserva
        Reserva reserva = new ReservaBuilder()
                .setIdReserva("RES-001")
                .setMascota(mascota)
                .setFecha(LocalDate.now().plusDays(2))
                .setFrecuencia(FrecuenciaReserva.UNICA)
                .agregarServicio(paquete)
                .setMetodoPago(metodoPago)
                .build();

        // 7. Confirmar reserva y procesar pago
        reserva.confirmar();

        System.out.println("Estado de reserva: "
                + reserva.getEstado());

        // 8. Registrar centro
        PoliticaCancelacion politica =
                new PoliticaCancelacion(
                    100.0,
                    1,
                    "Reembolso total con 24 horas de anticipación",
                    true
                );

        Centro centro = new Centro(
            1,
            "PetDayCare Guayaquil",
            "Av. Principal del Norte",
            20,
            politica
        );

        centro.registrarReserva(reserva);

        System.out.println("\nReserva registrada en: "
                + centro.getNombre());

        // 9. Enviar notificaciones
        String mensaje = "Tu reserva "
                + reserva.getIdReserva()
                + " ha sido procesada.";

        NotificacionEmail email = new NotificacionEmail();
        NotificacionSMS sms = new NotificacionSMS();
        NotificacionApp app = new NotificacionApp();

        email.enviar(cliente, mensaje);
        sms.enviar(cliente, mensaje);
        app.enviar(cliente, mensaje);

        System.out.println("\n==================================");
        System.out.println("     PRUEBA FINALIZADA");
        System.out.println("==================================");
    }
}
