package com.pharmacy.pharmacymanagementsystem.models;

import java.sql.Date;
import java.util.Arrays;

public class Prescription {

    private int id;
    private int customer_id;
    private int doctor_id;
    private Date date_of_prescription;
    private boolean status;
    private byte[] prescription_image;
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
    public int getDoctor_id() {
        return doctor_id;
    }
    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }
    public Date getDate_of_prescription() {
        return date_of_prescription;
    }
    public void setDate_of_prescription(Date date_of_prescription) {
        this.date_of_prescription = date_of_prescription;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public byte[] getPrescription_image() {
        return prescription_image;
    }
    public void setPrescription_image(byte[] prescription_image) {
        this.prescription_image = prescription_image;
    }
    @Override
    public String toString() {
        return "Prescription [id=" + id + ", customer_id=" + customer_id + ", doctor_id=" + doctor_id
                + ", date_of_prescription=" + date_of_prescription + ", status=" + status + ", prescription_image="
                + Arrays.toString(prescription_image) + "]";
    }
    

}
