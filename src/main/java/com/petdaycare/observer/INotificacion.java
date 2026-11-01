package com.petdaycare.observer;

import com.petdaycare.usuarios.Usuario;

public interface INotificacion {
    void enviar(Usuario usuario, String mensaje);
}
