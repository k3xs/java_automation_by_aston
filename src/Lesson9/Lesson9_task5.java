//Нужно написать программу, которая будет принимать от пользователя ввод различных логинов.
//Как только пользователь введет пустую строку - программа должна прекратить приём данных от
//пользователя и вывести в консоль логины, начинающиеся на букву f(строчную).

package Lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lesson9_task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();

        System.out.println("Введите логины (пустая строка для завершения):");

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            logins.add(input);
        }

        scanner.close();


        List<String> filteredLogins = logins.stream()
                .filter(login -> login.startsWith("f"))
                .collect(Collectors.toList());

        System.out.println("\nЛогины, начинающиеся на 'f':");
        filteredLogins.forEach(System.out::println);
    }
}
