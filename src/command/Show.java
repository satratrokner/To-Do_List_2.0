package command;

import manager.TaskManager;

public class Show implements Command{
    private TaskManager taskmanager;

    public Show(TaskManager taskmanager) {
        this.taskmanager = taskmanager;
    }

    @Override
    public void execute(){
        taskmanager.showTasks();
    }
}
