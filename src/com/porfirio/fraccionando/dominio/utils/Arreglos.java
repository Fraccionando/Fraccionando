package com.porfirio.fraccionando.dominio.utils;

/**
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class Arreglos {

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
