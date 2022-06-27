import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[][] daysMonths = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}
    };
    public static int months;
    public static int day;
    public static int steps;

    // вся работа с пользовательским вводом и выводом
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Interface();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            Interface();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена.");
    }

    public static void Interface() {

        System.out.println("Приветствую! Выберите одно из действий: ");
        System.out.println("1. Ввести количество шагов за определённый день;");
        System.out.println("2. Напечатать статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день;");
        System.out.println("4. Выйти из приложения.");

        Scanner user = new Scanner(System.in);
        int command = user.nextInt();
        while(true) {
            if (command == 1) {
                // ввести кол-во шагов за опр. день
                StepTracker.StepTracker();
                Interface();
            } else if (command == 2) {
                // статистика
                StepTracker.showStatistics();
                Interface();
            } else if (command == 3) {
                // изменить цель по кол-ву шагов в день
                StepTracker.changeGoalSteps();
                Interface();
            } else if (command == 4) {
                // выйти
                System.out.println("Выход.");
                break;
            } else {
                System.out.println("Ошибка! Такой команды нет.");
                Interface();
            }
        }
    }
}


class StepTracker {
    public static int goalSteps = 10000;
    public static void StepTracker() {
        // подсчет шагов
        Scanner user = new Scanner(System.in);
        System.out.println("Введите номер месяца (от 0 до 11):");
        Main.months = user.nextInt();
        if(Main.months<0||Main.months>11){
            System.out.println("Неверное число. Введите от 0 до 11:");
            Main.months = user.nextInt();
        }
        System.out.println("Введите день (от 0 до 29):");
        Main.day = user.nextInt();
        if(Main.day<0||Main.day>29){
            System.out.println("Неверное число. Введите от 0 до 29:");
            Main.day = user.nextInt();
        }
        System.out.println("Введите количество шагов:");
        Main.steps = user.nextInt();
        if(Main.steps<0){
            System.out.println("Количество шагов не может быть отрицательным. Введите положительное число или 0.");
            Main.steps = user.nextInt();
        }
        Main.steps = Main.daysMonths[Main.months][Main.day];
        showStatistics();
    }

    public static void showStatistics() {
        Scanner user = new Scanner(System.in);
// вывод статистики
        System.out.println("Хотите увидеть статистику? (Да/Нет)");
        String yesNo = user.nextLine();
        if (yesNo.equals("Да")) {

            // Количество пройденных шагов по дням
            for (int i = 1; i < 30; i++) {
                System.out.print(i + " день: " + Main.daysMonths[Main.months][i-1] + " шагов, ");
            }

            // Общее количество шагов за месяц
            int sumStepsMonth = 0;
            for (int j = 0; j < 30; j++) {
                sumStepsMonth =+ Main.daysMonths[Main.months][j];
            }
            System.out.println("Общее количество шагов за месяц: " + sumStepsMonth);

            // Максимальное пройденное количество шагов в месяце
            int maxSteps = 0;
            for (int m = 1; m < 30; m++) {
                if (Main.daysMonths[Main.months][m-1] > Main.daysMonths[Main.months][m]) {
                    maxSteps = Main.daysMonths[Main.months][m-1];
                } else {
                    maxSteps = Main.daysMonths[Main.months][m];
                }
            }
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);

            // Среднее количество шагов
            int averageNumOfSteps = 0;
            for (int a = 0; a < 30; a++) {
                averageNumOfSteps += Main.daysMonths[Main.months][a];
            }
            averageNumOfSteps = averageNumOfSteps / 30;
            System.out.println("Среднее количество шагов: " + averageNumOfSteps);

            // Пройденная дистанция (в км)
            double distance = (Main.steps * 0.5) / 1000;
            System.out.println("Пройденная дистанция: " + distance + " км.");

            // Количество сожжённых килокалорий
            // формулу нашла на каком-то диет-форуме, прости господи
            System.out.println("Количество сожжённых килокалорий за день: " + Converter(distance));

            // Лучшая серия: максимальное количество подряд идущих дней,
            // в течение которых количество шагов за день
            // было равно или выше целевого.
            int maxDayRow = 0;
            for (int x = 0; x < 30; x++) {
                if (Main.daysMonths[Main.months][x] >= goalSteps && Main.daysMonths[Main.months][x + 1] >= goalSteps) {
                    maxDayRow++;
                }
            }
            System.out.println("Лучшая серия: " + maxDayRow + " дней подряд.");
        } else if (yesNo.equals("Нет")) {
            System.out.println("Океюшки. Вывожу главное меню.");
            Main.Interface();
        } else {
            System.out.println("Нет такой команды.");
            Main.Interface();
        }
    }

    public static void changeGoalSteps(){
        Scanner user = new Scanner(System.in);
        System.out.println("Целевое количество шагов: "+ goalSteps+" в день.");
        System.out.println("Новая цель: ");
        int newGoal = user.nextInt();
        if(newGoal>=0){
            newGoal = goalSteps;
        } else{
            System.out.println("Целевое количество шагов не может быть отрицательным!");
        }
    }

    public static double Converter(double distance){
        double calories = distance * 75;
        return calories;
    }
}
