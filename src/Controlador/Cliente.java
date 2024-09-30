package Controlador;


public class Cliente {
    
    private String cedula;
    private String nombre;
    private String SISBEN;
    private String subsidio;
    private String direccion;
    private String telefono;

    public Cliente(String cedula, String nombre, String SISBEN, String subsidio, String direccion, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.SISBEN = SISBEN;
        this.subsidio = subsidio;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSISBEN() {
        return SISBEN;
    }

    public String getSubsidio() {
        return subsidio;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSISBEN(String SISBEN) {
        this.SISBEN = SISBEN;
    }

    public void setSubsidio(String subsidio) {
        this.subsidio = subsidio;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
            
}
