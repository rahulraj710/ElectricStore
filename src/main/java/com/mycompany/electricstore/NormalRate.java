/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

/**
 * Implementation of strategy pattern for normal pricing
 * @author Rahul & Xin
 */
public class NormalRate implements PaymentPlan {
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}
