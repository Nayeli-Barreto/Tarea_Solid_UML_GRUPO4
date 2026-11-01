package com.petdaycare.observer;

import com.petdaycare.usuarios.Usuario;

public class NotificacionSMS implements Notificacion {
    @Override
    public void enviar(Usuario usuario, String mensaje) {
        System.out.println("📱 [SMS enviado al teléfono " + usuario.getTelefono() + "]: " + mensaje);
    }
}
