package com.porfirio.fraccionando.test;

import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.logica.fracciones.FraccionSimple;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Esta clase prueba los metodos de la clase abstracta Fraccion, asi como de sus
 * implementaciones FraccionSimple y FraccionDetallada.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class TestFraccion {

    public static void main(String[] args) {
        Configuracion.inicializar();
        Procedimiento.iniciar();

        Fraccion f1 = new FraccionSimple(4l);
        Fraccion f2 = new FraccionSimple(2l, 4l);
        Fraccion f3 = new FraccionSimple(1l, 2l, 4l);
        Fraccion f4 = new FraccionSimple(5l, 3l);
        Fraccion[] fraccionesSimples = {f1, f2, f3, f4};
        Fraccion[] fraccionesDetalladas = {f1.toFraccionDetallada(),
            f2.toFraccionDetallada(), f3.toFraccionDetallada(),
            f4.toFraccionDetallada()};

        System.out.println("--- REPRESENTACION DE FRACCIONES");
        printFracciones(fraccionesSimples);

//        System.out.println("\n-- FRACCIONES SIMPLES");
//        System.out.println("- SIMPLIFICAR");
//        simplicar(fraccionesSimples);
//        printPasos();
//        System.out.println("- CONVERTIR A MIXTA");
//        cam(fraccionesSimples);
//        printPasos();
        System.out.println("- CONVERTIR A IMPROPIA");
        cai(fraccionesSimples);
        printPasos();

//        System.out.println("\n-- FRACCIONES DETALLADAS");
//        System.out.println("- SIMPLIFICAR");
//        simplicar(fraccionesDetalladas);
//        printPasos();
//        System.out.println("- CONVERTIR A MIXTA");
//        cam(fraccionesDetalladas);
//        printPasos();
        System.out.println("- CONVERTIR A IMPROPIA");
        cai(fraccionesDetalladas);
        printPasos();
    }

    private static void simplicar(Fraccion... fracciones) {
        for (Fraccion f : fracciones) {
            f.simplificar();
        }
    }

    private static void cam(Fraccion... fracciones) {
        for (Fraccion f : fracciones) {
            f.convertirAMixta();
        }
    }

    private static void cai(Fraccion... fracciones) {
        for (Fraccion f : fracciones) {
            f.convertirAImpropia();
        }
    }

    private static void printFracciones(Fraccion... fracciones) {
        for (Fraccion f : fracciones) {
            System.out.println(f.toString() + " : " + f.toLatex());
        }
    }

    private static void printPasos() {
        ArrayList<Paso> pasos = Procedimiento.getPasos();

        for (Paso p : pasos) {
            System.out.println(p.getContenido().replace("\\\\", "\n").replace("\\ ", " "));
        }

        System.out.println("-----------------------------");
        Procedimiento.iniciar();
    }
}
