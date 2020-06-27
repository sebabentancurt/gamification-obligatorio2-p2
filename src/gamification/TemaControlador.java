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
 * @author Mateo Sapiurka 211096
 * @author Sebastián Bentancurt 225768
 */
public class TemaControlador {

    /**
     * Importa temas desde un archivo
     *
     * @param sistema
     * @param array
     * @param lineasPregunta
     * @return
     */
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
                temaDomain = sistema.obtenerTema(tema);
                modificadas++;
            } else {
                temaDomain = sistema.agregarTema(temaDomain);
                agregadas++;
            }
            temaDomain.agregarPregunta(pregunta, respuesta);

        }

        ArrayList<Integer> resultado = new ArrayList<>();
        resultado.add(ignoradas);
        resultado.add(agregadas);
        resultado.add(modificadas);
        return resultado;
    }

    /**
     * Exporta los temas con sus preguntas a un archivo
     *
     * @param sistema
     * @param absolutePath
     * @return
     */
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

    /**
     * Genera temas con preguntas automaticamente
     *
     * @param sistema
     * @param temas
     * @param preguntasPorTema
     */
    public static void generarTemas(Sistema sistema, int temas, int preguntasPorTema) {
        for (int iTema = 1; iTema <= temas; iTema++) {
            String sTema = String.valueOf(iTema);
            Tema tema = new Tema("T:" + sTema, "Descripción de T" + String.valueOf(iTema));

            for (int iPregunta = 1; iPregunta <= preguntasPorTema; iPregunta++) {
                String sPregunta = String.valueOf(iPregunta);
                tema.agregarPregunta("T:" + sTema + " P:" + sPregunta + " Texto de P" + sPregunta, "T:" + sTema + " P:" + sPregunta + " Respuesta de P" + sPregunta);
            }
            sistema.agregarTema(tema);
        }
    }

}
