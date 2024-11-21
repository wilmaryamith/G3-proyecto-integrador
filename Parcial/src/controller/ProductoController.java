/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SAlA-9
 */
package controller;

import Model.Producto;
import Model.ProductoDAO;
import view.MainForm;

import java.util.List;

public class ProductoController {
    private ProductoDAO productoDAO;
    private MainForm mainForm;

    public ProductoController(ProductoDAO productoDAO, MainForm mainForm) {
        this.productoDAO = productoDAO;
        this.mainForm = mainForm;

        // Inicialmente cargamos los productos en la tabla
        mainForm.setController(this);
        verProductos();  // Cargar los productos al iniciar
    }

    // Método que actualiza la tabla con los productos actuales
    public void verProductos() {
        List<Producto> productos = productoDAO.listarProductos();
        mainForm.actualizarTabla(productos);  // Actualiza la tabla en la vista
    }

    public void agregarProducto(Producto producto) {
        productoDAO.agregarProducto(producto);  // Añade el producto a la lista a través del DAO
        verProductos(); 
    }

    public void actualizarProducto(Producto producto) {
        productoDAO.actualizarProducto(producto);
        verProductos();  // Actualiza la tabla inmediatamente
    }

    public void eliminarProducto(int id) {
        productoDAO.eliminarProducto(id);
        verProductos();  // Actualiza la tabla inmediatamente
    }
}