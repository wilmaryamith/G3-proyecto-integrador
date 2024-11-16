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
public interface IGestorDatosProyecto<T> {
    void creacion(T objeto);
    T lectura(String id);
    void actualizar(T objeto,String id);
    void eliminar(String id);
}
