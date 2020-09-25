package com.example.fooddelivery.repositories;

import com.example.fooddelivery.model.Couriers;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CouriersRepository {
    private JdbcTemplate jdbcTemplate;

    public CouriersRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Couriers> getAllCouriers() {
        String sql = "SELECT couriers.courier_id as cr_id, couriers.courier_name as cr_name, couriers.courier_secondname as cr_scndname, couriers.courier_middlename as cr_mdlename, couriers.delivery_type as dlvy_type, delivery_types.delivery_type_name as dlvy_t_name, couriers.order_cash as cash  FROM couriers JOIN delivery_types ON couriers.delivery_type = delivery_types.delivery_type_id";
        return jdbcTemplate.query(sql, new RowMapper<Couriers>() {
            @Override
            public Couriers mapRow(ResultSet resultSet, int i) throws SQLException {
                Couriers couriers = new Couriers();
                couriers.setCourier_id(resultSet.getInt("cr_id"));
                couriers.setCourier_name(resultSet.getString("cr_name"));
                couriers.setCourier_secondname(resultSet.getString("cr_scndname"));
                couriers.setCourier_middlename(resultSet.getString("cr_mdlename"));
                couriers.setDelivery_type(resultSet.getInt("dlvy_type"));
                couriers.setDelivery_type_name(resultSet.getString("dlvy_t_name"));
                couriers.setOrder_cash(resultSet.getDouble("cash"));
                return couriers;
            }
        });
    }

    public Couriers getCourierById(int id) {
        String sql = "SELECT couriers.courier_id as courier_id, couriers.courier_name as courier_name, couriers.courier_secondname as courier_secondname, couriers.courier_middlename as courier_middlename, couriers.delivery_type as delivery_type, delivery_types.delivery_type_name as delivery_type_name, couriers.order_cash as order_cash  FROM couriers JOIN delivery_types ON couriers.delivery_type = delivery_types.delivery_type_id WHERE courier_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Couriers.class));
    }

    public void addCourier(Couriers couriers) {
        String sql = "INSERT INTO couriers VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                couriers.getCourier_id(),
                couriers.getCourier_name(),
                couriers.getCourier_secondname(),
                couriers.getCourier_middlename(),
                couriers.getOrder_cash(),
                couriers.getDelivery_type());
    }

    public int editCourier(Couriers couriers, int id) {
        String sql = "UPDATE couriers SET courier_name = ?, courier_secondname = ?, courier_middlename = ?, order_cash = ?, delivery_type = ? WHERE courier_id = ?";
        return jdbcTemplate.update(sql,
                couriers.getCourier_name(),
                couriers.getCourier_secondname(),
                couriers.getCourier_middlename(),
                couriers.getOrder_cash(),
                couriers.getDelivery_type(),
                id);
    }

    public void deleteCourier(int id) {
        String sql = "DELETE FROM couriers WHERE courier_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
