package com.petdaycare.usuarios;

public class Cuidador extends UsuarioSistema {

    private String especialidad;
    private String turno;

    public Cuidador(int id, String nombre,
                    String especialidad, String turno) {

        super(id, nombre);

        this.especialidad = especialidad;
        this.turno = turno;
    }

    // Métodos del diagrama UML

    public void atenderMascota() {
        System.out.println(
            ">>> [Cuidador] " + nombre
            + " está atendiendo a una mascota."
        );
    }

    public String generarComentario() {
        return "Comentario del cuidador " + nombre
                + ": Atención realizada correctamente.";
    }

    // Métodos adicionales del código original

    public void atenderIncidencia(String descripcionIncidencia) {
        System.out.println(
            ">>> [Cuidador] Atendiendo incidencia: "
            + descripcionIncidencia
        );
    }

    public void registrarReporteDiario() {
        System.out.println(
            ">>> [Cuidador] Registrando reporte del turno: "
            + turno
        );
    }

    public void verificarBienestarMascota() {
        System.out.println(
            ">>> [Cuidador] Verificando el bienestar de las mascotas."
        );
    }

    // Getters y setters

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
