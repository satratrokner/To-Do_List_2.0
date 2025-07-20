package manager;

import models.Task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class TaskManager {
    public ArrayList<Task> tasks = new ArrayList<>();
    public int nextnumber = 1;

    //проверять существование таски с таким номером
    public boolean taskExist(int number){
        for (Task task: tasks){
            if (task.getNumber() == number) {
                return true;
            }
        }
        return false;
    }
    // изменять статус отдельно
    public boolean changeStatus(int number, String newstatus) {
        for (Task task : tasks) {
            if (task.getNumber() == number) {
                task.setStatus(newstatus);
                return true;
            }
        }
        return false;
    }


    //добавлять новую задачу
    public void addTask(Task task) {
            task.setNumber(nextnumber++);
            tasks.add(task);
    }

    //сохранять всё в файл после завершения программы
    public void setupShutDownHook(String filename) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Завершаю программу, сохраняю данные в файл");
            saveTasksToFile(filename);
        }));
    }

    //выводить список имеющихся тасков
    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("ваш список задач пуст");
        } else {
            for (Task task : tasks) {
                System.out.println(task.getNumber() + " " + task.getName() + " " + task.getText() + " " + task.getStatus());
            }
        }
    }

    //снова сохранять все данные в файл
    public void saveTasksToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.getNumber() + "|" + task.getName() + "|" + task.getText() + "|" + task.getStatus());
                writer.newLine();
            }
            System.out.println("Данные успешно сохранены в файл");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //метод для загрузки данных из файла при входе в программу
    public void loadTaskFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int maxnumber = 0;
            while((line = reader.readLine()) != null) {
                String[] parts =  line.split("\\|");
                int number = Integer.parseInt(parts[0]);
                String name = parts[1];
                String text = parts[2];
                String status = parts[3];

                Task task = new Task(name, text, status);
                task.setNumber(number);
                tasks.add(task);

                if (number > maxnumber) {
                    maxnumber = number;
                }
            }

            nextnumber = maxnumber + 1;
        } catch (Exception e) {
            System.out.println("предыдущие задачи не найдены");
            }
        }


    }




