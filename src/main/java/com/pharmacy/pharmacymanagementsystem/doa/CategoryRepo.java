package com.pharmacy.pharmacymanagementsystem.doa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pharmacy.pharmacymanagementsystem.models.Category;

@Repository
public class CategoryRepo {

    @Autowired
    private JdbcTemplate t;

    public void insertCategory(Category c)
    {
        String sql="INSERT INTO categories(cat_name) VALUES (?)";

        t.update(sql, c.getCat_name());
    }
    public void updateCategory(Category c)
    {
        String sql="UPDATE categories SET cat_name=? WHERE cat_id=?";

        t.update(sql, c.getCat_name(),c.getCat_id());
    }

    public void deleteCategory(int i)
    {
        String sql="DELETE FROM categories WHERE cat_id=?";

        t.update(sql,i);
    }


    
}
