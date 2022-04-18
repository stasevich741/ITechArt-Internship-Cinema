package cinema.menu.implementation;

import cinema.menu.Menu;

import java.util.Scanner;

import static cinema.constant.MenuSectionConst.MAIN_MENU;
import static cinema.constant.MenuSectionConst.WRONG_INPUT;

public class ManagerMenuImpl implements Menu {

    Scanner reader = new Scanner(System.in);

    public void menu() {
        try {
            while (true) {
                int command = Integer.parseInt(reader.nextLine());
                switch (command) {
                    case 1:
                        editMovieByManager();
                        break;
                    case 2:
                        buyTicketByManager();
                        break;
                    case 3:
                        returnTicketByManager();
                        break;
                    case 4:
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

    private void returnTicketByManager() {
    }

    private void buyTicketByManager() {
    }

    private void editMovieByManager() {
    }
}
