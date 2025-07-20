import manager.CommandManager;
import manager.TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в To-Do List, готовы начать? Есть команды: add, exit, show, change status");

        TaskManager taskmanager = new TaskManager();
        taskmanager.loadTaskFromFile("C:\\Users\\akatd\\IdeaProjects\\To-Do List 2.0\\Tasks");
        taskmanager.setupShutDownHook("C:\\Users\\akatd\\IdeaProjects\\To-Do List 2.0\\Tasks");

        Scanner scanner = new Scanner(System.in);

        CommandManager commandmanager = new CommandManager(scanner, taskmanager);
        commandmanager.processInput();

        scanner.close();
    }
}
