package com.porfirio.fraccionando.dominio.logica.fracciones;

/**
 * Esta clase es una implementacion de la clase abstracta Fraccion, donde las
 * operaciones realizadas no generan ningun tipo de explicacion.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class FraccionSimple extends Fraccion {

    /**
     * Constructor que recibe tres parametros.
     *
     * @param entero Es la parte entera de la fraccion.
     * @param numerador Es el numerador de la fraccion.
     * @param denominador Es el valor decimal de la fraccion.
     */
    public FraccionSimple(Long entero, Long numerador, Long denominador) {
        super(entero, numerador, denominador);
    }

    /**
     * Constructor que recibe dos parametros.
     *
     * @param numerador Es el numerador de la fraccion.
     * @param denominador Es el valor decimal de la fraccion.
     */
    public FraccionSimple(Long numerador, Long denominador) {
        this(0l, numerador, denominador);
    }

    /**
     * Constructor que recibe un parametro.
     *
     * @param entero Es la parte entera de la fraccion.
     */
    public FraccionSimple(Long entero) {
        this(entero, 0l, 0l);
    }

    /**
     * Constructor que no recibe parametros.
     */
    public FraccionSimple() {
        this(0l, 0l, 0l);
    }

    @Override
    public void simplificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean convertirAMixta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean convertirAImpropia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
