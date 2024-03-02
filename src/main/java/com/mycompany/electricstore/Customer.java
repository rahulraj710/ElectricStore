/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricstore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rahul & Xin
 */
public class Customer implements Observer, Display {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void update(String message) {
        display(message);
    }

    @Override
    public void display(String message) {
        try {
            FileWriter fileWriter = new FileWriter(FilePaths.OUTPUT.getPath(), true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(message);
            bufferWriter.newLine();
            bufferWriter.close();

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

}
