/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitoystorecameroncook;

/**
 * is the product class
 *
 * @author camer_000
 */
public class Product {

    private String name;
    private String description;
    private double price;
    private double id;
    private static double num = 3000;

    /**
     * is the constructor for this class
     *
     * @param name is the name of the product
     * @param description of product
     * @param price of product
     */
    public Product(String name, String description, double price) {
        this.id = num;
        this.name = name;
        this.description = description;
        this.price = price;
        num++;
    }

    /**
     * your to String method for product
     *
     * @return the string
     */
    public String toString() {
        return " name:   " + name + "   description:   " + description + "   price:   " + price + "   Unique id:   " + id;
    }

    /**
     * checks if to products have the same name and price
     *
     * @param e is the object we are comparing
     * @return true or false
     */
    public boolean equals(Object e) {
        if (this.getClass() != e.getClass()) {
            return false;
        }
        Product otherProduct = (Product) e;
        return this.name.equals(otherProduct.name) && this.price == otherProduct.price;
    }

    /**
     * gets the id of the product
     *
     * @return the id
     */
    public double getId() {
        return id;
    }

    /**
     * gets price
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }
}
