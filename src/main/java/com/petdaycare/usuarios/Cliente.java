package com.petdaycare.usuarios;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private String especialidadContacto;
    private List<String> mascotasRegistradas;

    public Cliente(int id, String nombre,
                   String correo, String telefono) {

        super(id, nombre, correo, telefono);

        this.especialidadContacto = "Contacto principal";
        this.mascotasRegistradas = new ArrayList<>();
    }

    public void agregarMascota(String nombreMascota) {

        mascotasRegistradas.add(nombreMascota);

        System.out.println(
            ">>> [Cliente] Mascota '" + nombreMascota
            + "' registrada exitosamente para " + nombre
        );
    }

    public String generarComentario(String comentario) {
        return "Comentario del cliente (" + nombre
                + "): " + comentario;
    }

    public String getEspecialidadContacto() {
        return especialidadContacto;
    }

    public void setEspecialidadContacto(String especialidadContacto) {
        this.especialidadContacto = especialidadContacto;
    }

    public List<String> getMascotasRegistradas() {
        return mascotasRegistradas;
    }
}
