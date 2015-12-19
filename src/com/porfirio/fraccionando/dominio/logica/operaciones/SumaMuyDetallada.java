package com.porfirio.fraccionando.dominio.logica.operaciones;

import com.porfirio.fraccionando.dominio.enumerados.TipoPaso;
import com.porfirio.fraccionando.dominio.logica.calculos.Calculos;
import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.procedimiento.FraccionPaso;
import com.porfirio.fraccionando.dominio.procedimiento.Paso;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.dominio.utils.Constantes;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Es una implementacion de Suma, donde las operaciones realizadas generan una
 * explicacion muy detallada del procedimiento llevado a cabo.
 *
 * @author Porfirio Angel Diaz Sanchez [porfirioads@gmail.com]
 */
public class SumaMuyDetallada extends Suma {

    /**
     * Constructor que recibe dos parametros.
     *
     * @param fracciones Contiene los operandos de la operacion.
     * @param operadores Contiene los operadores de la operacion.
     */
    public SumaMuyDetallada(ArrayList<Fraccion> fracciones,
            ArrayList<Character> operadores) {
        super(fracciones, operadores);
        ComunesOperacion.toFraccionDetallada(fracciones);
    }

    @Override
    public Fraccion calcularResultado(boolean operacionFinal) {
        if (isSuma()) {
            convertirMixtasAImpropias();

            Procedimiento.agregarPaso(new Paso(Constantes.bundle
                    .getString("SUM_SX_DEN"), TipoPaso.string));
            Procedimiento.agregarPaso(new Paso(Arrays
                    .toString(getDenominadores()), TipoPaso.expresion));

            if (sonIgualesLosDenominadores()) {
                Procedimiento.agregarPaso(new Paso(Constantes.bundle
                        .getString("SUM_SX_DEN_IGU"), TipoPaso.string));
            } else {
                Procedimiento.agregarPaso(new Paso(Constantes.bundle
                        .getString("SUM_SX_DEN_DIF"), TipoPaso.string));

                long mcm = Calculos.mcmDetallado(getDenominadores());

                Procedimiento.agregarPaso(new Paso(Constantes.bundle
                        .getString("SUM_SX_CONV_MCM"), TipoPaso.string));
                Procedimiento.agregarPaso(new Paso(
                        latexConversionMcmFracciones(mcm), TipoPaso.expresion));
                Procedimiento.agregarPaso(new Paso(Constantes.bundle
                        .getString("OPE_RES_CONV"), TipoPaso.string));

                convertirAEquivalentesMcm(mcm);

                Procedimiento.agregarPaso(new Paso(toLatex(false),
                        TipoPaso.expresion));
                Procedimiento.agregarPaso(new Paso(Constantes.bundle
                        .getString("SUM_SX_OPE_NUMS"), TipoPaso.string));
            }

            Procedimiento.agregarPaso(new Paso(latexSumaNumeradores(),
                    TipoPaso.expresion));
            Procedimiento.agregarPaso(new Paso(Constantes.bundle
                    .getString("OPE_RES"), TipoPaso.string));

            resultado = calcularResultadoSumaNumeradores()
                    .toFraccionDetallada();

            Procedimiento.agregarPaso(new Paso(resultado.toLatex(false),
                    TipoPaso.expresion));

            if (operacionFinal) {
                ComunesOperacion.terminarOperacion(resultado);
            }

            return resultado;
        } else {
            Multiplicacion multiplicacion
                    = new MultiplicacionMuyDetallada(fracciones, operadores);

            return multiplicacion.calcularResultado(operacionFinal);
        }
    }

    /**
     * Devuelve el codigo latex correspondiente al paso de la conversion de las
     * fracciones por medio del mcm para realizar la operacion.
     *
     * @param mcm Es el mcm de los denominadores.
     * @return El codigo latex del paso.
     */
    private String latexConversionMcmFracciones(long mcm) {
        String latex = "";
        String numerador;
        String denominador;

        for (int i = 0; i < fracciones.size(); i++) {
            numerador = mcm + " ÷ " + fracciones.get(i).getDenominador()
                    + " * " + fracciones.get(i).getNumerador();
            denominador = mcm + "";

            latex += new FraccionPaso(numerador, denominador).toLatex();

            if (i < fracciones.size() - 1) {
                latex += " " + operadores.get(i) + " ";
            }
        }

        return latex;
    }

    @Override
    protected void convertirMixtasAImpropias() {
        ComunesOperacion.convertirMixtasAImpropiasMuyDetallado(this);
    }

}
