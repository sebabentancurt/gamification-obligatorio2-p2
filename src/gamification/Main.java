/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification;

import gamification.domain.Sistema;
import gamification.domain.Tema;
import gamification.views.*;
import java.util.*;

/**
 *
 * @author sebab
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Sistema s = new Sistema();
        Tema tema = new Tema();
        Tema agregarTema = s.agregarTema(tema);
        ArrayList<String> preguntas = new ArrayList();
        ArrayList<String> respuestas = new ArrayList();

        preguntas.add("HOLA");
        respuestas.add("CHAU");

        preguntas.add("1");
        respuestas.add("2");

        preguntas.add("pregunta");
        respuestas.add("respuesta");

        VentanaFlashCards v = new VentanaFlashCards(preguntas, respuestas);
        //v.setVisible(true);

        Menu ve = new Menu();
        ve.setVisible(true);
    }

}
