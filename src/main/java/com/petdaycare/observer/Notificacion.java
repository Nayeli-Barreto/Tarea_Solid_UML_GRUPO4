package com.petdaycare.observer;

import com.petdaycare.usuarios.Usuario;

public interface Notificacion {
    void enviar(Usuario usuario, String mensaje);
}
