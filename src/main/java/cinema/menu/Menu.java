package cinema.menu;

import cinema.dao.FilmDao;
import cinema.dao.UserDao;
import cinema.entity.Film;
import cinema.entity.User;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner reader;
    private final UserDao userDao;
    private final FilmDao filmDao;
    private final UserActionMenu userActionMenu;

    private final String ASK_FOR_LOGIN = "enter login";
    private final String ASK_FOR_PASSWORD = "enter password";
    private final String WRONG_INPUT = "incorrect input";

    public Menu(Scanner reader, UserDao userDao, FilmDao filmDao, UserActionMenu userActionMenu) {
        this.reader = reader;
        this.userDao = userDao;
        this.filmDao = filmDao;
        this.userActionMenu = userActionMenu;
    }

    public void startMenu() {
        mainMenu();
        try {
            while (true) {
                int command = Integer.parseInt(reader.nextLine());
                switch (command) {
                    case 1:
                        authentication();
                        break;
                    case 2:
                        registration();
                        break;
                    case 3:
                        showFilms();
                        break;
                    case 4:
                        return;
                    default:
                        System.err.println(WRONG_INPUT);
                        break;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void showFilms() {
        List<Film> films = filmDao.findAll();
        for (Film film : films) {
            System.out.println(film);
        }
    }

    private void registration() {
        System.out.println(ASK_FOR_LOGIN);
        String login = reader.nextLine();
        System.out.println(ASK_FOR_PASSWORD);
        String password = reader.nextLine();
        User user = new User(login, password);
        userDao.save(user);
    }

    private void authentication() {
        System.out.println(ASK_FOR_LOGIN);
        String login = reader.nextLine();
        System.out.println(ASK_FOR_PASSWORD);
        String password = reader.nextLine();
        userActionMenu.userMenu(userDao.userAuthenticationByLoginAndPassword(login, password));
    }

    private void mainMenu() {
        System.out.println("===MENU===" + "\n" +
                "1. enter" + "\n" +
                "2. registration" + "\n" +
                "3. view events(movies)" + "\n" +
                "4. quit");
    }
}
