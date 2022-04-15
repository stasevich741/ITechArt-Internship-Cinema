package cinema.query;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserQuery {

    public static final String FIND_ALL_USERS_QUERY = "select id,login,password,role from users";
    public static final String DELETE_USER_BY_ID_QUERY = "delete from users where id=?";
    public static final String INSERT_USER_QUERY = "insert into users ( login, password, role) VALUES (?,?,?)";
    public static final String UPDATE_USER_QUERY = "update users set login =?,password=?,role=? where id=?";
    public static final String FIND_BY_ID_QUERY = "select id,login,password,role from users where id=?";
    public static final String SQL_ID_BY_LOGIN_AND_PASSWORD = "select id from users where login=? and password=?";
}
