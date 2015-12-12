package com.porfirio.fraccionando.controladores;

import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.logica.fracciones.FraccionSimple;
import com.porfirio.fraccionando.dominio.logica.operaciones.Operacion;
import com.porfirio.fraccionando.dominio.procedimiento.Procedimiento;
import com.porfirio.fraccionando.gui.componentes.FraccionPanel;
import com.porfirio.fraccionando.latex.LatexRender;
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
     * Es el componente usado para generar las fracciones.
     */
    private final FraccionPanel generadorFraccion;
    /**
     * Es un arreglo que contiene los botones de las operaciones basicas (suma,
     * resta, multiplicacion y division).
     */
    private JButton[] botonesOperacionesBasicas;
    private JButton botonResolver;
    private JButton botonReiniciar;

    public ControladorOperacion(JLabel labelOperacion,
            JPanel panelPasos, FraccionPanel generadorFraccion,
            JButton[] botonesOperacionesBasicas, JButton botonResolver,
            JButton botonReiniciar) {
        this.labelOperacion = labelOperacion;
        this.panelPasos = panelPasos;
        this.generadorFraccion = generadorFraccion;
        this.botonesOperacionesBasicas = botonesOperacionesBasicas;
        this.botonResolver = botonResolver;
        this.botonReiniciar = botonReiniciar;
        iniciarOperacion();
    }

    /**
     * Constructor que recibe tres parametros.
     *
     * @param labelOperacion Es donde se mostrara la operacion formulada.
     * @param panelPasos Es el panel donde se muestran los pasos de la
     * explicacion.
     * @param generadorFraccion Es el componente usado para generar las
     * fracciones.
     * @param botonesOperacionesBasicas Es un arreglo que contiene los botones
     * de las operaciones basicas (suma, resta, multiplicacion y division).
     */
    public ControladorOperacion(JLabel labelOperacion,
            JPanel panelPasos, FraccionPanel generadorFraccion,
            JButton[] botonesOperacionesBasicas) {
        this.labelOperacion = labelOperacion;
        this.panelPasos = panelPasos;
        this.generadorFraccion = generadorFraccion;
        this.botonesOperacionesBasicas = botonesOperacionesBasicas;
        iniciarOperacion();
    }

    /**
     * Inicia los datos de la operacion.
     */
    private void iniciarOperacion() {
        ArrayList<Fraccion> fracciones = new ArrayList<>();
        ArrayList<Character> operadores = new ArrayList<>();
        fracciones.add(new FraccionSimple());
        operacion = new Operacion(fracciones, operadores);
        generadorFraccion.setOperacion(operacion);
        habilitarBotonesOperaciones(false);
        botonReiniciar.setEnabled(false);
    }

    /**
     * Resuelve la operacion ingresada por el usuario.
     */
    public void resolverOperacion() {
        Procedimiento.iniciar();
        operacion.calcularResultado(true);
    }

    /**
     * Actualiza la operacion como respuesta a la interaccion del usuario con la
     * GUI.
     */
    public void actualizarOperacion() {
        String nombre = LatexRender.render("formulacion",
                operacion.toLatexFormulacion(), false);
        ImageIcon image = new ImageIcon(nombre);
        labelOperacion.setIcon(image);
        habilitarBotonesOperaciones(generadorFraccion.isCompleta());

        if (operacion.getFracciones().size() == 1) {
            if (operacion.getFracciones().get(0).equals(new FraccionSimple())) {
                botonReiniciar.setEnabled(false);
            } else {
                botonReiniciar.setEnabled(true);
            }
        }
    }

    /**
     * Agrega una nueva fraccion a la operacion.
     *
     * @param operador Es el operador con el que se agrego la fraccion.
     */
    public void agregarFraccion(Character operador) {
        operacion.getFracciones().add(new FraccionSimple());
        operacion.getOperadores().add(operador);
        generadorFraccion.reiniciarFraccion();
        actualizarOperacion();
    }

    /**
     * Actualiza la ultima fraccion ingresada.
     */
    public void actualizarFraccion() {
        int indice = operacion.getFracciones().size() - 1;
        operacion.getFracciones().set(indice, generadorFraccion.getFraccion());
        actualizarOperacion();
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
