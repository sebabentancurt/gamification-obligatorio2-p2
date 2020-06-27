/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification.domain;

import java.util.ArrayList;

/**
 *
 * @author Mateo Sapiurka 211096
 * @author Sebastián Bentancurt 225768
 */
public class Sistema {

    private ArrayList<Tema> listaTemas;

    public Sistema() {
        listaTemas = new ArrayList<Tema>();
    }

    /**
     * Agrega un tema sino existe en el sistema
     *
     * @param unTema
     * @return
     */
    public Tema agregarTema(Tema unTema) {

        if (!this.existeTema(unTema)) {
            this.getListaTemas().add(unTema);
        }

        return unTema;
    }

    /**
     * Obtiene tema a partir de un nombre
     *
     * @param nombre
     * @return
     */
    public Tema obtenerTema(String nombre) {
        Tema temp = new Tema();
        for (Tema tema : listaTemas) {
            if (tema.getNombre().equals(nombre)) {
                temp = tema;
            }
        }

        return temp;
    }

    /**
     * Evalua si existe un tema en el sistema
     *
     * @param unTema
     * @return
     */
    public boolean existeTema(Tema unTema) {
        boolean existe = false;

        for (Tema tema : listaTemas) {
            if (tema.getNombre().equals(unTema.getNombre())) {
                tema.setDescripcion(unTema.getDescripcion());
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Elimina un tema del sistema
     *
     * @param unTema
     */
    public void eliminarTema(Tema unTema) {
        this.getListaTemas().remove(unTema);
    }

    //---- Getters -----
    public ArrayList<Tema> getListaTemas() {
        return listaTemas;
    }

}
