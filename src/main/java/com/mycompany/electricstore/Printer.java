/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

/**
 *
 * @author Rahul & Xin
 */
public class Printer extends Equipment {

    public Printer() {
        name = "Printer";
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