package cinema.menu.implementation;

import cinema.menu.Menu;

import java.util.Scanner;

import static cinema.constant.MenuSectionConst.MAIN_MENU;
import static cinema.constant.MenuSectionConst.WRONG_INPUT;

public class UserMenuImpl implements Menu {

    Scanner reader = new Scanner(System.in);

    public void menu() {
        try {
            while (true) {
                int command = Integer.parseInt(reader.nextLine());
                switch (command) {
                    case 1:
                        showFilms();
                        break;
                    case 2:
                        buyTicketByUser();
                        break;
                    case 3:
                        returnTicketByUser();
                        break;
                    case 4:
                        viewBoughtTicketsByUser();
                    case 5:
                        System.out.println(MAIN_MENU);
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
    }

    private void buyTicketByUser() {
    }

    private void returnTicketByUser() {
    }

    private void viewBoughtTicketsByUser() {
    }
}
