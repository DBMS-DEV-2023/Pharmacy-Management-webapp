package com.pharmacy.pharmacymanagementsystem.doa;

import java.util.List;

import com.pharmacy.pharmacymanagementsystem.models.MedicationStock;

public interface MedRepo {
    List<MedicationStock> findAll();
    int findPriceById(int medicineId);
    public void deleteMedicationStock(int i);
    public void updateMedicationStock(MedicationStock m);
    public void insertMedicationStock (MedicationStock m);
}
