/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author SAlA-9
 */


import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private List<Producto> productos;
    
    
    public ProductoDAO() {
               
        // Datos iniciales
        productos = new ArrayList<>();  
        productos.add(new Producto(1, "Paracetamol", 2.5, 100));
        productos.add(new Producto(2, "Ibuprofeno", 3.0, 200));
        
    }
    
    // Método que lista todos los productos
    public List<Producto> listarProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void actualizarProducto(Producto producto) {
        for (Producto p : productos) {
            if (p.getId() == producto.getId()) {
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
                p.setCantidad(producto.getCantidad());
            }
        }
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }
}