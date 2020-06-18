package gamification.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mateo
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

    public boolean agregarPregunta(String question, String answer) {
        preguntas.put(question, answer);
        return true;
    }

    public boolean eliminarPregunta(String pregunta) {
        preguntas.remove(pregunta);
        return true;
    }

    public ArrayList<String> listarPreguntas() {
        ArrayList<String> listaAux = new ArrayList<>();
        Iterator<String> it = preguntas.keySet().iterator();
        while (it.hasNext()) {
            listaAux.add(it.next());
        }
        return listaAux;
    }
    
    public DefaultListModel modelListarPreguntas(){
        DefaultListModel model = new DefaultListModel<>();
        ArrayList<String> listaAux = new ArrayList<>();
        Iterator<String> it = preguntas.keySet().iterator();
        
        while (it.hasNext()) {
             model.addElement(it.next());
        }
        return model;
     }
    
    public String getRespuesta(String pregunta){
        return preguntas.get(pregunta);
    }

    //setters
    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public void setDescripcion(String unaDescripcion) {
        this.descripcion = unaDescripcion;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String toString(){
        return this.getNombre() + ": " + this.preguntas.size();
    }

}
