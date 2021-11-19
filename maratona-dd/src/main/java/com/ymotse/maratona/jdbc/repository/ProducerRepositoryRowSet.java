package com.ymotse.maratona.jdbc.repository;

import com.ymotse.maratona.jdbc.conn.ConnectionFactory;
import com.ymotse.maratona.jdbc.dominio.Producer;
import com.ymotse.maratona.jdbc.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name) {
        String sql = "SELECT * FROM producer WHERE name LIKE ?";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jdbcRowSet = ConnectionFactory.getJdbcRowSet()){
            jdbcRowSet.addRowSetListener(new CustomRowSetListener());
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

//    public static void updateJdbcRowSet(Producer producer) {
//        String sql = "UPDATE anime_store.producer SET name = ? WHERE id = ?";
//        try (JdbcRowSet jdbcRowSet = ConnectionFactory.getJdbcRowSet()){
//            jdbcRowSet.setCommand(sql);
//            jdbcRowSet.setString(1, producer.getName());
//            jdbcRowSet.setInt(2, producer.getId());
//            jdbcRowSet.execute();
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void updateJdbcRowSet(Producer producer) {
        String sql = "SELECT * FROM producer WHERE id = ?";
        try (JdbcRowSet jdbcRowSet = ConnectionFactory.getJdbcRowSet()){
            jdbcRowSet.addRowSetListener(new CustomRowSetListener());
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setInt(1, producer.getId());
            jdbcRowSet.execute();
            if(!jdbcRowSet.next()) {
                return;
            }

            jdbcRowSet.updateString("name", producer.getName());
            jdbcRowSet.updateRow();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCachedRowSet(Producer producer) {
        String sql = "SELECT * FROM producer WHERE id = ?";
        try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
            Connection connection = ConnectionFactory.getConnection()){
            connection.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection);
            if(!crs.next()) {
                return;
            }

            crs.updateString("name", producer.getName());
            crs.updateRow();
            crs.acceptChanges();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
