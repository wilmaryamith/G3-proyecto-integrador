
package Controlador;

public class Venta {
    
    /* Atributoss Globales */
    private double precioTotal;
    private int numeroCuotas;
    private float interes;
    private Cliente clienteAsociado;

    //Metodo Constructor
    public Venta(double precioTotal, int numeroCuotas, float interes, Cliente clienteAsociado) {
        this.precioTotal = precioTotal;
        this.numeroCuotas = numeroCuotas;
        this.interes = interes;
        this.clienteAsociado = clienteAsociado;
    }
    
    // Agregar getter y setter
    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }
}
