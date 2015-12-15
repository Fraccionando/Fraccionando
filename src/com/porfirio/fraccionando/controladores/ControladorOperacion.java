package com.porfirio.fraccionando.controladores;

import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.logica.fracciones.FraccionSimple;
import com.porfirio.fraccionando.dominio.logica.operaciones.Operacion;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.dominio.utils.Constantes;
import com.porfirio.fraccionando.gui.componentes.FraccionPanel;
import com.porfirio.fraccionando.latex.LatexRender;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Esta clase es un controlador para unir los datos de las operaciones con
 * fracciones con la GUI de la aplicacion.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class ControladorOperacion {

    /**
     * Es la operacion que el usuario ingresa.
     */
    private Operacion operacion;
    /**
     * Es donde se mostrara la operacion formulada.
     */
    private final JLabel labelOperacion;
    /**
     * Es el panel donde se muestran los pasos de la explicacion.
     */
    private JPanel panelPasos;
    /**
     * Es el panel donde se muestra el resultado de la operacion.
     */
    private JPanel panelResultado;
    /**
     * Es el componente usado para generar las fracciones.
     */
    private final FraccionPanel generadorFraccion;
    /**
     * Es un arreglo que contiene los botones de las operaciones basicas (suma,
     * resta, multiplicacion y division).
     */
    private JButton[] botonesOperacionesBasicas;
    /**
     * Es el boton de resolver operacion.
     */
    private JButton botonResolver;
    /**
     * Es el boton de reiniciar operacion.
     */
    private JButton botonReiniciar;
    /**
     * Es el controlador usado para colocar el resultado y pasos en los paneles
     * de la GUI correspondientes.
     */
    private ControladorResultadoOperacion controladorPasos;

    /**
     * Constructor que recibe siete parametros.
     *
     * @param labelOperacion Es donde se mostrara la operacion formulada.
     * @param panelPasos Es el panel donde se muestran los pasos de la
     * explicacion.
     * @param generadorFraccion Es el componente usado para generar las
     * fracciones.
     * @param botonesOperacionesBasicas Es un arreglo que contiene los botones
     * de las operaciones basicas (suma, resta, multiplicacion y division).
     * @param botonResolver Es el boton de resolver operacion.
     * @param botonReiniciar Es el boton de reiniciar operacion.
     * @param panelResultado Es el panel donde se muestra el resultado de la
     * operacion.
     */
    public ControladorOperacion(
            JLabel labelOperacion,
            JPanel panelPasos, FraccionPanel generadorFraccion,
            JButton[] botonesOperacionesBasicas, JButton botonResolver,
            JButton botonReiniciar, JPanel panelResultado) {
        this.labelOperacion = labelOperacion;
        this.panelPasos = panelPasos;
        this.generadorFraccion = generadorFraccion;
        this.botonesOperacionesBasicas = botonesOperacionesBasicas;
        this.botonResolver = botonResolver;
        this.botonReiniciar = botonReiniciar;
        this.panelResultado = panelResultado;
        controladorPasos = new ControladorResultadoOperacion(panelPasos,
                panelResultado);
        iniciarOperacion();
    }

    private void iniciarOperacion() {
        boolean detallada = Configuracion
                .getPropertyValue(Constantes.cExplicacion)
                .equals(Constantes.eMuyDetallado);

        operacion = new Operacion(new ArrayList<>(), new ArrayList<>(),
                detallada);
        generadorFraccion.setFracciones(operacion.getFracciones());
        generadorFraccion.setOperadores(operacion.getOperadores());

        updateGUI();
    }

    /**
     * Resuelve la operacion ingresada por el usuario.
     */
    public void resolverOperacion() {
        Procedimiento.iniciar();
        operacion.calcularResultado(true);
        controladorPasos.colocarResultadoPasos();
        iniciarOperacion();
    }

    public void reiniciarOperacion() {
        iniciarOperacion();
        labelOperacion.setIcon(null);
    }

    public void agregarFraccion(char c) {
        operacion.getOperadores().add(c);
        operacion.getFracciones().add(new FraccionSimple());
        generadorFraccion.updateGUI();
        updateGUI();
    }

    /**
     * Establece si la operacion es o no detallda.
     *
     * @param detallada true para operacion detallada o false para no detallada.
     */
    public void setOperacionDetallada(boolean detallada) {
        operacion.setDetallada(detallada);
    }

    public void updateGUI() {
        if (generadorFraccion.isCompleta()) {
            habilitarBotonesOperaciones(true);
        } else {
            habilitarBotonesOperaciones(false);
        }

        if (operacion.getFracciones().size() > 1) {
            botonReiniciar.setEnabled(true);
        } else if (operacion.getFracciones().size() == 1) {
            if (generadorFraccion.getFraccion().equals(new FraccionSimple())) {
                botonReiniciar.setEnabled(false);
            } else {
                botonReiniciar.setEnabled(true);
            }
        }

        if (operacion.getFracciones().size() > 1) {
            if (generadorFraccion.isCompleta()) {
                botonResolver.setEnabled(true);
            } else {
                botonResolver.setEnabled(false);
            }
        } else {
            botonResolver.setEnabled(false);
        }

        String nombre = LatexRender.render(
                "formulacion", operacion.toLatex(true), false);
        ImageIcon image = new ImageIcon(nombre);
        labelOperacion.setIcon(image);
    }

    /**
     * Habilita/deshabilita los botones de las operaciones basicas, segun la
     * entrada de datos.
     *
     * @param habilitados Valor que determina si los botones se van a habilitar
     * o deshabilitar.
     */
    private void habilitarBotonesOperaciones(boolean habilitados) {
        for (JButton boton : botonesOperacionesBasicas) {
            boton.setEnabled(habilitados);
        }

        if (operacion.getFracciones().size() > 1) {
            if (!habilitados) {
                botonResolver.setEnabled(habilitados);
            } else if (operacion.getFracciones().size() > 1) {
                botonResolver.setEnabled(habilitados);
            }
        } else {
            botonResolver.setEnabled(false);
        }

    }

}
