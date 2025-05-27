package org.example;

/**
 * Demo Runner
 *
 */
public class Demo {
    public static void main( String[] args ) {
        Employee emp1 = new Employee("Alice", "alice@example.com", 30, "Engineer");
        Employee emp2 = new Employee(null, "bob@example.com", 17, "IT Support");
        Employee emp3 = new Employee("Ed", "ed@example.com", 25, "Java Developer");
        Employee emp4 = new Employee("Safwan", "saf@example.org", 19, "A very long position title that exceeds the allowed length for position title...");

        validateAndPrint(emp1);
        validateAndPrint(emp2);
        validateAndPrint(emp3);
        validateAndPrint(emp4);



    }

    private static void validateAndPrint(Employee employee){
        System.out.println(employee);
        try{
            Validator.validate(employee);
        }catch(IllegalArgumentException | IllegalAccessException e){
            System.out.println("X INVALID: "+ e.getMessage());
        }
    }
}
