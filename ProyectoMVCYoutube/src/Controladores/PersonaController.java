/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Configuracion.ConexionLocal;
import Interface.IGestorDatos;
import Models.Persona;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julia
 */
public class PersonaController implements IGestorDatos<Persona> {

    private Connection cnn;
    private final ConexionLocal connNewAdmin = new ConexionLocal();

    @Override
    public void creacion(Persona objeto) {
        try {
            connNewAdmin.conectar();
            String sql = "INSERT INTO Persona (cedula,nombre, apellidos, correo, fecha_nacimiento, pais, profesion) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = connNewAdmin.getConexion().prepareStatement(sql);
            st.setString(1, objeto.getCedula());
            st.setString(2, objeto.getNombre());
            st.setString(3, objeto.getApellidos());
            st.setString(4, objeto.getCorreo());

            // Formatear Fecha
            java.sql.Date fechaNacimiento = new java.sql.Date(objeto.getFecha_nacimiento().getTime());
            st.setDate(5, fechaNacimiento);
            st.setString(6, objeto.getPais());
            st.setString(7, objeto.getProfesion());

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha realizado un nuevo Registro", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Por favor compruebe los datos", "Error al crear el registro", JOptionPane.ERROR_MESSAGE);
        } finally {
            connNewAdmin.desconectar();
        }
    }

    @Override
    public Persona lectura(String cedula) {
        String sql = "SELECT cedula,nombre,apellidos,correo,fecha_nacimiento,pais,profesion FROM Persona WHERE cedula = '" + cedula + "'";

        Persona personaTraida = new Persona();

        try {
            connNewAdmin.conectar();
            PreparedStatement realizaConsula = connNewAdmin.getConexion().prepareStatement(sql);
            ResultSet resultado = realizaConsula.executeQuery();

            if (resultado.next()) {
                personaTraida.setCedula(resultado.getString("cedula"));
                personaTraida.setNombre(resultado.getString("nombre"));
                personaTraida.setApellidos(resultado.getString("apellidos"));
                personaTraida.setCorreo(resultado.getString("correo"));
                personaTraida.setFecha_nacimiento(resultado.getDate("fecha_nacimiento"));
                personaTraida.setPais(resultado.getString("pais"));
                personaTraida.setProfesion(resultado.getString("profesion"));
            } else {
                // Inicializar el objeto en caso de que no se encuentre el usuario
                personaTraida = new Persona();
                JOptionPane.showMessageDialog(null, "No se encontraron datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontraron registros.", "Error al Recuperar",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Error de tipo: " + e);
            System.out.println("Error en la clase: " + this.getClass().getName());
        }
        return personaTraida;
    }

    @Override
    public void actualizar(Persona objetoActualizar, String cedula) {
        String sqlActualizar = "Update Persona set cedula=?,nombre=?,apellidos=?,correo=?,fecha_nacimiento=?,pais=?,profesion=? WHERE cedula = '" + cedula + "'";

        try {
            connNewAdmin.conectar();
            PreparedStatement prepararConsultaEditar = connNewAdmin.getConexion().prepareStatement(sqlActualizar);
            prepararConsultaEditar.setString(1, objetoActualizar.getCedula());
            prepararConsultaEditar.setString(2, objetoActualizar.getNombre());
            prepararConsultaEditar.setString(3, objetoActualizar.getApellidos());
            prepararConsultaEditar.setString(4, objetoActualizar.getCorreo());
            java.sql.Date fechaNacimiento = new java.sql.Date(objetoActualizar.getFecha_nacimiento().getTime());
            prepararConsultaEditar.setDate(5, fechaNacimiento);
            prepararConsultaEditar.setString(6, objetoActualizar.getPais());
            prepararConsultaEditar.setString(7, objetoActualizar.getProfesion());

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
        String eliminar = "DELETE from PERSONA where cedula = '" + cedula + "'";
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
