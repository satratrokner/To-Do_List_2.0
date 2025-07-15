import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в To-Do List, готовы начать?");

        TaskManager taskmanager = new TaskManager();
        taskmanager.loadTaskFromFile("C:\\Users\\akatd\\IdeaProjects\\To-Do List 2.0\\Tasks");
        taskmanager.setupShutDownHook("C:\\Users\\akatd\\IdeaProjects\\To-Do List 2.0\\Tasks");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название задачи:");
            String name = scanner.nextLine();

            if ("exit".equalsIgnoreCase(name)) {
                break;
            }

            System.out.println("Введите текст задачи:");
            String text = scanner.nextLine();

            System.out.println("Введите статус задачи:");
            String status = scanner.nextLine();





            try {
                taskmanager.addTask(new Task(name, text, status));
                System.out.println("задача добавлена");
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }

        scanner.close();
    }
}
