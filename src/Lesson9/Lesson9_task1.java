//Для любого набора случайно-сгенерированных чисел нужно определить количество чётных чисел.

package Lesson9;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Lesson9_task1 {

    public static void main(String[] args) {
        int[] array  = randomArray();
        System.out.println("Случайно сгенерированный массив: " + Arrays.toString(array));
        System.out.print("Количество четных чисел в массиве: ");
        evenChecker(array);
    }

    public static int[] randomArray() {
        int len = (int) (Math.random() * 10) + 1;
        int[] arrayRandomInts = new int[len];
        for (int i = 0; i < arrayRandomInts.length; i++) {
            arrayRandomInts[i] = (int) (Math.random() * 10) + 1;
        }
        return arrayRandomInts;
    }

    public static void evenChecker(int[] array) {
        long count = IntStream.of(array).filter(i -> i % 2 == 0).count();
        System.out.println(count);
    }
}
