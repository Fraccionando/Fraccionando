package com.porfirio.fraccionando.dominio.logica.operaciones;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;
import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Es una implementacion de Multiplicacion, donde las operaciones realizadas
 * generan una explicacion simple del procedimiento llevado a cabo.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class MultiplicacionPocoDetallada extends Multiplicacion {

    /**
     * Constructor que recibe dos parametros.
     *
     * @param fracciones Contiene los operandos de la operacion.
     * @param operadores Contiene los operadores de la operacion.
     */
    public MultiplicacionPocoDetallada(ArrayList<Fraccion> fracciones,
            ArrayList<Character> operadores) {
        super(fracciones, operadores);
        ComunesOperacion.toFraccionSimple(fracciones);
    }

    @Override
    protected void convertirMixtasAImpropias() {
        ComunesOperacion.convertirMixtasAImpropiasSimple(this);
    }

    @Override
    public Fraccion calcularResultado(boolean operacionFinal) {
        if (isMultiplicacion()) {
            convertirMixtasAImpropias();

            Procedimiento.agregarPaso(new Paso(Configuracion
                    .getString("MUL_NX"), TipoPaso.string));
            Procedimiento.agregarPaso(new Paso(latexMultiplicacionMiembros(),
                    TipoPaso.expresion));
            Procedimiento.agregarPaso(new Paso(Configuracion
                    .getString("OPE_RES"), TipoPaso.string));

            resultado = resultadoMultiplicacion().toFraccionSimple();

            Procedimiento.agregarPaso(new Paso(resultado.toLatex(),
                    TipoPaso.expresion));

            if (operacionFinal) {
                ComunesOperacion.terminarOperacion(resultado);
            }

            return resultado;
        } else {
            DivisionSimple division
                    = new DivisionSimplePocoDetallada(fracciones, operadores);

            return division.calcularResultado(operacionFinal);
        }
    }

}