package com.porfirio.fraccionando.main;

import com.porfirio.fraccionando.dominio.utils.Constantes;
import java.awt.Color;
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
    private static ResourceBundle bundle;
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

//        System.out.println(properties);
//        System.out.println(locale);
        Locale.setDefault(locale);
        ResourceBundle.clearCache();
        reiniciarBundle();
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

        guardar();
    }

    /**
     * Obtiene un string del ResourceBoundle correspondiente al idioma actual.
     *
     * @param key Es la llave de la cadena que va a buscar.
     * @return El valor de la cadena buscada.
     */
    public static String getString(String key) {
        return bundle.getString(key);
    }

    /**
     * Vuelve a inicializar el ResourceBundle, para cuando se cambie de idioma,
     * los nuevos resultados aparezcan en el idioma solicitado.
     */
    private static void reiniciarBundle() {
        bundle = ResourceBundle.getBundle(
                "com.porfirio.fraccionando.resources.strings.strings");
    }
}