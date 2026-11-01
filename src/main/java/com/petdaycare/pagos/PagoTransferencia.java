package com.petdaycare.pagos;

public class PagoTransferencia implements IMetodoPago {
    private String banco;
    private String numeroCuenta;

    public PagoTransferencia(String banco, String numeroCuenta) {
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public boolean procesarPago(double total) {
        System.out.println(">>> [PagoTransferencia] Procesando transferencia de $" + total + " desde el banco " + banco + ", cuenta: " + numeroCuenta);
        return true; 
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
