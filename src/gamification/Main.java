/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamification;

import gamification.domain.Sistema;
import gamification.views.*;

/**
 *
 * @author Mateo Sapiurka 211096
 * @author Sebastián Bentancurt 225768
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Sistema s = new Sistema();
        Menu ve = new Menu(s);
        ve.setVisible(true);
    }

}
