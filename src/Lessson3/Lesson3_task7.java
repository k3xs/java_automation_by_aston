//Задать пустой целочисленный массив длиной 100. С
//помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ...100;

package Lessson3;

public class Lesson3_task7 {
    public static void main(String[] args) {
        longArray();
    }

    public static void longArray() {

        int[] array = new int[100];
        int N = 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = N;
            N++;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}