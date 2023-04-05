package dev.laurynas;

import lombok.extern.java.Log;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.*;

public class App {

    public static void main(String[] args) throws Exception {
        Person person = make(Person.class, "Jonas", 20);
    }


    /**
     * Creates object and invokes all methods marked with InvokeImmediately anotation
     *
     * @param clazz class of the object to create
     * @param args  constructor arguments
     * @return new object of specified type
     * @throws Exception can error out if trying to make object with incorrect constructor arguments.
     */
    public static <T> T make(Class<T> clazz, Object... args) throws Exception {
        var argTypes = Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
        T object = clazz.getDeclaredConstructor(argTypes).newInstance(args);

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(InvokeImmediately.class)
                    && method.getParameterCount() == 0) {
                var anotation = method.getAnnotation(InvokeImmediately.class);
                for (int i = 0; i < anotation.times(); i++) {
                    System.out.print(anotation.important() ? "IMPORTANT!!!: " : anotation.prefix());
                    method.invoke(object);
                }

            }
        }
        return object;
    }
}