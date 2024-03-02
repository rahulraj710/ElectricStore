/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

/**
 *
 * @author Rahul & Xin
 */
public class Desktop extends Equipment {

    public Desktop() {
        name = "Desktop";
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