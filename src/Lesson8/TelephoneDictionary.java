//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
//В этот телефонный справочник с помощью метода add() можно добалять записи,
//а с помощью метода get() искать номер телефона по фамилии.
//Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//тогда при запросе такой фамилии должны выводится все телефоны.

package Lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDictionary {
    private HashMap<String, List<String>> dictionary;

    public TelephoneDictionary() {
        this.dictionary = new HashMap<>();

    }

    public void add(String secondName, String telephone) {
        if (dictionary.containsKey(secondName)) {
            List<String> phones = dictionary.get(secondName);
            phones.add(telephone);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(telephone);
            dictionary.put(secondName, phones);
        }

    }

    public List<String> get(String secondName) {
        if (dictionary.containsKey(secondName)) {
            return dictionary.get(secondName);
        } else {
            return new ArrayList<>();
        }
    }

    public void printAll() {
        if (dictionary.isEmpty()) {
            System.out.println("Справочник пуст.");
        }

        System.out.println("====== Телефонный мправочник =====");
        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("==================================");
        System.out.println();
    }

    public static void main(String[] args) {
        TelephoneDictionary dict = new TelephoneDictionary();

        dict.add("Doe", "89518080800");
        dict.add("Smith", "89518080801");
        dict.add("Kennedy", "89518080802");
        dict.add("Doe", "89518080803");
        dict.add("Kennedy", "89518080804");

        dict.printAll();

        System.out.println("Doe: " + dict.get("Doe"));
        System.out.println("Smith: " + dict.get("Smith"));
        System.out.println("Kennedy: " + dict.get("Kennedy"));
    }
}
