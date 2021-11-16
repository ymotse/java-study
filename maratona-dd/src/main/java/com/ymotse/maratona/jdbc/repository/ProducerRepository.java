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

    public static void showDriverMetadata() {
        log.info("Showing Driver Metadata\n");
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY");
                if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }

            if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }

            if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_SENSITIVE");
                if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
        } catch(SQLException e) {
            log.error("Error while showing driver matadata.", e);
        }
    }

    public static void showTypeScrollWorking() {
        String sql = "SELECT id, name FROM anime_store.producer";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {

            log.info("Last row? '{}'", rs.last());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build());

            System.out.println();

            log.info("First row? '{}'", rs.first());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build());

            System.out.println();

            log.info("Row Absolute? '{}'", rs.absolute(2));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build());

            System.out.println();

            log.info("Row Relative? '{}'", rs.relative(-1));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build());

            System.out.println();

            log.info("is last? '{}'", rs.isLast());
            log.info("Row number '{}'", rs.getRow());

            log.info("Last row? '{}'", rs.last());
            rs.next();
            log.info("After last row? '{}'", rs.isAfterLast());

            System.out.println("----------------------");
            while(rs.previous()) {
                log.info(Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build());
            }
        } catch(SQLException e) {
            log.error("Error while showing type scroll working.", e);
        }
    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        log.info("Finding Producers by name And update to uppercase");
        String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%%%s%%'".formatted(name);
        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                rs.updateString("name", rs.getString("name").toUpperCase());
//                rs.cancelRowUpdates();
                rs.updateRow();
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch(SQLException e) {
            log.error("Error while trying find producers by name and update to uppercase.", e);
        }
        return producers;
    }

    public static List<Producer> findByNameAndInsertThenNotFound(String name) {
        log.info("Finding Producers by name And insert then not found");
        String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%%%s%%'".formatted(name);
        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            if(rs.next()) {
                return producers;
            }
            insertNewProducer(name, rs);

            producers.add(getProducer(rs));
        } catch(SQLException e) {
            log.error("Error while trying find producers by name and insert then not found.", e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        log.info("Finding Producers by name And delete");
        String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%%%s%%'".formatted(name);

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
               rs.deleteRow();
            }
        } catch(SQLException e) {
            log.error("Error while trying find producers by name and delete.", e);
        }
    }

    public static List<Producer> findByNamePreparedStatement(String name) {
        log.info("Finding Producers by name Prepared Statement");

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementFindByName(conn, name);
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

    public static void updatePreparedStatement(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementUpdate(conn, producer)) {
            int rowsAffected = ps.executeUpdate();
            log.info("Updated producer '{}' from the database rows affected {}", producer.getId(), rowsAffected);
        } catch(SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    private static PreparedStatement preparedStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, "%" + name + "%");
//        preparedStatement.setString(1, String.format("%%%s%%", name));
        preparedStatement.setString(1, name);
        return preparedStatement;
    }

    private static PreparedStatement preparedStatementUpdate(Connection connection, Producer producer) throws SQLException {
        String sql = "UPDATE anime_store.producer SET name = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, producer.getName());
        preparedStatement.setInt(2, producer.getId());
        return preparedStatement;
    }

    private static void insertNewProducer(String name, ResultSet rs) throws SQLException {
        rs.moveToInsertRow();
        rs.updateString("name", name);
        rs.insertRow();
    }

    private static Producer getProducer(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        rs.next();
        return Producer.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build();
    }

}
