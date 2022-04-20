package cinema.service;

import cinema.constant.MenuSectionConst;
import cinema.dao.UserDao;
import cinema.entity.User;

import java.util.Optional;
import java.util.Scanner;

public class AuthService {

    private Scanner reader = new Scanner(System.in);
    private UserDao userDao = new UserDao();

    public void registration() {
        User user = getUserByConsoleInput();
        userDao.save(user);
    }

    public Optional<User> authentication() {
        User user = getUserByConsoleInput();
        return userDao.userAuthenticationByLoginAndPassword(user.getLogin(), user.getPassword());
    }

    User getUserByConsoleInput() {
        System.out.println(MenuSectionConst.ASK_FOR_LOGIN);
        String login = reader.nextLine();

        System.out.println(MenuSectionConst.ASK_FOR_PASSWORD);
        String password = reader.nextLine();

        return new User(login, password);
    }
}
