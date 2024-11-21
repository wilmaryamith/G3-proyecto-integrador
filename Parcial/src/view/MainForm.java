/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author SAlA-9
 */

import Model.Producto;
import controller.ProductoController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private JTable tablaProductos;
    private JButton agregarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JPanel panel;
    private ProductoController controller;

    public MainForm() {
        // Inicializamos el panel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Inicializamos los componentes
        tablaProductos = new JTable();
        agregarButton = new JButton("Agregar");
        editarButton = new JButton("Editar");
        eliminarButton = new JButton("Eliminar");
        actualizarButton = new JButton("Actualizar");

        // Añadimos los componentes al panel
        panel.add(new JScrollPane(tablaProductos));
        panel.add(agregarButton);
        panel.add(editarButton);
        panel.add(eliminarButton);
        panel.add(actualizarButton);

        // Establecemos el panel como contentPane del JFrame
        setContentPane(panel);

        setTitle("Farmacia CRUD");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Listeners de los botones
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoForm form = new ProductoForm(null);  // Abre el formulario para agregar un producto
                form.setVisible(true);
                Producto nuevoProducto = form.getProducto();
                if (nuevoProducto != null) {
                    controller.agregarProducto(nuevoProducto);  // Llama al método para agregar el producto
                }
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tablaProductos.getSelectedRow();
                if (fila >= 0) {
                    int id = (int) tablaProductos.getValueAt(fila, 0);
                    String nombre = (String) tablaProductos.getValueAt(fila, 1);
                    double precio = (double) tablaProductos.getValueAt(fila, 2);
                    int cantidad = (int) tablaProductos.getValueAt(fila, 3);

                    Producto producto = new Producto(id, nombre, precio, cantidad);
                    ProductoForm form = new ProductoForm(producto);
                    form.setVisible(true);
                    Producto productoEditado = form.getProducto();
                    if (productoEditado != null) {
                        controller.actualizarProducto(productoEditado);  // Actualiza la tabla después de editar
                    }
                } else {
                    JOptionPane.showMessageDialog(MainForm.this, "Seleccione un producto para editar");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tablaProductos.getSelectedRow();
                if (fila >= 0) {
                    int id = (int) tablaProductos.getValueAt(fila, 0);
                    controller.eliminarProducto(id);  // Actualiza la tabla después de eliminar
                } else {
                    JOptionPane.showMessageDialog(MainForm.this, "Seleccione un producto para eliminar");
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.verProductos();  // Actualiza manualmente los datos en la tabla
            }
        });
    }

    public void setController(ProductoController controller) {
        this.controller = controller;
    }

    // Método para actualizar la tabla con los productos actuales
    public void actualizarTabla(List<Producto> productos) {
        String[] columnas = {"ID", "Nombre", "Precio", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Producto p : productos) {
            Object[] fila = {p.getId(), p.getNombre(), p.getPrecio(), p.getCantidad()};
            modelo.addRow(fila);
        }

        tablaProductos.setModel(modelo);  // Actualiza el modelo de la tabla
    }
}

