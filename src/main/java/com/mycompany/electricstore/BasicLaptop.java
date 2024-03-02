/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

/**
 * Basic equipment which can be customized further through decorator pattern
 * @author Rahul & Xin
 */
public class BasicLaptop extends Equipment {

    public BasicLaptop() {
        name = "Laptop";
    }
    
    @Override
    public void setPricingStrategy(PaymentPlan paymentPlan) {
        this.paymentPlan = paymentPlan;
    }
    @Override
    public String getDescription() {
        return getName() + ": ";
    }
}
