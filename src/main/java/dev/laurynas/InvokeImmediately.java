package dev.laurynas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InvokeImmediately {
    byte times() default 1;
    boolean important() default false;

    String[] prefix() default "";
    boolean saveToLog() default false;
}
