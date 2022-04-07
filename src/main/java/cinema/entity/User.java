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

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.userRole = Role.USER;
    }
}
