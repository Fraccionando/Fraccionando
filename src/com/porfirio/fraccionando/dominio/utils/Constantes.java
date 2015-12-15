package com.porfirio.fraccionando.dominio.utils;

import java.util.Locale;

/**
 * Esta es una clase utilitaria que solo contiene atributos, los cuales son
 * constantes que son accedidas desde varias ubicaciones.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class Constantes {

    /**
     * Constructor privado para que no se puedan hacer instancias de la clase
     * con 'new'.
     */
    private Constantes() {
    }

    public static final Locale locale_en = new Locale("en", "US");
    public static final Locale locale_es = new Locale("es", "MX");
    public static final String cIdioma = "IDIOMA";
    public static final String cExplicacion = "EXPLICACION";
    public static final String cTema = "TEMA";
    public static final String iEspanol = "ESPANOL";
    public static final String iIngles = "INGLES";
    public static final String eMuyDetallado = "MUY_DETALLADO";
    public static final String ePocoDetallado = "POCO_DETALLADO";
    public static final String eSimple = "SIMPLE";
    public static final String tAzul = "AZUL";
    public static final String tAmarillo = "AMARILLO";
    public static final String tRosa = "ROSA";
    public static final String tRojo = "ROJO";
    public static final String tMorado = "MORADO";
    public static final String saltoLatex = "\\\\";
    public static final String espacioLatex = "\\ ";
    public static final String saltoHtml = "<br>";
    public static final String espacioHtml = " ";
    public static final String parteFraccionEntero = "ENTERO";
    public static final String parteFraccionNumerador = "NUMERADOR";
    public static final String parteFraccionDenominador = "DENOMINADOR";
}
