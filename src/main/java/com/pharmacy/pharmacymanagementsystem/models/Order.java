package com.pharmacy.pharmacymanagementsystem.models;

import java.sql.Date;

public class Order {
    private int id;
    private int customer_id;
    private Date order_date;
    private int prescription_id;
    private int total_amount;
    private String address;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public Date getOrder_date() {
        return order_date;
    }
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
    public int getPrescription_id() {
        return prescription_id;
    }
    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }
    public int getTotal_amount() {
        return total_amount;
    }
    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", customer_id=" + customer_id + ", order_date=" + order_date + ", prescription_id="
                + prescription_id + ", total_amount=" + total_amount + ", address=" + address + "]";
    }
    

}
