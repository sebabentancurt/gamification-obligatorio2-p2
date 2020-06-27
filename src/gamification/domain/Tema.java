package gamification.domain;

import java.util.*;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mateo Sapiurka 211096
 * @author Sebastián Bentancurt 225768
 */
public class Tema {

    private String nombre;
    private String descripcion;
    private HashMap<String, String> preguntas;

    //constructor sin parametros
    public Tema() {
        this.setNombre("sin nombre");
        this.setDescripcion("sin descripcion");
        preguntas = new HashMap<String, String>();
    }

    //constructor con parametros
    public Tema(String unNombre, String unaDescripcion) {
        this.setNombre(unNombre);
        this.setDescripcion(unaDescripcion);
        preguntas = new HashMap<String, String>();
    }

    /**
     * Agrega una pregunta al tema, de existir la actualiza.
     *
     * @param question
     * @param answer
     * @return
     */
    public boolean agregarPregunta(String question, String answer) {
        preguntas.put(question, answer);
        return true;
    }

    /**
     * Elimina una pregunta del tema
     *
     * @param pregunta
     * @return
     */
    public boolean eliminarPregunta(String pregunta) {
        preguntas.remove(pregunta);
        return true;
    }

    /**
     * Devuelve un ArrayList de las preguntas
     *
     * @return
     */
    public ArrayList<String> listarPreguntas() {
        ArrayList<String> listaAux = new ArrayList<>();
        Iterator<String> it = preguntas.keySet().iterator();
        while (it.hasNext()) {
            listaAux.add(it.next());
        }
        return listaAux;
    }

    /**
     * Devuelve modelo con preguntas para JList
     *
     * @return
     */
    public DefaultListModel modelListarPreguntas() {
        DefaultListModel model = new DefaultListModel<>();
        ArrayList<String> listaAux = new ArrayList<>();
        Iterator<String> it = preguntas.keySet().iterator();

        while (it.hasNext()) {
            model.addElement(it.next());
        }
        return model;
    }

    /**
     * Obtiene la respuesta de una pregunta
     *
     * @param pregunta
     * @return
     */
    public String getRespuesta(String pregunta) {
        return preguntas.get(pregunta);
    }

    //---- Setters -----
    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public void setDescripcion(String unaDescripcion) {
        this.descripcion = unaDescripcion;
    }

    //---- Getters -----
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String toString() {
        return this.getNombre() + ": " + this.preguntas.size();
    }

    public HashMap<String, String> getPreguntas() {
        return preguntas;
    }

}
