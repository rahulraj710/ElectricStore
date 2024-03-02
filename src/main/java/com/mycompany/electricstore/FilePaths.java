/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.electricstore;

/**
 *
 * @author Rahul & Xin
 */
public enum FilePaths {
    BASICPRODUCTS("C:\\Users\\ra_10\\Downloads\\project\\basicproducts.txt"), 
    PRODUCTADDONS("C:\\Users\\ra_10\\Downloads\\project\\productaddons.txt"), 
    PRODUCTPRICES("C:\\Users\\ra_10\\Downloads\\project\\productprices.txt"),
    SUBSCRIBERS("C:\\Users\\ra_10\\Downloads\\project\\subscribers.txt"),
    DISCOUNTINFO("C:\\Users\\ra_10\\Downloads\\project\\discountInfo.txt"),
    OUTPUT("C:\\Users\\ra_10\\Downloads\\project\\output.txt"),
    ORDEROUTPUT("C:\\Users\\ra_10\\Downloads\\project\\orderoutput.txt");
    
    private String path;
    private FilePaths(String path) {
        this.path = path;
    }
    
    public String getPath(){
        return this.path;
    }
}
