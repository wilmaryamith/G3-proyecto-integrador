/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.ConexionLocal;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Interface.IGestorDatosInmueble;
import Model.Inmueble;

/**
 *
 * @author julia
 */
public class InmuebleController implements IGestorDatosInmueble<Inmueble> {

    private Connection cnn;
    private final ConexionLocal connNewAdmin = new ConexionLocal();

    @Override
    public void creacion(Inmueble objeto) {
        try {
            connNewAdmin.conectar();
            String sql = "INSERT INTO Apartamento (id,numeroApto,valor,tipoUnidad,area,matricula,fechaVenta) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = connNewAdmin.getConexion().prepareStatement(sql);
            st.setString(1, objeto.getId());
            st.setString(2, objeto.getNumeroApto());
            st.setString(3, objeto.getValor());
            st.setString(4, objeto.getTipoUnidad());

            // Formatear Fecha
            java.sql.Date fechaVenta = new java.sql.Date(objeto.getFechaVenta().getTime());

            st.setDate(7, fechaVenta);
            st.setString(5, objeto.getArea());
            st.setString(6, objeto.getMatricula());

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha realizado un nuevo Registro", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Por favor compruebe los datos"+e, "Error al crear el registro", JOptionPane.ERROR_MESSAGE);
        } finally {
            connNewAdmin.desconectar();
        }
    }

    @Override
    public Inmueble lectura(String id) {
        String sql = "SELECT id,numeroApto,valor,tipoUnidad,fechaVenta,area,matricula FROM Apartamento WHERE id = '" + id + "'";

        Inmueble inmuebleTraido = new Inmueble();

        try {
            connNewAdmin.conectar();
            PreparedStatement realizaConsula = connNewAdmin.getConexion().prepareStatement(sql);
            ResultSet resultado = realizaConsula.executeQuery();

            if (resultado.next()) {
                inmuebleTraido.setId(resultado.getString("id"));
                inmuebleTraido.setNumeroApto(resultado.getString("numeroApto"));
                inmuebleTraido.setValor(resultado.getString("valor"));
                inmuebleTraido.setTipoUnidad(resultado.getString("tipoUnidad"));
                inmuebleTraido.setFechaVenta(resultado.getDate("fechaVenta"));
                inmuebleTraido.setMatricula(resultado.getString("matricula"));
                inmuebleTraido.setArea(resultado.getString("area"));
            } else {
                // Inicializar el objeto en caso de que no se encuentre el usuario
                inmuebleTraido = new Inmueble();
                JOptionPane.showMessageDialog(null, "No se encontraron datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontraron registros.", "Error al Recuperar",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Error de tipo: " + e);
            System.out.println("Error en la clase: " + this.getClass().getName());
        }
        return inmuebleTraido;
    }

    @Override
    public void actualizar(Inmueble objetoActualizar, String id) {
        String sqlActualizar = "Update Apartamento set id=?,numeroApto=?,valor=?,tipoUnidad=?,matricula=?,area=?,fechaVenta=? WHERE id = '" + id + "'";
        try {
            connNewAdmin.conectar();
            PreparedStatement prepararConsultaEditar = connNewAdmin.getConexion().prepareStatement(sqlActualizar);
            prepararConsultaEditar.setString(1, objetoActualizar.getId());
            prepararConsultaEditar.setString(2, objetoActualizar.getNumeroApto());
            prepararConsultaEditar.setString(3, objetoActualizar.getValor());
            prepararConsultaEditar.setString(4, objetoActualizar.getTipoUnidad());
            prepararConsultaEditar.setString(5, objetoActualizar.getMatricula());
            prepararConsultaEditar.setString(6, objetoActualizar.getArea());
            java.sql.Date fechaVenta = new java.sql.Date(objetoActualizar.getFechaVenta().getTime());
            prepararConsultaEditar.setDate(7, fechaVenta);
            prepararConsultaEditar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado un inmueble", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el inmueble" + e, "Error al Actualizar", JOptionPane.ERROR_MESSAGE);
        } finally {
            connNewAdmin.desconectar();
        }
    }

    @Override
    public void eliminar(String id) {
        String eliminar = "DELETE from Apartamento where id = '" + id + "'";
        try {
            connNewAdmin.conectar();
            PreparedStatement eliminacion = connNewAdmin.getConexion().prepareStatement(eliminar);
            int filasAfectadas = eliminacion.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Datos Eliminados");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos a eliminar");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e);
        } finally {
            connNewAdmin.desconectar();
        }
    }
}
