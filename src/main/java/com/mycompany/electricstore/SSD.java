/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

/**
 * Add on for basic equipment
 * @author Rahul & Xin
 */
public class SSD extends EquipmentDecorator {

    private Equipment equipment;

    public SSD(Equipment equipment, Double price) {
        this.equipment = equipment;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.equipment.getPrice() + price;
    }

    @Override
    public String getDescription() {
        return this.equipment.getDescription() + " SSD Drive(250 GB)";
    }
}
