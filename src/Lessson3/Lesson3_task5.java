//Написать метод, который определяет, является ли год
//високосным, и возвращает boolean (високосный - true, не
//високосный - false). Каждый 4-й год является високосным,
//кроме каждого 100-го, при этом каждый 400-й – високосный

package Lessson3;

public class Lesson3_task5 {
    public static void main(String[] args) {
        System.out.println(checkerLeapYear(2000));
        System.out.println(checkerLeapYear(1900));
        System.out.println(checkerLeapYear(2004));
        System.out.println(checkerLeapYear(2005));
    }

    public static boolean checkerLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}