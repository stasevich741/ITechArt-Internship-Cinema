package cinema.menu;

import cinema.dao.UserDao;
import cinema.entity.Role;
import cinema.entity.User;

import java.util.Optional;

public class UserActionMenu {

    UserDao userDao = new UserDao();

    void userMenu(Optional<User> user) {

        if (user.get().getUserRole() == Role.USER) {
            System.out.println("user");
        }

        if (user.get().getUserRole() == Role.MANAGER) {
            System.out.println("manager");
        }

        if (user.get().getUserRole() == Role.ADMIN) {
            System.out.println("admin");
        }
    }
}
