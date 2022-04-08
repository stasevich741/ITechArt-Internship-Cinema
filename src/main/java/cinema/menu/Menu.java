package cinema.menu;
//Данный слой не хранит информацию, только обрабатывает.
//        -     Слой консольного меню должен выводить информацию на экран, уметь получать информацию с экрана.
//        При этом консольный слой не должен производить обработку информации, для этого должны вызываться специальные методы из сервисного слоя.

import cinema.dao.FilmDao;
import cinema.dao.UserDao;
import cinema.entity.Film;
import cinema.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

    Scanner reader = new Scanner(System.in);
    UserDao userDao = new UserDao();
    FilmDao filmDao = new FilmDao();

    public void startMenu() {

        mainMenu();

        try {
            while (true) {
                int command = Integer.parseInt(reader.nextLine());

                if (command == 1) {
                    authentication();

                } else if (command == 2) {
                    registration();

                } else if (command == 3) {
                    showFilms();

                } else if (command == 4) System.exit(0);

                else System.err.println("некорректный ввод");
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
        System.out.println("введите логин");
        String login = reader.nextLine();
        System.out.println("введите пароль");
        String password = reader.nextLine();
        User user = new User(login, password);
        userDao.save(user);
    }

    private Optional<User> authentication() {
        System.out.println("введите логин");
        String login = reader.nextLine();
        System.out.println("введите пароль");
        String password = reader.nextLine();
        String sql_id_by_login_and_password = "select id from users where login='" + login + "' and password='" + password + "'";
        Optional<User> userDaoById = userDao.findById(Long.parseLong(sql_id_by_login_and_password));
        if (userDaoById.isPresent())
            return userDaoById;
        else throw new RuntimeException();
    }

    private void mainMenu() {
        System.out.println("===МЕНЮ===" + "\n" +
                "1. войти" + "\n" +
                "2. регистрация" + "\n" +
                "3. просмотреть мероприятия(фильмы)" + "\n" +
                "4. выход");
    }
}
