package Configuracion;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion {

    private Connection cnn;
    private String cadenaConexion, usuarioDB, claveDB;

    public MiConexion(String cadenaConexion, String usuarioDB, String claveDB) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  // Cambiado a Oracle
            this.cadenaConexion = cadenaConexion;
            this.usuarioDB = usuarioDB;
            this.claveDB = claveDB;
            cnn = DriverManager.getConnection(this.cadenaConexion, this.usuarioDB, this.claveDB);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean testearConexion() {
        try {
            return !cnn.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void abrirConexion() {
        try {
            cnn = DriverManager.getConnection(cadenaConexion, usuarioDB, claveDB);
            System.out.println("Conexión abierta");
        } catch (SQLException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarConexion() {
        try {
            if (cnn != null && !cnn.isClosed()) {
                cnn.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
