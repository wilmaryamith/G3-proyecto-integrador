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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProductoForm extends JFrame {
    private JTextField nombreField;
    private JTextField precioField;
    private JTextField cantidadField;
    private JButton guardarButton;
    private JPanel panel;
    private Producto producto;

    public ProductoForm(Producto producto) {
        this.producto = producto;

        // Crear un nuevo panel manualmente
        panel = new JPanel(new GridLayout(4, 2));

        // Crear los campos y botones
        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Precio:"));
        precioField = new JTextField();
        panel.add(precioField);

        panel.add(new JLabel("Cantidad:"));
        cantidadField = new JTextField();
        panel.add(cantidadField);

        guardarButton = new JButton("Guardar");
        panel.add(guardarButton);

        // Establecer el contenido del panel en el JFrame
        setContentPane(panel);

        setTitle(producto == null ? "Agregar Producto" : "Editar Producto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Si estamos editando, rellenar los campos con los datos del producto
        if (producto != null) {
            nombreField.setText(producto.getNombre());
            precioField.setText(String.valueOf(producto.getPrecio()));
            cantidadField.setText(String.valueOf(producto.getCantidad()));
        }

        // Listener para guardar el producto
        guardarButton.addActionListener(this::guardarProducto);
    }

    // Método para manejar la acción de guardar el producto
    private void guardarProducto(ActionEvent e) {
        try {
            if (producto == null) {
                producto = new Producto(0, nombreField.getText(), Double.parseDouble(precioField.getText()), Integer.parseInt(cantidadField.getText()));
            } else {
                producto.setNombre(nombreField.getText());
                producto.setPrecio(Double.parseDouble(precioField.getText()));
                producto.setCantidad(Integer.parseInt(cantidadField.getText()));
            }
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa valores numéricos válidos para el precio y la cantidad", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener el producto creado o editado
    public Producto getProducto() {
        return producto;
    }
}
