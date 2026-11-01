package com.petdaycare.centro;

import java.util.Date;

public class PoliticaCancelacion {
    private double porcentajeReembolso;
    private int diasAnticipacionMinima;
    private String descripcion;
    private boolean esCancelable;

    public PoliticaCancelacion(double porcentajeReembolso, int diasAnticipacionMinima, String descripcion, boolean esCancelable) {
        this.porcentajeReembolso = porcentajeReembolso;
        this.diasAnticipacionMinima = diasAnticipacionMinima;
        this.descripcion = descripcion;
        this.esCancelable = esCancelable;
    }

    public boolean verificarSiEsCancelable(Date fechaReserva) {
        return esCancelable;
    }


    public double getPorcentajeReembolso() { return porcentajeReembolso; }
    public void setPorcentajeReembolso(double porcentajeReembolso) { this.porcentajeReembolso = porcentajeReembolso; }

    public int getDiasAnticipacionMinima() { return diasAnticipacionMinima; }
    public void setDiasAnticipacionMinima(int diasAnticipacionMinima) { this.diasAnticipacionMinima = diasAnticipacionMinima; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isEsCancelable() { return esCancelable; }
    public void setEsCancelable(boolean esCancelable) { this.esCancelable = esCancelable; }
}
