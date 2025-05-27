package org.example;

public class Employee {
    @NotNull
    @Length(min = 3, max = 50)
    private String name;

    public Employee(String name) {
        this.name = name;
    }
}
