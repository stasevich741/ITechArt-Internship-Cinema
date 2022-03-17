package cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    Long id;
    String login;
    String password;
    Role userRole;

    public User(String login, String password, Role userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }
}
