/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author welco
 */
public class ConexionBD {
    
    //Definir unas variables de la conexion a la base de datos
   private String url="";
   public Connection con =null;
   private Statement stmt =null;
   private ResultSet rs = null;
   
   public ConexionBD(){
   
       //SQLite
       //url="jdbc:oracle:thin:@localhost:1521:JJW";
       
       //Base de datos con oracle
       url="jdbc:oracle:thin:@localhost:1521:XE";
       try {
           con = DriverManager.getConnection(url, "JJW", "JJW");
           if (con != null) {
               DatabaseMetaData meta = con.getMetaData();
               System.out.println("Base de datos conectada " + meta.getDriverName());
           }
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
   }
   
   public Connection getConnection(){
       return con;
   }
   
   public void closeConnection(Connection con){
       if(con != null){
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println("Error" + ex.getMessage());
               Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   
   }
   
   public ResultSet consultarBD(String sentencia){
   
       try {
           stmt = con.createStatement();
           rs=stmt.executeQuery(sentencia);
           
       } catch (SQLException sqlex){
           System.out.println("Error al hacedr el commit" + sqlex.getMessage());
       }
       catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       } 
       
       return rs;
   }
   
   
   public static void main(String[] args) throws SQLException {
        System.out.println("Iniciando la conexion a la base de datos");
        ConexionBD c = new ConexionBD();
        ResultSet rs = c.consultarBD("select * from proyecto");
        if(rs.next()){
            System.out.println("Dato 1");
            System.out.println(rs.getString("nombre"));
            System.out.println(rs.getString("descripcion"));
            System.out.println(rs.getInt("cantidad"));
        }
    }
}