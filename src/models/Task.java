package models;

public class Task {
    int number;
    String name;
    String text;
    String status;

    public Task(String name, String text, String status) {
        this.name = name;
        this.text = text;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getStatus() {
        return status;
    }
}
