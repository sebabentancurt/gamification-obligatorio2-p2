/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification.domain;

import java.util.ArrayList;

/**
 *
 * @author Mateo
 */
public class Sistema {

    private ArrayList<Tema> listaTemas;

    public Sistema() {
        listaTemas = new ArrayList<Tema>();
    }

    //getters
    public ArrayList<Tema> getListaTemas() {
        return listaTemas;
    }
    
    public void agregarTema(Tema unTema){
        this.getListaTemas().add(unTema);
    }

}
