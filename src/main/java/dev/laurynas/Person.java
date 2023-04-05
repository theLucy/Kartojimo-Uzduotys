package dev.laurynas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;

    @InvokeImmediately(times = 3, important = true, saveToLog = true)
    public void printPerson() {
        System.out.printf("Vardas: %s | Amzius: %d\n", name, age);
    }

    @InvokeImmediately
    public void metodas() {
        System.out.println("Iskviestas.");
    }
}
