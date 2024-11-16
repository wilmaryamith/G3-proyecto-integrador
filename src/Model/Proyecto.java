package Model;

public class Proyecto {
    
    /* Atributoss Globales */
    private String id,nombre,numeroTorres;

    //Metodo Constructor

    public Proyecto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    // Agregar getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroTorres() {
        return numeroTorres;
    }

    public void setNumeroTorres(String numeroTorres) {
        this.numeroTorres = numeroTorres;
    }
}
