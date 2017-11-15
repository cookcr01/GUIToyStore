/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitoystorecameroncook;

import java.util.ArrayList;

/**
 * is the inventory class
 *
 * @author camer_000
 */
public class Inventory {

    private ArrayList<LineItem> items;

    /**
     * constructor that intializes an arraylist of lineitem
     */
    public Inventory() {
        items = new ArrayList<LineItem>();
    }

    /**
     * adds items to the inventory
     *
     * @param l1 is the item to add the arraylist
     */
    public void addItems(LineItem l1) {
        items.add(l1);
    }

    /**
     * finds the product in the inventory
     *
     * @param proId is the id that it is looking for in the arraylist
     * @return the index of the product
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

    /**
     * gets the product based on the index that was sent to it
     *
     * @param index is the place where the product is located in the arraylist
     * @return a lineitem
     */
    public LineItem getProduct(int index) {
        return items.get(index);
    }

    /**
     * gest the price of the product
     *
     * @param index is the product you want the price of
     * @return the price of the product
     */
    public double getPrice(int index) {
        return items.get(index).getPrice();
    }

    /**
     * gets rid of inventory
     *
     * @param index is the item you want to get rid of inventory for
     * @param quantity is the quantity you want to get rid of
     */
    public void deleteInventory(int index, int quantity) {
        items.get(index).deleteQuantity(quantity);
    }

    /**
     * adds inventory
     *
     * @param index is the product you want to add inventory to
     * @param quantity is the quantity you want to add back.
     */
    public void addInventory(int index, int quantity) {
        items.get(index).addQuantity(quantity);
    }
}
