package cinema.menu.implementation;

import cinema.constant.MenuSectionConst;
import cinema.menu.Menu;

import java.util.Scanner;

public class ManagerMenuImpl implements Menu {

    private Scanner reader = new Scanner(System.in);

    private AdminMenuImpl adminMenu = new AdminMenuImpl();

    public void menu() {
        try {
            while (true) {
                int command = Integer.parseInt(reader.nextLine());
                switch (command) {
                    case 1:
                        adminMenu.showFilms();
                        break;
                    case 2:
                        adminMenu.showTickets();
                        break;
                    case 3:
                        editMovie();
                        break;
                    case 4:
                        buyTicket();
                        break;
                    case 5:
                        returnTicket();
                        break;
                    case 6:
                        System.out.println(MenuSectionConst.MAIN_MENU);
                    default:
                        System.err.println(MenuSectionConst.WRONG_INPUT);
                        break;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void returnTicket() {

    }

    private void buyTicket() {

    }

    private void editMovie() {
        adminMenu.editMovie();
    }
}
