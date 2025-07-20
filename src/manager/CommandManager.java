package manager;

import command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {
    private Map<String, Command> commands = new HashMap<>();
    private Scanner scanner;

    public CommandManager(Scanner scanner, TaskManager taskmanager) {
        this.scanner = scanner;

        commands.put("add", new Add(taskmanager, scanner));
        commands.put("exit", new Exit());
        commands.put("show", new Show(taskmanager));
        commands.put("change status", new ChangeStatus(taskmanager, scanner));
    }

    /* public void RegisterCommand(String key, command.Command command){
        commands.put(key, command);
    } */

    public void processInput(){
        while(true){
            System.out.println("Введите команду");
            String input = scanner.nextLine();

            if (commands.containsKey(input)) {
                commands.get(input).execute();

                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
            } else {
                System.out.println("Неизвестная команда. Попробуйте ещё раз.");
            }

        }
    }


}
