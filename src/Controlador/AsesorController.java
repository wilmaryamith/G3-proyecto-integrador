/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.Asesor;
import Configuracion.ConexionLocal;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Interface.IGestorDatosAsesor;

/**
 *
 * @author julia
 */
public class AsesorController implements IGestorDatosAsesor<Asesor> {

    private Connection cnn;
    private final ConexionLocal connNewAdmin = new ConexionLocal();

    @Override
    public void creacion(Asesor objeto) {
        try {
            connNewAdmin.conectar();
            String sql = "INSERT INTO Asesor (cedula, nombre, direccion,telefono, correo, usuario, contrasena) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = connNewAdmin.getConexion().prepareStatement(sql);
            st.setString(1, objeto.getCedula());
            st.setString(2, objeto.getNombre());
            st.setString(3, objeto.getDireccion());
            st.setString(4, objeto.getTelefono());
            st.setString(5, objeto.getCorreo());
            st.setString(6, objeto.getUsuario());
            st.setString(7, objeto.getContrasena());

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Asesor registrado correctamente", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Por favor compruebe los datos", "Error al crear el asesor", JOptionPane.ERROR_MESSAGE);
        } finally {
            connNewAdmin.desconectar();
        }
    }

    @Override
    public Asesor lectura(String cedula) {
        String sql = "SELECT cedula,nombre,direccion,telefono,correo,usuario,contrasena FROM Asesor WHERE cedula = '" + cedula + "'";

        Asesor asesorTraido = new Asesor();

        try {
            connNewAdmin.conectar();
            PreparedStatement realizaConsula = connNewAdmin.getConexion().prepareStatement(sql);
            ResultSet resultado = realizaConsula.executeQuery();

            if (resultado.next()) {
                asesorTraido.setCedula(resultado.getString("cedula"));
                asesorTraido.setNombre(resultado.getString("nombre"));
                asesorTraido.setDireccion(resultado.getString("direccion"));
                asesorTraido.setTelefono(resultado.getString("telefono"));
                asesorTraido.setCorreo(resultado.getString("correo"));
                asesorTraido.setUsuario(resultado.getString("usuario"));
                asesorTraido.setContrasena(resultado.getString("contrasena"));
            } else {
                // Inicializar el objeto en caso de que no se encuentre el usuario
                asesorTraido = new Asesor();
                JOptionPane.showMessageDialog(null, "No se encontraron datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontraron registros.", "Error al Recuperar",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Error de tipo: " + e);
            System.out.println("Error en la clase: " + this.getClass().getName());
        }
        return asesorTraido;
    }

    @Override
    public void actualizar(Asesor objetoActualizar, String cedula) {
        String sqlActualizar = "Update Asesor set cedula=?,nombre=?,direccion=?,telefono=?,correo=?,usuario=?,contrasena=? WHERE cedula = '" + cedula + "'";
        try {
            connNewAdmin.conectar();
            PreparedStatement prepararConsultaEditar = connNewAdmin.getConexion().prepareStatement(sqlActualizar);
            prepararConsultaEditar.setString(1, objetoActualizar.getCedula());
            prepararConsultaEditar.setString(2, objetoActualizar.getNombre());
            prepararConsultaEditar.setString(3, objetoActualizar.getDireccion());
            prepararConsultaEditar.setString(4, objetoActualizar.getTelefono());
            prepararConsultaEditar.setString(5, objetoActualizar.getCorreo());
            prepararConsultaEditar.setString(6, objetoActualizar.getUsuario());
            prepararConsultaEditar.setString(7, objetoActualizar.getContrasena());

            prepararConsultaEditar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado un nuevo Registro", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro de la persona" + e, "Error al Actualizar", JOptionPane.ERROR_MESSAGE);
        } finally {
            connNewAdmin.desconectar();
        }
    }

    @Override
    public void eliminar(String cedula) {
        String eliminar = "DELETE from ASESOR where cedula = '" + cedula + "'";
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
