package com.petdaycare.usuarios;

public class Cuidador extends Usuario {
    private String especialidad;
    private String turno;

    public Cuidador(String correo, String telefono, String especialidad, String turno) {
        super(correo, telefono);
        this.especialidad = especialidad;
        this.turno = turno;
    }

    public void atenderIncidencia(String descripcionIncidencia) {
        System.out.println(">>> [Cuidador] Atendiendo incidencia: " + descripcionIncidencia);
    }

    public void registrarReporteDiario() {
        System.out.println(">>> [Cuidador] Registrando reporte de actividades para el turno: " + turno);
    }

    public void verificarBienestarMascota() {
        System.out.println(">>> [Cuidador] Verificando el estado y bienestar de las mascotas asignadas.");
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
