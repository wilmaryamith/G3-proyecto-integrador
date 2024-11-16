/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

/**
 *
 * @author julia
 * @param <T>
 */
public interface IGestorDatosAsesor<T> {
    void creacion(T objeto);
    T lectura(String cedula);
    void actualizar(T objeto,String cedula);
    void eliminar(String cedula);
}
