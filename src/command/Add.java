package command;

import manager.TaskManager;
import other.Task;

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

        System.out.println("Введите статус задачи:");
        String status = scanner.nextLine();

        if ("exit".equalsIgnoreCase(status)) return;

        taskmanager.addTask(new Task(name, text, status));
        System.out.println("Задача добавлена");

    }

}
