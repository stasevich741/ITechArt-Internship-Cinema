package cinema.menu.implementation;

import cinema.constant.MenuSectionConst;
import cinema.constant.RoleActionConst;
import cinema.dao.FilmDao;
import cinema.dao.TicketDao;
import cinema.dao.UserDao;
import cinema.entity.Film;
import cinema.entity.Role;
import cinema.entity.Ticket;
import cinema.entity.User;
import cinema.menu.Menu;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class AdminMenuImpl implements Menu {

    private Scanner reader = new Scanner(System.in);

    private FilmDao filmDao = new FilmDao();
    private UserDao userDao = new UserDao();
    private TicketDao ticketDao = new TicketDao();

    public void showMenu() {
        try {
            while (true) {
                int command = Integer.parseInt(reader.nextLine());
                switch (command) {
                    case 1:
                        showUsers();
                        break;
                    case 2:
                        showFilms();
                        break;
                    case 3:
                        showTickets();
                        break;
                    case 4:
                        deleteUser();
                        break;
                    case 5:
                        editUser();
                        break;
                    case 6:
                        deleteMovie();
                        break;
                    case 7:
                        editMovie();
                    case 8:
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

    void showTickets() {
        List<Ticket> tickets = ticketDao.findAll();
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
            showMenu();
        }
    }

    void showFilms() {
        List<Film> films = filmDao.findAll();
        for (Film film : films) {
            System.out.println(film);
            showMenu();
        }
    }

    private void showUsers() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            showMenu();
        }
    }

    void editMovie() {
        System.out.println(RoleActionConst.EDIT_MOVIE);
        Long id = null;
        try {
            id = Long.getLong(reader.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Optional<Film> filmOptional = filmDao.findById(id);
        Film film = filmOptional.get();
        System.out.println(RoleActionConst.ENTER_NAME);
        film.setName(reader.nextLine());
        System.out.println(RoleActionConst.ENTER_COUNT_TICKETS);
        try {
            film.setTicket(Integer.parseInt(reader.nextLine()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        filmDao.update(film);
    }

    private void deleteMovie() {
        System.out.println(RoleActionConst.DELETE_MOVIE);
        Long id = null;
        try {
            id = Long.getLong(reader.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        filmDao.delete(id);

    }

    private void editUser() {
        System.out.println(RoleActionConst.EDIT_USER);
        Long id = null;
        try {
            id = Long.getLong(reader.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Optional<User> filmOptional = userDao.findById(id);
        User user = filmOptional.get();
        System.out.println(RoleActionConst.ENTER_NAME);
        user.setLogin(reader.nextLine());

        System.out.println(RoleActionConst.ENTER_PASSWORD);
        user.setPassword(reader.nextLine());

        System.out.println(RoleActionConst.ENTER_ROLE);
        user.setUserRole(Role.valueOf(reader.nextLine()));
    }

    private void deleteUser() {
        System.out.println(RoleActionConst.DELETE_USER);
        Long id = null;
        try {
            id = Long.getLong(reader.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        userDao.delete(id);
    }
}
