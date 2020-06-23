/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification;

import gamification.domain.Sistema;
import gamification.domain.Tema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebab
 */
public class TemaControlador {

    public static void importarTemas(Sistema sistema, ArrayList<List> array) {

        for (List list : array) {
            String tema = (String) list.get(0);
            String pregunta = (String) list.get(1);
            String respuesta = (String) list.get(2);
            Tema temaDomain = new Tema(tema, "A COMPLETAR");
            temaDomain = sistema.agregarTema(temaDomain);
            temaDomain.agregarPregunta(pregunta, respuesta);
        }
    }

}
