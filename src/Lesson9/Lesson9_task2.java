//Задана коллекция, состоящая из строк: «Highload», «High», «Load», «Highload».
//Нужно с ней выполнить следующие манипуляции:
//2.1. Посчитать, сколько раз объект «High» встречается в коллекции;
//2.2. Определить, какой элемент в коллекции находится на первом месте, если мы получили пустую коллекцию, то пусть возвращается 0;
//2.3. Необходимо вернуть последний элемент, если получили пустую коллекцию, то пусть возвращается 0;

package Lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Lesson9_task2 {
    public static void main(String[] args) {

        String[] array = {"HighLoad", "High", "Load", "Highload"};

        counterString(array);
        findFirstElement(array);
        findLastElement(array);

    }

    public static void counterString(String[] array) {
        long countHigh = Arrays.stream(array)
                .filter(n -> n.equals("High"))
                .count();
        System.out.println("Объект 'High' встречается в коллекции " + countHigh + " раз!");
    }

    public static void findFirstElement(String[] array) {
        String first = Arrays.stream(array)
                .findFirst()
                .orElse("0");
        System.out.println("На первом месте в коллекции находится элемент: " + first + "!");
    }

    public static void findLastElement(String[] array) {
        String last = Arrays.stream(array)
                .reduce((first, second) -> second)
                .orElse("0");
        System.out.println("На последнем месте в коллекции находится элемент: " + last + "!");
    }
}
