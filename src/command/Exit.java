package command;

public class Exit implements Command{
    @Override
    public void execute() {
        System.out.println("Выход из программы...");
    }
}
