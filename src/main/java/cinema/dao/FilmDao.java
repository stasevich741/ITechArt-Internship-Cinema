package cinema.dao;

import cinema.entity.Film;
import cinema.exception.DaoException;
import cinema.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilmDao implements Dao<Film> {

    private static final String FIND_ALL_FILMS_QUERY = "select id, name, date_and_time, tickets_list from film";
    private static final String FIND_BY_ID_FILM_QUERY = "select id, name, date_and_time, tickets_list from film where id=?";
    private static final String DELETE_FILM_BY_ID_QUERY = "delete from film where id=?";
    private static final String INSERT_FILM_QUERY = "insert into film ( name, date_and_time, tickets_list ) VALUES (?,?,?)";
    private static final String UPDATE_FILM_QUERY = "update film set name =?,date_and_time=?,tickets_list=? where id=?";

    @Override
    public List<Film> findAll() {
        List<Film> filmList = new ArrayList<>();
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_FILMS_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                filmList.add(buildFilm(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return filmList;
    }

    @Override
    public Optional<Film> findById(Long id) {
        Film film = null;
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_FILM_QUERY);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                film = buildFilm(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.ofNullable(film);
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FILM_BY_ID_QUERY);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Film film) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FILM_QUERY);
            preparedStatement.setString(1, film.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(film.getTimeAndDate()));
            preparedStatement.setInt(3, film.getTicket());
            preparedStatement.setLong(4, film.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void save(Film film) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FILM_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, film.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(film.getTimeAndDate()));
            preparedStatement.setInt(3, film.getTicket());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Film buildFilm(ResultSet resultSet) throws SQLException {
        return new Film(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("name", String.class),
                resultSet.getObject("date_and_time", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("tickets_list", Integer.class)
        );
    }
}