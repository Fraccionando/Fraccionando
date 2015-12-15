package com.porfirio.fraccionando.gui.componentes;

import com.porfirio.fraccionando.dominio.enumerados.ParteFraccion;
import com.porfirio.fraccionando.gui.listeners.CreacionFraccionListener;
import com.porfirio.fraccionando.gui.listeners.CreacionFraccionAdapter;
import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.logica.fracciones.FraccionSimple;
import com.porfirio.fraccionando.dominio.logica.operaciones.Operacion;
import com.porfirio.fraccionando.dominio.utils.Arreglos;
import com.porfirio.fraccionando.dominio.utils.ManejoDigitos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Esta clase es una extension de JPanel, su objetivo es proporcionar la
 * interface para ingresar fracciones en las operaciones de la aplicacion.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class FraccionPanel extends javax.swing.JPanel {

    /**
     * Son las fracciones de la operacion o comparacion que se esta formando, en
     * caso de que asi sea, en una conversion, esta lista solo tendra un
     * elemento.
     */
    private ArrayList<Fraccion> fracciones;
    private ArrayList<Character> operadores;
    /**
     * Es el escuchadorBasico basico que ya contiene el panel generador de
     * fracciones.
     */
    private EscuchadorBasico escuchadorBasico;
    /**
     * Es el escuchadorBasico de eventos para cuando una fraccion es modificada,
     * eliminada o reiniciada.
     */
    private CreacionFraccionListener creacionFraccionListener;
    /**
     * Valor que determina si el panel tendra visiblea el boton de remover
     * fraccion.
     */
    private boolean botonRemover;
    /**
     * Es un arreglo que contiene los botones temporales para el entero.
     */
    private JButton[] botonesTemporalesEntero;
    /**
     * Es un arreglo que contiene los botones temporales para el numerador.
     */
    private JButton[] botonesTemporalesNumerador;
    /**
     * Es un arreglo que contiene los botones temporales para el denominador.
     */
    private JButton[] botonesTemporalesDenominador;
    /**
     * Es un arreglo que contiene los botones numericos para el entero.
     */
    private JButton[] botonesNumericosEntero;
    /**
     * Es un arreglo que contiene los botones numericos para el numerador.
     */
    private JButton[] botonesNumericosNumerador;
    /**
     * Es un arreglo que contiene los botones numericos para el denominador.
     */
    private JButton[] botonesNumericosDenominador;

    /**
     * Constructor que recibe un parametro.
     *
     * @param botonRemover Valor que determina si el panel tendra visiblea el
     * boton de remover fraccion.
     * @param fracciones
     */
    public FraccionPanel(boolean botonRemover, ArrayList<Fraccion> fracciones,
            ArrayList<Character> operadores) {
        this.botonRemover = botonRemover;
        this.fracciones = fracciones;
        this.operadores = operadores;
        escuchadorBasico = new EscuchadorBasico();
        creacionFraccionListener = new CreacionFraccionAdapter();
        initComponents();
        iniciarGUI();
    }

    /**
     * Creates new form FraccionPanel
     */
    public FraccionPanel() {
        this(true, null, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButtonNum_7 = new javax.swing.JButton();
        jButtonNum_8 = new javax.swing.JButton();
        jButtonNum_9 = new javax.swing.JButton();
        jButtonNum_4 = new javax.swing.JButton();
        jButtonNum_5 = new javax.swing.JButton();
        jButtonNum_6 = new javax.swing.JButton();
        jButtonNum_1 = new javax.swing.JButton();
        jButtonNum_2 = new javax.swing.JButton();
        jButtonNum_3 = new javax.swing.JButton();
        jButtonNum_0 = new javax.swing.JButton();
        jButtonNumAc = new javax.swing.JButton();
        jButtonNumDel = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButtonDen_7 = new javax.swing.JButton();
        jButtonDen_8 = new javax.swing.JButton();
        jButtonDen_9 = new javax.swing.JButton();
        jButtonDen_4 = new javax.swing.JButton();
        jButtonDen_5 = new javax.swing.JButton();
        jButtonDen_6 = new javax.swing.JButton();
        jButtonDen_1 = new javax.swing.JButton();
        jButtonDen_2 = new javax.swing.JButton();
        jButtonDen_3 = new javax.swing.JButton();
        jButtonDen_0 = new javax.swing.JButton();
        jButtonDenAc = new javax.swing.JButton();
        jButtonDenDel = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButtonEnt_7 = new javax.swing.JButton();
        jButtonEnt_8 = new javax.swing.JButton();
        jButtonEnt_9 = new javax.swing.JButton();
        jButtonEnt_4 = new javax.swing.JButton();
        jButtonEnt_5 = new javax.swing.JButton();
        jButtonEnt_6 = new javax.swing.JButton();
        jButtonEnt_1 = new javax.swing.JButton();
        jButtonEnt_2 = new javax.swing.JButton();
        jButtonEnt_3 = new javax.swing.JButton();
        jButtonEnt_0 = new javax.swing.JButton();
        jButtonEntAc = new javax.swing.JButton();
        jButtonEntDel = new javax.swing.JButton();
        jButtonReiniciarFraccion = new javax.swing.JButton();
        jButtonRemoverFraccion = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Fracción"));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(2, 1));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Numerador"));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(4, 3));

        jButtonNum_7.setText("7");
        jPanel8.add(jButtonNum_7);

        jButtonNum_8.setText("8");
        jPanel8.add(jButtonNum_8);

        jButtonNum_9.setText("9");
        jPanel8.add(jButtonNum_9);

        jButtonNum_4.setText("4");
        jPanel8.add(jButtonNum_4);

        jButtonNum_5.setText("5");
        jPanel8.add(jButtonNum_5);

        jButtonNum_6.setText("6");
        jPanel8.add(jButtonNum_6);

        jButtonNum_1.setText("1");
        jPanel8.add(jButtonNum_1);

        jButtonNum_2.setText("2");
        jPanel8.add(jButtonNum_2);

        jButtonNum_3.setText("3");
        jPanel8.add(jButtonNum_3);

        jButtonNum_0.setText("0");
        jButtonNum_0.setEnabled(false);
        jPanel8.add(jButtonNum_0);

        jButtonNumAc.setBackground(new java.awt.Color(193, 2, 12));
        jButtonNumAc.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNumAc.setText("AC");
        jButtonNumAc.setToolTipText("Reinicia el numerador");
        jButtonNumAc.setEnabled(false);
        jPanel8.add(jButtonNumAc);

        jButtonNumDel.setBackground(new java.awt.Color(193, 2, 12));
        jButtonNumDel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNumDel.setText("DEL");
        jButtonNumDel.setToolTipText("Elimina el último dígito del numerador");
        jButtonNumDel.setEnabled(false);
        jPanel8.add(jButtonNumDel);

        jPanel7.add(jPanel8);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Denominador"));
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.GridLayout(4, 3));

        jButtonDen_7.setText("7");
        jPanel9.add(jButtonDen_7);

        jButtonDen_8.setText("8");
        jPanel9.add(jButtonDen_8);

        jButtonDen_9.setText("9");
        jPanel9.add(jButtonDen_9);

        jButtonDen_4.setText("4");
        jPanel9.add(jButtonDen_4);

        jButtonDen_5.setText("5");
        jPanel9.add(jButtonDen_5);

        jButtonDen_6.setText("6");
        jPanel9.add(jButtonDen_6);

        jButtonDen_1.setText("1");
        jPanel9.add(jButtonDen_1);

        jButtonDen_2.setText("2");
        jPanel9.add(jButtonDen_2);

        jButtonDen_3.setText("3");
        jPanel9.add(jButtonDen_3);

        jButtonDen_0.setText("0");
        jButtonDen_0.setEnabled(false);
        jPanel9.add(jButtonDen_0);

        jButtonDenAc.setBackground(new java.awt.Color(193, 2, 12));
        jButtonDenAc.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDenAc.setText("AC");
        jButtonDenAc.setToolTipText("Reinicia el denominador");
        jButtonDenAc.setEnabled(false);
        jPanel9.add(jButtonDenAc);

        jButtonDenDel.setBackground(new java.awt.Color(193, 2, 12));
        jButtonDenDel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDenDel.setText("DEL");
        jButtonDenDel.setToolTipText("Elimina el último dígito del denominador");
        jButtonDenDel.setEnabled(false);
        jPanel9.add(jButtonDenDel);

        jPanel7.add(jPanel9);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel7, gridBagConstraints);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Entero"));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(4, 3));

        jButtonEnt_7.setText("7");
        jPanel6.add(jButtonEnt_7);

        jButtonEnt_8.setText("8");
        jPanel6.add(jButtonEnt_8);

        jButtonEnt_9.setText("9");
        jPanel6.add(jButtonEnt_9);

        jButtonEnt_4.setText("4");
        jPanel6.add(jButtonEnt_4);

        jButtonEnt_5.setText("5");
        jPanel6.add(jButtonEnt_5);

        jButtonEnt_6.setText("6");
        jPanel6.add(jButtonEnt_6);

        jButtonEnt_1.setText("1");
        jPanel6.add(jButtonEnt_1);

        jButtonEnt_2.setText("2");
        jPanel6.add(jButtonEnt_2);

        jButtonEnt_3.setText("3");
        jPanel6.add(jButtonEnt_3);

        jButtonEnt_0.setText("0");
        jButtonEnt_0.setEnabled(false);
        jPanel6.add(jButtonEnt_0);

        jButtonEntAc.setBackground(new java.awt.Color(193, 2, 12));
        jButtonEntAc.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEntAc.setText("AC");
        jButtonEntAc.setToolTipText("Reinicia la parte entera");
        jButtonEntAc.setEnabled(false);
        jPanel6.add(jButtonEntAc);

        jButtonEntDel.setBackground(new java.awt.Color(193, 2, 12));
        jButtonEntDel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEntDel.setText("DEL");
        jButtonEntDel.setToolTipText("Remueve el último dígito de la parte entera");
        jButtonEntDel.setEnabled(false);
        jPanel6.add(jButtonEntDel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 149;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel10.add(jPanel6, gridBagConstraints);

        jButtonReiniciarFraccion.setText("Reiniciar");
        jButtonReiniciarFraccion.setToolTipText("Reinicia la última fracción ingresada");
        jButtonReiniciarFraccion.setEnabled(false);
        jButtonReiniciarFraccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarFraccionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel10.add(jButtonReiniciarFraccion, gridBagConstraints);

        jButtonRemoverFraccion.setText("Remover");
        jButtonRemoverFraccion.setToolTipText("Elimina la última fracción ingresada");
        jButtonRemoverFraccion.setEnabled(false);
        jButtonRemoverFraccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverFraccionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel10.add(jButtonRemoverFraccion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel10, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReiniciarFraccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarFraccionActionPerformed
        escuchadorBasico.onFraccionReseted();
        creacionFraccionListener.onFraccionReseted();
    }//GEN-LAST:event_jButtonReiniciarFraccionActionPerformed

    private void jButtonRemoverFraccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverFraccionActionPerformed
        escuchadorBasico.onFraccionRemoved();
        creacionFraccionListener.onFraccionRemoved();
    }//GEN-LAST:event_jButtonRemoverFraccionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDenAc;
    private javax.swing.JButton jButtonDenDel;
    private javax.swing.JButton jButtonDen_0;
    private javax.swing.JButton jButtonDen_1;
    private javax.swing.JButton jButtonDen_2;
    private javax.swing.JButton jButtonDen_3;
    private javax.swing.JButton jButtonDen_4;
    private javax.swing.JButton jButtonDen_5;
    private javax.swing.JButton jButtonDen_6;
    private javax.swing.JButton jButtonDen_7;
    private javax.swing.JButton jButtonDen_8;
    private javax.swing.JButton jButtonDen_9;
    private javax.swing.JButton jButtonEntAc;
    private javax.swing.JButton jButtonEntDel;
    private javax.swing.JButton jButtonEnt_0;
    private javax.swing.JButton jButtonEnt_1;
    private javax.swing.JButton jButtonEnt_2;
    private javax.swing.JButton jButtonEnt_3;
    private javax.swing.JButton jButtonEnt_4;
    private javax.swing.JButton jButtonEnt_5;
    private javax.swing.JButton jButtonEnt_6;
    private javax.swing.JButton jButtonEnt_7;
    private javax.swing.JButton jButtonEnt_8;
    private javax.swing.JButton jButtonEnt_9;
    private javax.swing.JButton jButtonNumAc;
    private javax.swing.JButton jButtonNumDel;
    private javax.swing.JButton jButtonNum_0;
    private javax.swing.JButton jButtonNum_1;
    private javax.swing.JButton jButtonNum_2;
    private javax.swing.JButton jButtonNum_3;
    private javax.swing.JButton jButtonNum_4;
    private javax.swing.JButton jButtonNum_5;
    private javax.swing.JButton jButtonNum_6;
    private javax.swing.JButton jButtonNum_7;
    private javax.swing.JButton jButtonNum_8;
    private javax.swing.JButton jButtonNum_9;
    private javax.swing.JButton jButtonReiniciarFraccion;
    private javax.swing.JButton jButtonRemoverFraccion;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables

    /**
     * Inicializa aspectos de la gui, que no se pueden colocar en el metodo
     * initComponents.
     */
    private void iniciarGUI() {
        jButtonReiniciarFraccion.setVisible(true);
        jButtonRemoverFraccion.setVisible(botonRemover);

        botonesTemporalesEntero = new JButton[]{
            jButtonEntAc, jButtonEntDel, jButtonEnt_0
        };

        botonesTemporalesNumerador = new JButton[]{
            jButtonNumAc, jButtonNumDel, jButtonNum_0
        };

        botonesTemporalesDenominador = new JButton[]{
            jButtonDenAc, jButtonDenDel, jButtonDen_0
        };

        botonesNumericosEntero = new JButton[]{
            jButtonEnt_0, jButtonEnt_1, jButtonEnt_2, jButtonEnt_3,
            jButtonEnt_4, jButtonEnt_5, jButtonEnt_6, jButtonEnt_7,
            jButtonEnt_8, jButtonEnt_9
        };

        botonesNumericosNumerador = new JButton[]{
            jButtonNum_0, jButtonNum_1, jButtonNum_2, jButtonNum_3,
            jButtonNum_4, jButtonNum_5, jButtonNum_6, jButtonNum_7,
            jButtonNum_8, jButtonNum_9
        };

        botonesNumericosDenominador = new JButton[]{
            jButtonDen_0, jButtonDen_1, jButtonDen_2, jButtonDen_3,
            jButtonDen_4, jButtonDen_5, jButtonDen_6, jButtonDen_7,
            jButtonDen_8, jButtonDen_9
        };

        EscuchadorBotonParteFraccion numeradorListener
                = new EscuchadorBotonParteFraccion(ParteFraccion.NUMERADOR,
                        jButtonNumAc, jButtonNumDel, botonesNumericosNumerador);

        for (JButton boton : botonesNumericosNumerador) {
            boton.addActionListener(numeradorListener);
        }

        jButtonNumAc.addActionListener(numeradorListener);
        jButtonNumDel.addActionListener(numeradorListener);

        EscuchadorBotonParteFraccion denominadorListener
                = new EscuchadorBotonParteFraccion(ParteFraccion.DENOMINADOR,
                        jButtonDenAc, jButtonDenDel,
                        botonesNumericosDenominador);

        for (JButton boton : botonesNumericosDenominador) {
            boton.addActionListener(denominadorListener);
        }

        jButtonDenAc.addActionListener(denominadorListener);
        jButtonDenDel.addActionListener(denominadorListener);

        EscuchadorBotonParteFraccion enteroListener
                = new EscuchadorBotonParteFraccion(ParteFraccion.ENTERO,
                        jButtonEntAc, jButtonEntDel, botonesNumericosEntero);

        for (JButton boton : botonesNumericosEntero) {
            boton.addActionListener(enteroListener);
        }

        jButtonEntAc.addActionListener(enteroListener);
        jButtonEntDel.addActionListener(enteroListener);
    }

    /**
     * Establece las fracciones de la operacion que se asocia al panel.
     *
     * @param fracciones Son las fracciones de la operacion o comparacion que se
     * esta formando.
     */
    public void setFracciones(ArrayList<Fraccion> fracciones) {
        this.fracciones = fracciones;
    }

    /**
     * Establece los operadores de la operacion que se asocia al panel.
     *
     * @param operadores Son los operadores de la operacion que se esta
     * formando.
     */
    public void setOperadores(ArrayList<Character> operadores) {
        this.operadores = operadores;
    }

    /**
     * Devuelve la fraccion formada por medio del componente.
     *
     * @return Una instancia de Fraccion, con la fraccion formada.
     */
    public Fraccion getFraccion() {
        if (fracciones.isEmpty()) {
            fracciones.add(new FraccionSimple());
        }

        int ultima = fracciones.size() - 1;

        return fracciones.get(ultima);
    }

    /**
     * Establece el listener de creacion de fraccion.
     *
     * @param cf Es el listener que se va a asignar.
     */
    public void setCreacionFraccionListener(CreacionFraccionListener cf) {
        this.creacionFraccionListener = cf;
    }

    /**
     * Devuelve el valor del listener de creacion de fraccion.
     *
     * @return El la instancia de CreacionFraccionListener asociada.
     */
    public CreacionFraccionListener getCreacionFraccionListener() {
        return creacionFraccionListener;
    }

    /**
     * Determina si la instancia actual de FraccionPanel tiene el boton de
     * remover fraccion.
     *
     * @return true si el boton esta visible o false en caso contrario.
     */
    public boolean hasBotonRemover() {
        return botonRemover;
    }

    /**
     * Habilita/deshabilita los botones contenidos en un arreglo de JButton.
     *
     * @param botones Es un arreglo que incluye los botones a modificar.
     * @param habilitado Es el valor que se establecera a la propiedad 'enabled'
     * de los botones.
     */
    private void habilitarBotones(JButton[] botones, boolean habilitado) {
        for (JButton boton : botones) {
            boton.setEnabled(habilitado);
        }
    }

    /**
     * Determina si la fraccion generada por el panel esta completa (que sus
     * partes asignadas formen una fraccion valida).
     *
     * @return boolean si la fraccion esta completa o false si no lo esta.
     */
    public boolean isCompleta() {
        long num = getFraccion().getNumerador();
        long den = getFraccion().getDenominador();
        long ent = getFraccion().getEntero();

        if (num == 0 && den == 0) {
            if (ent == 0) {
                return false;
            } else {
                return true;
            }
        } else if (num == 0 || den == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Establece si el boton de reiniciar fraccion va a estar habilitado o no.
     *
     * @param enabled Valor que determina si el boton esta habilitado.
     */
    public void setBotonReiniciarEnabled(boolean enabled) {
        jButtonReiniciarFraccion.setEnabled(enabled);
    }

    /**
     * Establece si el boton de remover fraccion va a estar habilitado o no.
     *
     * @param enabled Valor que determina si el boton esta habilitado.
     */
    public void setBotonRemoverEnabled(boolean enabled) {
        jButtonRemoverFraccion.setEnabled(enabled);
    }

    /**
     * Determina y actualiza los botones del panel segun a su disponibilidad que
     * deban tener en ese momento, habilitandolos o deshabilitandolos.
     */
    public void updateGUI() {
        boolean tieneEntero = getFraccion().getEntero() != 0l;
        boolean tieneNumerador = getFraccion().getNumerador() != 0l;
        boolean tieneDenominador = getFraccion().getDenominador() != 0l;

        if (tieneEntero || tieneNumerador || tieneDenominador) {
            jButtonReiniciarFraccion.setEnabled(true);
        } else {
            jButtonReiniciarFraccion.setEnabled(false);
        }

        if (botonRemover) {
            if (fracciones != null) {
                if (fracciones.size() == 1) {
                    if (getFraccion().equals(new FraccionSimple())) {
                        jButtonRemoverFraccion.setEnabled(false);
                    } else {
                        jButtonRemoverFraccion.setEnabled(true);
                    }
                } else if (fracciones.size() > 1) {
                    jButtonRemoverFraccion.setEnabled(true);
                } else {
                    jButtonRemoverFraccion.setEnabled(false);
                }
            }
        }

        if (tieneEntero) {
            habilitarBotones(botonesTemporalesEntero, true);
        } else {
            habilitarBotones(botonesTemporalesEntero, false);
        }

        if (tieneNumerador) {
            habilitarBotones(botonesTemporalesNumerador, true);
        } else {
            habilitarBotones(botonesTemporalesNumerador, false);
        }

        if (tieneDenominador) {
            habilitarBotones(botonesTemporalesDenominador, true);
        } else {
            habilitarBotones(botonesTemporalesDenominador, false);
        }
    }

    /**
     * Este es el escuchador por default que contiene un objeto de
     * FraccionPanel, el cual controla la habilitacion/deshabilitacion de los
     * botones que dependen de la fraccion que esta actualmente ingresada, como
     * lo son el boton 0, el boton Ac y el boton Del.
     */
    private class EscuchadorBotonParteFraccion implements ActionListener {

        /**
         * Es la parte de la fraccion de donde viene el evento.
         */
        private ParteFraccion parte;
        /**
         * Es el boton AC de la parte de la fraccion que genera el evento.
         */
        private JButton botonAc;
        /**
         * Es el boton DEL de la parte de la fraccion que genera el evento.
         */
        private JButton botonDel;
        /**
         * Son los botones numericos de la parte de la fraccion que genera el
         * evento.
         */
        private JButton[] botonesNumericos;

        /**
         * Constructor que recibe cuatro parametros.
         *
         * @param parte Es la parte de la fraccion de donde viene el evento.
         * @param botonAc Es el boton AC de la parte de la fraccion que genera
         * el evento.
         * @param botonDel Es el boton DEL de la parte de la fraccion que genera
         * el evento.
         * @param botonesNumericos Son los botones numericos de la parte de la
         * fraccion que genera el evento.
         */
        public EscuchadorBotonParteFraccion(ParteFraccion parte,
                JButton botonAc, JButton botonDel, JButton[] botonesNumericos) {
            this.parte = parte;
            this.botonAc = botonAc;
            this.botonDel = botonDel;
            this.botonesNumericos = botonesNumericos;
        }

        /**
         * Establece el valor a la parte de la fraccion controlada por la
         * instancia del listener.
         *
         * @param valor Es el valor a establecer.
         */
        private void setValorParteFraccion(Long valor) {
            switch (parte) {
                case ENTERO:
                    getFraccion().setEntero(valor);
                    break;
                case NUMERADOR:
                    getFraccion().setNumerador(valor);
                    break;
                case DENOMINADOR:
                    getFraccion().setDenominador(valor);
                    break;
            }
        }

        /**
         * Devuelve el valor de la parte de la fraccion controlada por la
         * instancia del listener.
         *
         * @return El valor de la parte de la fraccion.
         */
        private Long getValorParteFraccion() {
            switch (parte) {
                case ENTERO:
                    return getFraccion().getEntero();
                case NUMERADOR:
                    return getFraccion().getNumerador();
                case DENOMINADOR:
                    return getFraccion().getDenominador();
            }

            return 0l;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton origen = (JButton) e.getSource();

            if (origen == botonAc) {
                setValorParteFraccion(0l);
            } else if (origen == botonDel) {
                setValorParteFraccion(ManejoDigitos
                        .removerUltimoDigito(getValorParteFraccion()));
            } else {
                int indice = Arreglos.indexOf(botonesNumericos, origen);
                setValorParteFraccion(ManejoDigitos
                        .agregarDigito(getValorParteFraccion(), indice));
            }

            escuchadorBasico.onFraccionUpdated();
            creacionFraccionListener.onFraccionUpdated();
        }
    }

    /**
     * Este es el escuchador basico para la creacion de fracciones con
     * FraccionPanel, aqui se registran las acciones basicas que se deben hacer
     * cuando una fraccion es actualizada, reiniciada o removida, en su caso.
     */
    private class EscuchadorBasico implements CreacionFraccionListener {

        @Override
        public void onFraccionUpdated() {
            updateGUI();
        }

        @Override
        public void onFraccionRemoved() {
            if (fracciones != null) {
                if (fracciones.size() == 1) {
                    onFraccionReseted();
                } else {
                    int indiceFraccion = fracciones.size() - 1;
                    fracciones.remove(indiceFraccion);

                    int indiceOperador = operadores.size() - 1;

                    if (indiceOperador > -1) {
                        operadores.remove(indiceOperador);
                    }

                    updateGUI();
                }

            } else {
                JOptionPane.showMessageDialog(FraccionPanel.this,
                        "Operacion nula", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void onFraccionReseted() {
            getFraccion().setEntero(0l);
            getFraccion().setNumerador(0l);
            getFraccion().setDenominador(0l);
            onFraccionUpdated();
        }

    }

}
