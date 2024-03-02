/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

/**
 * Implementation of strategy pattern for discounted pricing
 * @author ra_10
 */
public class DiscountRate implements PaymentPlan {

    private double discountRate;

    public DiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculatePrice(double price) {
        return price - ((discountRate/100) * price);
    }
}
