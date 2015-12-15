package com.porfirio.fraccionando.controladores;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.gui.componentes.Generador;
import com.porfirio.fraccionando.latex.LatexRender;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Esta clase sirve para colocar el resultado y pasos de la explicacion,
 * generados por una operacion de la aplicacion, es generico para todas las
 * operaciones, tanto basicas, como comparaciones y conversiones.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class ControladorResultadoOperacion {

    /**
     * Es el panel donde se colocaran los pasos del procedimiento.
     */
    private JPanel panelPasos;
    /**
     * Es el panel donde se colocara el resultado de la operacion.
     */
    private JPanel panelResultado;

    /**
     * Constructor que recibe dos parametros.
     *
     * @param panelPasos Es el panel donde se colocaran los pasos del
     * procedimiento.
     * @param panelResultado Es el panel donde se colocara el resultado de la
     * operacion.
     */
    public ControladorResultadoOperacion(JPanel panelPasos,
            JPanel panelResultado) {
        this.panelPasos = panelPasos;
        this.panelResultado = panelResultado;
    }

    /**
     * Coloca el resultado y los pasos de la solucion en los paneles
     * correspondientes.
     */
    public void colocarResultadoPasos() {
        ArrayList<Paso> pasos = Procedimiento.getPasos();
        Paso resultado = Procedimiento.getResultado();

        if (resultado != null) {
            panelResultado.removeAll();

            if (resultado.getTipo() == TipoPaso.string) {
                panelResultado.add(new JLabel(resultado.getContenido()));
            } else if (resultado.getTipo() == TipoPaso.expresion) {
                panelResultado.add(crearLabelConImagen(
                        "resultado", resultado.getContenido()));
            }

            panelResultado.updateUI();
        } else {
            JOptionPane.showMessageDialog(null, "Resultado nulo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        if (pasos != null) {
            panelPasos.removeAll();

            if (pasos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hay 0 pasos",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                for (Paso paso : pasos) {
                    if (paso.getTipo() == TipoPaso.string) {
                        panelPasos.add(crearLabelConRenglones(
                                paso.getContenido()));
                    } else if (paso.getTipo() == TipoPaso.expresion) {
                        panelPasos.add(crearLabelConImagen("Paso",
                                paso.getContenido()));
                    }
                }

                panelPasos.updateUI();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pasos nulo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Crea y devuelve una instancia de JLabel, la cual tendra la imagen de una
     * formula latex.
     *
     * @param basename Es el nombre base para la imagen que se generara a partir
     * del codigo latex.
     * @param latex Es el codigo latex de la imagen que se colocara en la label.
     * @return La JLabel creada.
     */
    private JLabel crearLabelConImagen(String basename, String latex) {
        String nombreArchivo = LatexRender.render(basename, latex, false);
        ImageIcon image = new ImageIcon(nombreArchivo, nombreArchivo);
        JLabel label = new JLabel(image);
        return label;
    }

    /**
     * Crea y devuelve una instancia de JLabel, especificamente para los pasos
     * del procedimiento, donde el texto contendra los renglones
     * correspondientes, segun el ancho del panel.
     *
     * @param texto Es el texto que se colocara en la label.
     * @return La label creada.
     */
    private JLabel crearLabelConRenglones(String texto) {
        StringBuilder nuevoTexto = new StringBuilder("<html><br>");
        int anchoPanel = (int) panelPasos.getSize().getWidth();
        String[] palabras = texto.split(" ");

        String renglon = "";

        for (String palabra : palabras) {
            if (medirString(renglon + palabra) > anchoPanel) {
                nuevoTexto.append(renglon).append("<br>");
                renglon = palabra;
            } else {
                renglon += " " + palabra;
            }
        }

        nuevoTexto.append(renglon + "<br><br></html>");

        JLabel label = new JLabel(nuevoTexto.toString());
        label.setFont(Generador.generarFont(label, 20));

        return label;
    }

    /**
     * Devuelve el ancho de una JLabel que contiene el texto indicado, con una
     * fuente y tamano determinados.
     *
     * @param texto Es el texto que se va a medir.
     * @return El ancho del texto.
     */
    private int medirString(String texto) {
        texto = "<html>" + texto + "</html>";
        JLabel label = new JLabel(texto);
        label.setFont(Generador.generarFont(label, 20));
        int ancho = (int) label.getPreferredSize().getWidth() + 40;
        return ancho;
    }

}
