package com.porfirio.fraccionando.gui.componentes;

import java.awt.Font;
import javax.swing.JComponent;

/**
 * Esta clase utilitaria provee metodos para generar algunos objetos utiles para
 * la gui de la aplicacion.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class Generador {

    /**
     * Constructor privado para que no se puedan hacer instancias de la clase
     * con 'new'.
     */
    private Generador() {
    }

    /**
     * Genera una fuente a partir de un JComponent, con el tamano de letra
     * indicado.
     *
     * @param componente Es el componente del cual se obtendra su fuente por
     * default.
     * @param size Es el tamano deseado para la fuente.
     * @return La fuente con las caracteristicas deseadas.
     */
    public static Font generarFont(JComponent componente, int size) {
        String name = componente.getFont().getFontName();
        int style = componente.getFont().getStyle();
        return new Font(name, style, size);
    }
}
