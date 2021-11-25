package com.ymotse.maratona.crudJdbc.repository;

import com.ymotse.maratona.crudJdbc.conn.ConnectionFactory;
import com.ymotse.maratona.crudJdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {

    public static List<Producer> findByName(String name) {
        log.info("Finding Producers by name");

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch(SQLException e) {
            log.error("Error while trying find producers by name Prepared Statement.", e);
        }
        return producers;
    }

    private static PreparedStatement createPrepareStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer WHERE LOWER(name) LIKE LOWER(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.format("%%%s%%", name));
        return preparedStatement;
    }

    public static void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementDelete(conn, id)) {
            ps.execute();
            log.info("Deleted producer '{}' from the database", id);
        } catch(SQLException e) {
            log.error("Error while trying to insert producer '{}'", id, e);
        }
    }

    private static PreparedStatement createPrepareStatementDelete(Connection connection, Integer id) throws SQLException {
        String sql = "DELETE FROM anime_store.producer WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    public static void save(Producer producer) {
        log.info("Saving Producer '{}'", producer);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementSave(conn, producer)) {
            ps.execute();
        } catch(SQLException e) {
            log.error("Error while trying to save producer '{}'", producer.getId(), e);
        }
    }

    private static PreparedStatement createPreparedStatementSave(Connection connection, Producer producer) throws SQLException {
        String sql = "INSERT INTO anime_store.producer (name) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, producer.getName());
        return preparedStatement;
    }



}
