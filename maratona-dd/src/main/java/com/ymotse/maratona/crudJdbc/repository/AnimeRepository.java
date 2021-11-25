package com.ymotse.maratona.crudJdbc.repository;

import com.ymotse.maratona.crudJdbc.conn.ConnectionFactory;
import com.ymotse.maratona.crudJdbc.dominio.Anime;
import com.ymotse.maratona.crudJdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class AnimeRepository {

    public static List<Anime> findByName(String name) {
        log.info("Finding Producers by name");

        List<Anime> animes = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Producer producer = Producer.builder()
                        .name(rs.getString("producer_name"))
                        .id(rs.getInt("producer_id"))
                        .build();

                Anime anime = Anime.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .episodes(rs.getInt("episodes"))
                        .producer(producer)
                        .build();
                animes.add(anime);
            }
        } catch(SQLException e) {
            log.error("Error while trying find animes by name Prepared Statement.", e);
        }
        return animes;
    }

    private static PreparedStatement createPrepareStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = """
                        SELECT 
                            a.id
                            , a.name
                            , a.episodes
                            , a.producer_id
                            , p.name AS 'producer_name' 
                        FROM 
                            anime_store.anime a 
                        INNER JOIN 
                            anime_store.producer p 
                            ON a.producer_id = p.id 
                        WHERE 
                            LOWER(a.name) LIKE LOWER(?)
                        """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.format("%%%s%%", name));
        return preparedStatement;
    }

    public static void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementDelete(conn, id)) {
            ps.execute();
            log.info("Deleted anime '{}' from the database", id);
        } catch(SQLException e) {
            log.error("Error while trying to insert anime '{}'", id, e);
        }
    }

    private static PreparedStatement createPrepareStatementDelete(Connection connection, Integer id) throws SQLException {
        String sql = "DELETE FROM anime_store.anime WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    public static void save(Anime anime) {
        log.info("Saving Anime '{}'", anime);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementSave(conn, anime)) {
            ps.execute();
        } catch(SQLException e) {
            log.error("Error while trying to save anime '{}'", anime.getId(), e);
        }
    }

    private static PreparedStatement createPreparedStatementSave(Connection connection, Anime anime) throws SQLException {
        String sql = "INSERT INTO anime_store.anime (name, episodes, producer_id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, anime.getName());
        preparedStatement.setInt(2, anime.getEpisodes());
        preparedStatement.setInt(3, anime.getProducer().getId());
        return preparedStatement;
    }

    public static Optional<Anime> findById(Integer id) {
        log.info("Finding Anime by ID");

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementFindById(conn, id);
             ResultSet rs = ps.executeQuery()) {

            if(!rs.next()) {
                return Optional.empty();
            }

            Producer producer = Producer.builder()
                    .name(rs.getString("producer_name"))
                    .id(rs.getInt("producer_id"))
                    .build();

            Anime anime = Anime.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .episodes(rs.getInt("episodes"))
                    .producer(producer)
                    .build();

            return Optional.of(anime);
        } catch(SQLException e) {
            log.error("Error while trying find animes by name Prepared Statement.", e);
        }
        return Optional.empty();
    }

    private static PreparedStatement createPrepareStatementFindById(Connection connection, Integer id) throws SQLException {
        String sql = """
                        SELECT 
                            a.id
                            , a.name
                            , a.episodes
                            , a.producer_id
                            , p.name AS 'producer_name' 
                        FROM 
                            anime_store.anime a 
                        INNER JOIN 
                            anime_store.producer p 
                            ON a.producer_id = p.id 
                        WHERE 
                            a.id = ? 
                        """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    public static void update(Anime anime) {
        log.info("Updating anime '{}'", anime);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementUpdate(conn, anime)) {
            ps.execute();
        } catch(SQLException e) {
            log.error("Error while trying to update anime '{}'", anime.getId(), e);
        }
    }

    private static PreparedStatement createPreparedStatementUpdate(Connection connection, Anime anime) throws SQLException {
        String sql = "UPDATE anime_store.anime SET name = ?, episodes = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, anime.getName());
        preparedStatement.setInt(2, anime.getEpisodes());
        preparedStatement.setInt(3, anime.getId());
        return preparedStatement;
    }

}
