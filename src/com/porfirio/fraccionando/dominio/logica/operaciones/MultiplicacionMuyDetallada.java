package com.porfirio.fraccionando.dominio.logica.operaciones;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;
import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.dominio.utils.Constantes;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Es una implementacion de Multiplicacion, donde las operaciones realizadas
 * generan una explicacion muy detallada del procedimiento llevado a cabo.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class MultiplicacionMuyDetallada extends Multiplicacion {

    /**
     * Constructor que recibe dos parametros.
     *
     * @param fracciones Contiene los operandos de la operacion.
     * @param operadores Contiene los operadores de la operacion.
     */
    public MultiplicacionMuyDetallada(ArrayList<Fraccion> fracciones,
            ArrayList<Character> operadores) {
        super(fracciones, operadores);
        ComunesOperacion.toFraccionDetallada(fracciones);
    }

    @Override
    protected void convertirMixtasAImpropias() {
        ComunesOperacion.convertirMixtasAImpropiasMuyDetallado(this);
    }

    @Override
    public Fraccion calcularResultado(boolean operacionFinal) {
        if (isMultiplicacion()) {
            convertirMixtasAImpropias();

            Procedimiento.agregarPaso(new Paso(Constantes.bundle
                    .getString("MUL_SX"), TipoPaso.string));
            Procedimiento.agregarPaso(new Paso(latexMultiplicacionMiembros(),
                    TipoPaso.expresion));
            Procedimiento.agregarPaso(new Paso(Constantes.bundle
                    .getString("OPE_RES"), TipoPaso.string));

            resultado = resultadoMultiplicacion().toFraccionDetallada();

            Procedimiento.agregarPaso(new Paso(resultado.toLatex(false),
                    TipoPaso.expresion));

            if (operacionFinal) {
                ComunesOperacion.terminarOperacion(resultado);
            }

            return resultado;
        } else {
            DivisionSimple division
                    = new DivisionSimpleMuyDetallada(fracciones, operadores);

            return division.calcularResultado(operacionFinal);
        }
    }

}
