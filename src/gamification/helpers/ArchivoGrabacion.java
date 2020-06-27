package gamification.helpers;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

/**
 *
 * @author Mateo Sapiurka 211096
 * @author Sebastián Bentancurt 225768
 */
public class ArchivoGrabacion {

    private Formatter out;

    /**
     * Instancia lo necesario para escribir en un archivo
     *
     * @param unNombre
     */
    public ArchivoGrabacion(String unNombre) {
        try {
            FileWriter f = new FileWriter(unNombre, true);
            out = new Formatter(f);
        } catch (FileNotFoundException e) {
            System.out.println("no se puede crear");
        } catch (SecurityException e) {
            System.out.println("sin permisos");
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    /**
     * Imprime una linea en el archivo
     *
     * @param linea
     */
    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }

    /**
     * Cierra la conexion con el archivo
     */
    public void cerrar() {
        out.close();
    }
}
