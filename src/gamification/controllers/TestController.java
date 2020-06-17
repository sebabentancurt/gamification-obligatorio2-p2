/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification.controllers;

import gamification.domain.Tema;
import gamification.views.AddQuestion;
import gamification.views.Dashboard;
import gamification.views.questions.Agregar;
import gamification.views.questions.Listar;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sebab
 */
public class TestController {
    
    public static Boolean testAgregarPregunta(){
        Tema tema = new Tema("seba", "desca");
        JFrame panel = new Agregar(tema); 
        panel.setVisible(true);
        return true;
    }
    
    public static Boolean testListarPreguntas(){
        Tema tema = new Tema("seba", "desca");
        tema.agregarPregunta("Prueba", "Respuesta");
        JFrame panel = new Listar(tema); 
        panel.setVisible(true);
        return true;
    }

}
