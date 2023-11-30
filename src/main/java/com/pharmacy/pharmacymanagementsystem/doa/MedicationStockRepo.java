package com.pharmacy.pharmacymanagementsystem.doa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pharmacy.pharmacymanagementsystem.models.MedicationStock;

@Repository
public class MedicationStockRepo {
    
    @Autowired
    private JdbcTemplate t;

    public void insertMedicationStock (MedicationStock m)
    {
        String sql="INSERT INTO medication_stock(name,stock_quantity, price,dosage_strength,category_id) VALUES (?,?,?,?,?)";

        t.update(sql,m.getName(),m.getStock_quantity(),m.getPrice(),m.getDosage_strength(),m.getCategory_id());
    }

    public void updateMedicationStock(MedicationStock m)
    {
        String sql="UPDATE medication_stock SET name=?,stock_quantity = ?, price = ?, dosage_strength = ?, category_id =? WHERE id = ?";

        t.update(sql,m.getName(),m.getStock_quantity(),m.getPrice(),m.getDosage_strength(),m.getCategory_id(),m.getId());
    }

    public void deleteMedicationStock(int i)
    {
        String sql="DELETE FROM medication_stock WHERE id=?";

        t.update(sql,i);
    }



}
