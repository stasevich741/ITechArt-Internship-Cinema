package cinema.menu.implementation;

import cinema.constant.MenuSectionConst;
import cinema.constant.RoleActionConst;
import cinema.dao.TicketDao;
import cinema.entity.Ticket;
import cinema.menu.Menu;

import java.util.Scanner;

public class UserMenuImpl implements Menu {

    private Scanner reader = new Scanner(System.in);

    TicketDao ticketDao = new TicketDao();

    private AdminMenuImpl adminMenu = new AdminMenuImpl();
    private ManagerMenuImpl managerMenu = new ManagerMenuImpl();

    public void showMenu() {
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
        System.out.println(RoleActionConst.BUY_TICKET);
        Ticket ticket = managerMenu.getTicketIdByInput();
        ticket.setBought(true);
//       set user_id this
        ticketDao.update(ticket);
    }

    private void returnTicket() {
        System.out.println(RoleActionConst.RETURN_TICKET);
        Ticket ticket = managerMenu.getTicketIdByInput();
        ticket.setBought(false);
        //user_id null
        ticketDao.update(ticket);
    }

    private void viewBoughtTickets() {
//select from ticket where user_id = this
    }
}
