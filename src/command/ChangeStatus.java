package command;

import manager.TaskManager;

import java.util.Scanner;

public class ChangeStatus implements Command{
    private TaskManager taskmanager;
    private Scanner scanner;

    public ChangeStatus(TaskManager taskmanager, Scanner scanner) {
        this.taskmanager = taskmanager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        int number = -1;
        boolean validNumber = false;

        while (!validNumber) {
            System.out.println("Введите номер задачи, статус которой хотите изменить:");
            String strNumber = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(strNumber)) {
                return;
            }

            try {
                number = Integer.parseInt(strNumber);

                // Проверяем, существует ли задача с таким номером
                if (taskmanager.taskExist(number)) {
                    validNumber = true;
                } else {
                    System.out.println("Задача с таким номером не найдена. Попробуйте ещё раз.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Введите корректный номер задачи.");
            }
        }

        // После корректного ввода номера — вводим статус
        System.out.println("Введите новый статус (выполнено / не выполнено):");
        String newStatus = scanner.nextLine().trim();

        if (newStatus.equalsIgnoreCase("выполнено") || newStatus.equalsIgnoreCase("не выполнено")) {
            taskmanager.changeStatus(number, newStatus);
            System.out.println("Статус задачи успешно изменён.");
        } else {
            System.out.println("Некорректный статус. Статус не изменён.");
        }
    }

    }

