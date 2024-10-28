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
}
