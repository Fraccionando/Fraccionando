package com.porfirio.fraccionando.test;

import com.porfirio.fraccionando.dominio.utils.Constantes;
import com.porfirio.fraccionando.main.Configuracion;

/**
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class TestConfiguracion {

    public static void main(String[] args) {
        Configuracion.inicializar();
        System.out.println(Configuracion.getString("hola_mundo"));
        Configuracion.setIdioma(Constantes.iIngles);
        System.out.println(Configuracion.getString("hola_mundo"));
        Configuracion.setIdioma(Constantes.iEspanol);
        System.out.println(Configuracion.getString("hola_mundo"));
        Configuracion.setIdioma(Constantes.iIngles);
        System.out.println(Configuracion.getString("hola_mundo"));
        Configuracion.setIdioma(Constantes.iEspanol);
        System.out.println(Configuracion.getString("hola_mundo"));
    }

}
