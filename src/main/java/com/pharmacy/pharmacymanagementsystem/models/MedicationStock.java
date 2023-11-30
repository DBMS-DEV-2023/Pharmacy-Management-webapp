package com.pharmacy.pharmacymanagementsystem.models;


public class MedicationStock {
    
    private int id;

    private String name;

    private int stock_quantity;

    private int price;

    private int dosage_strength;

    private int category_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDosage_strength() {
        return dosage_strength;
    }

    public void setDosage_strength(int dosage_strength) {
        this.dosage_strength = dosage_strength;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "MedicationStock [id=" + id + ", name=" + name + ", stock_quantity=" + stock_quantity + ", price="
                + price + ", dosage_strength=" + dosage_strength + ", category_id=" + category_id + "]";
    }

    

    


}
