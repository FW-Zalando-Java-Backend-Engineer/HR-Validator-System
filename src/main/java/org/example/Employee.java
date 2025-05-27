package org.example;

public class Employee {
    @NotNull
    @Length(min = 3, max = 50)
    private String name;

    @NotNull
    private String email;

    @Min(18)
    private int age;

    @Length(max = 25)
    private String position;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, String email, int age, String position) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return name + ", " + email + ", " + age + ", " + position;
    }
}
