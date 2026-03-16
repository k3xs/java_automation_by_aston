//Написать метод, которому в качестве параметра
//передается целое число. Метод должен вернуть true, если
//число отрицательное, и вернуть false если положительное.

package Lessson3;

public class Lesson3_task3 {
    public static void main(String[] args) {
        System.out.println(checkerPosOrNeg(-1));
        System.out.println(checkerPosOrNeg(1));
    }

    public static boolean checkerPosOrNeg(int x) {
        if (x < 0) {
            return true;
        } else {
            return false;
        }
    }
}