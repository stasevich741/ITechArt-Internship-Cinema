package cinema.query;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TicketQuery {

    public static final String FIND_ALL_TICKETS_QUERY = "select id, user_id, film, seat_place, price, is_bought from ticket";
    public static final String DELETE_TICKET_BY_ID_QUERY = "delete from ticket where id=?";
    public static final String INSERT_TICKET_QUERY = "insert into ticket ( user_id, film, seat_place, price, is_bought) VALUES (?,?,?,?,?)";
    public static final String UPDATE_TICKET_QUERY = "update ticket set user_id =?,film=?,seat_place=?,price=?,is_bought=? where id=?";
    public static final String FIND_BY_ID_QUERY = "select id, user_id, film, seat_place, price, is_bought from ticket where id=?";
}
