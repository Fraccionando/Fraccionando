package com.porfirio.fraccionando.dominio.procedimiento;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;

/**
 * Esta clase representa un paso del procedimiento generado.
 *
 * @author Porfirio Angel Diaz Sanchez [porfirioads@gmail.com]
 */
public class Paso {

    /**
     * Es el contenido del paso.
     */
    private String contenido;
    /**
     * Es el tipo de paso que se esta representando.
     */
    private TipoPaso tipo;

    /**
     * Constructor que recibe dos parametros.
     *
     * @param contenido Es el contenido del paso.
     * @param tipo Es el tipo de paso que se esta representando.
     */
    public Paso(String contenido, TipoPaso tipo) {
        this.contenido = contenido;
        this.tipo = tipo;
    }

    /**
     * Devuelve el contenido del paso.
     *
     * @return El valor del contenido.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Devuelve el tipo de paso.
     *
     * @return Valor del enumerado TipoPaso.
     */
    public TipoPaso getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo + ": " + contenido;
    }

}
