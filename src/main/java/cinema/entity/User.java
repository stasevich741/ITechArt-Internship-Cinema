package cinema.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String login;
    private String password;
    private Role userRole;

    public User(String login, String password, Role userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }
}
