package com.example.fooddelivery.repositories;

import com.example.fooddelivery.model.StoreCategories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StoreCategoriesRepository {

    private JdbcTemplate jdbcTemplate;

    public StoreCategoriesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<StoreCategories> getAllCategories() {
        String sql = "SELECT * FROM store_categories";
        return jdbcTemplate.query(sql, new RowMapper<StoreCategories>() {
            @Override
            public StoreCategories mapRow(ResultSet resultSet, int i) throws SQLException {
                StoreCategories storeCategories = new StoreCategories();
                storeCategories.setCategory_id(resultSet.getInt(1));
                storeCategories.setCategory_name(resultSet.getString(2));
                return storeCategories;
            }
        });
    }

    public StoreCategories getCategoryById(int id) {
        String sql = "SELECT * FROM store_categories WHERE category_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(StoreCategories.class));
    }

    public void insertCategory(StoreCategories storeCategories) {
        String sql = "INSERT INTO store_categories VALUES (?, ?)";
        jdbcTemplate.update(sql, storeCategories.getCategory_id(), storeCategories.getCategory_name());
    }

    public void deleteCategory(int id) {
        String sql = "DELETE FROM store_categories WHERE category_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public int updateCategory(StoreCategories storeCategories, int id) {
        String sql = "UPDATE store_categories SET category_name = ? WHERE category_id = ?";
        return jdbcTemplate.update(sql, storeCategories.getCategory_name(), id);
    }
}
