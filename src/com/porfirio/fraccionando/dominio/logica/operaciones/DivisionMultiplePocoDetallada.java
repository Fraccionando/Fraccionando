package com.porfirio.fraccionando.dominio.logica.operaciones;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;
import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Es una implementacion de DivisionMultiple, donde las operaciones realizadas
 * generan una explicacion simple del procedimiento llevado a cabo.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class DivisionMultiplePocoDetallada extends DivisionMultiple {

    /**
     * Constructor que recibe dos parametros.
     *
     * @param fracciones Contiene los operandos de la operacion.
     * @param operadores Contiene los operadores de la operacion.
     */
    public DivisionMultiplePocoDetallada(ArrayList<Fraccion> fracciones,
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
        if (isDivisionMultiple()) {
            convertirMixtasAImpropias();

            Procedimiento.agregarPaso(new Paso(Configuracion
                    .getString("DIVS_NX"), TipoPaso.string));

            separarPorPares(this);

            if (operacionFinal) {
                ComunesOperacion.terminarOperacion(resultado);
            }

            return resultado;
        } else {
            MultiplicacionDivision multiplicacionDivision
                    = new MultiplicacionDivisionPocoDetallada(fracciones,
                            operadores);
            return multiplicacionDivision.calcularResultado(operacionFinal);
        }
    }

}
