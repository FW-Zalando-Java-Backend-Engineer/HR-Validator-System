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

            // 2. @Length annotation

            // Is this field annotated with @Length? -> Yes,
            // Is that field's value actually a String? -> Yes
            if(field.isAnnotationPresent(Length.class) && value instanceof String ){
              Length len = field.getAnnotation(Length.class); // Get the actual Length annotation on this 'field'

              String str = (String) value;
              if(str.length() < len.min() || str.length() > len.max()){
                  throw new IllegalAccessException(
                          "Field '"+field.getName()+"' must have length between "+ len.min()+" and " + len.max()
                  );
              }

            }

            // 3. @Min annotation
            if(field.isAnnotationPresent(Min.class) && value instanceof Integer){
                Min min = field.getAnnotation(Min.class);
                int minimumValue =  min.value();
                if((Integer) value < minimumValue ){
                    throw new IllegalAccessException(
                            "Field '"+field.getName()+"' must be >= "+ minimumValue
                    );
                }
            }
        }
    }
}
