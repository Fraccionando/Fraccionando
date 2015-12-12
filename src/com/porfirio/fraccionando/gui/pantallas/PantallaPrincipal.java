package com.porfirio.fraccionando.gui.pantallas;

import com.porfirio.fraccionando.gui.listeners.CreacionFraccionListener;
import com.porfirio.fraccionando.controladores.ControladorOperacion;
import com.porfirio.fraccionando.dominio.utils.Constantes;
import com.porfirio.fraccionando.latex.LatexRender;
import com.porfirio.fraccionando.main.Configuracion;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ItemEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private ControladorOperacion controlador;
    private final JButton[] botonesOperacionesBasicas;

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        iniciarGUI();
        botonesOperacionesBasicas = new JButton[]{
            jButtonMas, jButtonMenos, jButtonPor, jButtonEntre
        };
        controlador = new ControladorOperacion(jLabelOperacion, jPanelPasos,
                fraccionPanel, botonesOperacionesBasicas,
                jButtonResolverOperacion, jButtonReiniciarOperacion);
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

        buttonGroupTemas = new javax.swing.ButtonGroup();
        buttonGroupIdiomas = new javax.swing.ButtonGroup();
        buttonGroupExplicaciones = new javax.swing.ButtonGroup();
        jPanelFondoOscuro = new javax.swing.JPanel();
        jPanelFondoClaro = new javax.swing.JPanel();
        jPanelVista = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPanePasos = new javax.swing.JScrollPane();
        jPanelPasos = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPaneEntrada = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabelOperacion = new javax.swing.JLabel();
        jPanelDerecho = new javax.swing.JPanel();
        jScrollPaneCalculadora = new javax.swing.JScrollPane();
        jPanelCalculadora = new javax.swing.JPanel();
        fraccionPanel = new com.porfirio.fraccionando.gui.componentes.FraccionPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonMas = new javax.swing.JButton();
        jButtonMenos = new javax.swing.JButton();
        jButtonPor = new javax.swing.JButton();
        jButtonEntre = new javax.swing.JButton();
        jButtonEquivalentes = new javax.swing.JButton();
        jButtonReciprocas = new javax.swing.JButton();
        jButtonMayor = new javax.swing.JButton();
        jButtonSimplificar = new javax.swing.JButton();
        jButtonCam = new javax.swing.JButton();
        jButtonCai = new javax.swing.JButton();
        jButtonMcm = new javax.swing.JButton();
        jButtonMcd = new javax.swing.JButton();
        jPanelEnvio = new javax.swing.JPanel();
        jButtonResolverOperacion = new javax.swing.JButton();
        jButtonReiniciarOperacion = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jmItemNuevo = new javax.swing.JMenuItem();
        jmItemGuardar = new javax.swing.JMenuItem();
        jmItemSalir = new javax.swing.JMenuItem();
        jMenuPreferencias = new javax.swing.JMenu();
        jMenuTema = new javax.swing.JMenu();
        jrbItemAzul = new javax.swing.JRadioButtonMenuItem();
        jrbItemAmarillo = new javax.swing.JRadioButtonMenuItem();
        jrbItemRosa = new javax.swing.JRadioButtonMenuItem();
        jrbItemRojo = new javax.swing.JRadioButtonMenuItem();
        jrbItemMorado = new javax.swing.JRadioButtonMenuItem();
        jMenuIdioma = new javax.swing.JMenu();
        jrbItemEspanol = new javax.swing.JRadioButtonMenuItem();
        jrbItemIngles = new javax.swing.JRadioButtonMenuItem();
        jMenuExplicacion = new javax.swing.JMenu();
        jrbItemSimple = new javax.swing.JRadioButtonMenuItem();
        jrbItemDetallada = new javax.swing.JRadioButtonMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jmItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fraccionando");
        setIconImage(new ImageIcon(getClass().getResource("/com/porfirio/fraccionando/resources/images/Icono256.png")).getImage());
        setSize(new java.awt.Dimension(1000, 562));

        jPanelFondoOscuro.setBackground(Configuracion.colorOscuro);
        jPanelFondoOscuro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelFondoOscuro.setLayout(new java.awt.BorderLayout());

        jPanelFondoClaro.setBackground(Configuracion.colorClaro);
        jPanelFondoClaro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelFondoClaro.setLayout(new java.awt.BorderLayout());

        jPanelVista.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVista.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelVista.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));
        jPanel1.setToolTipText("En esta área se muestra el resultado de la operación");
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(482, 150));
        jPanelVista.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Explicación"));
        jPanel3.setToolTipText("En esta área se muestran los pasos de la explicación");
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanelPasos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanelPasos.setOpaque(false);
        jPanelPasos.setLayout(new java.awt.BorderLayout());

        jButton1.setText("jButton1");
        jButton1.setPreferredSize(new java.awt.Dimension(81, 1000));
        jPanelPasos.add(jButton1, java.awt.BorderLayout.CENTER);

        jScrollPanePasos.setViewportView(jPanelPasos);

        jPanel3.add(jScrollPanePasos, java.awt.BorderLayout.CENTER);

        jPanelVista.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Entrada"));
        jPanel4.setToolTipText("En esta área se muestra la operación que se está ingresando");
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(482, 150));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPaneEntrada.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 20, 0));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        jPanel6.add(jLabelOperacion);

        jScrollPaneEntrada.setViewportView(jPanel6);

        jPanel4.add(jScrollPaneEntrada);

        jPanelVista.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanelFondoClaro.add(jPanelVista, java.awt.BorderLayout.CENTER);

        jPanelDerecho.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanelDerecho.setOpaque(false);
        jPanelDerecho.setLayout(new java.awt.BorderLayout());

        jScrollPaneCalculadora.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneCalculadora.setRequestFocusEnabled(false);

        jPanelCalculadora.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 20));
        jPanelCalculadora.setOpaque(false);
        jPanelCalculadora.setLayout(new javax.swing.BoxLayout(jPanelCalculadora, javax.swing.BoxLayout.Y_AXIS));
        jPanelCalculadora.add(fraccionPanel);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButtonMas.setText("+");
        jButtonMas.setToolTipText("Agrega una suma");
        jButtonMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonMas, gridBagConstraints);

        jButtonMenos.setText("-");
        jButtonMenos.setToolTipText("Agrega una resta");
        jButtonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonMenos, gridBagConstraints);

        jButtonPor.setText("*");
        jButtonPor.setToolTipText("Agrega una multiplicación");
        jButtonPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonPor, gridBagConstraints);

        jButtonEntre.setText("÷");
        jButtonEntre.setToolTipText("Agrega una división");
        jButtonEntre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntreActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonEntre, gridBagConstraints);

        jButtonEquivalentes.setText("Equivalentes");
        jButtonEquivalentes.setToolTipText("Determina si dos fracciones son equivalentes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonEquivalentes, gridBagConstraints);

        jButtonReciprocas.setText("Recíprocas");
        jButtonReciprocas.setToolTipText("Determina si dos fracciones son recíprocas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonReciprocas, gridBagConstraints);

        jButtonMayor.setText("Mayor");
        jButtonMayor.setToolTipText("Determina la mayor de dos fracciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonMayor, gridBagConstraints);

        jButtonSimplificar.setText("Simplificar");
        jButtonSimplificar.setToolTipText("Simplifica una fracción");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonSimplificar, gridBagConstraints);

        jButtonCam.setText("C.A.M.");
        jButtonCam.setToolTipText("Convierte una fracción impropia en mixta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonCam, gridBagConstraints);

        jButtonCai.setText("C.A.I.");
        jButtonCai.setToolTipText("Convierte una fracción mixta en impropia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonCai, gridBagConstraints);

        jButtonMcm.setText("M.C.M.");
        jButtonMcm.setToolTipText("Calcula el Mínimo Común Múltiplo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonMcm, gridBagConstraints);

        jButtonMcd.setText("M.C.D.");
        jButtonMcd.setToolTipText("Calcula el Máximo Común Divisor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jButtonMcd, gridBagConstraints);

        jPanelCalculadora.add(jPanel2);

        jScrollPaneCalculadora.setViewportView(jPanelCalculadora);

        jPanelDerecho.add(jScrollPaneCalculadora, java.awt.BorderLayout.CENTER);

        jPanelEnvio.setOpaque(false);
        jPanelEnvio.setPreferredSize(new java.awt.Dimension(81, 100));
        jPanelEnvio.setLayout(new java.awt.GridLayout(2, 1));

        jButtonResolverOperacion.setText("Resolver");
        jButtonResolverOperacion.setToolTipText("Resuelve la operación ingresada");
        jButtonResolverOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResolverOperacionActionPerformed(evt);
            }
        });
        jPanelEnvio.add(jButtonResolverOperacion);

        jButtonReiniciarOperacion.setText("Reiniciar");
        jButtonReiniciarOperacion.setToolTipText("Reinicia la operación ingresada");
        jButtonReiniciarOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarOperacionActionPerformed(evt);
            }
        });
        jPanelEnvio.add(jButtonReiniciarOperacion);

        jPanelDerecho.add(jPanelEnvio, java.awt.BorderLayout.SOUTH);

        jPanelFondoClaro.add(jPanelDerecho, java.awt.BorderLayout.EAST);

        jPanelFondoOscuro.add(jPanelFondoClaro, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanelFondoOscuro, java.awt.BorderLayout.CENTER);

        jMenuArchivo.setText("Archivo");

        jmItemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmItemNuevo.setText("Nuevo");
        jMenuArchivo.add(jmItemNuevo);

        jmItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jmItemGuardar.setText("Guardar");
        jMenuArchivo.add(jmItemGuardar);

        jmItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmItemSalir.setText("Salir");
        jMenuArchivo.add(jmItemSalir);

        jMenuBar.add(jMenuArchivo);

        jMenuPreferencias.setText("Preferencias");

        jMenuTema.setText("Tema");

        buttonGroupTemas.add(jrbItemAzul);
        jrbItemAzul.setSelected(true);
        jrbItemAzul.setText("Azul");
        jrbItemAzul.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbItemAzulItemStateChanged(evt);
            }
        });
        jMenuTema.add(jrbItemAzul);

        buttonGroupTemas.add(jrbItemAmarillo);
        jrbItemAmarillo.setText("Amarillo");
        jrbItemAmarillo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbItemAmarilloItemStateChanged(evt);
            }
        });
        jMenuTema.add(jrbItemAmarillo);

        buttonGroupTemas.add(jrbItemRosa);
        jrbItemRosa.setText("Rosa");
        jrbItemRosa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbItemRosaItemStateChanged(evt);
            }
        });
        jMenuTema.add(jrbItemRosa);

        buttonGroupTemas.add(jrbItemRojo);
        jrbItemRojo.setText("Rojo");
        jrbItemRojo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbItemRojoItemStateChanged(evt);
            }
        });
        jMenuTema.add(jrbItemRojo);

        buttonGroupTemas.add(jrbItemMorado);
        jrbItemMorado.setText("Morado");
        jrbItemMorado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbItemMoradoItemStateChanged(evt);
            }
        });
        jMenuTema.add(jrbItemMorado);

        jMenuPreferencias.add(jMenuTema);

        jMenuIdioma.setText("Idioma");

        buttonGroupIdiomas.add(jrbItemEspanol);
        jrbItemEspanol.setSelected(true);
        jrbItemEspanol.setText("Español");
        jrbItemEspanol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbItemEspanolItemStateChanged(evt);
            }
        });
        jMenuIdioma.add(jrbItemEspanol);

        buttonGroupIdiomas.add(jrbItemIngles);
        jrbItemIngles.setText("Inglés");
        jrbItemIngles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbItemInglesItemStateChanged(evt);
            }
        });
        jMenuIdioma.add(jrbItemIngles);

        jMenuPreferencias.add(jMenuIdioma);

        jMenuExplicacion.setText("Explicación");

        buttonGroupExplicaciones.add(jrbItemSimple);
        jrbItemSimple.setText("Simple");
        jrbItemSimple.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbItemSimpleItemStateChanged(evt);
            }
        });
        jMenuExplicacion.add(jrbItemSimple);

        buttonGroupExplicaciones.add(jrbItemDetallada);
        jrbItemDetallada.setSelected(true);
        jrbItemDetallada.setText("Detallada");
        jrbItemDetallada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbItemDetalladaItemStateChanged(evt);
            }
        });
        jMenuExplicacion.add(jrbItemDetallada);

        jMenuPreferencias.add(jMenuExplicacion);

        jMenuBar.add(jMenuPreferencias);

        jMenuAyuda.setText("Ayuda");

        jmItemAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jmItemAcercaDe.setText("Acerca de...");
        jmItemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemAcercaDeActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jmItemAcercaDe);

        jMenuBar.add(jMenuAyuda);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbItemAzulItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbItemAzulItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cambiarTema(Constantes.tAzul);
        }
    }//GEN-LAST:event_jrbItemAzulItemStateChanged

    private void jrbItemAmarilloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbItemAmarilloItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cambiarTema(Constantes.tAmarillo);
        }
    }//GEN-LAST:event_jrbItemAmarilloItemStateChanged

    private void jrbItemRosaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbItemRosaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cambiarTema(Constantes.tRosa);
        }
    }//GEN-LAST:event_jrbItemRosaItemStateChanged

    private void jrbItemRojoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbItemRojoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cambiarTema(Constantes.tRojo);
        }
    }//GEN-LAST:event_jrbItemRojoItemStateChanged

    private void jrbItemMoradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbItemMoradoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cambiarTema(Constantes.tMorado);
        }
    }//GEN-LAST:event_jrbItemMoradoItemStateChanged

    private void jrbItemEspanolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbItemEspanolItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cambiarIdioma(Constantes.iEspanol);
        }
    }//GEN-LAST:event_jrbItemEspanolItemStateChanged

    private void jrbItemInglesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbItemInglesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cambiarIdioma(Constantes.iIngles);
        }
    }//GEN-LAST:event_jrbItemInglesItemStateChanged

    private void jrbItemSimpleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbItemSimpleItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cambiarExplicacion(Constantes.ePocoDetallado);
        }
    }//GEN-LAST:event_jrbItemSimpleItemStateChanged

    private void jrbItemDetalladaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbItemDetalladaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cambiarExplicacion(Constantes.eMuyDetallado);
        }
    }//GEN-LAST:event_jrbItemDetalladaItemStateChanged

    private void jButtonResolverOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResolverOperacionActionPerformed
        controlador.resolverOperacion();
    }//GEN-LAST:event_jButtonResolverOperacionActionPerformed

    private void jmItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemAcercaDeActionPerformed
        new DialogoAcercaDe(this, true).setVisible(true);
    }//GEN-LAST:event_jmItemAcercaDeActionPerformed

    private void jButtonReiniciarOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarOperacionActionPerformed
        JOptionPane.showMessageDialog(PantallaPrincipal.this,
                "Voy a reiniciar la operación");
    }//GEN-LAST:event_jButtonReiniciarOperacionActionPerformed

    private void jButtonMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMasActionPerformed
        controlador.agregarFraccion('+');
    }//GEN-LAST:event_jButtonMasActionPerformed

    private void jButtonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosActionPerformed
        controlador.agregarFraccion('-');
    }//GEN-LAST:event_jButtonMenosActionPerformed

    private void jButtonPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPorActionPerformed
        controlador.agregarFraccion('*');
    }//GEN-LAST:event_jButtonPorActionPerformed

    private void jButtonEntreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntreActionPerformed
        controlador.agregarFraccion('÷');
    }//GEN-LAST:event_jButtonEntreActionPerformed

    /**
     * Cambia el tema de la aplicacion, mandado llamar al momento de elegir una
     * opcion del menu de temas.
     *
     * @param tema Es el nombre del tema a ser colocado.
     */
    private void cambiarTema(String tema) {
        if (!Configuracion.getPropertyValue(Constantes.cTema).equals(tema)) {
            Configuracion.setTema(tema);
            jPanelFondoOscuro.setBackground(Configuracion.colorOscuro);
            jPanelFondoClaro.setBackground(Configuracion.colorClaro);
        }
    }

    /**
     * Cambia el idioma de la aplicacion, mandado llamar al momento de elegir
     * una opcion del menu de idiomas.
     *
     * @param idioma Es el nombre del idioma a ser colocado.
     */
    private void cambiarIdioma(String idioma) {
        // Se evalua para que no haga nada al iniciar la aplicacion.
        if (!Configuracion.getPropertyValue(Constantes.cIdioma).equals(idioma)) {
            int respuesta = JOptionPane.showConfirmDialog(PantallaPrincipal.this,
                    "Para ver los cambios debes reiniciar Fraccionando, lo cual borrará los datos de tu área de trabajo. ¿Deseas reiniciarlo ahora?",
                    "Confirmacion", JOptionPane.YES_NO_CANCEL_OPTION);

            if (respuesta != JOptionPane.CANCEL_OPTION) {
                Configuracion.setIdioma(idioma);

                if (respuesta == JOptionPane.YES_OPTION) {
                    PantallaPrincipal.main(new String[]{});
                    dispose();
                }
            }
        }
    }

    /**
     * Cambia el nivel de explicacion de las operaciones, mandado llamar al
     * momento de elegir una opcion del menu de explicaciones.
     *
     * @param explicacion Es el nombre del nivel de explicacion a ser
     * establecido.
     */
    private void cambiarExplicacion(String explicacion) {
        // Se evalua para que no haga nada al iniciar la aplicacion.
        if (!Configuracion.getPropertyValue(Constantes.cExplicacion).equals(explicacion)) {
            Configuracion.setNivelExplicacion(explicacion);

            JOptionPane.showMessageDialog(PantallaPrincipal.this,
                    "Los cambios en el nivel de detalle de la explicación se verán hasta la próxima vez que se resuelva una operación.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupExplicaciones;
    private javax.swing.ButtonGroup buttonGroupIdiomas;
    private javax.swing.ButtonGroup buttonGroupTemas;
    private com.porfirio.fraccionando.gui.componentes.FraccionPanel fraccionPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCai;
    private javax.swing.JButton jButtonCam;
    private javax.swing.JButton jButtonEntre;
    private javax.swing.JButton jButtonEquivalentes;
    private javax.swing.JButton jButtonMas;
    private javax.swing.JButton jButtonMayor;
    private javax.swing.JButton jButtonMcd;
    private javax.swing.JButton jButtonMcm;
    private javax.swing.JButton jButtonMenos;
    private javax.swing.JButton jButtonPor;
    private javax.swing.JButton jButtonReciprocas;
    private javax.swing.JButton jButtonReiniciarOperacion;
    private javax.swing.JButton jButtonResolverOperacion;
    private javax.swing.JButton jButtonSimplificar;
    private javax.swing.JLabel jLabelOperacion;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuExplicacion;
    private javax.swing.JMenu jMenuIdioma;
    private javax.swing.JMenu jMenuPreferencias;
    private javax.swing.JMenu jMenuTema;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelCalculadora;
    private javax.swing.JPanel jPanelDerecho;
    private javax.swing.JPanel jPanelEnvio;
    private javax.swing.JPanel jPanelFondoClaro;
    private javax.swing.JPanel jPanelFondoOscuro;
    private javax.swing.JPanel jPanelPasos;
    private javax.swing.JPanel jPanelVista;
    private javax.swing.JScrollPane jScrollPaneCalculadora;
    private javax.swing.JScrollPane jScrollPaneEntrada;
    private javax.swing.JScrollPane jScrollPanePasos;
    private javax.swing.JMenuItem jmItemAcercaDe;
    private javax.swing.JMenuItem jmItemGuardar;
    private javax.swing.JMenuItem jmItemNuevo;
    private javax.swing.JMenuItem jmItemSalir;
    private javax.swing.JRadioButtonMenuItem jrbItemAmarillo;
    private javax.swing.JRadioButtonMenuItem jrbItemAzul;
    private javax.swing.JRadioButtonMenuItem jrbItemDetallada;
    private javax.swing.JRadioButtonMenuItem jrbItemEspanol;
    private javax.swing.JRadioButtonMenuItem jrbItemIngles;
    private javax.swing.JRadioButtonMenuItem jrbItemMorado;
    private javax.swing.JRadioButtonMenuItem jrbItemRojo;
    private javax.swing.JRadioButtonMenuItem jrbItemRosa;
    private javax.swing.JRadioButtonMenuItem jrbItemSimple;
    // End of variables declaration//GEN-END:variables

    /**
     * Cambia el tipo de fuente recursivamente a todos los elementos que se
     * encuentran dentro de un contenedor, que puede ser un JPanel, un JMenuBar
     * o un JMenu.
     *
     * @param contenedor Es el contenedor de donde se extraeran los elementos
     * para cambiar la fuente.
     */
    static void cambiarLetraHijos(JComponent contenedor) {
        Component[] componentes;

        if (contenedor instanceof JMenu) {
            componentes = ((JMenu) contenedor).getMenuComponents();
        } else {
            componentes = contenedor.getComponents();
        }

        if (componentes.length > 0) {
            for (Component c : componentes) {
                if (c instanceof JMenuBar || c instanceof JMenu
                        || c instanceof JPanel) {
                    cambiarLetraHijos((JComponent) c);
                } else if (c instanceof JScrollPane) {
                    Component comp
                            = ((JScrollPane) c).getViewport().getComponent(0);
                    cambiarLetraHijos((JComponent) comp);
                }

                if (c instanceof JPanel) {
                    Border b = ((JPanel) c).getBorder();

                    if (b instanceof TitledBorder) {
                        ((TitledBorder) b).setTitleFont(generarFont((JComponent) c, 20));
                    }

                }

                c.setFont(generarFont((JComponent) c, 20));
            }
        } else {
            System.err.println("NO COMPONENTES DENTRO DE: " + contenedor.getClass());
        }
    }

    /**
     * Genera una fuente a partir de un JComponent, con el tamano de letra
     * indicado.
     *
     * @param componente Es el componente del cual se obtendra su fuente por
     * default.
     * @param size Es el tamano deseado para la fuente.
     * @return La fuente con las caracteristicas deseadas.
     */
    private static Font generarFont(JComponent componente, int size) {
        String name = componente.getFont().getFontName();
        int style = componente.getFont().getStyle();
        return new Font(name, style, size);
    }

    /**
     * Inicializa aspectos de la gui, que no se pueden colocar en el metodo
     * initComponents.
     */
    private void iniciarGUI() {
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        cambiarLetraHijos(jMenuBar);
        cambiarLetraHijos(jPanelFondoClaro);

        jScrollPaneCalculadora.getVerticalScrollBar().setUnitIncrement(15);
        jScrollPaneCalculadora.setBorder(BorderFactory.createEmptyBorder());
        jScrollPaneCalculadora.getViewport().setOpaque(false);
        jScrollPaneCalculadora.setViewportBorder(BorderFactory.createEmptyBorder());

        jScrollPanePasos.getVerticalScrollBar().setUnitIncrement(15);
        jScrollPanePasos.setBorder(BorderFactory.createEmptyBorder());
        jScrollPanePasos.getViewport().setOpaque(false);
        jScrollPanePasos.setViewportBorder(BorderFactory.createEmptyBorder());

        jScrollPaneEntrada.getHorizontalScrollBar().setUnitIncrement(15);
        jScrollPaneEntrada.setBorder(BorderFactory.createEmptyBorder());
        jScrollPaneEntrada.getViewport().setOpaque(false);
        jScrollPaneEntrada.setViewportBorder(BorderFactory.createEmptyBorder());

        seleccionarOpcionesGuardadasMenu();

        fraccionPanel.setCreacionFraccionListener(new CreacionFraccionListener() {
            @Override
            public void onFraccionUpdated() {
                controlador.actualizarFraccion();
            }

            @Override
            public void onFraccionRemoved() {
                controlador.actualizarOperacion();
            }

            @Override
            public void onFraccionReseted() {
                controlador.actualizarOperacion();
            }
        });
    }

    /**
     * Selecciona las opciones guardadas en las preferencias en los elementos de
     * la barra de menus.
     */
    private void seleccionarOpcionesGuardadasMenu() {
        String tema = Configuracion.getPropertyValue(Constantes.cTema);

        switch (tema) {
            case Constantes.tAmarillo:
                jrbItemAmarillo.setSelected(true);
                break;
            case Constantes.tMorado:
                jrbItemMorado.setSelected(true);
                break;
            case Constantes.tRojo:
                jrbItemRojo.setSelected(true);
                break;
            case Constantes.tRosa:
                jrbItemRosa.setSelected(true);
                break;
            default:
                jrbItemAzul.setSelected(true);
        }

        String idioma = Configuracion.getPropertyValue(Constantes.cIdioma);

        switch (idioma) {
            case Constantes.iIngles:
                jrbItemIngles.setSelected(true);
                break;
            default:
                jrbItemEspanol.setSelected(true);
        }

        String explicacion = Configuracion
                .getPropertyValue(Constantes.cExplicacion);

        switch (explicacion) {
            case Constantes.ePocoDetallado:
                jrbItemSimple.setSelected(true);
                break;
            default:
                jrbItemDetallada.setSelected(true);
        }
    }

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        UIManager.put("OptionPane.messageFont", generarFont(new JLabel(), 20));
        UIManager.put("OptionPane.buttonFont", generarFont(new JButton(), 20));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }
}
