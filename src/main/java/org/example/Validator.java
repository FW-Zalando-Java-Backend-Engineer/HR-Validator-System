package org.example;

import java.lang.reflect.Field;
/**
 * Reflection Logic
 * */
public class Validator {
    public static void validate(Object obj) throws IllegalAccessException{
        Class<?> clazz = obj.getClass(); // Get the blueprint (class) of the object
        for(Field field : clazz.getDeclaredFields()){ // Loop over all fields in the class
            field.setAccessible(true); // Allow access to private fields too -- unlocking
            Object value = field.get(obj); // Grab the actual value of that field from the object passed in.

            // Checking for the Annotations:

            // 1. @NotNull annotation
            if(field.isAnnotationPresent(NotNull.class)){ // Does this field have a @NotNull tag on it?
                if(value == null){ // Did the person forget to fill in this field?
                    // null? That's not allowed!
                    throw new IllegalAccessException("Field '"+field.getName()+"' cannot be null.");
                }
            }
        }
    }
}
