package com.petdaycare.centro;

import com.petdaycare.reserva.Reserva;
import com.petdaycare.servicios.IServicio;
import com.petdaycare.usuarios.Cuidador;
import java.util.ArrayList;
import java.util.List;

public class Centro {

    private int id;
    private String nombre;
    private String direccion;
    private int capacidad;
    private String horario;

    private List<IServicio> servicios;
    private List<Cuidador> cuidadores;
    private List<Reserva> reservas;

    private PoliticaCancelacion politicaCancelacion;

    public Centro(int id, String nombre, String direccion,
                  int capacidad,
                  PoliticaCancelacion politicaCancelacion) {

        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.politicaCancelacion = politicaCancelacion;

        this.horario = "No establecido";
        this.servicios = new ArrayList<>();
        this.cuidadores = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarServicio(IServicio servicio) {
        if (servicio != null) {
            servicios.add(servicio);
        }
    }

    public void eliminarServicio(IServicio servicio) {
        servicios.remove(servicio);
    }

    public void agregarCuidador(Cuidador cuidador) {
        if (cuidador != null) {
            cuidadores.add(cuidador);
        }
    }

    public void registrarReserva(Reserva reserva) {
        if (reserva != null) {
            reservas.add(reserva);
        }
    }

    public boolean verificarDisponibilidad() {
        long reservasActivas = reservas.stream()
            .filter(r -> r.getEstado() != null
                && r.getEstado() != com.petdaycare.reserva.EstadoReserva.CANCELADO)
            .count();

        return reservasActivas < capacidad;
    }

    public void actualizarHorario(String horario) {
        if (horario != null && !horario.isBlank()) {
            this.horario = horario;
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getHorario() {
        return horario;
    }

    public List<IServicio> getServicios() {
        return new ArrayList<>(servicios);
    }

    public List<Cuidador> getCuidadores() {
        return new ArrayList<>(cuidadores);
    }

    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    private final List<Promocion> promociones = new ArrayList<>();
private final List<Restriccion> restricciones = new ArrayList<>();

public void agregarPromocion(Promocion promocion) {
    if (promocion == null
            || !Double.isFinite(promocion.getDescuento())
            || promocion.getDescuento() < 0
            || promocion.getDescuento() > 100) {
        throw new IllegalArgumentException("Promoción inválida.");
    }

    boolean existe = promociones.stream()
            .anyMatch(p -> p.getId() == promocion.getId());

    if (!existe) {
        promociones.add(promocion);
    }
}

    public void agregarRestriccion(Restriccion restriccion) {
        if (restriccion == null || !restriccion.validar()) {
            throw new IllegalArgumentException("Restricción inválida.");
        }

        boolean existe = restricciones.stream()
                .anyMatch(r -> r.getId() == restriccion.getId());

        if (!existe) {
            restricciones.add(restriccion);
        }
    }

    public void configurarPolitica(PoliticaCancelacion politica) {
        if (politica == null) {
            throw new IllegalArgumentException("La política es obligatoria.");
        }

        politicaCancelacion = politica;
    }

    public void reemplazarServicio(IServicio anterior, IServicio nuevo) {
        if (nuevo == null
                || !Double.isFinite(nuevo.calcularPrecio())
                || nuevo.calcularPrecio() < 0
                || capacidad <= 0) {
            throw new IllegalArgumentException(
                    "Precio o capacidad inválidos.");
        }

        if (anterior != null && !servicios.contains(anterior)) {
            throw new IllegalArgumentException(
                    "El servicio anterior no pertenece al centro.");
        }

        if (anterior != null) {
            servicios.remove(anterior);
        }

        if (!servicios.contains(nuevo)) {
            servicios.add(nuevo);
        }
    }

    public List<Promocion> getPromociones() {
        return new ArrayList<>(promociones);
    }

    public List<Restriccion> getRestricciones() {
        return new ArrayList<>(restricciones);
    }
}
