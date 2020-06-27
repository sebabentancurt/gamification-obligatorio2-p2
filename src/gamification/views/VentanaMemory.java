/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification.views;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author Mateo
 */
public final class VentanaMemory extends javax.swing.JFrame {

    private HashMap<String, String> preguntas;

    //private HashMap<String, String> preguntas;
    private JButton[][] botones;

    /**
     * Creates new form VentanaMemory
     *
     * @param titulo
     * @param preguntasSinFiltrar
     */
    public VentanaMemory(String titulo, HashMap<String, String> preguntasSinFiltrar) {
        this.filtrarPreguntas(preguntasSinFiltrar);
        initComponents();
        crearBotones();
    }

    public void filtrarPreguntas(HashMap<String, String> preguntasSinFiltrar) {
        Set<String> keySet = preguntasSinFiltrar.keySet();
        ArrayList<String> keys = new ArrayList<>(keySet);

        Random r = new Random();

        for (int i = 0; i < 6; i++) {
            int randomNumber = r.nextInt(keys.size());
            String pregunta = keys.get(randomNumber);
            keys.remove(pregunta);
            this.preguntas.put(pregunta, preguntasSinFiltrar.get(pregunta));
        }
    }

    public void crearBotones() {
        int cantFilas = 3;
        int cantColumnas = 4;
        botones = new JButton[cantFilas][cantColumnas];
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < cantColumnas; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton("pregunta", "Texto de pregunta"));
                panelInferior.add(jButton);
                botones[i][j] = jButton;

                botones[i][j].setMargin(new Insets(-5, -5, -5, -5));
                botones[i][j].setBackground(Color.RED);
                botones[i][j].setText("<html><p>" + "BOTON" + "</p></html>");

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        btnAyudaParcial = new javax.swing.JButton();
        btnAyudaTotal = new javax.swing.JButton();
        btnText = new javax.swing.JButton();
        btnSonido = new javax.swing.JButton();
        lblPuntaje = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        btnAyudaParcial.setText("Ayuda Parcial");
        panelSuperior.add(btnAyudaParcial);

        btnAyudaTotal.setText("Ayuda Total");
        panelSuperior.add(btnAyudaTotal);

        btnText.setText("Reset");
        panelSuperior.add(btnText);

        btnSonido.setText("Sonido");
        panelSuperior.add(btnSonido);

        lblPuntaje.setText("Puntaje: ---");
        panelSuperior.add(lblPuntaje);

        getContentPane().add(panelSuperior);

        panelInferior.setLayout(new java.awt.GridLayout(3, 4));
        getContentPane().add(panelInferior);

        setBounds(0, 0, 414, 337);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentanaMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(String titulo, HashMap preguntas) {
                new VentanaMemory(titulo, preguntas).setVisible(true);
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyudaParcial;
    private javax.swing.JButton btnAyudaTotal;
    private javax.swing.JButton btnSonido;
    private javax.swing.JButton btnText;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables

    private class ListenerBoton implements ActionListener {

        private String tipo;
        private String pregunta;

        public ListenerBoton(String tipo, String pregunta) {
            // en el constructor se almacena la fila y columna que se presionó
            this.tipo = tipo;
            this.pregunta = pregunta;
        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método
            clickBoton(tipo, pregunta);
        }
    }

    private void clickBoton(String tipo, String pregunta) {
        // Método a completar!.
        // En fila y columna se reciben las coordenas donde presionó el usuario, relativas al comienzo de la grilla
        // fila 0 y columna 0 corresponden a la posición de arriba a la izquierda.
        // Debe indicarse cómo responder al click de ese botón.

    }
}
