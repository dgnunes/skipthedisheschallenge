/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.model;

/**
 *
 * @author douglas
 */
public class Cousine {
    private int cousineId;
    private String cousineDescription;

    public Cousine (){
        
    }
    
    public Cousine(int cousineId, String cousineDescription) {
        this.cousineId = cousineId;
        this.cousineDescription = cousineDescription;
    }

    public int getCousineId() {
        return cousineId;
    }

    public void setCousineId(int cousineId) {
        this.cousineId = cousineId;
    }

    public String getCousineDescription() {
        return cousineDescription;
    }

    public void setCousineDescription(String cousineDescription) {
        this.cousineDescription = cousineDescription;
    }
    
}
