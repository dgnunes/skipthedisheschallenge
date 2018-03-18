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
public class Store {
    private int storeId;
    private String storeName;
    private String storeAddress;
    private int cousineId;

    public Store(){
    }
    
    public Store(int storeId, String storeName, String storeAddress, int cousineId) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.cousineId = cousineId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getCousineId() {
        return cousineId;
    }

    public void setCousineId(int cousine) {
        this.cousineId = cousine;
    }
    
}
