package com.porfirio.fraccionando.test;

import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.logica.fracciones.FraccionSimple;
import com.porfirio.fraccionando.dominio.logica.operaciones.Operacion;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Esta clase prueba los metodos de la Clase Operacion, asi como de toda su
 * jerarquia de herencia e implementaciones.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class TestOperacion {

    public static void main(String[] args) {
        Fraccion f1 = new FraccionSimple(4l);
        Fraccion f2 = new FraccionSimple(2l, 4l);
        Fraccion f3 = new FraccionSimple(1l, 2l, 4l);
        Fraccion f4 = new FraccionSimple(5l, 3l);

        Fraccion[] fs1 = {
            f1.toFraccionSimple(),
            f2.toFraccionSimple(),
            f3.toFraccionSimple(),
            f4.toFraccionSimple()
        };

        Fraccion[] fd1 = {
            f1.toFraccionDetallada(),
            f2.toFraccionDetallada(),
            f3.toFraccionDetallada(),
            f4.toFraccionDetallada()
        };

        Fraccion[] fs2 = {
            f2.toFraccionSimple(),
            f3.toFraccionSimple()
        };

        Fraccion[] fd2 = {
            f2.toFraccionDetallada(),
            f3.toFraccionDetallada()
        };

        Character[] operadoresSuma = {'+', '-', '+'};
        Character[] operadoresMultiplicacion = {'*', '*', '*'};
        Character[] operadoresDivisionSimple = {'÷'};
        Character[] operadoresDivisionMultiple = {'÷', '÷', '÷'};
        Character[] operadoresMultiplicacionDivision = {'÷', '*', '÷'};
        Character[] operadoresMixta = {'÷', '+', '*'};

        Configuracion.inicializar();
        Procedimiento.iniciar();

        // Prueba con operacion de suma
        System.out.println("[[[[[---------- SUMA ----------]]]]]");
        mandarResolverOperacion(fd1, fs1, operadoresSuma);
        System.out.println("[[[[[---------- MULTIPLICACION ----------]]]]]");
        mandarResolverOperacion(fd1, fs1, operadoresMultiplicacion);
        System.out.println("[[[[[---------- DIVISION SIMPLE ----------]]]]]");
        mandarResolverOperacion(fd2, fs2, operadoresDivisionSimple);
        System.out.println("[[[[[---------- DIVISION MULTIPLE ----------]]]]]");
        mandarResolverOperacion(fd1, fs1, operadoresDivisionMultiple);
        System.out.println("[[[[[---------- MULTIPLICACION Y DIVISION ----------]]]]]");
        mandarResolverOperacion(fd1, fs1, operadoresMultiplicacionDivision);
        System.out.println("[[[[[---------- MIXTA ----------]]]]]");
        mandarResolverOperacion(fd1, fs1, operadoresMixta);
    }

    private static void mandarResolverOperacion(Fraccion[] fraccionesD,
            Fraccion[] fraccionesS, Character[] operadores) {
        Operacion operacion;

        operacion = new Operacion(
                arrayToList(fraccionesD),
                arrayToList(operadores),
                true
        );

        operacion.calcularResultado(true);
        printPasos();

        operacion = new Operacion(
                arrayToList(fraccionesS),
                arrayToList(operadores),
                false
        );

        operacion.calcularResultado(true);
        printPasos();
    }

    private static void printPasos() {
        System.out.println("-----------------------------");

        ArrayList<Paso> pasos = Procedimiento.getPasos();

        for (Paso p : pasos) {
            System.out.println(p.getContenido().replace("\\\\", "\n").replace("\\ ", " "));
        }

        System.out.println("-----------------------------");

        Procedimiento.iniciar();
    }

    private static ArrayList<Fraccion> arrayToList(Fraccion[] fracciones) {
        ArrayList<Fraccion> fraccionesList = new ArrayList<>();

        for (Fraccion f : fracciones) {
            fraccionesList.add(f);
        }

        return fraccionesList;
    }

    private static ArrayList<Character> arrayToList(Character[] operadores) {
        ArrayList<Character> operadoresList = new ArrayList<>();

        for (Character c : operadores) {
            operadoresList.add(c);
        }

        return operadoresList;
    }
}
