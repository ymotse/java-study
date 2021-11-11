package com.ymotse.maratona.jdbc.repository;

import com.ymotse.maratona.jdbc.conn.ConnectionFactory;
import com.ymotse.maratona.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer) {
        String sql = "INSERT INTO anime_store.producer (name) VALUES('%s')".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}' from the database rows affected {}", producer.getName(), rowsAffected);
        } catch(SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM anime_store.producer WHERE id = %d".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' from the database rows affected {}", id, rowsAffected);
        } catch(SQLException e) {
            log.error("Error while trying to insert producer '{}'", id, e);
        }
    }

    public static void update(Producer producer) {
        String sql = "UPDATE anime_store.producer SET name = '%s' WHERE id = %d".formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Updated producer '{}' from the database rows affected {}", producer.getId(), rowsAffected);
        } catch(SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    public static List<Producer> findAll() {
        log.info("Finding all Producers");
        return findByName("");
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding Producers by name");
        String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%%%s%%'".formatted(name);
        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch(SQLException e) {
            log.error("Error while trying find producers by name.", e);
        }
        return producers;
    }

    public static void showProducerMetadata() {
        log.info("Showing Producer Metadata");
        String sql = "SELECT * FROM anime_store.producer";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            log.info("Columns count '{}'", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", rsMetaData.getTableName(i));
                log.info("Column name '{}'", rsMetaData.getColumnName(i));
                log.info("Column size '{}'", rsMetaData.getColumnDisplaySize(i));
                log.info("Column type '{}'", rsMetaData.getColumnTypeName(i));
            }
        } catch(SQLException e) {
            log.error("Error while trying find all producers.", e);
        }
    }

}
