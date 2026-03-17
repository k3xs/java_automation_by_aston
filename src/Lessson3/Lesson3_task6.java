//Задать целочисленный массив, состоящий из элементов 0 и1.
// Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// С помощью цикла и условия заменить 0 на 1, 1 на 0

package Lessson3;

public class Lesson3_task6 {
    public static void main(String[] args) {
        replaceInArray();
    }

    public static void replaceInArray() {
        int[] array = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.print("Original array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

        System.out.println("");

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else if (array[i] == 0) {
                array[i] = 1;
            }
        }

        System.out.print("Modified array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}