package cinema;

import cinema.dao.FilmDao;
import cinema.menu.MenuLogic;
import cinema.menu.implementation.AdminMenuImpl;
import cinema.menu.implementation.ManagerMenuImpl;
import cinema.menu.implementation.UserMenuImpl;
import cinema.service.AuthService;
import cinema.service.FilmService;

import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FilmDao filmDao = new FilmDao();
        UserMenuImpl userMenu = new UserMenuImpl();
        ManagerMenuImpl managerMenu = new ManagerMenuImpl();
        AdminMenuImpl adminMenu = new AdminMenuImpl();
        FilmService filmService = new FilmService(filmDao);
        AuthService authService = new AuthService();

        MenuLogic menuLogic = new MenuLogic(scanner, userMenu, managerMenu, adminMenu, filmService, authService);
        menuLogic.showStartMenu();
    }
}


