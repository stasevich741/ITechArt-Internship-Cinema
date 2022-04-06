package cinema.query;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FilmQuery {

    public static final String FIND_ALL_FILMS_QUERY = "select id, name, date_and_time, tickets_list from film";
    public static final String FIND_BY_ID_FILM_QUERY = "select id, name, date_and_time, tickets_list from film where id=?";
    public static final String DELETE_FILM_BY_ID_QUERY = "delete from film where id=?";
    public static final String INSERT_FILM_QUERY = "insert into film ( name, date_and_time, tickets_list ) VALUES (?,?,?)";
    public static final String UPDATE_FILM_QUERY = "update film set name =?,date_and_time=?,tickets_list=? where id=?";
}
