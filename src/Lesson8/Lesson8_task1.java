//Создать массив с набором слов (10-20 слов, должны встречатся повторяющиеся).
//Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)

package Lesson8;

import java.util.*;

public class Lesson8_task1 {
    public static void main(String[] args) {
        String[] myArrayTest = {"java", "c++", "QA", "java", "python", "java", "go", "QA", "rust", "python"};
        System.out.println("Изначальный список: " + Arrays.toString(myArrayTest));
        System.out.println("----");
        arrayChecker(myArrayTest);
    }

    public static void arrayChecker(String[] array) {
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        System.out.println("Список уникальных слов: " + set);
        System.out.println("----");


        List<String> uniqueList = new ArrayList<>(set);

        HashMap<String, String> dictionary = new HashMap<>();

        for (int i = 0; i < uniqueList.size(); i++) {

            int counter = 0;

            for (int j = 0; j < array.length; j++) {

                if (uniqueList.get(i).equalsIgnoreCase(array[j])) {
                    counter++;

                }


            }

            dictionary.put(uniqueList.get(i), Integer.toString(counter));

        }

        for (Map.Entry<String, String> dict : dictionary.entrySet()) {
            System.out.println("Слово " + "'" + dict.getKey() + "'" + " встречается " + dict.getValue() + " раз!");
        }
    }
}
