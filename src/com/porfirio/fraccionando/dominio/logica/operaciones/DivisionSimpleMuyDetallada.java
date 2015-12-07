package com.porfirio.fraccionando.dominio.logica.operaciones;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;
import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Es una implementacion de DivisionSimple, donde las operaciones realizadas
 * generan una explicacion muy detallada del procedimiento llevado a cabo.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class DivisionSimpleMuyDetallada extends DivisionSimple {

    /**
     * Constructor que recibe dos parametros.
     *
     * @param fracciones Contiene los operandos de la operacion.
     * @param operadores Contiene los operadores de la operacion.
     */
    public DivisionSimpleMuyDetallada(ArrayList<Fraccion> fracciones,
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
        if (isDivisionSimple()) {
            convertirMixtasAImpropias();

            Procedimiento.agregarPaso(new Paso(Configuracion
                    .getString("DIV_SIM_SX"), TipoPaso.string));
            Procedimiento.agregarPaso(new Paso(latexMultiplicacionesCruzadas(),
                    TipoPaso.expresion));
            Procedimiento.agregarPaso(new Paso(Configuracion
                    .getString("OPE_RES"), TipoPaso.string));

            resultado = resultadoMultiplicacionCruzada().toFraccionDetallada();

            Procedimiento.agregarPaso(new Paso(resultado.toLatex(),
                    TipoPaso.expresion));

            if (operacionFinal) {
                ComunesOperacion.terminarOperacion(resultado);
            }

            return resultado;
        } else {
            DivisionMultiple divisionMultiple
                    = new DivisionMultipleMuyDetallada(fracciones, operadores);
            return divisionMultiple.calcularResultado(operacionFinal);
        }
    }

}
