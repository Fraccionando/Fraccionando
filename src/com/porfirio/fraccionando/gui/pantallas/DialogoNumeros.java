package com.porfirio.fraccionando.gui.pantallas;

import com.porfirio.fraccionando.dominio.utils.Arreglos;
import com.porfirio.fraccionando.dominio.utils.Constantes;
import com.porfirio.fraccionando.gui.componentes.Generador;
import com.porfirio.fraccionando.main.Configuracion;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Este es un cuadro de dialogo para insertar los calculos con numeros, como lo
 * son el minimo comun multiplo y maximo comun divisor.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class DialogoNumeros extends javax.swing.JDialog {

    private int respuesta;
    private long[] numeros;

    /**
     * Creates new form DialogoNumeros
     */
    public DialogoNumeros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Generador.cambiarLetraHijos(jPanelFondoClaro);
        pack();
        setLocationRelativeTo(parent);

        jTextFieldNumeros.addKeyListener(new KeyListener() {
            private final int coma = KeyEvent.VK_COMMA;
            private final int backspace = KeyEvent.VK_BACK_SPACE;
            private final int enter = KeyEvent.VK_ENTER;
            private boolean consumido;

            private boolean isNumerico(KeyEvent e) {
                return !(e.getKeyChar() < '0' || e.getKeyChar() > '9');
            }

            private boolean isFlecha(KeyEvent e) {
                int arriba = KeyEvent.VK_UP;
                int abajo = KeyEvent.VK_DOWN;
                int derecha = KeyEvent.VK_RIGHT;
                int izquierda = KeyEvent.VK_LEFT;
                int code = e.getKeyCode();

                return code == arriba || code == abajo || code == derecha
                        || code == izquierda;
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (consumido) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                consumido = false;
                int codigoTecla = e.getKeyCode();

                if (codigoTecla == enter) {
                    if (jButtonAceptar.isEnabled()) {
                        jButtonAceptar.getActionListeners()[0].actionPerformed(null);
                    }
                } else if (!isNumerico(e)) {
                    if (codigoTecla != coma) {
                        if (codigoTecla != backspace && !isFlecha(e)) {
                            consumido = true;
                            e.consume();
                        }
                    } else {
                        // Posicion del cursor y texto antes de agregar el caracter
                        int posicionCursor = jTextFieldNumeros.getSelectionStart();
                        String texto = jTextFieldNumeros.getText();

                        boolean ultimaPosicion = posicionCursor == texto.length();
                        boolean primeraPosicion = posicionCursor == 0;

                        if (primeraPosicion) {
                            consumido = true;
                            e.consume();
                        } else if (ultimaPosicion) {
                            if (texto.charAt(texto.length() - 1) == ',') {
                                consumido = true;
                                e.consume();
                            }
                        } else {
                            int siguienteIndice = posicionCursor;
                            int anteriorIndice = posicionCursor - 1;

                            if (texto.charAt(siguienteIndice) == ','
                                    || texto.charAt(anteriorIndice) == ',') {
                                consumido = true;
                                e.consume();
                            }
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (consumido) {
                    e.consume();
                } else if (e.getKeyCode() == backspace) {
                    String texto = jTextFieldNumeros.getText();
                    String textoModificado = eliminarComasRepetidas(texto);

                    if (!texto.equals(textoModificado)) {
                        jTextFieldNumeros.setText(textoModificado);
                    }
                }

                String texto = jTextFieldNumeros.getText();

                if (texto.endsWith(",")) {
                    jButtonAceptar.setEnabled(false);
                } else if (texto.split(",").length > 1) {
                    jButtonAceptar.setEnabled(true);
                } else {
                    jButtonAceptar.setEnabled(false);
                }
            }

            /**
             * Elimina las comas repetidas y la coma al principio del texto del
             * JTextField.
             *
             * @param texto Es el texto al que se le quitaran las comas.
             * @return El texto modificado sin comas repetidas.
             */
            private String eliminarComasRepetidas(String texto) {
                String textoModificado = texto.replace(",,", ",");

                if (textoModificado.startsWith(",")) {
                    if (textoModificado.length() > 1) {
                        textoModificado = textoModificado.substring(1,
                                textoModificado.length());
                    } else {
                        textoModificado = "";
                    }
                }

                if (textoModificado.equals(texto)) {
                    return texto;
                } else {
                    return eliminarComasRepetidas(textoModificado);
                }
            }
        });

        getRootPane().setDefaultButton(jButtonAceptar);
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
        jPanelFondoClaro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNumeros = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelFondoOscuro.setBackground(Configuracion.colorOscuro);
        jPanelFondoOscuro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelFondoOscuro.setLayout(new java.awt.BorderLayout());

        jPanelFondoClaro.setBackground(Configuracion.colorClaro);
        jPanelFondoClaro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelFondoClaro.setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setText("Inserta los números separados por comas");
        jPanel1.add(jLabel1);
        jPanel1.add(jTextFieldNumeros);

        jPanel2.setOpaque(false);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setEnabled(false);
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAceptar);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCancelar);

        jPanel1.add(jPanel2);

        jPanelFondoClaro.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanelFondoOscuro.add(jPanelFondoClaro, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanelFondoOscuro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        respuesta = Constantes.DIALOG_ACEPTAR;
        numeros = Arreglos.stringToLongArray(jTextFieldNumeros.getText(), ",");
        dispose();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        respuesta = Constantes.DIALOG_CANCELAR;
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogoNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoNumeros dialog = new DialogoNumeros(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFondoClaro;
    private javax.swing.JPanel jPanelFondoOscuro;
    private javax.swing.JTextField jTextFieldNumeros;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtiene la respuesta que desprende al dialogo segun la forma de cerrarse,
     * siendo DIALOG_ACEPTAR para una entrada exitosa, o DIALOG_CANCELAR para
     * cuando se cierra el dialogo sin concluir la entrada.
     *
     * @return Un valor de la clase Constantes, que determina la respuesta.
     */
    public int getRespuesta() {
        return respuesta;
    }

    /**
     * Obtiene los numeros que se ingresaron por medio del campo de texto.
     *
     * @return Un arreglo que contiene los numeros.
     */
    public long[] getNumeros() {
        return numeros;
    }

}
