package com.porfirio.fraccionando.latex;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

/**
 * Esta clase utilitaria sirve para renderizar codigos latex, y guardar el
 * resultado como imagenes, para su posterior utilizacion en la aplicacion.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class LatexRender {

    /**
     * Constructor privado para que no se puedan hacer instancias de la clase
     * con 'new'.
     */
    private LatexRender() {
    }

    /**
     * Es el numero de imagen actual.
     */
    private static int numImagen = 1;

    /**
     * Renderiza un codigo latex, creando un archivo con la imagen generada.
     *
     * @param basename Es el nombre base para el archivo generado.
     * @param latex Es el codigo latex que se va a renderizar.
     * @param test Determina si la formula renderizada es para una prueba.
     * @return La ruta donde se encuentra el archivo generado.
     */
    public static String render(String basename, String latex, boolean test) {
        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 30);
        icon.setInsets(new Insets(5, 5, 5, 5));
        BufferedImage imagen = new BufferedImage(icon.getIconWidth(),
                icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imagen.createGraphics();
        g2.setColor(new Color(0, 0, 0, 0)); // Fondo transparente
        g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
        JLabel jl = new JLabel();
        jl.setForeground(new Color(0, 0, 0));
        icon.paintIcon(jl, g2, 0, 0);

        File carpeta = new File("tmp"); // Aqui se almacenan las imagenes

        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        File imagenArchivo = new File(String
                .format("%s%s%s_%d%s", carpeta.getPath(), File.separator,
                        basename, numImagen, ".png"));

        try {
            ImageIO.write(imagen, "png", imagenArchivo.getAbsoluteFile());

            if (!test) {
                numImagen++;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return imagenArchivo.getAbsolutePath();
    }
}
