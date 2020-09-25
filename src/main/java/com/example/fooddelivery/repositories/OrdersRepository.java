package com.example.fooddelivery.repositories;

import com.example.fooddelivery.model.Orders;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class OrdersRepository {
    private JdbcTemplate jdbcTemplate;

    public OrdersRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Orders> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new RowMapper<Orders>() {
            @Override
            public Orders mapRow(ResultSet resultSet, int i) throws SQLException {
                Orders orders = new Orders();
                orders.setOrder_id(resultSet.getInt(1));
                orders.setClient_number(resultSet.getString(2));
                orders.setMenu_id(resultSet.getInt(3));
                orders.setOrder_time(resultSet.getTimestamp(4));
                orders.setCourier_id(resultSet.getInt(5));
                orders.setOrder_status(resultSet.getBoolean(6));
                return orders;
            }
        });
    }

    public List<Orders> getDetailedOrders() {
        String sql = "SELECT orders.order_id as order_id, orders.client_number as client_number, orders.menu_id as menu_id, menu.foods as foods, menu.price as price,orders.courier_id as courier_id, couriers.courier_name as courier_name, couriers.courier_secondname as courier_secondname, orders.order_time as order_time, orders.order_status FROM orders JOIN menu ON orders.menu_id = menu.menu_id JOIN couriers ON orders.courier_id = couriers.courier_id";
        return jdbcTemplate.query(sql, new RowMapper<Orders>() {
            @Override
            public Orders mapRow(ResultSet resultSet, int i) throws SQLException {
                Orders orderDetails = new Orders();
                orderDetails.setOrder_id(resultSet.getInt("order_id"));
                orderDetails.setClient_number(resultSet.getString("client_number"));
                orderDetails.setMenu_id(resultSet.getInt("menu_id"));
                orderDetails.setFoods(resultSet.getString("foods"));
                orderDetails.setPrice(resultSet.getDouble("price"));
                orderDetails.setCourier_id(resultSet.getInt("courier_id"));
                orderDetails.setCourier_name(resultSet.getString("courier_name"));
                orderDetails.setCourier_secondname(resultSet.getString("courier_secondname"));
                orderDetails.setOrder_time(resultSet.getTimestamp("order_time"));
                orderDetails.setOrder_status(resultSet.getBoolean("order_status"));
                return orderDetails;
            }
        });
    }

    public void cancelOrder(int id) {
        String sql = "UPDATE orders SET order_time = ?, order_status = ? WHERE order_id = ?";
        jdbcTemplate.update(sql, Timestamp.valueOf(LocalDateTime.now()), false, id);
    }

    public void addNewOrder(Orders orders) {
        String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orders.getOrder_id(), orders.getClient_number(), orders.getMenu_id(), orders.getOrder_time(), orders.getCourier_id(), true);
    }

    public Orders getOrderDetailById(int id) {
        String sql = "SELECT orders.order_id as order_id, orders.client_number as client_number, orders.menu_id as menu_id, menu.foods as foods, menu.price as price,orders.courier_id as courier_id, couriers.courier_name as courier_name, couriers.courier_secondname as courier_secondname, orders.order_time as order_time, orders.order_status FROM orders JOIN menu ON orders.menu_id = menu.menu_id JOIN couriers ON orders.courier_id = couriers.courier_id WHERE order_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Orders.class));
    }

    public void deleteCancelledOrders() {
        String sql = "DELETE FROM orders WHERE order_status = ?";
        jdbcTemplate.update(sql, false);
    }

    public void payFromOrders() {
        String sql = "WITH price AS (SELECT sum(menu.price) as pricevalues, orders.courier_id as courier_id FROM orders JOIN menu ON orders.menu_id = menu.menu_id WHERE orders.courier_id in (select courier_id from orders) GROUP BY orders.courier_id) UPDATE couriers SET order_cash = price.pricevalues*0.05 FROM price WHERE couriers.courier_id = price.courier_id";
        jdbcTemplate.update(sql);
    }
}
