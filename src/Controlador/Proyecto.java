package Controlador;

public class Proyecto {
    
    /* Atributoss Globales */
    public String nombre;
    public String numeroTorres;

    //Metodo Constructor
    public Proyecto(String nombre, String numeroTorres) {
        this.nombre = nombre;
        this.numeroTorres = numeroTorres;
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
    
    //Metodos adicionales
    public void agregarProyecto(String nombre, String numeroTorres) {
        this.nombre = nombre;
        this.numeroTorres = numeroTorres;
    }
    
    public void leerProyecto(String nombre){
        // Aqui va laa consulta a la base de datos que devuelve el proyecto
    }
    
    public void actualizarProyecto(String nuevoNombre, String nuevoNumeroTorres){
        this.nombre=nuevoNombre;
        this.numeroTorres=nuevoNumeroTorres;
    }
    
    public void eliminarProyecto(){
        this.nombre="";
        this.numeroTorres="";
    }
}
