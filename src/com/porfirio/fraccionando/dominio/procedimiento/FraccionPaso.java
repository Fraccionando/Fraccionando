package com.porfirio.fraccionando.dominio.procedimiento;

/**
 * Esta es una clase auxiliar para la representacion de un paso que involucre
 * una serie de operaciones en una fraccion, por lo que sus partes estan
 * representadas como cadenas, en lugar de numeros.
 *
 * @author Porfirio Angel Diaz Sanchez [porfirioads@gmail.com]
 */
public class FraccionPaso {

    /**
     * Es la parte entera de la fraccion en el procedimiento.
     */
    private String entero;
    /**
     * Es el numerador de la fraccion en el procedimiento.
     */
    private String numerador;
    /**
     * Es el denominador de la fraccion en el procedimiento.
     */
    private String denominador;

    /**
     * Constructor que recibe tres parametros
     *
     * @param entero Es la parte entera de la fraccion en el procedimiento.
     * @param numerador Es el numerador de la fraccion en el procedimiento.
     * @param denominador Es el denominador de la fraccion en el procedimiento.
     */
    public FraccionPaso(String entero, String numerador, String denominador) {
        if (entero.equals("0")) {
            this.entero = "";
        } else {
            this.entero = entero;
        }

        this.numerador = numerador;
        this.denominador = denominador;
    }

    /**
     * Constructor que recibe dos parametros.
     *
     * @param numerador Es el numerador de la fraccion en el procedimiento.
     * @param denominador Es el denominador de la fraccion en el procedimiento.
     */
    public FraccionPaso(String numerador, String denominador) {
        this("", numerador, denominador);
    }

    public String toLatex() {
        String latex = "";

        // Evalua si la fraccion solo posee la parte entera
        if (!numerador.equals("")) {
            latex = entero + "";
        }
        // Evalua si la fraccion es mixta
        if (!entero.equals("")) {
            latex = String.format("%s\\frac{%s}{%s}", entero, numerador,
                    denominador);
        } // Solo queda que sea propia o impropia, las cuales se representan igual
        else {
            latex = String.format("\\frac{%s}{%s}", numerador, denominador);
        }

        return latex;
    }

    @Override
    public String toString() {
        return toLatex();
    }

}
