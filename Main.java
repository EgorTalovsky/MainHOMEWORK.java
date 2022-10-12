import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Пришло время практики!");
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter Converter = new Converter();
        while (true) {
            printMenu();
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                System.out.println("Введите месяц (0 - январь, 11 - декабрь)");
                int month = scanner.nextInt();
                System.out.println("Введите день");
                int day = scanner.nextInt();
                stepTracker.saveSteps(steps, month, day);
                System.out.println("Значение сохранено! Месяц: " + month + " , день: " + day + " количество шагов: " + steps);
            } else if (cmd == 2) {
                System.out.println("За какой месяц показать статистику? (0 - январь, 11 - декабрь)");
                int month = scanner.nextInt();
                stepTracker.showDailyStats(month);
                System.out.println("Сумма шагов за " + month + " месяц: " + stepTracker.showTotalAmt(month));
                System.out.println("Рекорд за месяц: " + stepTracker.showMaxAmt(month) + " шагов.");
                System.out.println("Среднедневное количество шагов в " + month + "-м месяце: " + stepTracker.showAvrgAmt(month));
                System.out.println("Пройденная дистанция: " + Converter.showDistance(stepTracker.showTotalAmt(month)) + "км");
                System.out.println("Сожжено калорий: " + Converter.showCalAmt(stepTracker.showTotalAmt(month)));
                System.out.println("Лучшая серия: " + stepTracker.bestRange(month) );
            } else if (cmd == 3) {
                System.out.println("Введите новое целевое значение");
                int newGoal = scanner.nextInt();
                stepTracker.saveNewGoal(newGoal);
                System.out.println("Цель сохранена, теперь она " + newGoal + " шагов. " );
            } else if (cmd == 0) {
                System.out.println("Завершение сеанса...");
                System.out.println("Завершение работы");
                break;
            } else if (cmd < 0 || cmd > 3) {
                System.out.println("Такой команды пока нет, давайте еще разочек");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Увидеть статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день;");
        System.out.println("0. Выход");
    }
}
