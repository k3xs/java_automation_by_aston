//Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4".
//Необходимо отсортировать строки в алфавитном порāдке и добавить их в массив.


package Lesson9;

import java.util.*;

public class Lesson9_task3 {
    public static void main(String[] args) {
        String[] array = {"f10", "f15", "f2", "f4", "f4"};
        System.out.println("Исходная коллекция: " + Arrays.toString(array));
        System.out.println("Итоговая коллекция: " + Arrays.toString(collectionSorter(array)));
    }

    public static String[] collectionSorter(String[] array) {


        String[] sortedArray = Arrays.stream(array)
                .sorted((a, b) -> {
                    int numA = Integer.parseInt(a.substring(1));
                    int numB = Integer.parseInt(b.substring(1));
                    return Integer.compare(numA, numB);
                })
                .toArray(String[]::new);

        return sortedArray;
    }
}
