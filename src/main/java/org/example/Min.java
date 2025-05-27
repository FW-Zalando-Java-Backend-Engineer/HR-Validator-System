package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Min {
    // means the user must provide a number when using @Min.
    int value(); // minimum value allowed
}
