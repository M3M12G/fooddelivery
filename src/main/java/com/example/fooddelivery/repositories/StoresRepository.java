package com.example.fooddelivery.repositories;

import com.example.fooddelivery.model.Stores;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoresRepository {
    private JdbcTemplate jdbcTemplate;

    public StoresRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Stores> getAllStores() {
//        String sql = "SELECT stores.store_id, stores.store_name, store_categories.category_name FROM stores JOIN store_categories ON stores.store_category = store_categories.category_id";
        String sql = "SELECT * FROM stores";
        return jdbcTemplate.query(sql, new RowMapper<Stores>() {
            @Override
            public Stores mapRow(ResultSet resultSet, int i) throws SQLException {
                Stores stores = new Stores();
                stores.setStore_id(resultSet.getInt(1));
                stores.setStore_name(resultSet.getString(2));
                stores.setStore_category(resultSet.getInt(3));
                return stores;
            }
        });
    }

    public void addNewStore(Stores stores) {
        String sql = "INSERT INTO stores VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, stores.getStore_id(), stores.getStore_name(), stores.getStore_category());
    }

    public Stores getStoreById(int id) {
        String sql = "SELECT * FROM stores WHERE store_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Stores.class));
    }

    public Stores getStoreWithNameById(int id) {
        String sql = "SELECT stores.store_id as store_id, stores.store_name as store_name, stores.store_category as store_category, store_categories.category_name as category_name FROM stores JOIN store_categories ON stores.store_category = store_categories.category_id WHERE store_id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Stores.class));
    }


    public List<Stores> getAllStoresWithNames() {
        String sql = "SELECT stores.store_id as store_id, stores.store_name as store_name, stores.store_category as store_category, store_categories.category_name as category_name FROM stores JOIN store_categories ON stores.store_category = store_categories.category_id";
        return jdbcTemplate.query(sql, new RowMapper<Stores>() {
            @Override
            public Stores mapRow(ResultSet resultSet, int i) throws SQLException {
                Stores stores = new Stores();
                stores.setStore_id(resultSet.getInt("store_id"));
                stores.setStore_name(resultSet.getString("store_name"));
                stores.setStore_category(resultSet.getInt("store_category"));
                stores.setCategoryName(resultSet.getString("category_name"));
                return stores;
            }
        });
    }
}

