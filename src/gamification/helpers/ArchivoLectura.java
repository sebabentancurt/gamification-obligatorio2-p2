/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification.helpers;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mateo Sapiurka 211096
 * @author Sebastián Bentancurt 225768
 */
public class ArchivoLectura {

    private Scanner in;
    private String linea;

    /**
     * Instancia un escaner para leer un archivo
     *
     * @param unNombre
     */
    public ArchivoLectura(String unNombre) {
        try {
            in = new Scanner(Paths.get(unNombre));
        } catch (IOException e) {
            System.err.println("Error ");
            System.exit(1);
        }
    }

    /**
     * Verifica si existen más lineas para leer o si estoy en el final del
     * archivo
     *
     * @return
     */
    public boolean hayMasLineas() {
        boolean hay = false;
        linea = null;
        if (in.hasNext()) {
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }

    /**
     * Lista lineas de a X cantidad
     *
     * @param cant
     * @return
     */
    public ArrayList<List> listarDeAN(int cant) {
        ArrayList<List> arrayList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int van = 0;

        while (this.hayMasLineas()) {
            van++;
            String linea = this.linea();
            if (!linea.isBlank()) {
                list.add(this.linea());
            }

            if (van == cant) {
                arrayList.add(list);
                list = new ArrayList<>();
                van = 0;
            }
        }
        this.cerrar();
        return arrayList;
    }

    /**
     * Devuelve la ultima linea leida
     *
     * @return
     */
    public String linea() {
        return linea;
    }

    /**
     * Cierra la conexion con el archivo
     */
    public void cerrar() {
        in.close();
    }
}
