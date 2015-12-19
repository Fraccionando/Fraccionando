package com.porfirio.fraccionando.dominio.logica.operaciones;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;
import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.dominio.utils.Constantes;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Es una implementacion de MultiplicacionDivision, donde las operaciones
 * realizadas generan una explicacion simple del procedimiento llevado a cabo.
 *
 * @author Porfirio Angel Diaz Sanchez [porfirioads@gmail.com]
 */
public class MultiplicacionDivisionPocoDetallada
        extends MultiplicacionDivision {

    /**
     * Constructor que recibe dos parametros.
     *
     * @param fracciones Contiene los operandos de la operacion.
     * @param operadores Contiene los operadores de la operacion.
     */
    public MultiplicacionDivisionPocoDetallada(ArrayList<Fraccion> fracciones,
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
        if (isMultiplicacionDivision()) {
            convertirMixtasAImpropias();

            Procedimiento.agregarPaso(new Paso(Constantes.bundle
                    .getString("MUL_DIV_NX_GRUP"), TipoPaso.string));
            Procedimiento.agregarPaso(new Paso(latexAgruparMultiplicaciones(),
                    TipoPaso.expresion));

            resultado = resultadoMultiplicacionesDivisiones(this);

            if (operacionFinal) {
                ComunesOperacion.terminarOperacion(resultado);
            }

            return resultado;
        } else {
            Mixta mixta = new MixtaPocoDetallada(fracciones, operadores);
            return mixta.calcularResultado(operacionFinal);
        }
    }

}
