package Controlador;

import java.util.Date;

public class Pago {
    
    /* Atributoss Globales */
    private double valor;
    private Date fecha;
    private Cliente clienteAsociado;
    private Asesor asesorAsociado;

    //Metodo Constructor
    public Pago(double valor, Date fecha, Cliente clienteAsociado, Asesor asesorAsociado) {
        this.valor = valor;
        this.fecha = fecha;
        this.clienteAsociado = clienteAsociado;
        this.asesorAsociado = asesorAsociado;
    }

    // Agregar getter y setter
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public Asesor getAsesorAsociado() {
        return asesorAsociado;
    }

    public void setAsesorAsociado(Asesor asesorAsociado) {
        this.asesorAsociado = asesorAsociado;
    }
}
