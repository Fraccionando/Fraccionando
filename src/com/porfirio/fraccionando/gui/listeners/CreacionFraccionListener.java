package com.porfirio.fraccionando.gui.listeners;

/**
 * Esta interface es un listener para los eventos personalizados, que pueden
 * ocurrir al formar fracciones.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public interface CreacionFraccionListener {

    public void onFraccionUpdated();

    public void onFraccionRemoved();

    public void onFraccionReseted();
}
