/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitoystorecameroncook;

import java.util.ArrayList;
import java.util.Date;

/**
 * sale class that extends transaction
 *
 * @author camer_000
 */
public class Sale extends Transaction {

    /**
     * constructor of a sale
     *
     * @param item of the sale
     * @param d1 date of the sale
     * @param e1 employee of the sale
     * @param c1 customer of the sale
     */
    public Sale(LineItem item, Date d1, Employee e1, Customer c1) {
        super(item, d1, e1, c1);
    }

    /**
     * gets the total of the sale
     *
     * @return the total of the sale
     */
    public double getTotalMade() {
        return super.getTotal();
    }

}
