package cinema.dao;

import cinema.entity.Ticket;
import cinema.exception.DaoException;
import cinema.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Ticket> {

    private static final String FIND_ALL_TICKETS_QUERY = "select id, user_id, film, seat_place, price, is_bought from ticket";
    private static final String DELETE_TICKET_BY_ID_QUERY = "delete from ticket where id=?";
    private static final String INSERT_TICKET_QUERY = "insert into ticket ( user_id, film, seat_place, price, is_bought) VALUES (?,?,?,?,?)";
    private static final String UPDATE_TICKET_QUERY = "update ticket set user_id =?,film=?,seat_place=?,price=?,is_bought=? where id=?";
    private static final String FIND_BY_ID_QUERY = "select id, user_id, film, seat_place, price, is_bought from ticket where id=?";

    @Override
    public List<Ticket> findAll() {
        List<Ticket> ticketList = new ArrayList<>();
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_TICKETS_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ticketList.add(buildTicket(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return ticketList;
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        Ticket ticket = null;
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ticket = buildTicket(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.ofNullable(ticket);
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TICKET_BY_ID_QUERY);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Ticket ticket) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TICKET_QUERY);
            preparedStatement.setInt(1, ticket.getUserId());
            preparedStatement.setString(2, ticket.getFilm());
            preparedStatement.setInt(3, ticket.getSeatPlace());
            preparedStatement.setBigDecimal(4, ticket.getPrice());
            preparedStatement.setBoolean(5, ticket.isBought());
            preparedStatement.setLong(6, ticket.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void save(Ticket ticket) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TICKET_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, ticket.getUserId());
            preparedStatement.setString(2, ticket.getFilm());
            preparedStatement.setInt(3, ticket.getSeatPlace());
            preparedStatement.setBigDecimal(4, ticket.getPrice());
            preparedStatement.setBoolean(5, ticket.isBought());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Ticket buildTicket(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("user_id", Integer.class),
                resultSet.getObject("film", String.class),
                resultSet.getObject("seat_place", Integer.class),
                resultSet.getObject("price", BigDecimal.class),
                resultSet.getObject("is_bought", Boolean.class)
        );
    }
}
