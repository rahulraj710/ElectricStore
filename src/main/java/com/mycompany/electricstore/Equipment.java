/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

/**
 * Abstract class for implementing decorator pattern for equipments and their
 * customizations
 *
 * @author Rahul & Xin
 */
public abstract class Equipment {

    protected String name;
    protected double price;
    protected String description;
    protected PaymentPlan paymentPlan;

    public void setBasicPrice(Double price) {
        this.price = price;
    }

    public void setPricingStrategy(PaymentPlan paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return this.paymentPlan.calculatePrice(price);
    }

    public String getDescription() {
        return description;
    }

}
