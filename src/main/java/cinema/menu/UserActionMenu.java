package cinema.menu;

import cinema.dao.UserDao;
import cinema.entity.Role;
import cinema.entity.User;

import java.util.Optional;

//        Пользователь должен регистрироваться сам.
//        Может быть три уровня пользователя (у каждого свой уровень доступа).
//        1) Простой пользователь может:
//        - просматривать мероприятия (фильмы)
//        - покупать и возвращать билеты
//        - просматривать купленные билеты
//        2) Менеджер может:
//        - редактировать мероприятия (фильмы)
//        - покупать и возвращать билеты определенного пользователя
//        3) Админ может:
//        - удалять и изменять пользователей
//        - удалять и изменять мероприятия

//        Админ и менеджер добавляется изначально и не создается через форму регистрации.
//        -	Билет (id, пользователь, фильм, номер места, цена, флаг на куплен или нет)
//        Если место не куплено, тогда значение пользователя должно быть пустым.
//        -	Фильм (id, название, число + время, список билетов)

public class UserActionMenu {

    private final UserDao userDao;


    public UserActionMenu(UserDao userDao) {
        this.userDao = userDao;
    }


    void userMenu(Optional<User> user) {

        if (user.get().getUserRole() == Role.USER) {
            System.out.println("===USER_MENU===" + "\n" +
                    "1. view events(movies)" + "\n" +
                    "2. buy ticket" + "\n" +
                    "3. return ticket" + "\n" +
                    "4. view bought tickets" + "\n" +
                    "5. quit");
        }

        if (user.get().getUserRole() == Role.MANAGER) {
            System.out.println("===MANAGER_MENU===" + "\n" +
                    "1. edit events(movie)" + "\n" +
                    "2. buy and return for user" + "\n" +
                    "3. quit");
        }

        if (user.get().getUserRole() == Role.ADMIN) {
            System.out.println("===ADMIN_MENU===" + "\n" +
                    "1. delete and edit user" + "\n" +
                    "2. delete and edit events(movie)" + "\n" +
                    "4. quit");
        }
    }
}
