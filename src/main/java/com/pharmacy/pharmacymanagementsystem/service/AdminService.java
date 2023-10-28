package com.pharmacy.pharmacymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.pharmacymanagementsystem.doa.CategoryRepo;
import com.pharmacy.pharmacymanagementsystem.doa.MedicationStockRepo;
import com.pharmacy.pharmacymanagementsystem.doa.QueriesRepo;
import com.pharmacy.pharmacymanagementsystem.models.Category;
import com.pharmacy.pharmacymanagementsystem.models.Customer;
import com.pharmacy.pharmacymanagementsystem.models.IncreaseMedicationStock;
import com.pharmacy.pharmacymanagementsystem.models.MedicationStock;
import com.pharmacy.pharmacymanagementsystem.models.Order;

@Service
public class AdminService {

    @Autowired
    private MedicationStockRepo medicationStockRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private QueriesRepo queriesRepo;
    public void addMedicationStock(MedicationStock medicine, Category category)
    {
        queriesRepo.addNewMedicine(medicine,category);
    }
    public void addCategory(Category c)
    {
        categoryRepo.insertCategory(c);
    }
    public Category getCategoryById(int i)
    {
        return queriesRepo.getCategoryById(i);
    }
    public void DeleteCategory(int id) {
        
        categoryRepo.deleteCategory(id);
    }
    public void deleteMedicine(int id) {
        
        medicationStockRepo.deleteMedicationStock(id);
    }
    public List<MedicationStock> getMedicinesByCategoryId(int i)
    {
        return queriesRepo.getMedicinesByCategoryId(i);
    }
    public MedicationStock getMedicineById(int id)
    {
        return queriesRepo.getMedicineById(id);
    }
    public List<Category> getCategories()
    {
        return queriesRepo.getCategories();
    }
    public void restock(MedicationStock m,IncreaseMedicationStock q)
    {
        queriesRepo.restockMedicine(m,q);
    }
    public List<Order> getOrders()
    {
        return queriesRepo.getOrders();
    }
    public Customer getCustomerById(int id)
    {
        return queriesRepo.getCustomerById(id);
    }
    
    

}
