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
import Interface.IGestorDatosProyecto;
import Model.Proyecto;

/**
 *
 * @author julia
 */
public class ProyectoController implements IGestorDatosProyecto<Proyecto> {

    private Connection cnn;
    private final ConexionLocal connNewAdmin = new ConexionLocal();

    @Override
    public void creacion(Proyecto objeto) {
        try {
            connNewAdmin.conectar();
            String sql = "INSERT INTO Proyecto (id,nombre,numeroTorres) VALUES (?,?,?)";
            PreparedStatement st = connNewAdmin.getConexion().prepareStatement(sql);
            st.setString(1, objeto.getId());
            st.setString(2, objeto.getNombre());
            st.setString(3, objeto.getNumeroTorres());

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proyecto creado correctamente", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Por favor compruebe los datos", "Error al crear el proyecto", JOptionPane.ERROR_MESSAGE);
        } finally {
            connNewAdmin.desconectar();
        }
    }

    @Override
    public Proyecto lectura(String id) {
        String sql = "SELECT id,nombre,numeroTorres FROM Proyecto WHERE id = '" + id + "'";

        Proyecto proyectoTraido = new Proyecto();

        try {
            connNewAdmin.conectar();
            PreparedStatement realizaConsulta = connNewAdmin.getConexion().prepareStatement(sql);
            ResultSet resultado = realizaConsulta.executeQuery();

            if (resultado.next()) {
                proyectoTraido.setId(resultado.getString("id"));
                proyectoTraido.setNombre(resultado.getString("nombre"));
                proyectoTraido.setNumeroTorres(resultado.getString("numeroTorres"));
            } else {
                // Inicializar el objeto en caso de que no se encuentre el usuario
                proyectoTraido = new Proyecto();
                JOptionPane.showMessageDialog(null, "No se encontraron datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontraron registros.", "Error al Recuperar",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Error de tipo: " + e);
            System.out.println("Error en la clase: " + this.getClass().getName());
        }
        return proyectoTraido;
    }

    @Override
    public void actualizar(Proyecto objetoActualizar, String id) {
        String sqlActualizar = "Update Proyecto set id=?,nombre=?,numeroTorres=? WHERE id = '" + id + "'";
        try {
            connNewAdmin.conectar();
            PreparedStatement prepararConsultaEditar = connNewAdmin.getConexion().prepareStatement(sqlActualizar);
            prepararConsultaEditar.setString(1, objetoActualizar.getId());
            prepararConsultaEditar.setString(2, objetoActualizar.getNombre());
            prepararConsultaEditar.setString(3, objetoActualizar.getNumeroTorres());
            prepararConsultaEditar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado un proyecto", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el proyecto" + e, "Error al Actualizar", JOptionPane.ERROR_MESSAGE);
        } finally {
            connNewAdmin.desconectar();
        }
    }

    @Override
    public void eliminar(String id) {
        String eliminar = "DELETE from Proyecto where id = '" + id + "'";
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
