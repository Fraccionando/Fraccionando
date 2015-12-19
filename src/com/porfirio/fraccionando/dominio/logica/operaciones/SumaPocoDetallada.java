package com.porfirio.fraccionando.dominio.logica.operaciones;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;
import com.porfirio.fraccionando.dominio.logica.calculos.Calculos;
import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.dominio.utils.Constantes;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;

/**
 * Es una implementacion de Suma, donde las operaciones realizadas generan una
 * explicacion simple del procedimiento llevado a cabo.
 *
 * @author Porfirio Angel Diaz Sanchez [porfirioads@gmail.com]
 */
public class SumaPocoDetallada extends Suma {

    /**
     * Constructor que recibe dos parametros.
     *
     * @param fracciones Contiene los operandos de la operacion.
     * @param operadores Contiene los operadores de la operacion.
     */
    public SumaPocoDetallada(ArrayList<Fraccion> fracciones,
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
        if (isSuma()) {
            convertirMixtasAImpropias();

            if (!sonIgualesLosDenominadores()) {
                Procedimiento.agregarPaso(new Paso(Constantes.bundle
                        .getString("SUM_NX_DEN_DIF"), TipoPaso.string));

                long mcm = Calculos.mcmSimple(getDenominadores());
                convertirAEquivalentesMcm(mcm);

                Procedimiento.agregarPaso(new Paso(toLatex(false),
                        TipoPaso.expresion));
            }

            Procedimiento.agregarPaso(new Paso(Constantes.bundle
                    .getString("SUM_NX_DEN_IGU"), TipoPaso.string));
            Procedimiento.agregarPaso(new Paso(latexSumaNumeradores(),
                    TipoPaso.expresion));
            Procedimiento.agregarPaso(new Paso(Constantes.bundle
                    .getString("OPE_RES"), TipoPaso.string));

            resultado = calcularResultadoSumaNumeradores().toFraccionSimple();

            Procedimiento.agregarPaso(new Paso(resultado.toLatex(false),
                    TipoPaso.expresion));

            if (operacionFinal) {
                ComunesOperacion.terminarOperacion(resultado);
            }

            return resultado;
        } else {
            Multiplicacion multiplicacion
                    = new MultiplicacionPocoDetallada(fracciones, operadores);
            return multiplicacion.calcularResultado(operacionFinal);
        }
    }

}
