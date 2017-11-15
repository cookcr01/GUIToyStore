/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitoystorecameroncook;

/**
 * person abstract super class
 *
 * @author camer_000
 */
public abstract class Person {

    private String name;
    private String phoneNumber;
    private String address;
    private double id;
    private static double num = 1000;

    /**
     * constructors
     *
     * @param name of the person
     * @param phoneNumber of the person
     * @param address of the person
     */
    public Person(String name, String phoneNumber, String address) {
        id = num;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        num = num + 1;
    }

    /**
     * to string method of person
     *
     * @return the string
     */
    public String toString() {
        return " Name :     " + name + "   Phone Number :     " + phoneNumber + "   Address :    " + address + "   Unique Employee id :   " + id;
    }

    /**
     * gets the id of person
     *
     * @return the id
     */
    public double getId() {
        return id;
    }

}