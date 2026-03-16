//    Написать метод, принимающий на вход два целых числа и проверяющий,
//    что их сумма лежит в пределах от 10 до 20 (включительно),
//    если да – вернуть true, в противном случае – false.
package Lessson3;


public class Lesson3_task1 {
    public static void main(String[] args) {
        System.out.println(sumChecker(5, 10));
        System.out.println(sumChecker(20, 10));
        System.out.println(sumChecker(0, 10));
    }

    public static boolean sumChecker(int n1, int n2) {
        int sum = n1 + n2;
        return (sum >= 10 && sum <= 20);
    }
}