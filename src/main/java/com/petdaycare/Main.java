package com.petdaycare;

import com.petdaycare.centro.Centro;
import com.petdaycare.centro.HistorialAtencion;
import com.petdaycare.centro.PoliticaCancelacion;
import com.petdaycare.centro.Promocion;
import com.petdaycare.centro.Restriccion;
import com.petdaycare.mascota.AlertaSalud;
import com.petdaycare.mascota.Mascota;
import com.petdaycare.mascota.MascotaBuilder;
import com.petdaycare.mascota.TamanoMascota;
import com.petdaycare.observer.NotificacionApp;
import com.petdaycare.observer.NotificacionEmail;
import com.petdaycare.observer.NotificacionSMS;
import com.petdaycare.pagos.PagoTarjeta;
import com.petdaycare.reserva.FrecuenciaReserva;
import com.petdaycare.reserva.Reserva;
import com.petdaycare.reserva.ReservaBuilder;
import com.petdaycare.servicios.Hospedaje;
import com.petdaycare.servicios.Paquete;
import com.petdaycare.servicios.Paseo;
import com.petdaycare.servicios.SesionesBienestar;
import com.petdaycare.usuarios.Administrador;
import com.petdaycare.usuarios.Cliente;
import java.time.LocalDate;
import java.util.Date;

public class Main {
        public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       SISTEMA PETDAYCARE");
        System.out.println("==================================");

        // 1. Crear cliente
        Cliente cliente = new Cliente(
                1,
                "Ana Pérez",
                "ana.perez@email.com",
                "0991234567"
        );

        System.out.println(
                "\nCliente registrado: " + cliente.getCorreo()
        );

        // 2. Construir y registrar mascota
        Mascota mascota = new MascotaBuilder()
                .setId(1)
                .setNombre("Firulais")
                .setEspecie("Canino")
                .setRaza("Golden Retriever")
                .setEdad(3)
                .setTamano(TamanoMascota.GRANDE)
                .agregarAlertaSalud(
                        new AlertaSalud("Alergia al pollo", "Alta")
                )
                .build();

        cliente.registrarMascota(mascota);

        System.out.println(
                "\nMascota registrada: " + mascota.getNombre()
        );

        // 3. Crear servicios
        Hospedaje hospedaje = new Hospedaje(1, 25.0);
        Paseo paseo = new Paseo(10.0, "Matutino");
        SesionesBienestar bienestar =
                new SesionesBienestar(15.0, "Relajación");

        // 4. Crear paquete
        Paquete paquete = new Paquete("Vacaciones Felices");
        paquete.agregarServicio(hospedaje);
        paquete.agregarServicio(paseo);
        paquete.agregarServicio(bienestar);

        System.out.println(
                "\nPrecio del paquete: $" + paquete.calcularPrecio()
        );

        // 5. Crear centro y política
        PoliticaCancelacion politica = new PoliticaCancelacion(
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

        // 6. Configurar el catálogo mediante el administrador
        Administrador administrador =
                new Administrador(2, "Administradora");

        administrador.asignarCentro(centro);

        administrador.prepararServicio(null, paquete);
        administrador.editarServicio();

        Promocion promocion = new Promocion(
                1,
                "Promoción de bienvenida",
                10,
                LocalDate.now(),
                LocalDate.now().plusDays(30)
        );

        administrador.prepararPromocion(promocion);
        administrador.crearPromocion();

        administrador.prepararRestriccion(
                new Restriccion(1, "Presentar vacunas al día")
        );
        administrador.crearRestriccion();

        administrador.prepararPolitica(politica);
        administrador.crearPoliticaCancelacion();

        System.out.println(
                "\nPromociones registradas: "
                        + centro.getPromociones().size()
        );

        // 7. Seleccionar método de pago simulado
        PagoTarjeta metodoPago = new PagoTarjeta(
                "1234567890123456",
                "Ana Perez"
        );

        // 8. Crear la reserva mediante el usuario
        ReservaBuilder constructor = new ReservaBuilder();

        constructor.setIdReserva("RES-001")
                .setMascota(mascota)
                .setFecha(LocalDate.now().plusDays(2))
                .setFrecuencia(FrecuenciaReserva.UNICA)
                .agregarServicio(paquete)
                .setMetodoPago(metodoPago);

        Reserva reserva = cliente.crearReserva(constructor);

        centro.registrarReserva(reserva);

        System.out.println(
                "\nReserva registrada en: " + centro.getNombre()
        );

        // 9. Confirmar reserva y procesar pago
        reserva.confirmar();

        System.out.println(
                "Estado de reserva: " + reserva.getEstado()
        );

        // 10. Enviar notificaciones simuladas
        String mensaje = "Tu reserva "
                + reserva.getIdReserva()
                + " ha sido procesada.";

        NotificacionEmail email = new NotificacionEmail();
        NotificacionSMS sms = new NotificacionSMS();
        NotificacionApp app = new NotificacionApp();

        email.enviar(cliente, mensaje);
        sms.enviar(cliente, mensaje);
        app.enviar(cliente, mensaje);

        // 11. Registrar comentarios y observaciones
        HistorialAtencion historial = new HistorialAtencion(
                "H-001",
                new Date(),
                mascota,
                reserva.getServicios(),
                "Inicio de la atención"
        );

        historial.prepararTexto("La mascota comió normalmente.");
        historial.agregarComentario();

        historial.prepararTexto(
                "Se mostró tranquila durante la estancia."
        );
        historial.actualizarObservaciones();

        historial.consultarHistorial();

        // 12. Demostrar la cancelación básica desde el usuario
        cliente.seleccionarReserva(reserva);
        cliente.cancelarReserva();

        System.out.println(
                "\nEstado después de cancelar: " + reserva.getEstado()
        );

        System.out.println("\n==================================");
        System.out.println("     PRUEBA FINALIZADA");
        System.out.println("==================================");
        }
}