package com.porfirio.fraccionando.dominio.utils;

/**
 * Esta clase utilitaria proporciona metodos para el manejo de arreglos, en
 * necesidades muy especificas de la aplicacion.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class Arreglos {

    /**
     * Constructor privado para que no se puedan hacer instancias de la clase
     * con 'new'.
     */
    private Arreglos() {
    }

    /**
     * Determina el indice donde un objeto o, se encuentra en un arreglo array.
     *
     * @param array Es el arreglo donde se buscara el elemento.
     * @param o Es el elemento a buscar.
     * @return El indice del objeto en el arreglo o -1 si no se encuentra.
     */
    public static int indexOf(Object[] array, Object o) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(o)) {
                    return i;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }
}
