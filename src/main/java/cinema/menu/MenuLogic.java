package cinema.menu;

import cinema.entity.Role;
import cinema.entity.User;
import cinema.menu.implementation.AdminMenuImpl;
import cinema.menu.implementation.ManagerMenuImpl;
import cinema.menu.implementation.UserMenuImpl;
import cinema.service.AuthService;
import cinema.service.FilmService;

import java.util.Optional;
import java.util.Scanner;

import static cinema.constant.MenuSectionConst.*;

public class MenuLogic {

    private final Scanner reader;

    private final UserMenuImpl userMenu;
    private final ManagerMenuImpl managerMenu;
    private final AdminMenuImpl adminMenu;

    private final FilmService filmService;
    private final AuthService authService;

    public MenuLogic(Scanner reader, UserMenuImpl userMenu, ManagerMenuImpl managerMenu, AdminMenuImpl adminMenu, FilmService filmService, AuthService authService) {
        this.reader = reader;
        this.userMenu = userMenu;
        this.managerMenu = managerMenu;
        this.adminMenu = adminMenu;
        this.filmService = filmService;
        this.authService = authService;
    }

    public void showStartMenu() {
        System.out.println(MAIN_MENU);
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

    void userMenuSelection(Optional<User> user) {

        if (user.get().getUserRole() == Role.USER) {
            System.out.println(USER_MENU);
            userMenu.menu();
        }

        if (user.get().getUserRole() == Role.MANAGER) {
            System.out.println(MANAGER_MENU);
            managerMenu.menu();
        }

        if (user.get().getUserRole() == Role.ADMIN) {
            System.out.println(ADMIN_MENU);
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
        userMenuSelection(authService.authentication());
    }
}

