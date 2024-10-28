package Controlador;

public class Inmueble {
    
    /* Atributoss Globales */
    public String numero;
    public double valor;
    public String tipoUnidad;
    public float area;
    private String matricula;
    private String vendedor;
    private String fechaEscritura;
    public String numeroTorre;

    //Metodo Constructor para el apartamento
    public Inmueble(String numero, double valor, float area, String matricula, String vendedor, String fechaEscritura ,String numeroTorre) {
        this.numero = numero;
        this.valor = valor;
        this.area = area;
        this.matricula = matricula;
        this.vendedor = vendedor;
        this.fechaEscritura = fechaEscritura;
        this.numeroTorre=numeroTorre;
    }
    
    //Metodo constructor para garage y local
    public Inmueble(double valor,float area,String vendedor,String fechaEscritura){
        this.valor=valor;
        this.area=area;
        this.vendedor=vendedor;
        this.fechaEscritura=fechaEscritura;
    }
    
    // Agregar getter y setter
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getFechaEscritura() {
        return fechaEscritura;
    }

    public void setFechaEscritura(String fechaEscritura) {
        this.fechaEscritura = fechaEscritura;
    }
}
