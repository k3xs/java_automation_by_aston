// Написать метод, которому в качестве аргументов
//передается строка и число, метод должен отпечатать в
//консоль указанную строку, указанное количество раз

package Lessson3;

public class Lesson3_task4 {
    public static void main(String[] args) {
        printString("Hello!", 3);
        printString("Привет", 2);
        printString("Buona sera!", 1);
    }

    public static void printString(String s1, int n1) {
        for (int i = 0; i < n1; i++) {
            System.out.println(s1);
        }
    }
}