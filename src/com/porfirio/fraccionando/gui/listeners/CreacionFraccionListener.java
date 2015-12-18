package com.porfirio.fraccionando.gui.listeners;

/**
 * Esta interface es un listener para los eventos personalizados, que pueden
 * ocurrir al formar fracciones.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public interface CreacionFraccionListener {

    /**
     * Se dispara cuando una fraccion ha sido actualizada.
     */
    public void onFraccionUpdated();

    /**
     * Se dispara cuando en una operacion, la ultima fraccion se elimina de
     * ella.
     */
    public void onFraccionRemoved();

    /**
     * Se dispara cuando la fraccion se reinicia.
     */
    public void onFraccionReseted();
}
