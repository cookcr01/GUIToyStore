/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitoystorecameroncook;

import java.util.ArrayList;

/**
 * is the customer class
 *
 * @author camer_000
 */
public class Customer extends Person {

    private int age;
    ArrayList<Sale> purchases;

    /**
     * is the constructor of the customer class
     *
     * @param name name of the customer
     * @param phoneNumber of the customer
     * @param address of the customer
     * @param age of the customer
     */
    public Customer(String name, String phoneNumber, String address, int age) {
        super(name, phoneNumber, address);
        this.age = age;
        this.purchases = purchases;
        purchases = new ArrayList<>();
    }

    /**
     * called when you print a customer
     *
     * @return the person to string method plus age.
     */
    public String toString() {
        return super.toString() + " Age: " + age;
    }

    /**
     * adds purchases to the arraylist of purchases for the customer
     *
     * @param s1 is the sale that is added
     */
    public void addPurchases(Sale s1) {
        purchases.add(s1);
    }

    /**
     * is the total number of purchases the customer has made
     *
     * @return the double of purchases that customer has made.
     */
    public double totalNumberOfPurchases() {
        return purchases.size();

    }

    /**
     * this caculates how much money the customer has made
     *
     * @return the total of all purchases made by this customer.
     */
    public double purchaseTotal() {
        double moneyMade = 0;
        for (Sale s1 : purchases) {
            moneyMade = moneyMade + s1.getTotal();
        }
        return moneyMade;
    }
}