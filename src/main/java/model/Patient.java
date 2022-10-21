package model;

public class Patient {

    private String name;
    private String lastname;
    private boolean priority;
    private String age;

    public Patient(String name, String lastname, boolean priority, String age) {
        this.name = name;
        this.lastname = lastname;
        this.priority = priority;
        this.age = age;
    }

    public boolean isPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}
