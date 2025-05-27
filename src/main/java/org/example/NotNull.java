package org.example;

import java.lang.annotation.*; // importing annotation-related classes from Java's core library

/**
 * Tells validator that a field must not be null
 * */

@Retention(RetentionPolicy.RUNTIME) // This means our @NotNull annotation will be available at runtime.
@Target(ElementType.FIELD) // This limits the usage of our @NotNull annotation to fields only (e.g., class variables)
public @interface NotNull {

}
