package Configuracion;

import Interface.IGestorConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionLocal implements IGestorConexion {

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario = "JJW";
    private String clave = "JJW";

    private Connection conexion;

    public ConexionLocal() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void conectar() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  // Cambiado a Oracle
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conectado a la base de datos Oracle");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Desconectado de la base de datos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean testearConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                System.out.println("Conexión a Oracle abierta");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionLocal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
            
