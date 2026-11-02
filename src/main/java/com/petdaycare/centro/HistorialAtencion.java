package com.petdaycare.centro;

import com.petdaycare.mascota.Mascota;
import com.petdaycare.servicios.IServicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialAtencion {
    private String idHistorial;
    private Date fecha;
    private Mascota mascota;
    private List<IServicio> serviciosRealizados;
    private final List<String> observaciones = new ArrayList<>();
    private final List<String> comentarios = new ArrayList<>();
    private String textoPendiente;

    public HistorialAtencion(String idHistorial, Date fecha, Mascota mascota, List<IServicio> serviciosRealizados, String observaciones) {
        this.idHistorial = idHistorial;
        this.fecha = fecha;
        this.mascota = mascota;
        this.serviciosRealizados = new ArrayList<>(serviciosRealizados);
        setObservaciones(observaciones);
    }

    public void agregarServicio(IServicio servicio) {
        this.serviciosRealizados.add(servicio);
    }

    public String getIdHistorial() { return idHistorial; }
    public void setIdHistorial(String idHistorial) { this.idHistorial = idHistorial; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }

    public List<IServicio> getServiciosRealizados() { return serviciosRealizados; }
    public void setServiciosRealizados(List<IServicio> serviciosRealizados) { this.serviciosRealizados = serviciosRealizados; }

    public String getObservaciones() {
        return String.join(" | ", observaciones);
    }

    public void setObservaciones(String texto) {
        observaciones.clear();

        if (texto != null && !texto.isBlank()) {
            observaciones.add(texto);
        }
    }

    public void prepararTexto(String texto) {
    if (texto == null || texto.isBlank()) {
        throw new IllegalArgumentException(
                "El texto no puede estar vacío.");
    }

    textoPendiente = texto;
    }

    private String tomarTexto() {
        if (textoPendiente == null) {
            throw new IllegalStateException(
                    "Ingrese primero el texto.");
        }

        String texto = textoPendiente;
        textoPendiente = null;

        return texto;
    }

    public void agregarComentario() {
        comentarios.add(tomarTexto());
    }

    public void actualizarObservaciones() {
        observaciones.add(tomarTexto());
    }

    public void consultarHistorial() {
        System.out.println("Observaciones: " + observaciones);
        System.out.println("Comentarios: " + comentarios);
    }

    public List<String> getComentarios() {
        return new ArrayList<>(comentarios);
    }
}
