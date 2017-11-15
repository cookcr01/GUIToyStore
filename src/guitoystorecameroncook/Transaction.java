/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitoystorecameroncook;

import java.util.ArrayList;
import java.util.Date;

/**
 * this is abstract superclass Transaction.java
 *
 * @author camer_000
 */
public abstract class Transaction {

    private ArrayList<LineItem> items = new ArrayList<>();
    private Date d1;
    private Employee e1;
    private Customer c1;
    private double saleId;
    private static double num = 2000;

    /**
     * this is the constructor
     *
     * @param item is the lineitem, that gets added to the items arraylist
     * @param d1 the is the date at which the sale took place
     * @param e1 is the employee that did the transcation
     * @param c1 is the customer that did the transactions
     */
    public Transaction(LineItem item, Date d1, Employee e1, Customer c1) {
        items.add(item);
        this.d1 = d1;
        this.c1 = c1;
        this.e1 = e1;
        saleId = num;
        num++;

    }

    /**
     * To String method for transaction
     *
     * @return a string which is used when try and print a transaction object
     */
    public String toString() {
        return "This transaction contained:" + "Product(s) " + items.toString() + "|| Employee: "
                + e1.toString() + "|| Customer: " + c1.toString() + " Date: " + d1.toString() + " TransAction Number: " + saleId;
    }

    /**
     * gets the total of a transaction
     *
     * @return double that is the total of the transaction
     */
    public double getTotal() {
        double total = 0;
        for (LineItem el : items) {
            total = total + el.getPrice() * el.getQuanity();
        }
        return total;
    }

    /**
     * gets the sale id of a object
     *
     * @return the saleid
     */
    public double getSaleId() {
        return saleId;
    }

    /**
     * gets the quantity of the product sold
     *
     * @param i is the index of what item we want the quantity of
     * @return the quantity of the product
     */
    public int getQuantity(int i) {
        return items.get(i).getQuanity();
    }

    /**
     * finds the product in the transaction
     *
     * @param proId is the id of the product we are looking for
     * @return the index of the product.
     */
    public int findProduct(double proId) {
        int proPosition;
        for (int x = 0; x < items.size(); x++) {
            if (items.isEmpty()) {
                return -1;
            }
            if (items.get(x).getId() == proId) {
                return x;
            }
        }
        return -1;
    }
}