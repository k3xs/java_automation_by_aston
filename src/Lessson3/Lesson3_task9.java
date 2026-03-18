//Создать квадратный двумерный целочисленный массив
//(количество строк и столбцов одинаковое), и с помощью
//цикла(-ов) заполнить его диагональные элементы единицами
//(можно только одну из диагоналей, если обе сложно).
//Определить элементы одной из диагоналей можно по
//следующему принципу: индексы таких элементов равны,
// то есть [0][0], [1][1], [2][2], ..., [n][n];

package Lessson3;

public class Lesson3_task9 {
    public static void main(String[] args) {
        diagonalArray(5, 5);
        diagonalArray(3, 3);
        diagonalArray(8, 8);
    }

    public static void diagonalArray(int a, int b) {

        int[][] array = new int[a][b];

        for (int i = 0; i < a; i++) {
            array[i][i] = 1;
            array[i][array.length - 1 - i] = 1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
