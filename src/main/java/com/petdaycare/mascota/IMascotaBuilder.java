package com.petdaycare.mascota;

public interface IMascotaBuilder {
    IMascotaBuilder setNombre(String nombre);
    IMascotaBuilder setEspecie(String especie);
    IMascotaBuilder setRaza(String raza);
    IMascotaBuilder setEdad(int edad);
    IMascotaBuilder setTamano(TamanoMascota tamano);
    IMascotaBuilder agregarAlertaSalud(AlertaSalud alerta);
    Mascota build();
}
