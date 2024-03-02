/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

import java.util.ArrayList;

/**
 *
 * @author Rahul & Xin
 */
public class Store implements Subject {

    protected ArrayList<Observer> observers = new ArrayList<>();
    protected ArrayList<String[]> products = new ArrayList<>();
    protected String discountInfo;

    public String getProductString(){
        String message = "";
        for(String[] info: products){
            message += info[0] + info[1];
        }
        return message;
    }
    public void setProducts(ArrayList<String[]> products){
        this.products = products;
    }
    public void setDiscountInfo(String discountInfo){
        this.discountInfo = discountInfo;
    }
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        String customerName = "";
        String message = getProductString();
        for (Observer observer : observers) {
            customerName = observer.getName();
            String finalMessage = "\nDear " + customerName + "\nFollowing is the current price list of our products along with the discounts that we are offering\n" + message + this.discountInfo;
            observer.update(finalMessage);
        }
    }

}
