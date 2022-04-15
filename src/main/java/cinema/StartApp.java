package cinema;

import cinema.dao.FilmDao;
import cinema.dao.UserDao;
import cinema.menu.Menu;
import cinema.menu.UserActionMenu;

import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        Menu menu = new Menu(new Scanner(System.in), userDao, new FilmDao(), new UserActionMenu(userDao));
        menu.startMenu();
    }
}

