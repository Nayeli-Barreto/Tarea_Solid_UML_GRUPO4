package com.petdaycare.observer;

import com.petdaycare.usuarios.Usuario;

public class NotificacionApp implements INotificacion {
    @Override
    public void enviar(Usuario usuario, String mensaje) {
        System.out.println("🔔 [PUSH APP para " + usuario.getNombre() + "]: " + mensaje);
    }
}
