package cinema.menu.implementation;

import cinema.constant.MenuSectionConst;
import cinema.constant.RoleActionConst;
import cinema.dao.TicketDao;
import cinema.entity.Ticket;
import cinema.menu.Menu;

import java.util.Optional;
import java.util.Scanner;

public class ManagerMenuImpl implements Menu {

    private Scanner reader = new Scanner(System.in);

    private AdminMenuImpl adminMenu = new AdminMenuImpl();

    private TicketDao ticketDao = new TicketDao();

    public void showMenu() {
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
        System.out.println(RoleActionConst.RETURN_TICKET);
        Ticket ticket = getTicketIdByInput();

        System.out.println(RoleActionConst.USER_ID_RETURN_TICKET);
        getUserIdByInput(ticket);
        ticket.setBought(false);
        ticketDao.update(ticket);
    }

    private void buyTicket() {
        System.out.println(RoleActionConst.BUY_TICKET);
        Ticket ticket = getTicketIdByInput();

        System.out.println(RoleActionConst.USER_ID_BYU_TICKET);
        getUserIdByInput(ticket);
        ticket.setBought(true);
        ticketDao.update(ticket);
    }

    private void editMovie() {
        adminMenu.editMovie();
    }

    Ticket getTicketIdByInput() {
        Long id = null;
        try {
            id = Long.getLong(reader.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Optional<Ticket> ticketOptional = ticketDao.findById(id);
        return ticketOptional.get();
    }

    private void getUserIdByInput(Ticket ticket) {
        try {
            ticket.setUserId(Integer.parseInt(reader.nextLine()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
