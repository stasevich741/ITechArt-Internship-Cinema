package cinema.menu;
//Данный слой не хранит информацию, только обрабатывает.
//        -     Слой консольного меню должен выводить информацию на экран, уметь получать информацию с экрана.
//        При этом консольный слой не должен производить обработку информации, для этого должны вызываться специальные методы из сервисного слоя.

import java.util.Scanner;

public class Menu {
    public static void extracted() {
        //      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(System.in);

        System.out.println("===МЕНЮ===");
        System.out.println("1. войти");
        System.out.println("2. регистрация");
        System.out.println("3. выход");


        try {
            while (true) {
                int command = Integer.parseInt(reader.nextLine());

                if (command == 1) {
                    System.out.println("1/ enter");

                } else if (command == 2) {
                    System.out.println("2/ register");

                } else if (command == 3) System.exit(0);

                else System.err.println("wrong typing");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
