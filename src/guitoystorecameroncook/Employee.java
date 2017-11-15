/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitoystorecameroncook;

import java.util.ArrayList;



/**
 * this is the employee class
 * @author camer_000
 */
public class Employee extends Person {
    private double salary;
    ArrayList<Sale> sales;
    
    /**
     * this is the constructor of the employee
     * @param name of employee
     * @param phoneNumber of employee
     * @param address of employee
     * @param salary of employee
     */
    public Employee(String name, String phoneNumber, String address, double salary){
        super(name,phoneNumber,address);
        this.salary=salary;
        sales = new ArrayList<>();
        
       
    }
    /**
     * is the toString method for employee
     * @return person toString method plus salary
     */
    public String toString(){
        return super.toString() +"   Salary : "+ salary;
    }
    /**
     * add sales to the employee arralist
     * @param s1 is the sale that is added
     */
    public void addSales(Sale s1){
        sales.add(s1);
    }
    /**
     * gives the total amount of sales made by this employee
     * @return the total number of sales
     */
    public double totalNumberOfSales(){
        return sales.size();
        
    }
    /**
     * caculates the total money made by this employeee
     * @return double of the money made
     */
    public double moneyMade(){
        double moneyMade=0;
        for(Sale s1: sales){
            moneyMade = moneyMade + s1.getTotalMade();
        }
        return moneyMade;
    }
}