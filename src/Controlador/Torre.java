package Controlador;

public class Torre {
    
    /* Atributoss Globales */
    public String numeroTorre;
    public String numeroApartamentos;

    //Metodo Constructor
    public Torre(String numeroTorre, String numeroApartamentos) {
        this.numeroTorre = numeroTorre;
        this.numeroApartamentos = numeroApartamentos;
    }

    // Agregar getter y setter
    public String getNumeroTorre() {
        return numeroTorre;
    }

    public void setNumeroTorre(String numeroTorre) {
        this.numeroTorre = numeroTorre;
    }

    public String getNumeroApartamentos() {
        return numeroApartamentos;
    }

    public void setNumeroApartamentos(String numeroApartamentos) {
        this.numeroApartamentos = numeroApartamentos;
    }
    
    public void agregarTorre(String numeroTorre, String numeroApartamentos) {
        this.numeroTorre = numeroTorre;
        this.numeroApartamentos = numeroApartamentos;
    }
    
    public void leerTorre(String numeroTorre){
    // Aqui va laa consulta a la base de datos que devuelve la torre
    }
    
    public void actualizarTorre(String nuevoNumeroTorre,String nuevoNumeroApartamentos){
        this.numeroTorre = nuevoNumeroTorre;
        this.numeroApartamentos = nuevoNumeroApartamentos;
    }
    
    public void eliminarTorre(){
        this.numeroTorre = "";
        this.numeroApartamentos = "";
    }
}
