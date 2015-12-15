package com.porfirio.fraccionando.exportacion;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Esta clase representa un documento pdf que va a ser formado y exportado.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class Pdf {

    /**
     * Es la instancia de Document, que es la que crea el documento.
     */
    private Document document;

    /**
     * Constructor que recibe un parametro.
     *
     * @param nombreArchivo Es el nombre del archivo a exportar.
     */
    public Pdf(String nombreArchivo) {
        document = new Document(PageSize.LETTER);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }

        float margen = crearMargen(2.5f);

        document.setMargins(margen, margen, margen, margen);

        document.open();
    }

    /**
     * Devuelve la conversion a puntos para obtener una medida dada en
     * centimetros.
     *
     * @param medidaEnCm Es la medida deseada en centimetros.
     * @return La medida equivalente en puntos.
     */
    private float crearMargen(float medidaEnCm) {
        float margenEnIn = 0.3937f * medidaEnCm;
        float margenEnPt = 72 * margenEnIn;
        return margenEnPt;
    }

    /**
     * Establece el encabezado del documento.
     *
     * @param titulo Es el titulo que se va a colocar como encabezado.
     */
    public void setEncabezado(String titulo) {
        Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 25, Font.BOLD);

        Paragraph encabezado = new Paragraph(titulo, fontTitulo);
        encabezado.setSpacingAfter(20);
        encabezado.setAlignment(Element.ALIGN_CENTER);

        try {
            document.add(encabezado);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Agrega el contenido al pdf.
     *
     * @param elementos Es un arreglo de componentes (JLabel) de los cuales se
     * extrae el contenido.
     */
    public void addContenido(Component[] elementos) {
        for (Component component : elementos) {
            try {
                JLabel label = (JLabel) component;

                if (label.getIcon() == null) {
                    document.add(new Paragraph(label.getText()
                            .replace("<html>", "").replace("</html>", "")
                            .replace("<br>", "")));
                } else {
                    Image image = Image.getInstance(
                            ((ImageIcon) label.getIcon()).getDescription());
                    image.setAlignment(Image.ALIGN_LEFT);
                    image.scalePercent(50);
                    document.add(image);
                }

            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Guarda el documento.
     */
    public void guardar() {
        document.close();
    }
}
