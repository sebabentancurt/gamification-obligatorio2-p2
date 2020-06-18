/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification;

import gamification.domain.Sistema;
import gamification.domain.Tema;
import gamification.views.Dashboard;
import gamification.views.VentanaTemas;

/**
 *
 * @author sebab
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Sistema s = new Sistema();
        Tema tema = new Tema();
        s.agregarTema(tema);
        VentanaTemas v = new VentanaTemas(s);
        v.setVisible(true);
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);

    }

}
