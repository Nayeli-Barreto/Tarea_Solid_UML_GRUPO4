package com.petdaycare.centro;

import com.petdaycare.mascota.Mascota;
import com.petdaycare.servicios.IServicio;
import java.util.Date;
import java.util.List;

public class HistorialAtencion {
    private String idHistorial;
    private Date fecha;
    private Mascota mascota;
    private List<IServicio> serviciosRealizados;
    private String observaciones;

    public HistorialAtencion(String idHistorial, Date fecha, Mascota mascota, List<IServicio> serviciosRealizados, String observaciones) {
        this.idHistorial = idHistorial;
        this.fecha = fecha;
        this.mascota = mascota;
        this.serviciosRealizados = serviciosRealizados;
        this.observaciones = observaciones;
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

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
