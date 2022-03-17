package cinema.dao;

import cinema.entity.Role;
import cinema.entity.User;
import cinema.exception.DaoException;
import cinema.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {

    private static final String FIND_ALL_USERS_QUERY = "select id,login,password,role from users";
    private static final String DELETE_USER_BY_ID_QUERY = "delete from users where id=?";
    private static final String INSERT_USER_QUERY = "insert into users ( login, password, role) VALUES (?,?,?)";
    private static final String UPDATE_USER_QUERY = "update users set login =?,password=?,role=? where id=?";
    private static final String FIND_BY_ID_QUERY = "select id,login,password,role from users where id=?";

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(buildUser(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return userList;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = null;
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = buildUser(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID_QUERY);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setObject(3, user.getUserRole());
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void save(User user) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUserRole().name());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private User buildUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("login", String.class),
                resultSet.getObject("password", String.class),
                Role.valueOf(resultSet.getObject("role", String.class))
        );
    }
}
