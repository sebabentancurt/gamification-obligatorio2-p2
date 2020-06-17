/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification.controllers;

import gamification.domain.Tema;

/**
 *
 * @author sebab
 */
public class TemaController {
    
   public static boolean createAnswerQuestion(Tema theme,String question,String answer) {
        try {
            return theme.agregarPregunta(question,answer);
        } catch (Exception e) {
            return false;
        }
    }
}
