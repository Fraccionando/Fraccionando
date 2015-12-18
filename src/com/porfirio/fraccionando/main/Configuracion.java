package com.porfirio.fraccionando.main;

import com.porfirio.fraccionando.dominio.enumerados.ColorTema;
import com.porfirio.fraccionando.dominio.utils.Constantes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Esta clase se encarga de cargar y guardar los aspectos de configuracion de
 * Fraccionando tales como idioma, tema visual y nivel de explicacion.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class Configuracion {

    private static final String archivo = "Preferencias.properties";
    private static Properties properties;
//    private static ResourceBundle bundle;
    public static Locale locale;
    public static Color colorClaro;
    public static Color colorOscuro;
    public static String salto = Constantes.saltoLatex;
    public static String espacio = Constantes.espacioLatex;

    /**
     * Constructor privado para que no se puedan hacer instancias de la clase
     * con 'new'.
     */
    private Configuracion() {
    }

    /**
     * Inicializa las propiedades de configuracion y las deja listas para su
     * uso.
     */
    public static void inicializar() {
        preparaDirectorios();
        properties = leerPropiedades();
        setIdioma(properties.getProperty(Constantes.cIdioma));
        setNivelExplicacion(properties.getProperty(Constantes.cExplicacion));
        setTema(properties.getProperty(Constantes.cTema));
    }

    /**
     * Lee el archivo de propiedades.
     */
    private static Properties leerPropiedades() {
        Properties p = new Properties();

        InputStream entrada = null;

        try {
            entrada = new FileInputStream(archivo);
            p.load(entrada);
            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return p;
    }

    /**
     * Guarda las configuraciones en el archivo de propiedades.
     */
    public static void guardar() {
        OutputStream salida = null;

        try {
            salida = new FileOutputStream(archivo);
            properties.store(salida, null);
            salida.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * Establece el idioma (locale) de la aplicacion.
     *
     * @param idioma Es el idioma que se va a establecer.
     */
    public static void setIdioma(String idioma) {
        if (idioma == null) {
            idioma = Constantes.iEspanol;
        }

        properties.setProperty(Constantes.cIdioma, idioma);

        switch (idioma) {
            case Constantes.iEspanol:
                locale = Constantes.locale_es;
                break;
            case Constantes.iIngles:
                locale = Constantes.locale_en;
                break;
            default:
                locale = Constantes.locale_es;
        }

        Locale.setDefault(locale);

        guardar();
    }

    /**
     * Establece el nivel de explicacion para las operaciones de la aplicacion.
     *
     * @param explicacion Es el nivel de explicacion que se va a establecer.
     */
    public static void setNivelExplicacion(String explicacion) {
        if (explicacion == null) {
            explicacion = Constantes.eMuyDetallado;
        }

        properties.setProperty(Constantes.cExplicacion, explicacion);

        guardar();
    }

    /**
     * Establece el tema visual de la aplicacion.
     *
     * @param tema Es el tema visual que se va a establecer.
     */
    public static void setTema(String tema) {
        if (tema == null) {
            tema = Constantes.tAzul;
        }

        properties.setProperty(Constantes.cTema, tema);

        ColorTema temaElegido = ColorTema.valueOf(tema);
        colorClaro = temaElegido.getClaro();
        colorOscuro = temaElegido.getOscuro();

        guardar();
    }

    public static Dimension porcentajePantalla(int porcentaje) {
        Dimension resolucionPantalla = Toolkit.getDefaultToolkit()
                .getScreenSize();
        Dimension resolucionPorcentaje = null;

        int ancho = (resolucionPantalla.width * porcentaje) / 100;
        int alto = (resolucionPantalla.height * porcentaje) / 100;

        resolucionPorcentaje = new Dimension(ancho, alto);

        return resolucionPorcentaje;
    }

    /**
     * Devuelve el valor de una property guardada.
     *
     * @param key Es el identificador de la property a buscar.
     * @return El valor de la property.
     */
    public static String getPropertyValue(String key) {
        return properties.getProperty(key);
    }

    /**
     * Prepara los directorios y archivos necesarios para la aplicacion.
     */
    private static void preparaDirectorios() {
        File carpetaTemporal = new File("tmp");
        File archivoPreferencias = new File("Preferencias.properties");

        if (carpetaTemporal.exists()) {
            if (carpetaTemporal.isFile()) {
                carpetaTemporal.delete();
                carpetaTemporal.mkdir();
            } else {
                File[] archivos = carpetaTemporal.listFiles();

                if (archivos != null) {
                    for (int i = 0; i < archivos.length; i++) {
                        archivos[i].delete();
                    }
                }
            }
        } else {
            carpetaTemporal.mkdir();
        }

        if (archivoPreferencias.exists()) {
            if (archivoPreferencias.isDirectory()) {
                archivoPreferencias.delete();

                try {
                    archivoPreferencias.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            try {
                archivoPreferencias.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
