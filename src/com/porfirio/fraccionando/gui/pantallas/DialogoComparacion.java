package com.porfirio.fraccionando.gui.pantallas;

import com.porfirio.fraccionando.dominio.logica.fracciones.Fraccion;
import com.porfirio.fraccionando.dominio.logica.fracciones.FraccionSimple;
import com.porfirio.fraccionando.dominio.utils.Constantes;
import com.porfirio.fraccionando.gui.componentes.Generador;
import com.porfirio.fraccionando.gui.componentes.RoundedPanel;
import com.porfirio.fraccionando.gui.listeners.CreacionFraccionListener;
import com.porfirio.fraccionando.latex.LatexRender;
import com.porfirio.fraccionando.main.Configuracion;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 * Este cuadro de dialogo es mostrado para insertar funciones de comparacion,
 * como lo son determinar fracciones equivalentes, reciprocas y la mayor.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class DialogoComparacion extends javax.swing.JDialog
        implements DialogoFuncion {

    /**
     * Es la respuesta obtenida del dialogo para determinar si la accion dentro
     * de el fue hecha correctamente o si fue cancelada.
     */
    private int respuesta;
    /**
     * Lista que contiene las dos fracciones que se van a comparar.
     */
    ArrayList<Fraccion> fracciones;

    /**
     * Creates new form DialogoComparacion
     */
    public DialogoComparacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Generador.cambiarLetraHijos(jPanelFondoClaro);
        jScrollPaneEntrada.getHorizontalScrollBar().setUnitIncrement(15);
        jScrollPaneEntrada.setBorder(BorderFactory.createEmptyBorder());
        jScrollPaneEntrada.getViewport().setOpaque(false);
        jScrollPaneEntrada.setViewportBorder(BorderFactory.createEmptyBorder());
        getRootPane().setDefaultButton(jButtonAceptar);
        pack();
        setLocationRelativeTo(parent);

        fracciones = new ArrayList<>();
        generadorFraccion.setFracciones(fracciones);
        // Para que no de un NullPointerException
        generadorFraccion.setOperadores(new ArrayList<>());
        agregarFraccion();

        generadorFraccion.setCreacionFraccionListener(
                new CreacionFraccionListener() {

                    @Override
                    public void onFraccionUpdated() {
                        updateGUI();
                    }

                    @Override
                    public void onFraccionRemoved() {
                        updateGUI();
                    }

                    @Override
                    public void onFraccionReseted() {
                        updateGUI();
                    }
                });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondoOscuro = new javax.swing.JPanel();
        jPanelFondoClaro = new RoundedPanel(10);
        jPanel1 = new javax.swing.JPanel();
        generadorFraccion = new com.porfirio.fraccionando.gui.componentes.FraccionPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonAgregarFraccion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        roundedPanel1 = new com.porfirio.fraccionando.gui.componentes.RoundedPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPaneEntrada = new javax.swing.JScrollPane();
        jPanelOperacion = new javax.swing.JPanel();
        jLabelEntrada = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelFondoOscuro.setBackground(Configuracion.colorOscuro);
        jPanelFondoOscuro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelFondoOscuro.setLayout(new java.awt.BorderLayout());

        jPanelFondoClaro.setBackground(Configuracion.colorClaro);
        jPanelFondoClaro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelFondoClaro.setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jPanel1.add(generadorFraccion);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jButtonAgregarFraccion.setText("Agregar fracción");
        jButtonAgregarFraccion.setToolTipText("Agrega la otra fracción de la comparación");
        jButtonAgregarFraccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarFraccionActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonAgregarFraccion, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        roundedPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Entrada"));
        jPanel4.setToolTipText("En esta área se muestra la operación que se está ingresando");
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(482, 150));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPaneEntrada.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanelOperacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 20, 0));
        jPanelOperacion.setOpaque(false);
        jPanelOperacion.setLayout(new javax.swing.BoxLayout(jPanelOperacion, javax.swing.BoxLayout.LINE_AXIS));
        jPanelOperacion.add(jLabelEntrada);

        jScrollPaneEntrada.setViewportView(jPanelOperacion);

        jPanel4.add(jScrollPaneEntrada);

        roundedPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(roundedPanel1);

        jPanel3.setOpaque(false);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAceptar);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCancelar);

        jPanel2.add(jPanel3);

        jPanel1.add(jPanel2);

        jPanelFondoClaro.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanelFondoOscuro.add(jPanelFondoClaro, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanelFondoOscuro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        respuesta = Constantes.DIALOG_ACEPTAR;
        dispose();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        respuesta = Constantes.DIALOG_CANCELAR;
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAgregarFraccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarFraccionActionPerformed
        agregarFraccion();
    }//GEN-LAST:event_jButtonAgregarFraccionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogoComparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoComparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoComparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoComparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoComparacion dialog = new DialogoComparacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.porfirio.fraccionando.gui.componentes.FraccionPanel generadorFraccion;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAgregarFraccion;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelEntrada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelFondoClaro;
    private javax.swing.JPanel jPanelFondoOscuro;
    private javax.swing.JPanel jPanelOperacion;
    private javax.swing.JScrollPane jScrollPaneEntrada;
    private com.porfirio.fraccionando.gui.componentes.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public int getRespuesta() {
        return respuesta;
    }

    /**
     * Devuelve las fracciones generadas.
     *
     * @return List de Fraccion.
     */
    ArrayList<Fraccion> getFracciones() {
        return fracciones;
    }

    /**
     * Agrega una fraccion a la comparacion.
     */
    public void agregarFraccion() {
        fracciones.add(new FraccionSimple());
        generadorFraccion.updateGUI();
        updateGUI();
    }

    /**
     * Actualiza los componentes de la GUI como respuesta a los eventos de
     * interaccion con el usuario.
     */
    private void updateGUI() {

        if (generadorFraccion.isCompleta() && fracciones.size() > 1) {
            jButtonAceptar.setEnabled(true);
        } else {
            jButtonAceptar.setEnabled(false);
        }

        if (fracciones.size() == 1) {
            jButtonAceptar.setEnabled(false);

            if (generadorFraccion.isCompleta()) {
                jButtonAgregarFraccion.setEnabled(true);
            } else {
                jButtonAgregarFraccion.setEnabled(false);
            }
        } else {
            jButtonAgregarFraccion.setEnabled(false);
        }

        String fraccionesString = "[" + fracciones.get(0).toLatexFormulacion()
                + "," + Configuracion.espacio;
        if (fracciones.size() == 2) {
            fraccionesString += fracciones.get(1).toLatexFormulacion();
        }

        fraccionesString += "]";

        String nombre = LatexRender.render("formulacion", fraccionesString,
                false);
        ImageIcon image = new ImageIcon(nombre);
        jLabelEntrada.setIcon(image);
    }
}
