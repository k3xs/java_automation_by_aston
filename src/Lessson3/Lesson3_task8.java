//Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
// пройти по нему циклом, и числа меньшие 6 умножить на 2

package Lessson3;

public class Lesson3_task8 {
    public static void main(String[] args) {
        myArray();
    }

    public static void myArray() {

        int[] array = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] resultArray = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (resultArray[i] < 6) {
                resultArray[i] *= 2;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }
}