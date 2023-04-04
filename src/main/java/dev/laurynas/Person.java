package dev.laurynas;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person implements Serializable, Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int compareTo(Person o) {
        return Integer.compare(age, o.age);
    }
}
