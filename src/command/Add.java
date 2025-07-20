package command;
import manager.TaskManager;
import models.Task;
import java.util.Scanner;

public class Add implements Command {
    private TaskManager taskmanager;
    private Scanner scanner;

    public Add(TaskManager taskmanager, Scanner scanner) {
        this.taskmanager = taskmanager;
        this.scanner = scanner;
    }

    @Override
    public void execute(){
        System.out.println("Введите название задачи:");
        String name = scanner.nextLine();

        if ("exit".equalsIgnoreCase(name)) return;

        System.out.println("Введите текст задачи:");
        String text = scanner.nextLine();

        if ("exit".equalsIgnoreCase(text)) return;

        String status = "";
        boolean validStatus = false;

        while (!validStatus) {
            System.out.println("Введите статус задачи (выполнено / не выполнено):");
            status = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(status)) {
                return;
            }

            if (status.equalsIgnoreCase("выполнено") || status.equalsIgnoreCase("не выполнено")) {
                validStatus = true;
            } else {
                System.out.println("Некорректный статус. Допустимые значения: 'выполнено', 'не выполнено'.");
            }
        }


        taskmanager.addTask(new Task(name, text, status));
        System.out.println("Задача добавлена");

    }

}
