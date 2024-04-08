package SchoolJavaMalkov;

import java.util.Scanner;

public class ConsoleCounterApp {
    private Counter counter;
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Текущее значение счетчика: " + counter.getCount());
        while (true) {
            System.out.print("Введите команду (/inc, /stop, /reset): ");
            command = scanner.nextLine();
            switch (command) {
                case "/inc":
                    counter.increment();
                    System.out.println("Счетчик увеличен. Новое значение: " + counter.getCount());
                    break;
                case "/stop":
                    counter.saveState();
                    System.out.println("Текущее значение счетчика: " + counter.getCount());
                    System.out.println("Завершаю работу");
                    return;
                case "/reset":
                    counter.reset();
                    System.out.println("Счетчик сброшен. Новое значение: " + counter.getCount());
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте /inc, /stop или /reset.");
            }
        }
    }

    public ConsoleCounterApp() {
        counter = new Counter(); // Создаем экземпляр класса Counter
        Counter loadedCounter = counter.loadState(); // Загружаем состояние счетчика
        if (loadedCounter != null) {
            counter = loadedCounter; // Если загрузка прошла успешно, используем загруженный счетчик
            System.out.println("Счетчик загружен, значение: " + counter.getCount());
        } else {
            System.out.println("Счетчик не был загружен, создан новый счетчик.");
        }
    }
}
