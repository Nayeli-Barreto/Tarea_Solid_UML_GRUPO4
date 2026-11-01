package com.petdaycare.usuarios;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private String especialidadContacto; 
    private List<String> mascotasRegistradas; s

    public Cliente(String correo, String telefono, String especialidadContacto) {
        super(correo, telefono);
        this.especialidadContacto = especialidadContacto;
        this.mascotasRegistradas = new ArrayList<>();
    }

    public void agregarMascota(String nombreMascota) {
        this.mascotasRegistradas.add(nombreMascota);
        System.out.println(">>> [Cliente] Mascota '" + nombreMascota + "' registrada exitosamente para " + correo);
    }

    public String generarComentario(String comentario) {
        return "Comentario del cliente (" + correo + "): " + comentario;
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
