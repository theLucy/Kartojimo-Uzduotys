package dev.laurynas;

import lombok.Data;
import lombok.experimental.ExtensionMethod;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.Arrays;

@ExtensionMethod(Arrays.class)
public class App {
    public static void main(String[] args) {
        Class<Person> klase = Person.class;

        try {
            Person person = klase.getDeclaredConstructor(String.class, int.class)
                    .newInstance("Jonas", 20);

            String vardas = (String) person.getClass()
                    .getDeclaredMethod("getName")
                    .invoke(person);

            System.out.println(vardas);


            Constructor<Person> klaseConst = klase.getDeclaredConstructor();
            klaseConst.setAccessible(true);
            klaseConst.newInstance();

        } catch (Exception e) {
            System.err.println("Klaida: " + e);
        }

        var klaseArr = Person[].class;
        Class<Serializable> klase2 = Serializable.class;
        klase.getMethods().stream().forEach(x -> System.out.println(x + "|" + x.isSynthetic()));

        /* ARRAY */

        Person[] people = (Person[]) Array.newInstance(Person.class, 10);
        int[] skaiciai = (int[]) Array.newInstance(int.class, 4);
        Array.setInt(skaiciai, 0, 3);
        System.out.println(skaiciai.toString());


        people.fill(new Person("Jonas", 30));
        Array.set(people, 2, new Person("Bevardis", 0));
        System.out.println(people.toString());

        String greeting = "Hello world";
        System.out.println(greeting);
        String[] greetings = thingToArr(greeting, 5);
        System.out.println(greetings.toString());

        int number = 6;
        System.out.println(number);
        Integer[] numbers = thingToArr(number, 5);
        System.out.println(numbers.toString());

    }

    public static <T> T[] thingToArr(T thing, int length) {
        T[] array = (T[]) Array.newInstance(thing.getClass(), length);
        Array.set(array, 0, thing);
        return array;
    }
}