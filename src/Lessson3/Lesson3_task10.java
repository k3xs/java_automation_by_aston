//Написать метод, принимающий на вход два аргумента: len
//и initialValue, и возвращающий одномерный массив типа int
//длиной len, каждая ячейка которого равна initialValue.

package Lessson3;

public class Lesson3_task10 {
    public static void main(String[] args) {
        int[] array = arrayByValue(5, 8);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static int[] arrayByValue(int len, int initialValue) {
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

        return array;

    }
}
