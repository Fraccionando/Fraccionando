package com.porfirio.fraccionando.dominio.procedimiento;

import java.util.ArrayList;

/**
 * Esta clase se encarga de administrar los pasos generados por las operaciones
 * del software.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class Procedimiento {

    /**
     * En esta lista se guardan los pasos del procedimiento.
     */
    private static ArrayList<Paso> pasos;

    /**
     * Constructor privado para que no se puedan hacer instancias de la clase.
     */
    private Procedimiento() {
    }

    /**
     * Reinicia el procedimento.
     */
    public static void iniciar() {
        pasos = new ArrayList<Paso>();
    }

    /**
     * Agrega un nuevo paso al procedimiento.
     *
     * @param paso Es el objeto que contiene el paso a ser agregado.
     */
    public static void agregarPaso(Paso paso) {
        // Verifica si el procedimiento se a inicializado
        if (pasos == null) {
            iniciar();
        }

        pasos.add(paso); // Agrega el paso a la lista
    }

    /**
     * Devuelve la lista de pasos.
     *
     * @return Un ArrayList con los pasos del procedimiento almacenados.
     */
    public static ArrayList<Paso> getPasos() {
        return pasos;
    }
}
