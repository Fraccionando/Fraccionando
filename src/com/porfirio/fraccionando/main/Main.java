package com.porfirio.fraccionando.main;

import com.porfirio.fraccionando.gui.pantallas.DialogoCarga;
import com.porfirio.fraccionando.gui.pantallas.PantallaPrincipal;
import com.porfirio.fraccionando.test.TestCalculo;
import com.porfirio.fraccionando.test.TestConfiguracion;
import com.porfirio.fraccionando.test.TestFraccion;
import com.porfirio.fraccionando.test.TestFraccionPanel;
import com.porfirio.fraccionando.test.TestOperacion;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Esta es la clase principal del programa, por medio de la cual se inicia ya
 * sea la aplicacion o las pruebas.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String texto = e.toString();
                JOptionPane.showMessageDialog(null, texto, "ERROR",
                        JOptionPane.ERROR_MESSAGE);

                System.out.println();
                e.printStackTrace();
            }
        });

//        TestCalculo.main(args);
//        TestConfiguracion.main(args);
//        TestFraccion.main(args);
//        TestOperacion.main(args);
//        TestFraccionPanel.main(args);
//        PantallaPrincipal.main(args);
        DialogoCarga.main(args);
    }
}
