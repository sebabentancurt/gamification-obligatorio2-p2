/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification;

import gamification.domain.Sistema;
import gamification.domain.Tema;
import gamification.helpers.ArchivoGrabacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebab
 */
public class TemaControlador {

    public static ArrayList<Integer> importarTemas(Sistema sistema, ArrayList<List> array, int lineasPregunta) {

        int ignoradas = 0;
        int agregadas = 0;
        int modificadas = 0;

        for (List list : array) {
            if (list.size() != lineasPregunta) {
                ignoradas++;
                continue;
            }
            String tema = (String) list.get(0);
            String pregunta = (String) list.get(1);
            String respuesta = (String) list.get(2);
            Tema temaDomain = new Tema(tema, "A COMPLETAR");

            if (sistema.existeTema(temaDomain)) {
                modificadas++;
            } else {
                agregadas++;
            }
            temaDomain = sistema.agregarTema(temaDomain);
            temaDomain.agregarPregunta(pregunta, respuesta);
        }

        ArrayList<Integer> resultado = new ArrayList<>();
        resultado.add(ignoradas);
        resultado.add(agregadas);
        resultado.add(modificadas);
        return resultado;
    }

    public static boolean exportarTemas(Sistema sistema, String absolutePath) {

        ArchivoGrabacion grab = new ArchivoGrabacion(absolutePath);
        for (Tema tema : sistema.getListaTemas()) {
            ArrayList<String> listarPreguntas = tema.listarPreguntas();
            for (String pregunta : listarPreguntas) {
                grab.grabarLinea(tema.getNombre());
                grab.grabarLinea(pregunta);
                grab.grabarLinea(tema.getRespuesta(pregunta));
            }
        }
        grab.cerrar();
        return true;
    }

}
