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

    public Tema agregarTema(Tema unTema) {

        boolean existe = false;

        for (Tema tema : listaTemas) {
            if (tema.getNombre().equals(unTema.getNombre())) {
                tema.setDescripcion(unTema.getDescripcion());
                existe = true;
            }
        }

        if (!existe) {
            this.getListaTemas().add(unTema);
        }

        return unTema;
    }

    public void eliminarTema(Tema unTema) {
        this.getListaTemas().remove(unTema);
    }

}
