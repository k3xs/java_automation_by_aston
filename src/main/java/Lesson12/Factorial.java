package Lesson12;

public class Factorial {

    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен: " + n);
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Факториал 5 = " + calculate(5));
        System.out.println("Факториал 10 = " + calculate(10));
        System.out.println("Факториал 0 = " + calculate(0));
        System.out.println("Факториал 1 = " + calculate(1));
    }
}