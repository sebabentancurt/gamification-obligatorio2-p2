/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification.views;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

/**
 *
 * @author Mateo Sapiurka 211096
 * @author Sebastián Bentancurt 225768
 */
public final class VentanaMemory extends javax.swing.JFrame {

    private HashMap<String, String> preguntas = new HashMap<>();
    private String[] preguntasOrdenadas = new String[12];
    private String[] preguntasDesordenadas = new String[12];
    private String[][] textos = new String[3][4];
    private String[][] tipos = new String[3][4];
    private boolean[][] activos = new boolean[3][4];
    private JButton[][] botones;
    private boolean ayudaParcial = false;
    private boolean ayudaTotal = false;
    private int[] seleccion1 = new int[2];
    private int[] seleccion2 = new int[2];
    private boolean preseleccion = false;
    private int puntaje = 0;

    private boolean sound = false;
    private Clip clip;

    /**
     * Creates new form VentanaMemory
     *
     * @param titulo
     * @param preguntasSinFiltrar
     */
    public VentanaMemory(String titulo, HashMap<String, String> preguntasSinFiltrar) {
        this.setTitle(titulo);
        cargarSonido();
        this.filtrarPreguntas(preguntasSinFiltrar);
        setPreguntasOrdenadas(preguntas);
        preguntasDesordenadas = desordenarPreguntas(preguntasOrdenadas);
        initComponents();
        crearBotones();
        actualizarTablero();
    }

    //toma las preguntas ordenadas del HashMap y las ordena formato Pregunta - Reespuesta en Array
    public void setPreguntasOrdenadas(HashMap<String, String> preguntasSinFiltrar) {
        int index = 0;
        for (Map.Entry<String, String> entry : preguntasSinFiltrar.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            preguntasOrdenadas[index] = (String) key;
            index++;
            preguntasOrdenadas[index] = (String) val;
            index++;
        }
    }

    //Desordena las preguntas aleatoriamente
    public String[] desordenarPreguntas(String[] preguntasOrdenadas) {
        String[] ar = preguntasOrdenadas.clone();
        Random rnd = new Random();

        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }

        return ar;
    }

    //De todas las preguntas de los temas selecionados selecciona 6 aleatoriamente
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
        int index = 0;
        int cantFilas = 3;
        int cantColumnas = 4;
        botones = new JButton[cantFilas][cantColumnas];
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < cantColumnas; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                panelInferior.add(jButton);
                botones[i][j] = jButton;

                textos[i][j] = preguntasDesordenadas[index]; //agrega el texto a la matriz paralela
                index++;

                String tipo;
                //agrega texto de tipo en matriz paralela
                if (preguntas.containsKey(textos[i][j])) {
                    tipo = "PREGUNTA";
                    botones[i][j].setForeground(Color.BLUE);
                } else {
                    tipo = "RESPUESTA";
                    botones[i][j].setForeground(Color.RED);
                }
                tipos[i][j] = tipo;

                botones[i][j].setMargin(new Insets(-5, -5, -5, -5));
            }
        }
    }

    public void actualizarTablero() {
        actualizarPuntaje();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (ayudaTotal) {
                    botones[i][j].setText(textos[i][j]); // muestra respuesta
                } else if (ayudaParcial) {
                    botones[i][j].setText(tipos[i][j]); // muestra tipos
                } else {
                    if (activos[i][j]) {
                        botones[i][j].setText(textos[i][j]); // muestra los ya matcheados
                    } else {
                        botones[i][j].setText("");
                    }
                }
            }
        }
    }

    public void actualizarPuntaje() {
        lblPuntaje.setText("Puntaje: " + puntaje);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        btnAyudaParcial.setText("Ayuda Parcial");
        btnAyudaParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaParcialActionPerformed(evt);
            }
        });
        panelSuperior.add(btnAyudaParcial);

        btnAyudaTotal.setText("Ayuda Total");
        btnAyudaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaTotalActionPerformed(evt);
            }
        });
        panelSuperior.add(btnAyudaTotal);

        btnText.setText("Reset");
        btnText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTextActionPerformed(evt);
            }
        });
        panelSuperior.add(btnText);

        btnSonido.setText("Sonido");
        btnSonido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonidoActionPerformed(evt);
            }
        });
        panelSuperior.add(btnSonido);
        btnSonido.getAccessibleContext().setAccessibleDescription("");

        lblPuntaje.setText("Puntaje: ---");
        panelSuperior.add(lblPuntaje);

        getContentPane().add(panelSuperior);

        panelInferior.setLayout(new java.awt.GridLayout(3, 4));
        getContentPane().add(panelInferior);

        setBounds(0, 0, 414, 337);
    }// </editor-fold>//GEN-END:initComponents

    private void cargarSonido() {

        try {
            clip = AudioSystem.getClip();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            File file = new File("./src/gamification/resources/melodyloop.wav");
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            clip.open(inputStream);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private void btnSonidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonidoActionPerformed
        // TODO add your handling code here:
        if (!sound) {
            clip.start();
            sound = true;
        } else {
            clip.stop();
            sound = false;
        }

    }//GEN-LAST:event_btnSonidoActionPerformed

    private void btnAyudaParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaParcialActionPerformed
        // TODO add your handling code here:
        ayudaParcial = !ayudaParcial;
        actualizarTablero();
    }//GEN-LAST:event_btnAyudaParcialActionPerformed

    private void btnAyudaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaTotalActionPerformed
        // TODO add your handling code here:
        ayudaTotal = !ayudaTotal;
        actualizarTablero();
    }//GEN-LAST:event_btnAyudaTotalActionPerformed

    private void btnTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTextActionPerformed
        // TODO add your handling code here:
        ayudaTotal = false;
        ayudaParcial = false;
        actualizarTablero();
    }//GEN-LAST:event_btnTextActionPerformed

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

        private int x;
        private int y;

        public ListenerBoton(int fila, int col) {
            // en el constructor se almacena la fila y columna que se presion�
            x = fila;
            y = col;
        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un bot�n, se ejecutar� este m�todo
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int col) {
        // M�todo a completar!.
        // En fila y columna se reciben las coordenas donde presion� el usuario, relativas al comienzo de la grilla
        // fila 0 y columna 0 corresponden a la posici�n de arriba a la izquierda.
        // Debe indicarse c�mo responder al click de ese bot�n.
        botones[fila][col].setText(textos[fila][col]); // muestra texto
        if (!preseleccion) { //primera carta
            seleccion1[0] = fila;
            seleccion1[1] = col;
            preseleccion = true;
        } else { // segunda carta
            seleccion2[0] = fila; 
            seleccion2[1] = col;
            preseleccion = false; //termina turno

            checkMatch(); // verifica

        }
    }

    private void checkMatch() {
        String card1 = textos[seleccion1[0]][seleccion1[1]];
        String card2 = textos[seleccion2[0]][seleccion2[1]];
        boolean match = false;

        for (Map.Entry<String, String> entry : preguntas.entrySet()) {
            Object key = (String) entry.getKey();
            Object val = (String) entry.getValue();

            if ((card1.equals(key) && card2.equals(val)) || (card1.equals(val) && card2.equals(key))) { //chequea si efectivamente las cartas son match
                match = true;
                activos[seleccion1[0]][seleccion1[1]] = true;
                activos[seleccion2[0]][seleccion2[1]] = true;
            }
        }
        //puntaje
        if (match) {
            puntaje += 50;
        } else {
            puntaje -= 10;
            JOptionPane.showMessageDialog(rootPane, "Match incorrecto: resta 10 puntos", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
        actualizarTablero();
    }

}
