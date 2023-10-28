package com.pharmacy.pharmacymanagementsystem.doa;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pharmacy.pharmacymanagementsystem.models.*;

@Repository
public class QueriesRepo {
    
    @Autowired
    private JdbcTemplate t;

    public User selectUser(String u) {

        try {

            String x = "SELECT * FROM Users WHERE userEmail = ?";

            return t.queryForObject(x, new BeanPropertyRowMapper<>(User.class),u);

        }

        catch (EmptyResultDataAccessException e) {

            return null;

        }

    }

    public void addNewMedicine(MedicationStock m, Category c)
    {
        String x="INSERT INTO medication_stock(name,stock_quantity, price,dosage_strength,category_id) VALUES (?,?,?,?,?)";

        t.update(x,m.getName(),m.getStock_quantity(),m.getPrice(),m.getDosage_strength(),c.getCat_id());

    }
    public void restockMedicine(MedicationStock m, IncreaseMedicationStock q)
    {
        String sql="UPDATE medication_stock SET stock_quantity=?+? WHERE id=?";

        t.update(sql, m.getStock_quantity(),q.getQuantity(),m.getId());

    }



     public List<MedicationStock> getMedicinesByCategoryId(int i) {
        try {

            String x = "SELECT * FROM medication_stock  WHERE category_id=?";

            return t.query(x, new BeanPropertyRowMapper<>(MedicationStock.class),i);

        }

        catch (EmptyResultDataAccessException e) {
            System.out.println("ono");

            return null;

        }

    }
    public List<Category> getCategories() {
        try {

            String x = "SELECT * FROM categories";

            return t.query(x, new BeanPropertyRowMapper<>(Category.class));

        }

        catch (EmptyResultDataAccessException e) {
            System.out.println("ono");

            return null;

        }

    }
    public List<Order> getOrders() {
        try {

            String x = "SELECT * FROM orders";

            return t.query(x, new BeanPropertyRowMapper<>(Order.class));

        }

        catch (EmptyResultDataAccessException e) {
            System.out.println("ono");

            return null;

        }

    }

    public MedicationStock getMedicineById(int v) {

        try {

            String x = "SELECT * FROM medication_stock WHERE id = ?";

            return t.queryForObject(x, new BeanPropertyRowMapper<>(MedicationStock.class), new Object[] { v });

        }

        catch (EmptyResultDataAccessException e) {

            return null;

        }

    }
    public Category getCategoryById(int v) {

        try {

            String x = "SELECT * FROM categories WHERE cat_id = ?";

            return t.queryForObject(x, new BeanPropertyRowMapper<>(Category.class), new Object[] { v });

        }

        catch (EmptyResultDataAccessException e) {

            return null;

        }

    }
    public Customer getCustomerById(int v) {

        try {

            String x = "SELECT * FROM customers WHERE id = ?";

            return t.queryForObject(x, new BeanPropertyRowMapper<>(Customer.class), new Object[] { v });

        }

        catch (EmptyResultDataAccessException e) {

            return null;

        }

    }

}

