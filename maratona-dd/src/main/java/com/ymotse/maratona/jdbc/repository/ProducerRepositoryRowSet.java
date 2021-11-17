package com.ymotse.maratona.jdbc.repository;

import com.ymotse.maratona.jdbc.conn.ConnectionFactory;
import com.ymotse.maratona.jdbc.dominio.Producer;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name) {
        String sql = "SELECT * FROM producer WHERE name LIKE ?";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jdbcRowSet = ConnectionFactory.getJdbcRowSet()){
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setString(1, String.format("%%%s%%", name));
            jdbcRowSet.execute();
            while (jdbcRowSet.next()) {
                Producer producer = Producer.builder().id(jdbcRowSet.getInt("id")).name(jdbcRowSet.getString("name")).build();
                producers.add(producer);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }
}
