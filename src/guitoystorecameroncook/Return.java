/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitoystorecameroncook;

import java.util.ArrayList;
import java.util.Date;

/**
 * the return class that extends transaction
 *
 * @author camer_000
 */

public class Return extends Transaction {

    private Sale s1;

    /**
     *
     * constructor for the return class
     *
     * @param item is item of the return
     * @param d1 date of the return
     * @param e1 employee of the return
     * @param c1 customer of the return
     * @param s1 sale that wants to return
     */
    public Return(LineItem item, Date d1, Employee e1, Customer c1, Sale s1) {
        super(item, d1, e1, c1);
        this.s1 = s1;
    }
}
