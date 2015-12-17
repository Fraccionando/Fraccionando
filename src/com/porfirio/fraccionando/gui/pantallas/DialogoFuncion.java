package com.porfirio.fraccionando.gui.pantallas;

import javax.swing.JDialog;

/**
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public interface DialogoFuncion {

    /**
     * Obtiene la respuesta que desprende al dialogo segun la forma de cerrarse,
     * siendo DIALOG_ACEPTAR para una entrada exitosa, o DIALOG_CANCELAR para
     * cuando se cierra el dialogo sin concluir la entrada.
     *
     * @return Un valor de la clase Constantes, que determina la respuesta.
     */
    public int getRespuesta();

}
