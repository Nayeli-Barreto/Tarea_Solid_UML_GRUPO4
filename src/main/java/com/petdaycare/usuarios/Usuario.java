package com.petdaycare.usuarios;

public abstract class Usuario {
    protected String correo;
    protected String telefono;

    public Usuario(String correo, String telefono) {
        this.correo = correo;
        this.telefono = telefono;
    }

    public void registrarMascota() {
        System.out.println(">>> [PetDayCare] Registrando mascota...");
    }

    public void crearReserva() {
        System.out.println(">>> [PetDayCare] Creando nueva reserva...");
    }

    public void cancelarReserva() {
        System.out.println(">>> [PetDayCare] Solicitud de cancelación procesada.");
    }

    public void reportarIncidente(String descripcion) {
        System.out.println(">>> [Incidente Reportado]: " + descripcion);
    }

    public void consultarReservas() {
        System.out.println(">>> [PetDayCare] Consultando reservas activas...");
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
