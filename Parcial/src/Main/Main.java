/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author SAlA-9
 */

import controller.ProductoController;
import Model.ProductoDAO;
import view.MainForm;

public class Main {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        MainForm mainForm = new MainForm();
        ProductoController controller = new ProductoController(productoDAO, mainForm);

        // Mostrar la ventana principal
        mainForm.setVisible(true);
    }
}
