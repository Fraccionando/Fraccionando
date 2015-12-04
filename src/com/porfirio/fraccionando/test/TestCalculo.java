package com.porfirio.fraccionando.test;

import com.porfirio.fraccionando.dominio.logica.calculos.Calculos;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Esta clase prueba los calculos del mcm y mcd.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class TestCalculo {

    public static void main(String[] args) {
        Configuracion.inicializar();

        long[] datosMcm = {2, 3, 4, 5, 6};
        long[] datosMcd = {1000, 100};
        long mcm;
        long mcd;

        mcm = Calculos.mcmSimple(datosMcm);
        System.out.println("MCM simple");
        System.out.println(mcm);

        mcm = Calculos.mcmDetallado(datosMcm);
        System.out.println("MCM detallado");
        System.out.println(mcm);
        printPasos();

        mcd = Calculos.mcdSimple(datosMcd);
        System.out.println("MCD simple");
        System.out.println(mcd);

        mcd = Calculos.mcdDetallado(datosMcd);
        System.out.println("MCD detallado");
        System.out.println(mcd);
        printPasos();
    }

    private static void printPasos() {
        ArrayList<Paso> pasos = Procedimiento.getPasos();

        for (Paso p : pasos) {
            System.out.println(p.getContenido().replace("\\\\", "\n").replace("\\ ", " "));
        }

        Procedimiento.iniciar();
    }
}
