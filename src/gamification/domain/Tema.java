package gamification.domain;

import java.util.HashMap;

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
    
    public void addQuestionAnswer(String question, String answer){
        preguntas.put(question, answer);
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

}
