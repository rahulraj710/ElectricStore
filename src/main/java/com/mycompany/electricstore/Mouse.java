/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

/**
 *
 * @author Rahul & Xin
 */
public class Mouse extends EquipmentDecorator {

    private Equipment equipment;

    public Mouse(Equipment equipment, Double price) {
        this.equipment = equipment;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.equipment.getPrice() + price;
    }

    @Override
    public String getDescription() {
        return this.equipment.getDescription() + " Mouse";
    }
}