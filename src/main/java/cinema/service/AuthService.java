package cinema.service;

import cinema.dao.UserDao;
import cinema.entity.User;

import java.util.Optional;
import java.util.Scanner;

import static cinema.constant.MenuSectionConst.ASK_FOR_LOGIN;
import static cinema.constant.MenuSectionConst.ASK_FOR_PASSWORD;

public class AuthService {

    Scanner reader = new Scanner(System.in);
    UserDao userDao = new UserDao();

    public void registration() {
        System.out.println(ASK_FOR_LOGIN);
        String login = reader.nextLine();
        System.out.println(ASK_FOR_PASSWORD);
        String password = reader.nextLine();
        User user = new User(login, password);
        userDao.save(user);
    }

    public Optional<User> authentication() {
        System.out.println(ASK_FOR_LOGIN);
        String login = reader.nextLine();
        System.out.println(ASK_FOR_PASSWORD);
        String password = reader.nextLine();
        return userDao.userAuthenticationByLoginAndPassword(login, password);
    }
}
