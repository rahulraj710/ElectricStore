/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.electricstore;

/**
 *
 * @author Rahul & Xin
 */
public interface Subject {

    public void subscribe(Observer observer);

    public void unSubscribe(Observer observer);

    public void notifyObservers();
}
