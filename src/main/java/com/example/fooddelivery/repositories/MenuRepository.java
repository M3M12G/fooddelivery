package com.example.fooddelivery.repositories;

import com.example.fooddelivery.model.Menu;
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
public class MenuRepository {
    private JdbcTemplate jdbcTemplate;

    public MenuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Menu> getAllMenu() {
    String sql = "SELECT * FROM menu";
    return jdbcTemplate.query(sql, new RowMapper<Menu>() {
        @Override
        public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
            Menu menu = new Menu();
            menu.setMenu_id(resultSet.getInt(1));
            menu.setFoods(resultSet.getString(2));
            menu.setPrice(resultSet.getDouble(3));
            menu.setStore(resultSet.getInt(4));
            return menu;
        }
    });
    }


    public void addNewMenu(Menu menu) {
        String sql = "INSERT INTO menu VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, menu.getMenu_id(), menu.getFoods(), menu.getPrice(), menu.getStore());
    }

    public int editMenu(Menu menu, int id) {
        String sql = "UPDATE menu SET foods = ?, price = ?, store = ? WHERE menu_id = ?";
        return jdbcTemplate.update(sql, menu.getFoods(), menu.getPrice(), menu.getStore(), id);
    }

    public void deleteMenu(int id) {
        String sql = "DELETE FROM menu WHERE menu_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Menu> getAllDetailedMenu() {
        String sql = "SELECT menu.menu_id as menu_id, menu.foods as foods, menu.price as price, menu.store as store, stores.store_name FROM menu JOIN stores ON menu.store = stores.store_id";
        return jdbcTemplate.query(sql, new RowMapper<Menu>() {
            @Override
            public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
                Menu menu = new Menu();
                menu.setMenu_id(resultSet.getInt("menu_id"));
                menu.setFoods(resultSet.getString("foods"));
                menu.setPrice(resultSet.getDouble("price"));
                menu.setStore(resultSet.getInt("store"));
                menu.setStore_name(resultSet.getString("store_name"));
                return menu;
            }
        });
    }

    public Menu getDetailedMenuById(int id) {
        String sql = "SELECT menu.menu_id as menu_id, menu.foods as foods, menu.price as price, menu.store as store, stores.store_name FROM menu JOIN stores ON menu.store = stores.store_id WHERE store_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Menu.class));
    }
}
//-- INSERT INTO store_categories(category_id, category_name) VALUES (1, 'Fast-Food');
//-- SELECT * FROM store_categories;
//
//-- INSERT INTO stores(store_id, store_name, store_category) VALUES (1, 'KFC', 1);
//-- SELECT stores.store_name, store_categories.category_name FROM stores JOIN store_categories ON stores.store_category = store_categories.category_id;
//-- UPDATE store_categories SET category_name = 'Fast-Food Restaurant' WHERE category_id = 1;
//
//-- ALTER TABLE delivery_types ALTER COLUMN delivery_type_name TYPE varchar(50)
//
//-- INSERT INTO delivery_types(delivery_type_id, delivery_type_name, delivery_amount) VALUES (1, 'Pedestrian', 0.25);
//-- SELECT * FROM delivery_types;
//
//-- INSERT INTO menu(menu_id, foods, price, store) VALUES (3, 'Coke 0.5, Steak, Fried potato', 2700.30, 2);
//-- SELECT menu.foods, menu.price, stores.store_name FROM menu JOIN stores ON menu.store = stores.store_id;
//SELECT stores.store_name as store_name, menu.menu_id as menu_id, menu.foods as foods, menu.price as price FROM menu JOIN stores ON menu.store = stores.store_id
//-- INSERT INTO couriers(courier_id, courier_name, courier_secondname, courier_middlename, order_cash, delivery_type) VALUES(1, 'Glovo', 'Norway', 'Delivery', 0, 1);
//-- SELECT couriers.courier_name, couriers.courier_middlename, delivery_types.delivery_type_name, delivery_types.delivery_amount, couriers.order_cash FROM couriers JOIN delivery_types ON couriers.delivery_type = delivery_types.delivery_type_id;
//
//-- INSERT INTO orders(order_id, client_number, menu_id, order_time, courier_id, order_status, delivered) VALUES (1, '87777777777', 1, '2020-06-11 11:15:00', 1, true, true);
//-- SELECT menu.foods, menu.price as price, couriers.courier_name, orders.order_time, orders.order_status FROM orders
//-- JOIN menu ON orders.menu_id = menu.menu_id
//-- JOIN couriers ON orders.courier_id = couriers.courier_id;