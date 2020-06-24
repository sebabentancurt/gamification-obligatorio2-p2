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
 * @author sebab
 */
public class ArchivoLectura {

    private Scanner in;
    private String linea;

    public ArchivoLectura(String unNombre) {
        try {
            in = new Scanner(Paths.get(unNombre));
        } catch (IOException e) {
            System.err.println("Error ");
            System.exit(1);
        }
    }

    public boolean hayMasLineas() {
        boolean hay = false;
        linea = null;
        if (in.hasNext()) {
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }

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

    public String linea() {
// devuelve la última linea leida
        return linea;
    }

    public void cerrar() {
        in.close();
    }
}
