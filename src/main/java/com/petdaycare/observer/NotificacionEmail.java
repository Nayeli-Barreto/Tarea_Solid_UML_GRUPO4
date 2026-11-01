package com.petdaycare.observer;

import com.petdaycare.usuarios.Usuario;

public class NotificacionEmail implements Notificacion {
    @Override
    public void enviar(Usuario usuario, String mensaje) {
        System.out.println("📧 [EMAIL enviado a " + usuario.getCorreo() + "]: " + mensaje);
    }
}
