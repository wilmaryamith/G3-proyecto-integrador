/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.ConexionLocal;
import Model.Torre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Interface.IGestorDatosTorre;


/**
 *
 * @author julia
 */
public class TorreController implements IGestorDatosTorre<Torre>{

    private Connection cnn;
    private final ConexionLocal connNewAdmin = new ConexionLocal();

    @Override
    public void creacion(Torre objeto) {
        try {
            connNewAdmin.conectar();
            String sql = "INSERT INTO Torre (id,numeroTorre,numeroApartamentos,id_Proyecto) VALUES (?,?,?,?)";
            PreparedStatement st = connNewAdmin.getConexion().prepareStatement(sql);
            st.setString(1, objeto.getId());
            st.setString(2, objeto.getNumeroTorre());
            st.setString(3, objeto.getNumeroApts());
            st.setString(4, objeto.getIdProyecto());

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Torre insertada correctamente", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Por favor compruebe los datos"+e, "Error al crear el proyecto", JOptionPane.ERROR_MESSAGE);
        } finally {
            connNewAdmin.desconectar();
        }
    }

    @Override
    public Torre lectura(String id) {
        String sql = "SELECT id,numeroTorre,numeroApartamentos,id_Proyecto FROM Torre WHERE id = '" + id + "'";

        Torre torreTraida = new Torre();

        try {
            connNewAdmin.conectar();
            PreparedStatement realizaConsulta = connNewAdmin.getConexion().prepareStatement(sql);
            ResultSet resultado = realizaConsulta.executeQuery();

            if (resultado.next()) {
                torreTraida.setId(resultado.getString("id"));
                torreTraida.setNumeroTorre(resultado.getString("numeroTorre"));
                torreTraida.setNumeroApts(resultado.getString("numeroApartamentos"));
                torreTraida.setIdProyecto(resultado.getString("id_proyecto"));

            } else {
                // Inicializar el objeto en caso de que no se encuentre el usuario
                torreTraida = new Torre();
                JOptionPane.showMessageDialog(null, "No se encontraron datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontraron registros.", "Error al Recuperar",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Error de tipo: " + e);
            System.out.println("Error en la clase: " + this.getClass().getName());
        }
        return torreTraida;
    }

    @Override
    public void actualizar(Torre objetoActualizar, String id) {
        String sqlActualizar = "Update Torre set id=?,numeroTorre=?,numeroApartamentos=?,id_proyecto=? WHERE id = '" + id + "'";
        try {
            connNewAdmin.conectar();
            PreparedStatement prepararConsultaEditar = connNewAdmin.getConexion().prepareStatement(sqlActualizar);
            prepararConsultaEditar.setString(1, objetoActualizar.getId());
            prepararConsultaEditar.setString(2, objetoActualizar.getNumeroTorre());
            prepararConsultaEditar.setString(3, objetoActualizar.getNumeroApts());
            prepararConsultaEditar.setString(4, objetoActualizar.getIdProyecto());

            prepararConsultaEditar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado una torre", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la torre " + e, "Error al Actualizar", JOptionPane.ERROR_MESSAGE);
        } finally {
            connNewAdmin.desconectar();
        }
    }

    @Override
    public void eliminar(String id) {
        String eliminar = "DELETE from Torre where id = '" + id + "'";
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
