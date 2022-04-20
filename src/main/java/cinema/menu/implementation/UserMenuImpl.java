package cinema.menu.implementation;

import cinema.constant.MenuSectionConst;
import cinema.menu.Menu;

import java.util.Scanner;

public class UserMenuImpl implements Menu {

    private Scanner reader = new Scanner(System.in);

    AdminMenuImpl adminMenu = new AdminMenuImpl();

    public void menu() {
        try {
            while (true) {
                int command = Integer.parseInt(reader.nextLine());
                switch (command) {
                    case 1:
                        adminMenu.showFilms();
                        break;
                    case 2:
                        buyTicket();
                        break;
                    case 3:
                        returnTicket();
                        break;
                    case 4:
                        viewBoughtTickets();
                    case 5:
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

    private void buyTicket() {
    }

    private void returnTicket() {
    }

    private void viewBoughtTickets() {
    }
}
