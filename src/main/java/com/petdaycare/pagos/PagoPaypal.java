package com.petdaycare.pagos;

public class PagoPaypal implements IMetodoPago {
    private String email;

    public PagoPaypal(String email) {
        this.email = email;
    }

    @Override
    public boolean procesarPago(double total) {
        System.out.println(">>> [PagoPaypal] Procesando pago de $" + total + " con la cuenta PayPal: " + email);
        return true; 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
