package cinema.menu;

import cinema.constant.MenuSectionConst;
import cinema.entity.Role;
import cinema.entity.User;
import cinema.menu.implementation.AdminMenuImpl;
import cinema.menu.implementation.ManagerMenuImpl;
import cinema.menu.implementation.UserMenuImpl;
import cinema.service.AuthService;
import cinema.service.FilmService;

import java.util.Optional;
import java.util.Scanner;

public class MenuLogic {

    private Scanner reader;

    private Menu userMenu;
    private Menu managerMenu;
    private Menu adminMenu;

    private FilmService filmService;
    private AuthService authService;

    public MenuLogic(Scanner reader, UserMenuImpl userMenu, ManagerMenuImpl managerMenu, AdminMenuImpl adminMenu, FilmService filmService, AuthService authService) {
        this.reader = reader;
        this.userMenu = userMenu;
        this.managerMenu = managerMenu;
        this.adminMenu = adminMenu;
        this.filmService = filmService;
        this.authService = authService;
    }

    public void showStartMenu() {
        System.out.println(MenuSectionConst.MAIN_MENU);
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
                        System.err.println(MenuSectionConst.WRONG_INPUT);
                        break;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    void selectUserMenu(Optional<User> user) {

        if (user.get().getUserRole() == Role.USER) {
            System.out.println(MenuSectionConst.USER_MENU);
            userMenu.menu();
        }

        if (user.get().getUserRole() == Role.MANAGER) {
            System.out.println(MenuSectionConst.MANAGER_MENU);
            managerMenu.menu();
        }

        if (user.get().getUserRole() == Role.ADMIN) {
            System.out.println(MenuSectionConst.ADMIN_MENU);
            adminMenu.menu();
        }
    }

    private void showFilms() {
        filmService.showFilms();
    }

    private void registration() {
        authService.registration();
    }

    private void authentication() {
        selectUserMenu(authService.authentication());
    }
}

