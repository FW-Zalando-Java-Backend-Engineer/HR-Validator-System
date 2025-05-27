package org.example;

/**
 * Demo Runner
 *
 */
public class Demo {
    public static void main( String[] args ) {
        Employee emp1 = new Employee("S.");
        validateAndPrint(emp1);


    }

    private static void validateAndPrint(Employee employee){
        try{
            Validator.validate(employee);
        }catch(IllegalAccessException e){
            System.out.println("X INVALID: "+ e.getMessage());
        }
    }
}
