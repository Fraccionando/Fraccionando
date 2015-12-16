package com.porfirio.fraccionando.gui.componentes;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

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
    
    /**
     * Cambia el tipo de fuente recursivamente a todos los elementos que se
     * encuentran dentro de un contenedor, que puede ser un JPanel, un JMenuBar
     * o un JMenu.
     *
     * @param contenedor Es el contenedor de donde se extraeran los elementos
     * para cambiar la fuente.
     */
    public static void cambiarLetraHijos(JComponent contenedor) {
        Component[] componentes;
        
        if (contenedor instanceof JMenu) {
            componentes = ((JMenu) contenedor).getMenuComponents();
        } else {
            componentes = contenedor.getComponents();
        }
        
        if (componentes.length > 0) {
            for (Component c : componentes) {
                if (c instanceof JMenuBar || c instanceof JMenu
                        || c instanceof JPanel) {
                    cambiarLetraHijos((JComponent) c);
                } else if (c instanceof JScrollPane) {
                    Component comp
                            = ((JScrollPane) c).getViewport().getComponent(0);
                    cambiarLetraHijos((JComponent) comp);
                }
                
                if (c instanceof JPanel) {
                    Border b = ((JPanel) c).getBorder();
                    
                    if (b instanceof TitledBorder) {
                        ((TitledBorder) b).setTitleFont(
                                Generador.generarFont((JComponent) c, 20));
                    }
                    
                }
                
                c.setFont(Generador.generarFont((JComponent) c, 20));
            }
        } else {
            System.err.println("NO COMPONENTES DENTRO DE: "
                    + contenedor.getClass());
        }
    }
}
