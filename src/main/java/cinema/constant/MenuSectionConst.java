package cinema.constant;

public final class MenuSectionConst {

    private MenuSectionConst() {
    }

    public static final String ASK_FOR_LOGIN = "enter login";
    public static final String ASK_FOR_PASSWORD = "enter password";
    public static final String WRONG_INPUT = "incorrect input";

    public static final String ADMIN_MENU = "===ADMIN_MENU===" + "\n" +
            "1. delete user" + "\n" +
            "2. edit(update) user" + "\n" +
            "3. delete events(movie)" + "\n" +
            "4. edit events(movie)" + "\n" +
            "5. quit";

    public static final String MAIN_MENU = "===MENU===" + "\n" +
            "1. enter" + "\n" +
            "2. registration" + "\n" +
            "3. view events(movies)" + "\n" +
            "4. quit";

    public static final String USER_MENU = "===USER_MENU===" + "\n" +
            "1. view events(movies)" + "\n" +
            "2. buy ticket" + "\n" +
            "3. return ticket" + "\n" +
            "4. view bought tickets" + "\n" +
            "5. quit";

    public static final String MANAGER_MENU = "===MANAGER_MENU===" + "\n" +
            "1. edit events(movie)" + "\n" +
            "2. buy ticket for user" + "\n" +
            "3. return ticket for user" + "\n" +
            "4. quit";
}
