package com.petdaycare.pagos;

public class PagoTarjeta implements IMetodoPago {
    private String numeroTarjeta;
    private String titular;

    public PagoTarjeta(String numeroTarjeta, String titular) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
    }

    @Override
    public boolean procesarPago(double total) {
        System.out.println(">>> [PagoTarjeta] Procesando pago de $" + total + " con tarjeta de " + titular);
        return true; 
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
