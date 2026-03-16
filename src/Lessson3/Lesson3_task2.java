//Написать метод, которому в качестве параметра
//передается целое число, метод должен напечатать в консоль,
//положительное ли число передали или отрицательное.
//Замечание: ноль считаем положительным числом.
package Lessson3;

public class Lesson3_task2 {
    public static void main(String[] args) {
        checkerPosOrNeg(5);
        checkerPosOrNeg(0);
        checkerPosOrNeg(-1);
    }

    public static void checkerPosOrNeg(int x) {
        if (x >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }
}