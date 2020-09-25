package com.example.fooddelivery.repositories;

import com.example.fooddelivery.model.DeliveryType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DeliveryTypeRepository {

    private JdbcTemplate jdbcTemplate;

    public DeliveryTypeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<DeliveryType> getAllDeliveryTypes() {
        String sql = "SELECT * FROM delivery_types";
        return jdbcTemplate.query(sql, new RowMapper<DeliveryType>() {
            @Override
            public DeliveryType mapRow(ResultSet resultSet, int i) throws SQLException {
                DeliveryType deliveryType = new DeliveryType();
                deliveryType.setDelivery_type_id(resultSet.getInt(1));
                deliveryType.setDelivery_type_name(resultSet.getString(2));
                return deliveryType;
            }
        });
    }

    public void insertNewDeliveryType(DeliveryType deliveryType) {
        String sql = "INSERT INTO delivery_types VALUES (?, ?)";
        jdbcTemplate.update(sql, deliveryType.getDelivery_type_id(),
                deliveryType.getDelivery_type_name()
        );
    }


    public int updateDeliveryType(DeliveryType deliveryType, int id) {
        String sql = "UPDATE delivery_types SET delivery_type_name = ? WHERE delivery_type_id = ?";
        return jdbcTemplate.update(sql, deliveryType.getDelivery_type_name(), id);

    }

    public void deleteDeliveryType(int id) {
        String sql = "DELETE FROM delivery_types WHERE delivery_type_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public DeliveryType getDeliveryTypeById(int id) {
        String sql = "SELECT * FROM delivery_types WHERE delivery_type_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(DeliveryType.class));
    }
}
