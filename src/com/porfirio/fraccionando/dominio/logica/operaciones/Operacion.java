package com.porfirio.fraccionando.dominio.logica.operaciones;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;
import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Esta clase es la base para toda la jerarquia de herencia de las operaciones
 * basicas que se pueden hacer con la aplicacion (suma, resta, multiplicacion y
 * division).
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class Operacion {

    private boolean detallada;

    /**
     * Contiene los operandos de la operacion.
     */
    protected ArrayList<Fraccion> fracciones;
    /**
     * Contiene los operadores de la operacion.
     */
    protected ArrayList<Character> operadores;
    /**
     * Es el resultado de la operacion.
     */
    protected Fraccion resultado;

    /**
     * Constructor que recibe tres parametros.
     *
     * @param fracciones Contiene los operandos de la operacion.
     * @param operadores Contiene los operadores de la operacion.
     */
    public Operacion(ArrayList<Fraccion> fracciones,
            ArrayList<Character> operadores, boolean detallada) {
        this.fracciones = fracciones;
        this.operadores = operadores;
        this.detallada = detallada;
    }

    /**
     * Constructor que recibe dos parametros.
     *
     * @param fracciones Contiene los operandos de la operacion.
     * @param operadores Contiene los operadores de la operacion.
     */
    public Operacion(ArrayList<Fraccion> fracciones,
            ArrayList<Character> operadores) {
        this.fracciones = fracciones;
        this.operadores = operadores;
    }

    @Override
    public String toString() {
        String operacion = "";

        if (fracciones.size() > 0) {
            operacion = fracciones.get(0).toString();

            for (int i = 0; i < operadores.size(); i++) {
                operacion += " " + operadores.get(i) + " "
                        + fracciones.get(i + 1);
            }
        }

        return operacion;
    }

    /**
     * Devuelve el codigo latex correspondiente a la operacion.
     *
     * @return
     */
    public String toLatex() {
        String latex = "";

        if (fracciones.size() > 0) {
            latex = fracciones.get(0).toLatexFormulacion();

            for (int i = 0; i < operadores.size(); i++) {
                latex += " " + operadores.get(i) + " " + fracciones.get(i + 1)
                        .toLatex();
            }
        }

        return latex;
    }

    /**
     * Devuelve el codigo latex correspondiente a la operacion cuando se esta
     * formando a partir de la entrada del usuario.
     *
     * @return
     */
    public String toLatexFormulacion() {
        String latex = "";

        if (fracciones.size() > 0) {
            latex = fracciones.get(0).toLatexFormulacion();

            for (int i = 0; i < operadores.size(); i++) {
                latex += " " + operadores.get(i) + " " + fracciones.get(i + 1)
                        .toLatexFormulacion();
            }
        }

        return latex;
    }

    /**
     * Determina si al menos una de las fracciones de la operacion es mixta.
     *
     * @return true si alguna fraccion es mixta o false si ninguna lo es.
     */
    public boolean hayUnaFraccionMixta() {
        boolean mixtas = false;

        // Recorre las fracciones para ver si alguna es mixta
        for (Fraccion f : fracciones) {
            if (f.isMixta()) {
                mixtas = true;
                break;
            }
        }

        return mixtas;
    }

    /**
     * Calcula el resultado de la operacion.
     *
     * @param operacionFinal Indica si la operacion a resolver es la operacion
     * final o forma parte de una operacion mas grande. Esto para controlar
     * cuando se simplificara el resultado y cuando no lo hara.
     * @return La fraccion que representa el resultado de la operacion.
     */
    public Fraccion calcularResultado(boolean operacionFinal) {
        Procedimiento.agregarPaso(new Paso(Configuracion.getString("OPE_INI"),
                TipoPaso.string));
        Procedimiento.agregarPaso(new Paso(toLatex(), TipoPaso.expresion));

        Suma suma = null;

        if (detallada) {
            suma = new SumaMuyDetallada(fracciones, operadores);
        } else {
            suma = new SumaPocoDetallada(fracciones, operadores);
        }

        return suma.calcularResultado(operacionFinal);
    }

    /**
     * Determina si la operacion es una suma o resta.
     *
     * @return true si es una suma o false si no lo es.
     */
    protected boolean isSuma() {
        String operadoresString = arrayUnion(operadores);
        return operadoresString.replace("+", "").replace("-", "").length() == 0;
    }

    /**
     * Determina si la operacion es una multiplicacion.
     *
     * @return true si es una multiplicacion o false si no lo es.
     */
    protected boolean isMultiplicacion() {
        String operadoresString = arrayUnion(operadores);
        return operadoresString.replace("*", "").length() == 0;
    }

    /**
     * Determina si la operacion es una division simple.
     *
     * @return true si es una division simple o false si no lo es.
     */
    protected boolean isDivisionSimple() {
        return (operadores.size() == 1) && (operadores.get(0) == '÷');
    }

    /**
     * Determina si la operacion es una division multiple.
     *
     * @return true si es una division multiple o false si no lo es.
     */
    protected boolean isDivisionMultiple() {
        String operadoresString = arrayUnion(operadores);

        return (operadores.size() > 1)
                && (operadoresString.replace("÷", "").length() == 0);
    }

    /**
     * Determina si la operacion es una multiplicacion y division.
     *
     * @return true si es una multiplicacion y division o false si no lo es.
     */
    protected boolean isMultiplicacionDivision() {
        String operadoresString = arrayUnion(operadores);

        if (operadores.size() > 1) {
            return (operadores.contains('*') && operadores.contains('÷'))
                    && (operadoresString
                    .replace("÷", "")
                    .replace("*", "")
                    .length() == 0);
        }

        return false;
    }

    /**
     * Determina si la operacion es mixta.
     *
     * @return true si es una operacion mixta o false si no lo es.
     */
    protected boolean isMixta() {
        if (operadores.size() > 1) {
            return (operadores.contains('+') || operadores.contains('-'))
                    && (operadores.contains('*') || operadores.contains('÷'));
        }

        return false;
    }

    /**
     * Concatena los elementos de una lista.
     *
     * @param list Contiene los elementos que se van a concatenar.
     * @return La cadena que resulta de la concatenacion de los elementos.
     */
    private String arrayUnion(ArrayList list) {
        String string = "";

        for (Object o : list) {
            string += o.toString();
        }

        return string;
    }

    /**
     * Devuelve las fracciones de la operacion.
     *
     * @return Una list de Fraccion.
     */
    public ArrayList<Fraccion> getFracciones() {
        return fracciones;
    }

    /**
     * Devuelve los operadores de la operacion.
     *
     * @return Una list de Character con los operadores.
     */
    public ArrayList<Character> getOperadores() {
        return operadores;
    }

    /**
     * Convierte a impropias las fracciones mixtas de la operacion.
     */
    protected void convertirMixtasAImpropias() {
    }
}
