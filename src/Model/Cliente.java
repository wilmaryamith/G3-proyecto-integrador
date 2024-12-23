package Model;


public class Cliente {
    
    
    private Long cedula;
    private String nombre;
    private String SISBEN;
    private String subsidio;
    private String direccion;
    private String telefono;

    // Metodo constructor
    public Cliente(Long cedula, String nombre, String SISBEN, String subsidio, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.SISBEN = SISBEN;
        this.subsidio = subsidio;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Metodos getter and setter
    public long getCedula() {
        return 0;
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

    public void setCedula(Long cedula) {
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
