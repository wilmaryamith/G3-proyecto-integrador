package Controlador;

public class Asesor {
    
    /* Atributoss Globales */
    private String nombre;
    private Number cedula;
    private String apellido;
    private String usuario;
    private String contraseña;

    //Metodo Constructor

    public Asesor(String nombre,Long cedula, String apellido, String usuario, String contraseña) {
        this.nombre = nombre;
        this.cedula=cedula;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    public long getCedula(){
        return 0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
   
}
